package com.senla.booksshop.utility;

import com.senla.booksshop.model.IModel;

import java.util.ArrayList;
import java.util.List;

public class IdUtil {
    public static <T extends IModel> int getId(List<T> tList) {
        List<Integer> idSet = new ArrayList<>();
        for (IModel iModel : tList) {
            idSet.add(iModel.getId());
        }
        for (int i = 1;; i++) {
            if(!idSet.contains(i)){
                return i;
            }
        }

    }
}
