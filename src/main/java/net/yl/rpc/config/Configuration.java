package net.yl.rpc.config;


/**
 * @author yulei0
 * @date 2020/9/24
 */
public class Configuration {

    private RegistryConfig registryConfig;

    private RemoteObjectConfig remoteObjectConfig;

    public void load(){

    }

    public RegistryConfig getRegistryConfig() {
        return registryConfig;
    }

    public RemoteObjectConfig getRemoteObjectConfig() {
        return remoteObjectConfig;
    }
}
