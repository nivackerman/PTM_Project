package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * A serial server will handle the clients one by one,
 * via ClientHandler.
 */
public class MySerialServer implements Server{
    private Boolean stop;

    /**
     *Listen's to the client on the received port and handles the request(on a separated thread).
     */
    public MySerialServer() {
        this.stop = false;
    }

    /**
     *Set's a different thread that waits for a client's request.
     * @param port
     * @param c
     */
    @Override
    public void open(int port, ClientHandler c) {
        try {
            ServerSocket s = new ServerSocket(port);
            //System.out.println("Server is Alive and running on: " + port);
            s.setSoTimeout(1000);
            new Thread(()->{
                while(!stop) {
                    try {
                        Socket client = s.accept();
                        //new Thread(()-> { // Uncomment all to have multi threaded server
                         //   try {
                                //System.out.println("New client on socket: " + client.getPort());
                                c.handleClient(client.getInputStream(),client.getOutputStream());
                                client.close();
                          //  } catch (IOException e) {
                                //e.printStackTrace();
                           // }
                        //}).start();

                    } catch (IOException ignored) {
                        //System.out.print(".");
                    }

                }
                try {
                    s.close();
                } catch (IOException ignored) {}
            }).start();
        } catch (IOException ignored) {}
    }

    @Override
    public void stop() {
        if(!this.stop)
            this.stop=true;
    }
}
