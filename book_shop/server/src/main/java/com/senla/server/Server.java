package com.senla.server;

import com.senla.api.IController;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    private static final int PORT = 9090;
    private static final String EXCEPTION = "Exception: ";
    public static final String NEW_CLIENT = "new client";
    public static final String MAIN_SERVER_INITIATE_EXITING = "Main Server initiate exiting...";

    private static Logger log = Logger.getLogger(Server.class.getName());

    public static void runServer(IController controller) throws IOException {
        try (ServerSocket server = new ServerSocket(PORT)){
            log.info(MAIN_SERVER_INITIATE_EXITING);
            while(!server.isClosed()){
                Socket client = server.accept();
                new Thread(new MonoThreadClientHandler(client, controller)).start();
                System.out.println(NEW_CLIENT);
                log.info(NEW_CLIENT);
            }
        } catch (IOException e) {
            log.log(Level.SEVERE, EXCEPTION, e);
            throw new RuntimeException(e);
        }
    }

}
