package ui.senla.com;

import java.util.List;
import java.util.Scanner;

public interface IMenu {

    String getNmae();

    void setNmae(String nmae);

    String getContent();

    void setContent(String content);

    List<MenuItem> getItems();

    void setItems(List<MenuItem> items);

    void addItem(MenuItem item);

    void addNextMenu(Menu menu);
}

