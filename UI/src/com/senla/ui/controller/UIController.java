package com.senla.ui.controller;


import com.senla.annotation.Injection;
import com.senla.booksshop.controller.IController;
import com.senla.ui.Navigator;
import com.senla.ui.menu.MenuBuilder;

public class UIController implements IUIController {

    private MenuBuilder menuBuilder = new MenuBuilder();
    private Navigator navigator = new Navigator();

    @Injection
    private IMenuController menuController;

    @Injection
    private IController shopController;

    public UIController() {
    }

    public UIController(IController shopController, String filePath) {
        this.shopController = shopController;
        menuController = new MenuController(shopController);

    }

    @Override
    public void run(){
        boolean run = true;
        shopController.readSerializable();
        navigator.setMenu(menuBuilder.buildMenu());
        while (run){
            navigator.action(menuController);
            navigator.printNextMenu();
            run = navigator.navigate();
        }
        shopController.writeSerializable();
    }



}
