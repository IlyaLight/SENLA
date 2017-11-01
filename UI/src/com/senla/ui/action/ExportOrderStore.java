package com.senla.ui.action;

import com.senla.ui.controller.MenuController;

public class ExportOrderStore implements IAction {
    @Override
    public void action(MenuController menuController) {
        menuController.exportOrderStore();
    }
}
