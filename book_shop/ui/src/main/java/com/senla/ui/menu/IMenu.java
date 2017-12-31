package com.senla.ui.menu;

import java.util.List;

public interface IMenu {

    String getName();

    void setName(String name);

    String getContent();

    void setContent(String content);

    List<MenuItem> getItems();

    void setItems(List<MenuItem> items);

    void addItem(MenuItem item);

    void addNextMenu(Menu menu);
}

