package net.yl.rpc.registry;

import net.yl.rpc.proxy.ObjectName;
import net.yl.rpc.proxy.ObjectProxy;

/**
 * @author yulei0
 * @date 2020/9/24
 */
public class DefaultRegistry implements Registry{

    @Override
    public ObjectProxy bind(Object object, ObjectName name) throws RegistryException {
        return null;
    }

    @Override
    public void unBind(ObjectName name) throws RegistryException {

    }

    @Override
    public void unBind(Object object) throws RegistryException {

    }

    @Override
    public void unBind(ObjectProxy objectProxy) throws RegistryException {

    }

    @Override
    public ObjectProxy lookup(ObjectName name) {
        return null;
    }
}
