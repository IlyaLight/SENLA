package ui.senla.com;

import com.senla.booksshop.controller.Controller;
import com.senla.booksshop.controller.IController;

import java.util.Date;

public class MenuBuilder {

    private MenuController menuController;
    private IController shopController;

    public MenuBuilder(MenuController menuController ,IController shopController){
        this.menuController = menuController;
        this.shopController = shopController;
    }

    private Menu rootMenu = new Menu();

    public Menu getRootMenu() {
        return rootMenu;
    }

    public Menu buildMenu(){
        Menu homeMenu = new Menu("Home");
        homeMenu.setContent(
                "\t     SENLA\n" +
                "\tcourses on java\n" +
                "\t  Book shop");

        Menu orderMenu = new Menu("Order");
        Menu bookMenu = new Menu("Book");
        Menu requestMenu = new Menu("Request");
        Menu shopMenu = new Menu("Shop");

        rootMenu.addNextMenu(homeMenu);

        homeMenu.addItem(new MenuItem(homeMenu, "EXIT", () -> menuController.stopRun()));
        homeMenu.addNextMenu(orderMenu);
        homeMenu.addNextMenu(bookMenu);
        homeMenu.addNextMenu(requestMenu);
        homeMenu.addNextMenu(shopMenu);



        shopMenu.addItem(new MenuItem(homeMenu));
        shopMenu.addItem(new MenuItem(shopMenu, "Income", () ->{
            System.out.println("Income for a period of time");
            System.out.println(shopController.getIncome(Console.getDate("from"),Console.getDate("to")));
        } ));
        return rootMenu;
    }


}
