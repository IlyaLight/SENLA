package ui.senla.com;

import java.util.List;
import java.util.Scanner;

public interface IMenu {
    String getNmae();

    void setNmae(String nmae);

    String getContent();

    void setContent(String content);

    List<IMenu> getMenuItem();

    void setMenuItem(List<IMenu> menuItem);

    List<IAction> getCommands();

    void setCommands(List<IAction> commands);

    void addCommand(IAction command);

    void addMenuItem(IMenu menu);

    Scanner getScanner();

    void setScanner(Scanner scanner);
}
