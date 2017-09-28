package com.senla.booksshop.collection;

import com.danco.training.TextFileWorker;
import com.senla.booksshop.interfaces.TextFileWork;
import com.senla.booksshop.objekt.Order;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Light on 27.09.2017.
 */
public class CollectionOrder implements TextFileWork {

    private ArrayList<Order> orderArrayList = new ArrayList<Order>();

    public ArrayList<Order> getOrderArrayList() {
        return orderArrayList;
    }

    public  void readFromFile(final String filePath){
        TextFileWorker textFileWorker = new TextFileWorker(filePath);
        String[] strings = textFileWorker.readFromFile();
        orderArrayList = new ArrayList<Order>();
        for (String string : strings) {
            String[] order = string.split(" ");
            orderArrayList.add(new Order(order[0],
                    Float.parseFloat(order[2]),
                    new Date(Long.decode(order[1])),
                    order[3],
                    Boolean.parseBoolean(order[4])));
        }
    }

    public void writeToFile(final String filePath){
        TextFileWorker textFileWorker = new TextFileWorker(filePath);
        ArrayList<String> orders = new ArrayList<String>();
        for (Order order : orderArrayList) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(order.getBookName() + " ");
            stringBuilder.append(order.getPrice() + " ");
            stringBuilder.append(order.getDataCompletion().getTime() + " ");
            stringBuilder.append(order.getStatus() + " ");
            stringBuilder.append(order.isCompleted());
            orders.add(stringBuilder.toString());
        }
        textFileWorker.writeToFile(orders.toArray(new String[orders.size()]));
    }
}
