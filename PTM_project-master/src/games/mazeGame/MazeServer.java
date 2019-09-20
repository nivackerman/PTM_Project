package games.mazeGame;

import server.*;

public class MazeServer {

    public static void main(String[] args) {
        Server server =
                new MySerialServer();

        server.open(Integer.valueOf(args[0]),
                new MazeClientHandler(
                        new MazeSolver(), new FileCacheManager()));
    }
}
