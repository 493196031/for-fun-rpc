package net.yl.rpc;

import net.yl.rpc.config.Configuration;
import net.yl.rpc.registry.Registry;

/**
 * @author yulei0
 * @date 2020/9/24
 */
public class Container {

    private Server server;

    private Registry registry;

    private Configuration configuration;


    public void start() {
        configuration.load();
        server.start();
    }

    public void stop() {
        server.stop();
    }

}
