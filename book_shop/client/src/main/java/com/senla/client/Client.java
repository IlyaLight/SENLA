package com.senla.client;

import com.google.gson.Gson;
import com.senla.api.Command;
import com.senla.api.Response;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

public class Client implements IClient {

    private static final int    PORT            = 9090;
    private static final String ADDRESS         = "localhost";
    private static final String EXCEPTION       = "Client Exception: ";
    private static final String CONNECTED       = "Client connected to socket";

    private static volatile Client instance;

    private static final org.slf4j.Logger LOGGER  = LoggerFactory.getLogger(Client.class);
    private static final Gson GSON = new Gson();

    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;


    public Client() {
        connect();
    }

    public static Client getInstance() {
        Client localInstance = instance;
        if (localInstance == null) {
            synchronized (Client.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Client();
                    instance.connect();
                }
            }
        }
        return localInstance;
    }

    @Override
    public Response writeCommand (Command command) {
        String jsonString;
        try {
            jsonString = GSON.toJson(command);
            out.writeUTF(jsonString);
            out.flush();
            jsonString = in.readUTF();
            return  (Response)GSON.fromJson(jsonString, Response.class);
        } catch (IOException e) {
            LOGGER.error(EXCEPTION, e);
            throw new RuntimeException(e);
        }
    }


    private void connect(){
        try {
            this.socket = new Socket(ADDRESS, PORT);
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            LOGGER.info(CONNECTED);
        } catch (Exception e) {
            LOGGER.error(EXCEPTION, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void stop() {
        try {
            socket.close();
        } catch (IOException e) {
            LOGGER.error(EXCEPTION, e);
            throw new RuntimeException(e);
        }
    }
}
