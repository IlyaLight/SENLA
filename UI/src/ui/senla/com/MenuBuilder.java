package ui.senla.com;

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
        Menu shopMenu = new Menu("Order");

        rootMenu.addNextMenu(homeMenu);

        homeMenu.addItem(new MenuItem(menuController, homeMenu, "EXIT", menuController -> menuController.stopRun()));
        homeMenu.addNextMenu(shopMenu);
        homeMenu.addNextMenu(bookMenu);
        homeMenu.addNextMenu(requestMenu);
        homeMenu.addNextMenu(orderMenu);

        shopMenu.addItem(new MenuItem(menuController, shopMenu, "Income", menuController -> System.out.println(shopController.getIncome(new Date(),new Date())) ));

        return rootMenu;
    }


}
