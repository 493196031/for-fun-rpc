package net.yl.rpc.config;

import net.yl.rpc.proxy.ObjectName;
import net.yl.rpc.proxy.ObjectProxy;
import net.yl.rpc.registry.Registry;


/**
 *
 *
 * @author yulei0
 * @date 2020/9/24
 */
public class RemoteObjectConfig {

    private Object target;

    private ObjectName objectName;

    public ObjectProxy bind(Registry registry) {
        return registry.bind(target, objectName);
    }
}
