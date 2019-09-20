package test;

// change this to match your code

import games.mazeGame.MazeClientHandler;
import games.mazeGame.MazeSolver;
import server.*;

public class TestSetter {
	

	static Server s; 
	
	public static void runServer(int port) {
		// put the code here that runs your server
		// for example:
		s=new MySerialServer();
		s.open(port,
				new MazeClientHandler(
						new MazeSolver(), new FileCacheManager()));
	}

	public static void stopServer() {
		// put the code here that stops your server
		// for example:
		s.stop();
	}
	

}
