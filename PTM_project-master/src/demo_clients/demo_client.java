package demo_clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class demo_client {

    public static void main(String[] args) {
        try {
            Socket ourServer = new Socket("localhost",6400);
            BufferedReader in = new BufferedReader(new InputStreamReader(ourServer.getInputStream()));
            PrintWriter out = new PrintWriter(ourServer.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            while(true) {
                System.out.print("Pleas enter a query: ");
                String line = scanner.nextLine();
                out.println(line);
                out.flush();
                System.out.println(in.readLine());

                if(line.equals("end")) {
                    break;
                }
            }
            in.close();
            out.close();
            ourServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
