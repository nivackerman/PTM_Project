package games.mazeGame;

import server.*;

import java.io.*;

public class MazeClientHandler implements ClientHandler {
    Solver<Solution,Problem> solver;
    CacheManager cm;

    public MazeClientHandler(Solver<Solution, Problem> solver, CacheManager cm) {
        this.solver = solver;
        this.cm = cm;
    }

    @Override
    public void handleClient(InputStream input, OutputStream output) {
        PrintWriter out = new PrintWriter(output);
        BufferedReader in = new BufferedReader(new InputStreamReader(input));
        String line, sol;
        try {
            Problem problem = new Problem();

            while((line = in.readLine()) != null && !line.equals("end")) {
                problem.add(line);
            }
            problem.add("end");
            problem.add(in.readLine());
            problem.add(in.readLine());

            if(!cm.check(problem.toString())) {
                cm.save(problem.toString(), solver.solve(problem).toString());
            }
            sol = cm.load(problem.toString());
            out.print(sol);
            out.flush();

        } catch (IOException e) {
            //System.out.println("client is disconnected");
            //e.printStackTrace();
        }
    }
}
