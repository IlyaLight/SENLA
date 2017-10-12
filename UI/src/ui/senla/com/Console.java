package ui.senla.com;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Console {

    static final Scanner scaner = new Scanner(System.in);
    static final String dateFormat = "yyyy, mm, dd";
    static final String WRONG_DATA = "wrong data";

    static Date getDate(String s){
        System.out.println("enter the date \"" + s + "\" in the format: " + dateFormat);
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = null;
        boolean wrong = true;
        while (wrong) {
            try {
                date = sdf.parse(scaner.nextLine());
                wrong = false;
            }catch(Exception e) {
                System.out.println(WRONG_DATA);
            }
        }
        return date;
    }

    static int getInt(){
        int i = 0;
        boolean wrong = true;
        while (wrong) {
            if (scaner.hasNextInt()) {
                i = scaner.nextInt();
                wrong = false;
            } else {
                System.out.println("you did not enter an integer");
            }
        }
        return i;
    }

    static int getInt(int min, int max){
        int i = 0;
        boolean wrong = true;
        System.out.println("the number should be in the range from " + min + " to " + max + " inclusively");
        while (wrong) {
            i = getInt();
            if (i >= min && i <= max){
                wrong = false;
            } else {
                System.out.println("the number is not in the range from " + min + " to " + max + " inclusively");
            }
        }
        return i;
    }


}
