package com.senla.booksshop.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
    private static final String CREATE_ENTITY_MANAGER_FACTORY = "create EntityManagerFactory";
    private static final EntityManagerFactory managerFactory;
    private static final ThreadLocal<EntityManager> threadLocal;

    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateUtil.class);

    static {
        managerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        threadLocal = new ThreadLocal<EntityManager>();
        LOGGER.info(CREATE_ENTITY_MANAGER_FACTORY);
    }

    public static EntityManager getEntityManager() {
        EntityManager em = threadLocal.get();

        if (em == null) {
            em = managerFactory.createEntityManager();
            threadLocal.set(em);
        }
        return em;
    }

    public static void closeEntityManager() {
        EntityManager em = threadLocal.get();
        if (em != null) {
            em.close();
            threadLocal.set(null);
        }
    }

    public static void closeEntityManagerFactory() {
        managerFactory.close();
    }

    public static void beginTransaction() {
        getEntityManager().getTransaction().begin();
    }

    public static void rollback() {
        getEntityManager().getTransaction().rollback();
    }

    public static void commit() {
        getEntityManager().getTransaction().commit();
    }

}
