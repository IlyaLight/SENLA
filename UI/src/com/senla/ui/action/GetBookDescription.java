package com.senla.ui.action;

import com.senla.ui.controller.IMenuController;

public class GetBookDescription implements IAction {
    @Override
    public void action(IMenuController menuController) {
        menuController.getBookDescription();
    }
}
