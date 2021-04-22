package net.yl.rpc.codec;

import java.io.IOException;

public interface Codec {

    int jdk = 0;
    int pb = 1;

    <S> byte[] encode(S source) throws IOException;

    <S> S decode(Class<S> clazz, byte[] encoded) throws IOException;

}
