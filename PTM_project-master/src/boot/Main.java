package boot;

import server.*;

public class Main {

    public static void main(String[] args) {
        Server server =
                new MySerialServer();

        server.open(Integer.valueOf(args[0]),
                new MyTestClientHandler(
                        new StringReverser(), new FileCacheManager()));
    }
}
