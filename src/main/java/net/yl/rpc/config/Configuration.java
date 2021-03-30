package net.yl.rpc.config;


import net.yl.rpc.Constants;
import net.yl.rpc.LifeCycle;
import net.yl.rpc.container.Container;
import net.yl.rpc.util.ReflectUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author yulei0
 * @date 2020/9/24
 */
public class Configuration implements LifeCycle {

    private Container container;

    private String configFile = "application.properties";

    private Properties configProp = new Properties();

    private DefaultPropertyMerger merger = new DefaultPropertyMerger();

    public Configuration() {

    }

    public Configuration(String configFile) {
        this.configFile = configFile;
    }

    private void load() throws IllegalAccessException, InstantiationException, IOException, ClassNotFoundException {
        // 加载所有配置，并初始化
        configProp.load(readFromClasspath(configFile));
        merger.merge(configProp);

        // 实例化容器
        String containerClazz = configProp.getProperty(Constants.containerKey);
        container = (Container) ReflectUtils.newInstance(containerClazz);

        container.setConfig(this);

    }

    private InputStream readFromClasspath(String configFile) {
        return Configuration.class.getResourceAsStream("/" + configFile);
    }

    @Override
    public void init() {
        try {
            load();
        } catch (Exception e) {
            throw new IllegalStateException("容器类实例化失败", e);
        }

        container.init();
    }

    @Override
    public void start() {
        container.start();
    }

    @Override
    public void stop() {
        container.stop();
    }

    @Override
    public void destroy() {
        container.destroy();
    }

    public String getProperty(String key) {
        return configProp.getProperty(key);
    }

    public String getProperty(String key, String defaultValue) {
        return configProp.getProperty(key, defaultValue);
    }

    class DefaultPropertyMerger {


        void merge(Properties properties) {
            merge(properties, Constants.containerKey,
                    "net.yl.rpc.container.SampleContainer");
        }

        void merge(Properties properties,
                   String key, String defaultValue) {
            if (properties.containsKey(key)) {
                return;
            } else {
                properties.put(key, defaultValue);
            }
        }
    }
}
