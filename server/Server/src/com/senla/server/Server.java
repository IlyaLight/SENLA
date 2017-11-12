package com.senla.server;

import com.senla.booksshop.controller.IController;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int PORT = 9090;

    public static void runServer(IController controller) throws IOException {
        try (ServerSocket server = new ServerSocket(PORT)){
            System.out.println("Main Server initiate exiting...");
            while(!server.isClosed()){
                Socket client = server.accept();
                new Thread(new MonoThreadClientHandler(client, controller)).start();
                System.out.println("new client");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
