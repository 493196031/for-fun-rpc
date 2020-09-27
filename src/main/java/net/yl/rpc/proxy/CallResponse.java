package net.yl.rpc.proxy;

/**
 * @author yulei0
 * @date 2020/9/24
 */
public class CallResponse {

    private Object result;

    public CallResponse(Object result) {
        this.result = result;
    }


    public static CallResponse wrap(Object result) {
        return  new CallResponse(result);
    }

}
