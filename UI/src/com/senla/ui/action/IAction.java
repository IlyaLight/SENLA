package com.senla.ui.action;

import com.senla.ui.controller.MenuController;

@FunctionalInterface
public interface IAction {
    void action(MenuController menuController);
}
