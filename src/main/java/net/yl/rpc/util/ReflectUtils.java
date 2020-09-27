package net.yl.rpc.util;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * @author yulei0
 * @date 2020/9/24
 */
public class ReflectUtils {

    private ReflectUtils() {
        throw new IllegalStateException();
    }


    public static Object invoke(Object target,
                                Method method,
                                Object[] params) {
        return ReflectionUtils.invokeMethod(method, target, params);
    }

}
