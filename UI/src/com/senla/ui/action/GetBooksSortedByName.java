package com.senla.ui.action;

import com.senla.ui.controller.IMenuController;

public class GetBooksSortedByName implements IAction {
    @Override
    public void action(IMenuController controller) {
        controller.getBooksSortedByName();
    }
}
