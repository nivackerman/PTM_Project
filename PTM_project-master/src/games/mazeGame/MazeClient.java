package games.mazeGame;

import server.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MazeClient {
    static List<Problem> problemList = new ArrayList<>();

    static {
        Problem problem;

        problem = new Problem();
        problem.add("10,15,2,8");
        problem.add("20,4,14,5");
        problem.add("1,4,100,3");
        problem.add("end");
        problem.add("0,2");
        problem.add("2,1");
        problemList.add(problem);

        problem = new Problem();
        problem.add("10,15,2,8");
        problem.add("20,4,14,5");
        problem.add("1,4,100,3");
        problem.add("end");
        problem.add("0,2");
        problem.add("2,1");
        problemList.add(problem);


        problem = new Problem();
        problem.add("10,15,2,8");
        problem.add("20,4,14,5");
        problem.add("1,4,100,3");
        problem.add("end");
        problem.add("0,2");
        problem.add("2,1");
        problemList.add(problem);


        problem = new Problem();
        problem.add("10,15,2,8");
        problem.add("20,4,14,5");
        problem.add("1,4,100,3");
        problem.add("end");
        problem.add("0,2");
        problem.add("2,1");
        problemList.add(problem);
    }

    public static void main(String[] args) {
        problemList.forEach(problem -> {
            try {
                Socket ourServer = new Socket("localhost", 6400);
                BufferedReader in = new BufferedReader(new InputStreamReader(ourServer.getInputStream()));
                PrintWriter out = new PrintWriter(ourServer.getOutputStream());

                problem.forEach(x -> {
                    out.println(x);
                    out.flush();
                });
                System.out.println("We asked solution for: \n" + problem.toString());
                System.out.println("We got solution: ");
                in.lines().forEach(System.out::println);

                in.close();
                out.close();
                ourServer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("---------");
        });

    }
}
