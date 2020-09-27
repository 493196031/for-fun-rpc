package net.yl.rpc.proxy;

/**
 * @author yulei0
 * @date 2020/9/24
 */
public interface ObjectProxy {

    CallResponse call(CallRequest callRequest) throws CallException;

}
