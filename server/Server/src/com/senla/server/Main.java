package com.senla.server;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            Server.runServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // write your code here
    }
}
