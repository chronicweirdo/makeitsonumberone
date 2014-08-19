package org.chronicweirdo.chattymonkey.dao.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by scacoveanu on 8/19/2014.
 */
public class JPADAO {

    public static final String PERSISTENCE_UNIT_NAME = "org.chronicweirdo.chattymonkey.jpa";

    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
