package ui.senla.com;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Menu menu = new Menu();
        Menu menu0 = new Menu();
        Menu menu1 = new Menu();
        Menu menu2 = new Menu();
        Menu menu3 = new Menu();
        menu.setNmae("menu test");
        List<Menu> menus = new ArrayList<>();
        menu0.setNmae("menu0");
        menu1.setNmae("menu1");
        menu2.setNmae("menu2");
        menu3.setNmae("menu3");
        menus.add(menu0);
        menus.add(menu1);
        menus.add(menu2);
        menus.add(menu3);
        menu.setMenuItem(menus);
        Controler controler = Controler.getInstance(menu);
        controler.setMenu(menu);
        controler.runUI();
    }
}
