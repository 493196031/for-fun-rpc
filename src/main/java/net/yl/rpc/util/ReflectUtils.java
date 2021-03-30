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

    public static <T> T newInstance(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }
    public static Object newInstance(String clazz) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return newInstance(Class.forName(clazz));
    }
}
