package com.senla.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MonoThreadClientHandler implements Runnable {

    private static Socket clientDialog;

    public MonoThreadClientHandler(Socket client){
        MonoThreadClientHandler.clientDialog = client;
    }

    @Override
    public void run() {
        try {
            DataOutputStream out = new DataOutputStream(clientDialog.getOutputStream());
            DataInputStream in = new DataInputStream(clientDialog.getInputStream());
            while (!clientDialog.isClosed()){
                String entry = in.readUTF();
                System.out.println(entry);
                if (entry.equalsIgnoreCase("exit")){
                    System.out.println("Client initialize connections suicide ...");
                    System.out.println("Server reply - " + entry + " - OK");
                    Thread.sleep(3000);
                    break;
                }
                //эхо
                System.out.println("Server try writing to channel");
                out.writeUTF("Server reply - " + entry + " - OK");
                System.out.println("Server Wrote message to clientDialog.");
                out.flush();
            }
            System.out.println("Client disconnected");

            // закрываем сначала каналы сокета !
            in.close();
            out.close();

            // потом закрываем сокет общения с клиентом в нити моносервера
            clientDialog.close();

            System.out.println("Closing connections & channels - DONE.");
        }catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
