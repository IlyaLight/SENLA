package ui.senla.com.Builder;

import ui.senla.com.Builder.IBuilder;
import ui.senla.com.IMenu;

public class ExitMenuBuilder implements IBuilder {

    private static final String NAME = "Закрыить программу";
    private static final String CONTENT = "Вы уверены что хотите закрыть программу";

    @Override
    public void buildMenu(IMenu menu) {


        menu.setNmae(NAME);
        menu.setContent(CONTENT);
        menu.addCommand(menu1 -> {
            if ()
            menu.getScanner().close();
            System.exit(0);
        });
    }
}
