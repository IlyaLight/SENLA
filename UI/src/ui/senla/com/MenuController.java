package ui.senla.com;


import com.senla.booksshop.controller.Controller;
import com.senla.booksshop.controller.IController;

import java.util.Scanner;

public class MenuController
{
    private IController shopController = new Controller();
    private MenuBuilder menuBuilder = new MenuBuilder(this, shopController);
    private Navigator navigator = new Navigator();
    private boolean stopRun = false;


    public void run(){
        try {
            shopController.readFromFile("");
        }catch (IllegalArgumentException e){
            System.out.println("could not read data from file");
            stopRun();
        }
        navigator.setMenu(menuBuilder.buildMenu());
        Scanner scanner = new Scanner(System.in);
        while (true){
            navigator.printMenu();
            if (stopRun){
                break;
            }
            navigator.setIndex(scanner.nextInt());

        }

    }

    public void stopRun(){
        stopRun = true;
        navigator.stopRun();
    }
}
