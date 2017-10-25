package com.senla.ui.action;

import com.senla.ui.controller.MenuController;

public class ExportAllStores implements IAction {
    @Override
    public void action(MenuController menuController) {
        menuController.exportAllStores();
    }
}
