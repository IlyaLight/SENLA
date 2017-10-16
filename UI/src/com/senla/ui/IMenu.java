package com.senla.ui;

import java.util.List;

public interface IMenu {

    String getNamae();

    void setNamae(String namae);

    String getContent();

    void setContent(String content);

    List<MenuItem> getItems();

    void setItems(List<MenuItem> items);

    void addItem(MenuItem item);

    void addNextMenu(Menu menu);
}

