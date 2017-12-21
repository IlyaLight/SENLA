package com.senla.ui.utility;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class Console {

    public static final Scanner scanner = new Scanner(System.in);
    public static final String DATE_FORMAT = "yyyy, mm, dd";
    public static final String WRONG_DATA = "wrong data";
    public static final String GET_DATE = "enter the date \"%s\" in the format: ";
    public static final String NOT_INTEGER = "\"you did not enter an integer\"";
    public static final String GETIN = "the number should be in the range from %d to %d inclusively";
    public static final String GETIN_NOT_IN_RANGE = "the number is not in the range from %d to %d inclusively";

    public static Date getDate(String s){
        System.out.format(GET_DATE, s);
        System.out.println(DATE_FORMAT);
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        Date date = null;
        boolean wrong = true;
        while (wrong) {
            try {
                date = sdf.parse(scanner.nextLine());
                wrong = false;
            }catch(Exception e) {
                System.out.println(WRONG_DATA);
            }
        }
        return date;
    }

    public static int getInt(){
        int i = 0;
        boolean wrong = true;
        while (wrong) {
            if (scanner.hasNextInt()) {
                i = scanner.nextInt();
                wrong = false;
            } else {
                System.out.println(NOT_INTEGER);
            }
        }
        return i;
    }

    public static int getInt(String s){
        System.out.println(s);
        return getInt();
    }

    public static int getInt(int min, int max){
        int i = 0;
        boolean wrong = true;
        System.out.format(GETIN, min, max);
        while (wrong) {
            i = getInt();
            if (i >= min && i <= max){
                wrong = false;
            } else {
                System.out.format(GETIN_NOT_IN_RANGE, min, max);
            }
        }
        return i;
    }

    public static void out(String s){
        System.out.println(s);
    }

    public static String inString(){
        return scanner.nextLine();
    }

    public static String inString(String s){
        System.out.println(s);
        return scanner.nextLine();
    }

    static public void outCollection(Collection collection){
        for (Object o : collection) {
            System.out.println(o);
        }
    }

    static public boolean confirmation(String s){
        System.out.println(s);
        System.out.println("y/n");
        String in = scanner.nextLine();
        while (true) {
            if (in.equals("y")) {
                return true;
            } else if (in.equals("n")) {
                return false;
            }
        }

    }
}
