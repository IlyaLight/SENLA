package com.senla.ui.action;

import com.senla.ui.controller.IMenuController;

public class ExportOrderStore implements IAction {
    @Override
    public void action(IMenuController menuController) {
        menuController.exportOrderStore();
    }
}
