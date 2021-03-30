package net.yl.rpc.container;

import net.yl.rpc.LifeCycle;
import net.yl.rpc.config.Configuration;


public interface Container extends LifeCycle {

    void setStartClass(Class<? extends LifeCycle> startClass);

    void setConfig(Configuration config);

    void init();

    void start();

    void stop();

    void destroy();

    <T> T getBean(Class<T> clazz);
}
