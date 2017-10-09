package ui.senla.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Light on 05.10.2017.
 */
public class  Menu implements IMenu {

    private String nmae;
    private String Content;
    private List<IMenu> menuItem = new ArrayList<>();
    private List<IAction> commands = new ArrayList<>();
    private Scanner scanner;


    @Override
    public String toString() {
        return nmae;
    }

    @Override
    public String getNmae() {
        return nmae;
    }

    @Override
    public void setNmae(String nmae) {
        this.nmae = nmae;
    }

    @Override
    public String getContent() {
        return Content;
    }

    @Override
    public void setContent(String content) {
        this.Content = content;
    }

    @Override
    public List<IMenu> getMenuItem() {
        return menuItem;
    }

    @Override
    public void setMenuItem(List<IMenu> menuItem) {
        this.menuItem = menuItem;
    }

    @Override
    public List<IAction> getCommands() {
        return commands;
    }

    @Override
    public void setCommands(List<IAction> commands) {
        this.commands = commands;
    }

    @Override
    public void addCommand(IAction command) {
        commands.add(command);
    }

    @Override
    public void addMenuItem(IMenu menu){
        if (menuItem.size() > 0 && menu.getMenuItem().size() > 0){
            //ошибка напровления сборки иерахии дерива меню
        }
        else if (menuItem.size() >= 0 && menu.getMenuItem().size() == 0){
            menuItem.add(menu);
            menu.addMenuItem(this);
        }
        else menuItem.add(menu);
    }

    @Override
    public Scanner getScanner() {
        return scanner;
    }

    @Override
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
