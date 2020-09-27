package net.yl.rpc.proxy;

import net.yl.rpc.util.ReflectUtils;

/**
 * @author yulei0
 * @date 2020/9/24
 */
public class RemoteObjectProxy implements ObjectProxy{

    private Object target;

    @Override
    public CallResponse call(CallRequest callRequest) {
        Object invokeResult = ReflectUtils.invoke(target,
                callRequest.getMethod(),
                callRequest.getParams());
        return CallResponse.wrap(invokeResult);
    }

}
