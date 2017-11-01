package com.senla.ui.action;

import com.senla.ui.controller.MenuController;

public class GetBookDescription implements IAction {
    @Override
    public void action(MenuController menuController) {
        menuController.getBookDescription();
    }
}
