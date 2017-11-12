package com.senla.client;

import java.io.*;
import java.net.Socket;

public class Client {
    private static final int PORT = 9090;
    private static final String ADDRESS = "localhost";

    private  ObjectOutputStream out;
    private  ObjectInputStream in;

    public Client() {
        try {
            Socket socket = new Socket(ADDRESS, PORT);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            System.out.println("Client connected to socket");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public  com.senla.server.Response writeCommand (com.senla.server.Command o) {
        try {
            out.writeObject(o);
            out.flush();
            return  (com.senla.server.Response)in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
