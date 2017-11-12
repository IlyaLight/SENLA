package com.senla.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class ClientNIO {
    private static final int PORT = 9090;
    private static final String ADDRESS = "localhost";
    private ByteBuffer buffer = ByteBuffer.allocate(16);

    private void run() throws IOException{
        Selector selector = Selector.open();
        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking( false );
        channel.register(selector, SelectionKey.OP_CONNECT);
        channel.connect(new InetSocketAddress(ADDRESS, PORT));
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(2);
        new Thread(() ->{
            Scanner scanner = new Scanner(System.in);
            while (true){
                try {
                    queue.put(scanner.nextLine());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                SelectionKey key = channel.keyFor(selector);
                key.interestOps(SelectionKey.OP_WRITE);
                selector.wakeup();
            }
        }).start();
        while (true){
            selector.select();
            for (SelectionKey key : selector.selectedKeys()) {
                if (key.isConnectable()){
                    channel.finishConnect();
                }else if (key.isReadable()){
                    buffer.clear();
                    channel.read(buffer);
                    System.out.println("Received = " + new String(buffer.array()));
                }else if (key.isWritable()){
                    String line = queue.poll();
                    if (line != null){
                        channel.write(ByteBuffer.wrap(line.getBytes()));
                    }
                }
            }

        }


    }
}
