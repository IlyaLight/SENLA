package com.senla.ui.action;

import com.senla.ui.MenuController;

public class GetOrderSortedByStatus implements IAction {
    @Override
    public void action(MenuController menuController) {
        menuController.getOrderSortedByStatus();
    }
}
