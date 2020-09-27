package net.yl.rpc.registry;

import net.yl.rpc.proxy.ObjectName;
import net.yl.rpc.proxy.ObjectProxy;
import net.yl.rpc.proxy.RegistryException;

public interface Registry {

    ObjectProxy bind(Object object, ObjectName name) throws RegistryException;

    void unBind(ObjectName name) throws RegistryException;

    void unBind(Object object) throws RegistryException;

    void unBind(ObjectProxy objectProxy) throws RegistryException;

    ObjectProxy lookup(ObjectName name);

}
