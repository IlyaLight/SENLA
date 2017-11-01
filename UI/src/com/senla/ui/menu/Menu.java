package com.senla.ui.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Light on 05.10.2017.
 */
public class  Menu implements IMenu {

    private String name;
    private String content;
    private List<MenuItem> items = new ArrayList<>();

    public Menu(){}

    public Menu(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public List<MenuItem> getItems() {
        return items;
    }

    @Override
    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    @Override
    public void addItem(MenuItem item){
        items.add(item);
    }

    @Override
    public void addNextMenu(Menu menu) {
        items.add(new MenuItem(menu));
    }
}



