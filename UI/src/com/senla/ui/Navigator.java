package com.senla.ui;

import com.senla.ui.utility.Console;

public class Navigator {
    private static final String MENU_ITEMS = "\t%d - %s\n";
    private static final String LINE = "------------------------";
    private static final String INDENT = "\n\n\n\n";
    private static final String WRONG_VALUE_ENTERED = "wrong value entered";
    private static final String ENTER_EXIT_TO_EXIT_THE_PROGRAM = "enter \"exit\" to exit the program";
    private static final String EXTI = "exti";

    private Menu menu;
    private int index;

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public boolean navigate() {
        String in = Console.inString(ENTER_EXIT_TO_EXIT_THE_PROGRAM);
        int inint = 0;
         if (in.equals(EXTI)){
            return false;
        }else {
             boolean getIndex = false;
             while (getIndex == false) {
                 try {
                     inint = Integer.parseInt(in);
                 } catch (NumberFormatException e) {
                     Console.out(WRONG_VALUE_ENTERED);
                 }
                 if (inint < 0 || inint > menu.getItems().size()) {
                     Console.out(WRONG_VALUE_ENTERED);
                 }else {
                     getIndex = true;
                 }
             }
        }
        index = inint;
        return true;
    }

    public void printNextMenu() {
        menu = menu.getItems().get(index).getNextMenu();
        Console.out(INDENT);
        Console.out(LINE);
        Console.out(menu.getNamae());
        if (menu.getContent() != null) {
            Console.out(LINE);
            Console.out(menu.getContent());
        }
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

    public void action(MenuController menuController) {
        if (isAction()) {
            menu.getItems().get(index).action(menuController);
        }
    }
}
