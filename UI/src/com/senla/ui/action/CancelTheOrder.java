package com.senla.ui.action;

import com.senla.ui.MenuController;

public class CancelTheOrder implements IAction {
    @Override
    public void action(MenuController menuController) {
        menuController.cancelTheOrder();
    }
}
