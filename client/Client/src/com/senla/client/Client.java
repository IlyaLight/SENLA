package com.senla.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private static final int PORT = 9090;
    private static final String ADDRESS = "localhost";

    static Socket socket;

    public Client() {
        try {
            // создаём сокет общения на стороне клиента в конструкторе объекта
            socket = new Socket(ADDRESS, PORT);
            System.out.println("Client connected to socket");
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {


        try (

                // создаём объект для записи строк в созданный скокет, для
                // чтения строк из сокета
                // в try-with-resources стиле
                DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
                DataInputStream ois = new DataInputStream(socket.getInputStream())) {
            System.out.println("Client oos & ois initialized");

            int i = 0;
            // создаём рабочий цикл
            while (true) {

                // пишем сообщение автогенерируемое циклом клиента в канал
                // сокета для сервера
                oos.writeUTF("clientCommand " + i);

                // проталкиваем сообщение из буфера сетевых сообщений в канал
                oos.flush();

                // ждём чтобы сервер успел прочесть сообщение из сокета и
                // ответить
                Thread.sleep(10);
                System.out.println("Client wrote & start waiting for data from server...");

                // забираем ответ из канала сервера в сокете
                // клиента и сохраняем её в ois переменную, печатаем на
                // консоль
                System.out.println("reading...");
                String in = ois.readUTF();
                System.out.println(in);
                i++;
                Thread.sleep(5000);

            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();}
    }
}
