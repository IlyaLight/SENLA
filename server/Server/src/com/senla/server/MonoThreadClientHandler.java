package com.senla.server;

import com.senla.booksshop.controller.IController;
import com.senla.booksshop.exception.ObjectAvailabilityException;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

public class MonoThreadClientHandler implements Runnable {

    private static Socket client;
    private static IController controller;

    public MonoThreadClientHandler(Socket client, IController controller){
        MonoThreadClientHandler.client = client;
        MonoThreadClientHandler.controller = controller;

    }

    @Override
    public void run() {

        try {
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            while (!client.isClosed()){
                Command command = (Command)in.readObject();
                out.writeObject (executeCommand(command));
            }
            System.out.println("Client disconnected");
            in.close();
            out.close();
            client.close();
            System.out.println("Closing connections & channels - DONE.");
        }catch (IOException | ClassNotFoundException e) {
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
                throw new RuntimeException(e);
            }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
