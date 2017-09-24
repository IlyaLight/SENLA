package com.senla.booksshop.Request;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class RequestNumberRequestComparator implements Comparator<String> {
    Map<String, Integer> map;

    public RequestNumberRequestComparator(HashMap<String, Integer> map){
        this.map = map;
    }

    @Override
    public int compare(String o1, String o2) {
        if (map.get(o1) > map.get(o2)){
            return -1;
        }
        if (map.get(o1) < map.get(o2)){
            return 1;
        }
        return 0;
    }
}
