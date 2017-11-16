package com.senla.client;

import com.senla.api.Command;
import com.senla.api.Response;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {

    private static final int PORT = 9090;
    private static final String ADDRESS = "localhost";
    private static final String EXCEPTION = "Exception: ";
    public static final String CONNECTED = "Client connected to socket";

    private  Socket socket;
    private  ObjectOutputStream out;
    private  ObjectInputStream in;

    private static Logger log = Logger.getLogger(Client.class.getName());

    public Client() {
        connect();
    }

    public Response writeCommand (Command command) {
        try {
            out.writeObject(command);
            out.flush();
            return  (Response)in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            log.log(Level.SEVERE, EXCEPTION, e);
            throw new RuntimeException(e);
        }
    }

    public void connect(){
        try {
            this.socket = new Socket(ADDRESS, PORT);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            log.info(CONNECTED);
            System.out.println(CONNECTED);
        } catch (Exception e) {
            log.log(Level.SEVERE, EXCEPTION, e);
            throw new RuntimeException(e);
        }
    }

    public void stop() {
        try {
            socket.close();
        } catch (IOException e) {
            log.log(Level.SEVERE, EXCEPTION, e);
            throw new RuntimeException(e);
        }
    }
}
