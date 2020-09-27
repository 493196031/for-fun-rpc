package net.yl.rpc.proxy;


import java.lang.reflect.Method;

/**
 * @author yulei0
 * @date 2020/9/24
 */
public class CallRequest {

    private ObjectProxy objectProxy;

    private Method method;

    private Object[] params;

    public CallRequest(ObjectProxy objectProxy, Method method, Object[] params) {
        this.objectProxy = objectProxy;
        this.method = method;
        this.params = params;
    }

    public ObjectProxy getObjectProxy() {
        return objectProxy;
    }

    public Method getMethod() {
        return method;
    }

    public Object[] getParams() {
        return params;
    }
}
