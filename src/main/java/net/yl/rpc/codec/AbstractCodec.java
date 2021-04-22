package net.yl.rpc.codec;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yulei0
 * @date 2021/4/22
 */
public abstract class AbstractCodec implements Codec{

    private static Map<Integer, Codec> codecs = new HashMap<>();

    static {
        register(Codec.jdk, new JdkCodec());
    }

    public AbstractCodec() {

    }

    public static Codec register(Integer type, Codec codec) {
        return codecs.put(type, codec);
    }

    public static Codec getCodec(Integer type) {
        return codecs.get(type);
    }

}
