package server;

public interface Server {
    /**
     * This method run the server.
     * @param c
     * @param port
     */
    void open(int port, ClientHandler c);

    /**
     * stops the server
     */
    void stop();
}
