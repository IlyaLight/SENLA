package com.senla.booksshop.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
    private static final String CREATE_ENTITY_MANAGER_FACTORY = "create EntityManagerFactory";
    private static EntityManagerFactory managerFactory;

    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateUtil.class);

    public static EntityManagerFactory getEntityManagerFactory() {
        if (managerFactory == null) {
            managerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            LOGGER.info(CREATE_ENTITY_MANAGER_FACTORY);
        }
        return managerFactory;
    }

    public static EntityManager getEm(){
        if (managerFactory == null) {
            getEntityManagerFactory();
        }
        return managerFactory.createEntityManager();
    }

    public static void shutdownEntityManagerFactory() {
        if (managerFactory != null) {
            managerFactory.close();
            managerFactory = null;
        }
    }

}
