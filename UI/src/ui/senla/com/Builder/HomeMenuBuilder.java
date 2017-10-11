package ui.senla.com.Builder;


import ui.senla.com.IMenu;

public class HomeMenuBuilder implements IBuilder {

    private static final String NAME = "Home menu";
    private static final String CONTENT = "SENLA JAVA curs" +
            "Book shop";

    @Override
    public void buildMenu(IMenu menu) {
        menu.setNmae(NAME);
        menu.setContent(CONTENT);
    }
}
