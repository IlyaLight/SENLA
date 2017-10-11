package ui.senla.com;

public class MenuItem {
    private MenuController controller;
    private String title;
    private Menu nextMenu;
    private IAction action;


    public MenuItem(Menu nextMenu) {
        this.title = nextMenu.getNmae();
        this.nextMenu = nextMenu;
    }

    public MenuItem(MenuController controller, Menu nextMenu, String title, IAction action) {
        this.controller = controller;
        this.title = title;
        this.nextMenu = nextMenu;
        this.action = action;
    }

    public MenuController getController() {
        return controller;
    }

    public void setController(MenuController controller) {
        this.controller = controller;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Menu getNextMenu() {
        return nextMenu;
    }

    public void setNextMenu(Menu nextMenu) {
        this.nextMenu = nextMenu;
    }

    public IAction getAction() {
        return action;
    }

    public void setAction(IAction action) {
        this.action = action;
    }

    public void action(){
        action.action(controller);
    }
}
