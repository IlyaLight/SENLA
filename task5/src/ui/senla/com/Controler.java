package ui.senla.com;

/**
 * Created by Light on 05.10.2017.
 *
 *
 *
 */
public class Controler {

    private static final String MENU_ITEMS = "\t%d - %s\n";
    private static Controler instance;
    private Menu menu;

    private Controler(Menu menu){
        this.menu = menu;
    }

    public static Controler getInstance(Menu menu){
        if (instance == null){
            instance = new Controler(menu);
        }
        return instance;
    }

    public Menu getMenu(){
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void runUI(){
        System.out.println(menu.getNmae());
        if (menu.getContent()!= null) {
            System.out.println(menu.getContent());
        }
        if (menu.getCommands().size() > 0){
            menu.getCommands().stream().forEach( command -> command.action());
        }
        int i = 0;
        for(IMenu m : menu.getMenuItem()){
            System.out.format(MENU_ITEMS, i, m.getNmae());
            i++;
        }

    }

    public void closeUI(){}
}
