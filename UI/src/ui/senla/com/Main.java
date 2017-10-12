package ui.senla.com;

import com.senla.booksshop.controller.*;
import com.senla.booksshop.utility.WorkWithFile;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //WorkWithFile.createFiles("");
        MenuController menuController = new MenuController();
        menuController.run();
    }
}
