package com.senla.ui.action;

import com.senla.ui.controller.IMenuController;

@FunctionalInterface
public interface IAction {
    void action(IMenuController menuController);
}
