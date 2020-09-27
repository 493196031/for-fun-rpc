package net.yl.rpc;

import net.yl.rpc.config.Configuration;

/**
 * @author yulei0
 * @date 2020/9/24
 */
public class Container {

    private Server server;

    private Configuration configuration;

    public void start() {
        // 加载配置信息
        configuration.load();
        // 启动服务器
        server.start();
    }

    public void stop() {
        server.stop();
    }

}
