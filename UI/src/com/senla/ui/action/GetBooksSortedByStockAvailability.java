package com.senla.ui.action;

import com.senla.ui.controller.MenuController;

public class GetBooksSortedByStockAvailability implements IAction {

    @Override
    public void action(MenuController menuController) {
        menuController.getBooksSortedByStockAvailability();
    }
}
