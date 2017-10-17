package com.senla.ui.controller;


import com.senla.booksshop.controller.IController;
import com.senla.ui.MenuBuilder;
import com.senla.ui.Navigator;

public class UIController implements IUIController {

    private MenuBuilder menuBuilder = new MenuBuilder();
    private Navigator navigator = new Navigator();
    private MenuController menuController;

    public UIController(IController shopController, String filePath) {
        menuController = new MenuController(shopController);
        shopController.readFromFile(filePath);
        navigator.setMenu(menuBuilder.buildMenu());
    }

    @Override
    public void run(){
        boolean run = true;
        while (run){
            navigator.action(menuController);
            navigator.printNextMenu();
            run = navigator.navigate();
        }
    }



}
