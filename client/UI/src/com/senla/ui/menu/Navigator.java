package com.senla.ui.menu;

import com.senla.ui.controller.IMenuController;
import com.senla.ui.controller.MenuController;
import com.senla.ui.menu.Menu;
import com.senla.ui.menu.MenuItem;
import com.senla.ui.utility.Console;

public class Navigator {
    private static final String MENU_ITEMS = "\t%d - %s\n";
    private static final String LINE = "-----------------------------";
    private static final String INDENT = "\n\n";
    private static final String WRONG_VALUE_ENTERED = "wrong value entered";
    private static final String ENTER_EXIT_TO_EXIT_THE_PROGRAM = "enter \"exit\" to exit the program";
    private static final String EXIT = "exit";

    private Menu menu;
    private int index;

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public boolean navigate() {
        Console.out(INDENT);
        String in = Console.inString(ENTER_EXIT_TO_EXIT_THE_PROGRAM);
        int inInt = 0;
         if (in.equals(EXIT)){
            return false;
        }else {
             boolean getIndex = false;
             while (!getIndex) {
                 try {
                     inInt = Integer.parseInt(in);
                 } catch (NumberFormatException e) {
                     Console.out(WRONG_VALUE_ENTERED);
                 }
                 if (inInt < 0 || inInt > menu.getItems().size()) {
                     Console.out(WRONG_VALUE_ENTERED);
                 }else {
                     getIndex = true;
                 }
             }
        }
        index = inInt;
        return true;
    }

    public void printNextMenu() {
        menu = menu.getItems().get(index).getNextMenu();
        Console.out(INDENT);
        Console.out(LINE);
        Console.out(menu.getName());
        if (menu.getContent() != null) {
            Console.out(LINE);
            Console.out(menu.getContent());
        }
        Console.out(LINE);
        int i = 0;
        for(MenuItem m : menu.getItems()){
            System.out.format(MENU_ITEMS, i, m.getTitle());
            i++;
        }
    }

    public boolean isAction() {
        if (menu.getItems().get(index).getAction() == null){
            return false;
        }
        return true;
    }

    public void action(IMenuController menuController) {
        if (isAction()) {
            Console.out(INDENT);
            Console.out(LINE);
            Console.out(menu.getItems().get(index).getTitle());
            Console.out(LINE);
            menu.getItems().get(index).action(menuController);
            Console.out(LINE);
            Console.out("\n");
            Console.inString("press \"Enter\" to continue");
        }
    }
}
