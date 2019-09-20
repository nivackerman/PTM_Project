package server;

import java.io.*;

/**
 * Some client handler for testing
 */
public class MyTestClientHandler implements ClientHandler{
    Solver<String,String> solver;
    CacheManager cm;

    /**
     *
     * @param solver
     * @param cm
     */
    public MyTestClientHandler(Solver<String, String> solver, CacheManager cm) {
        this.solver = solver;
        this.cm = cm;
    }

    /**
     * Handle the client requests or server response
     * @param input from client socket or whatever
     * @param output from client socket or whatever
     */
    @Override
    public void handleClient(InputStream input, OutputStream output) {
        PrintWriter out = new PrintWriter(output);
        BufferedReader in = new BufferedReader(new InputStreamReader(input));
        String line, sol;
        try {
            while((line = in.readLine()) != null && !line.equals("end")) {
                if(cm.check(line)) {
                    sol = cm.load(line);
                } else {
                    sol = solver.solve(line);
                    cm.save(line ,sol);
                }
                //System.out.println(sol);
                out.println(sol);
                out.flush();
            }
        } catch (IOException e) {
            //System.out.println("client is disconnected");
            //e.printStackTrace();
        }
    }
}
