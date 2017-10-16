package com.senla.ui.action;

import com.senla.ui.MenuController;

public class GetBooksSortedByName implements IAction {
    @Override
    public void action(MenuController controller) {
        controller.getBooksSortedByName();
    }
}
