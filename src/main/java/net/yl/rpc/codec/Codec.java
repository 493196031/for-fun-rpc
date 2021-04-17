package net.yl.rpc.codec;

public interface Codec<S,E> {

    E encode(S source);

    S decode(E encoded);

}
