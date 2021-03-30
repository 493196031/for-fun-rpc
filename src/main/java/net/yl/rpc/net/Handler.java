package net.yl.rpc.net;


import java.util.concurrent.Future;

public interface Handler<I,O> {

    Future<O> process(I input);

}
