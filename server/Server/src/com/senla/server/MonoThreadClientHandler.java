package com.senla.server;

import com.senla.booksshop.controller.IController;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MonoThreadClientHandler implements Runnable {

    private static final String DISCONNECTED = "Client disconnected";
    private static final String CLOSING_CONNECTIONS_CHANNELS_DONE = "Closing connections & channels - DONE.";
    private static final String EXCEPTION = "Exception: ";
    private static final String STOP_CLIENT = "stopClient";
    private  Socket client;
    private static IController controller;

    private static Logger log = Logger.getLogger(MonoThreadClientHandler.class.getName());

    public MonoThreadClientHandler(Socket client, IController controller){
        this.client = client;
        MonoThreadClientHandler.controller = controller;

    }

    @Override
    public void run() {

        try {
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            while (true){
                Command command = (Command)in.readObject();
                if (command.getMethodName().equals(STOP_CLIENT)){
                    out.writeObject(new Response(STOP_CLIENT));
                    break;
                }
                out.writeObject (ExecuteCommandUtil.execute(command, controller));
            }
            log.info(DISCONNECTED);
            in.close();
            out.close();
            client.close();
            log.info(CLOSING_CONNECTIONS_CHANNELS_DONE);
        }catch (IOException | ClassNotFoundException e) {
            log.log(Level.SEVERE, EXCEPTION, e);
            throw new RuntimeException(e);
        }
    }


}
