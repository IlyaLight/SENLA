package com.senla.ui.controller;


import com.senla.client.IClientController;
import com.senla.dependencyinjection.annotation.Injection;
import com.senla.ui.menu.MenuBuilder;
import com.senla.ui.menu.Navigator;

public class UIController implements IUIController {

    private MenuBuilder menuBuilder = new MenuBuilder();
    private Navigator navigator = new Navigator();

    @Injection
    private IMenuController menuController;

    @Injection
    private IClientController shopController;

    public UIController() {
    }

    public UIController(IClientController shopController) {
        this.shopController = shopController;
    }

    public MenuBuilder getMenuBuilder() {
        return menuBuilder;
    }

    public void setMenuBuilder(MenuBuilder menuBuilder) {
        this.menuBuilder = menuBuilder;
    }

    public Navigator getNavigator() {
        return navigator;
    }

    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    public Object getMenuController() {
        return menuController;
    }

    public void setMenuController(IMenuController menuController) {
        this.menuController = menuController;
    }

    public IClientController getShopController() {
        return shopController;
    }

    public void setShopController(IClientController shopController) {
        this.shopController = shopController;
    }

    @Override
    public void run(){
        boolean run = true;
        menuController.setShopController(shopController);
        shopController.readSerializable();
        navigator.setMenu(menuBuilder.buildMenu());
        while (run){
            navigator.action(menuController);
            navigator.printNextMenu();
            run = navigator.navigate();
        }
        shopController.writeSerializable();
        shopController.stopClient();

    }



}
