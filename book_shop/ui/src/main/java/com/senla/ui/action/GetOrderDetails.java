package com.senla.ui.action;

import com.senla.ui.controller.IMenuController;

public class GetOrderDetails implements IAction {
    @Override
    public void action(IMenuController IMenuController) {
        IMenuController.getOrderDetails();
    }
}
