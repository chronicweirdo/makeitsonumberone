package org.chronicweirdo.tdd.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Created by Silviu on 6/22/14.
 */
public class HibernatePersonDaoIntegrationTest {

    @Test
    public void persistedObjectExistsInTheDatabase() throws Exception {
        SessionFactory sessionFactory = getSessionFactory();
        HibernatePersonDao dao = new HibernatePersonDao();
        dao.setSessionFactory(sessionFactory);

        Person person = new Person("John", "Doe");
        dao.save(person);
        assertNotNull(person.getId());

        Session session = sessionFactory.openSession();
        Object copy = session.get(Person.class, person.getId());
        assertEquals(person, copy);
    }

    private SessionFactory getSessionFactory() throws Exception {
        return createConfiguration().buildSessionFactory();
    }

    private Configuration createConfiguration() throws Exception {
        Configuration configuration = loadProductionConfiguration();
        loadTestConfigurationInto(configuration, "/hibernate.test.properties");
        return null;
    }

    private void loadTestConfigurationInto(Configuration configuration, String path) throws Exception {
        Properties properties = loadPropertiesFromPath(path);
        Enumeration keys = properties.keys();
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            String value = properties.getProperty(key);
            configuration.setProperty(key, value);
        }
    }

    private Properties loadPropertiesFromPath(String path) throws Exception {
        InputStream inputStream = getClass().getResourceAsStream(path);
        assertNotNull("resource not found: " + path, inputStream);
        Properties properties = new Properties();
        properties.load(inputStream);
        inputStream.close();
        return properties;
    }

    private Configuration loadProductionConfiguration() {
        return new Configuration().configure();
    }
}
