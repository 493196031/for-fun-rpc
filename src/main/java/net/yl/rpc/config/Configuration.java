package net.yl.rpc.config;


import net.yl.rpc.proxy.ObjectProxy;
import net.yl.rpc.registry.Registry;

import java.util.ArrayList;
import java.util.List;
import java.util.List;

/**
 * @author yulei0
 * @date 2020/9/24
 */
public class Configuration {

    private RegistryConfig registryConfig;

    private List<RemoteObjectConfig> remoteObjectConfig;

    public void load(){
        // 加载所有配置，并初始化
    }

    public RegistryConfig getRegistryConfig() {
        return registryConfig;
    }

    public List<RemoteObjectConfig> getRemoteObjectConfigs() {
        return null;
    }

    public List<ObjectProxy> registryRemoteObjects(){
        List<ObjectProxy> objectProxies = new ArrayList<>();
        for(RemoteObjectConfig remoteObjectConfig : getRemoteObjectConfigs()) {
            ObjectProxy remoteObject = remoteObjectConfig.bind(getRegistry());
            objectProxies.add(remoteObject);
        }
        return objectProxies;
    }

    public Registry getRegistry() {
        return null;
    }
}
