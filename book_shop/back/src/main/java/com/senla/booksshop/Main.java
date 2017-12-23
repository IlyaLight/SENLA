package com.senla.booksshop;



import com.senla.api.model.Book;
import com.senla.booksshop.dao.realization.MySqlBookDao;
import com.senla.booksshop.stores.BookStore;
import com.senla.booksshop.utility.JdbcMySqlUtil;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.PatternLayout;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;


public class Main {

    public static void main(String[] args) throws Exception{
        Properties prop = new Properties();
        InputStream input = new FileInputStream("log4j.properties");
        prop.load(input);
        String pattern = prop.getProperty("log4j.appender.stdout.layout.conversionPattern");
        BasicConfigurator.configure(new ConsoleAppender(new PatternLayout(pattern)));

        BookStore bookStore = new BookStore();

        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, Calendar.FEBRUARY, 1);

        MySqlBookDao mySqlBookDao = new MySqlBookDao();
        Book book = new Book();
        book.setName("x");
        book.setDateIssue(new Date());
        book.setDatePublication(calendar.getTime());
        book.setPrice((float)90);
        book.setInStock(2);

        bookStore.create(book);

        JdbcMySqlUtil.closeConnection();
    }




}
