package com.senla.ui.controller;


import com.senla.booksshop.controller.IController;
import com.senla.ui.Navigator;
import com.senla.ui.menu.MenuBuilder;

public class UIController implements IUIController {

    private MenuBuilder menuBuilder = new MenuBuilder();
    private Navigator navigator = new Navigator();
    private MenuController menuController;
    private IController shopController;

    public UIController(IController shopController, String filePath) {
        this.shopController = shopController;
        menuController = new MenuController(shopController);
        shopController.readPropertiesFromFile(filePath);
        shopController.readSerializable();
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
        shopController.writeSerializable();
    }



}
