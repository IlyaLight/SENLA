package com.senla.ui;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Light on 05.10.2017.
 */
public class  Menu implements IMenu {

    private String namae;
    private String Content;
    private List<MenuItem> items = new ArrayList<>();

    public Menu(){}

    public Menu(String namae) {
        this.namae = namae;
    }

    @Override
    public String getNamae() {
        return namae;
    }

    @Override
    public void setNamae(String namae) {
        this.namae = namae;
    }

    @Override
    public String getContent() {
        return Content;
    }

    @Override
    public void setContent(String content) {
        this.Content = content;
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



