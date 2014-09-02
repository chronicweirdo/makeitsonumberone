package org.chronicweirdo.chattymonkey.dao.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by scacoveanu on 9/1/2014.
 */
public abstract class JPADAOTest {

    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        if (entityManager == null) {
            return getNewEntityManager();
        }
        return entityManager;
    }

    protected EntityManager getNewEntityManager() {
        if (entityManager != null) {
            entityManager.close();
        }
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(JPADAO.PERSISTENCE_UNIT_NAME);
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }
}
