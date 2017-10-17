package com.senla.ui.action;

import com.senla.ui.controller.MenuController;

public class GetStaleBooksPrice implements IAction {
    @Override
    public void action(MenuController menuController) {
        menuController.getStaleBooksPrice();
    }
}
