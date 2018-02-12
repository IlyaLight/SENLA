package com.senla.back.dao.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    @Autowired
    private static SessionFactory sessionFactory;

    public static Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
