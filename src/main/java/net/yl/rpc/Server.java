package net.yl.rpc;

import net.yl.rpc.config.Configuration;
import net.yl.rpc.config.RemoteObjectConfig;
import net.yl.rpc.proxy.ObjectProxy;
import net.yl.rpc.registry.RegistryException;
import net.yl.rpc.registry.Registry;
import java.util.List;

/**
 * @author yulei0
 * @date 2020/9/24
 */
public class Server {

    private Registry registry;

    private Configuration configuration;

    public void start() {
        // 启动端口
        configuration.registryRemoteObjects();
    }

    public void stop() {

    }

    public void pause() {

    }

}
