package net.yl.rpc.container;

import net.yl.rpc.Constants;
import net.yl.rpc.LifeCycle;
import net.yl.rpc.config.Configuration;
import net.yl.rpc.service.RpcService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 基于Spring容器实现
 *
 * @author yulei0
 * @date 2021/3/29
 */
public class SampleContainer implements Container{

    private static final Class defaultStartClass = RpcService.class;

    private Class<? extends LifeCycle> startClass = defaultStartClass;

    private static final String defaultConfigFile = "container.xml";

    private LifeCycle startBean;

    private ApplicationContext container;

    private Configuration configuration;

    public SampleContainer() {

    }

    public SampleContainer(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void setStartClass(Class<? extends LifeCycle> startClass) {
        this.startClass = startClass;
    }

    @Override
    public void setConfig(Configuration config) {
        this.configuration = config;
    }


    @Override
    public void init() {
        // 生成Bean和注入关系
        createBean(configuration.getProperty(Constants.containerConfigFileKey, defaultConfigFile));
    }

    private void createBean(String configFile) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(configFile);
        this.container = applicationContext;
    }

    @Override
    public void start() {
        LifeCycle startBean = getBean(startClass);
        if (startBean == null) {
            throw new IllegalStateException();
        }
        startBean.start();
    }

    @Override
    public void stop() {
        startBean.stop();
    }

    @Override
    public void destroy() {
        startBean.destroy();
    }

    @Override
    public <T> T getBean(Class<T> clazz) {
        return this.container.getBean(clazz);
    }

}
