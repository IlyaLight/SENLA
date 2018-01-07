package com.senla.server;

import com.google.gson.Gson;
import com.senla.api.Command;
import com.senla.api.IController;
import com.senla.api.Response;

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

    //запускается в отдельном потоке
    @Override
    public void run() {
        final Gson GSON = new Gson();

        try {
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            DataInputStream   in = new DataInputStream (client.getInputStream());
            String jsonString;
            while (true){
                jsonString = in.readUTF();   //ждем команды от клиента
                Command command = (Command)GSON.fromJson(jsonString, Command.class);
                if (command.getMethodName().equals(STOP_CLIENT)){
                    jsonString = GSON.toJson(new Response(STOP_CLIENT));
                    out.writeUTF(jsonString);
                    break;
                }
                jsonString = GSON.toJson(ExecuteCommandUtil.execute(command, controller));
                out.writeUTF(jsonString);
            }
            log.info(DISCONNECTED);
            in.close();
            out.close();
            client.close();
            log.info(CLOSING_CONNECTIONS_CHANNELS_DONE);
        }catch (IOException e) {
            log.log(Level.SEVERE, EXCEPTION, e);
            throw new RuntimeException(e);
        }
    }


}
