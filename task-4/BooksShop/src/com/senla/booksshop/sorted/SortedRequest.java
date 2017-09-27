package com.senla.booksshop.sorted;

import com.senla.booksshop.objekt.Request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by Light on 24.09.2017.
 */
public class SortedRequest {

    public SortedRequest() {
    }

    public SortedRequest(ArrayList<Request> requestArrayList) {
        this.requestArrayList = requestArrayList;
    }

    private ArrayList<Request> requestArrayList;

    public ArrayList<Request> getRequestArrayList() {
        return requestArrayList;
    }

    public void setRequestArrayList(ArrayList<Request> requestArrayList) {
        this.requestArrayList = requestArrayList;
    }

    public TreeSet<Request> getRequstSortedByBookName() {
        TreeSet<Request> treeSet = new TreeSet<>(new RequestBookNameComparator());
        treeSet.addAll(requestArrayList);
        return treeSet;
    }

    public ArrayList<Request> getRequstSortedNumberRequst() {
        HashMap<String, Integer> map = new HashMap<>();
        String bookName;
        for (Request request : requestArrayList) {
            bookName = request.getBookName();
            if (map.containsKey(bookName)){
                map.put(bookName, map.get(bookName) + 1);
            }
            else {
                map.put(bookName, 1);
            }
        }
        TreeMap<String, Integer> treeMap = new TreeMap<>(new RequestNumberRequestComparator(map));
        treeMap.putAll(map);
        ArrayList<Request> sortedArray = new ArrayList<>();
        for (String nameBook : treeMap.keySet()) {
            for (Request request : requestArrayList) {
                if (request.getBookName().equals(nameBook)){
                    sortedArray.add(request);
                }
            }
        }
        return sortedArray;
    }
}
