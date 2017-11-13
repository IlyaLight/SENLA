package com.senla.server;

import com.senla.booksshop.controller.IController;
import com.senla.booksshop.exception.ObjectAvailabilityException;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MonoThreadClientHandler implements Runnable {

    public static final String DISCONNECTED = "Client disconnected";
    public static final String CLOSING_CONNECTIONS_CHANNELS_DONE = "Closing connections & channels - DONE.";
    private static final String EXCEPTION = "Exception: ";
    public static final String STOP_CLIENT = "stopClient";
    private static Socket client;
    private static IController controller;

    private static Logger log = Logger.getLogger(MonoThreadClientHandler.class.getName());

    public MonoThreadClientHandler(Socket client, IController controller){
        MonoThreadClientHandler.client = client;
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
                out.writeObject (executeCommand(command));
            }
            System.out.println(DISCONNECTED);
            log.info(DISCONNECTED);
            in.close();
            out.close();
            client.close();
            System.out.println(CLOSING_CONNECTIONS_CHANNELS_DONE);
            log.info(CLOSING_CONNECTIONS_CHANNELS_DONE);
        }catch (IOException | ClassNotFoundException e) {
            log.log(Level.SEVERE, EXCEPTION, e);
            throw new RuntimeException(e);
        }
    }

    public Response executeCommand(Command command){
        Class[] paramType = null;
        if (command.getParams() != null) {
            int length = command.getParams().length;
            paramType = new Class[length];
            while (length > 0) {
                length--;
                paramType[length] = command.getParams()[length].getClass();
            }
        }
        Class clazz = controller.getClass();
        try {
            Method method = clazz.getMethod(command.getMethodName(), paramType);
            try {
                return new Response(method.invoke(controller, command.getParams()));
            } catch (InvocationTargetException e){
                return new Response(e);
            } catch (IllegalAccessException e){
                log.log(Level.SEVERE, EXCEPTION, e);
                throw new RuntimeException(e);
            }
        } catch (NoSuchMethodException e) {
            log.log(Level.SEVERE, EXCEPTION, e);
            throw new RuntimeException(e);
        }
    }
}
