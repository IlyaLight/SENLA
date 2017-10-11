package ui.senla.com;

public class Navigator {
    private static final String MENU_ITEMS = "\t%d - %s\n";

    private Menu menu;
    private int index;
    private Boolean stopRun = false;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void printMenu() {
        MenuItem item = (menu.getItems().get(index));
        if (item.getAction() != null){
            item.action();
        }
        if (stopRun){
            return;
        }
        menu = item.getNextMenu();
        //если null то ошибка!
        System.out.println(menu.getNmae());
        if (menu.getContent() != null) {
            System.out.println(menu.getContent());
        }
        int i = 0;
        for(MenuItem m : menu.getItems()){
            System.out.format(MENU_ITEMS, i, m.getTitle());
            i++;
        }
    }

    public  void navigate(Integer index){
        this.index = index;
    }

    public void stopRun(){
        stopRun = true;
    }
}
