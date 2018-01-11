package com.senla.booksshop;



import com.senla.api.model.Book;
import com.senla.booksshop.dao.api.IBookDao;
import com.senla.booksshop.dao.realization.hibernate.HibernateBookDao;
import com.senla.booksshop.utility.HibernateUtil;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.PatternLayout;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;


public class Main {

    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("log4j.properties");
            prop.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String pattern = prop.getProperty("log4j.appender.stdout.layout.conversionPattern");
        BasicConfigurator.configure(new ConsoleAppender(new PatternLayout(pattern)));


        EntityManagerFactory sessionFactory  = HibernateUtil.getEntityManagerFactory();
        EntityManager entityManager = sessionFactory.createEntityManager();

        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, Calendar.FEBRUARY, 1);

        Book book = new Book();
        book.setName("x");
        book.setDateIssue(new Date());
        book.setDatePublication(calendar.getTime());
        book.setPrice((float)90);
        book.setInStock(2);

     /*   entityManager.getTransaction().begin();
        entityManager.persist( book );
        entityManager.getTransaction().commit();
        entityManager.close();*/

        IBookDao bookDao = new  HibernateBookDao();
        book = bookDao.getByPK(10);
        System.out.println("book name");
        System.out.println(book.getName());



        HibernateUtil.shutdown();


    }




}
