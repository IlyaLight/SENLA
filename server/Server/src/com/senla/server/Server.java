package com.senla.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private static final int PORT = 9090;
    private static int MAX_NUMBER_OF_CLIENTS = 10;

    public static void runServer() throws IOException {
        ExecutorService executeIt = Executors.newFixedThreadPool(MAX_NUMBER_OF_CLIENTS);
        try (ServerSocket server = new ServerSocket(PORT);
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while(!server.isClosed()){
                if (br.ready()){
                    String serverCommand = br.readLine();
                    if (serverCommand.equalsIgnoreCase("quit")) {
                        System.out.println("Main Server initiate exiting...");
                        server.close();
                        break;
                    }
                }
                Socket client = server.accept();
                executeIt.execute(new MonoThreadClientHandler(client));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
