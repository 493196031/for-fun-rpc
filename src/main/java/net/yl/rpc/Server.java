package net.yl.rpc;

import net.yl.rpc.config.Configuration;


/**
 * @author yulei0
 * @date 2020/9/24
 */
public class Server implements LifeCycle{

    private Configuration configuration;

    public Server(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void init() {
        configuration.init();
    }

    @Override
    public void start() {
        configuration.start();
    }

    @Override
    public void stop() {
        configuration.stop();
    }

    @Override
    public void destroy() {
        configuration.destroy();
    }

    public static void main(String[] args) {
        Configuration configuration;
        if (args.length <= 0) {
            configuration = new Configuration();
        } else {
            configuration = new Configuration(args[0]);
        }
        Server server = new Server(configuration);

        server.init();

        server.start();

        server.stop();

    }

}
