package com.senla.server;
/*сервер для каждого нового подключения создает отдельный поток*/

import com.senla.api.IController;
import com.senla.properties.PropertiesUtil;
import com.senla.properties.PropertyNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    private static final Integer PORT;
    private static final String EXCEPTION = "Exception: ";
    private static final String NEW_CLIENT = "new client";
    private static final String MAIN_SERVER_INITIATE_EXITING = "Main Server initiate exiting...";
    private static final Logger LOGGER;


    private static final String PROPERTIES_FILE = "config.properties";

    static {
        LOGGER  = LoggerFactory.getLogger(Server.class);
        try {
            PORT = Integer.valueOf(PropertiesUtil.getProperties(PROPERTIES_FILE, "Server.port"));
        } catch (PropertyNotFoundException e) {
            LOGGER.error("не удалось получить параметры " + PROPERTIES_FILE);
            throw  new RuntimeException(e);
        }
    }


    public static void runServer(IController controller) throws IOException {
        try (ServerSocket server = new ServerSocket(PORT)){
            LOGGER.info(MAIN_SERVER_INITIATE_EXITING);
            while(!server.isClosed()){
                Socket client = server.accept();
                new Thread(new MonoThreadClientHandler(client, controller)).start();    //new thread
                LOGGER.info(NEW_CLIENT);
            }
        } catch (IOException e) {
            LOGGER.error(EXCEPTION, e);
            throw new RuntimeException(e);
        }
    }

}
