package com.senla.booksshop.collection;

import com.danco.training.TextFileWorker;
import com.senla.booksshop.objekt.Request;

import java.util.ArrayList;

/**
 * Created by Light on 27.09.2017.
 */
public class CollectionRequest {

    private ArrayList<Request> requestArrayList;

    public  void readFromFile(String filePath){
        TextFileWorker textFileWorker = new TextFileWorker(filePath);
        String[] strings = textFileWorker.readFromFile();
        requestArrayList = new ArrayList<Request>();
        for (String string : strings) {
            String[] order = string.split(" ");
            requestArrayList.add(new Request(order[0],
                    Boolean.parseBoolean(order[1])));
        }
    }

    public void writeToFile(String filePath){
        TextFileWorker textFileWorker = new TextFileWorker(filePath);
        ArrayList<String> orders = new ArrayList<String>();
        for (Request order : requestArrayList) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(order.isCompleted());
        }
        textFileWorker.writeToFile(orders.toArray(new String[orders.size()]));
    }
}
