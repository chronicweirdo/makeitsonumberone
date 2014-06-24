package org.chronicweirdo.junk.collection;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by scacoveanu on 6/24/2014.
 */
public class FilterCollectionTest {

    public class SimpleBean {
        public SimpleBean(String name, int age) {
            this.name = name;
            this.age = age;
        }

        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    @Test
    public void equalsFieldFilterTest() throws Exception {
        SimpleBean bean = new SimpleBean("beanName", 1);

        FieldFilter goodFilter = new FieldEqualsFilter("name", "beanName");
        assertTrue(goodFilter.filter(bean));

        FieldFilter badFilter = new FieldEqualsFilter("name", "anotherName");
        assertFalse(badFilter.filter(bean));
    }

    @Test
    public void startsWithFieldFilterTest() throws Exception {
        SimpleBean bean = new SimpleBean("beanName", 1);

        FieldFilter goodFilter = new StartsWithFilter("name", "bean");
        assertTrue(goodFilter.filter(bean));
    }

    @Test
    public void filterCollection() throws Exception {
        SimpleBean bean1 = new SimpleBean("Bean1", 1);
        SimpleBean bean2 = new SimpleBean("Bean2", 2);

        Collection<SimpleBean> collection = new ArrayList<SimpleBean>();
        collection.add(bean1);
        collection.add(bean2);

        Collection<SimpleBean> filtered = (new CollectionFilter<SimpleBean>(new FieldEqualsFilter("name", "Bean1"))).filter(collection);
        assertEquals(1, filtered.size());
        for (SimpleBean bean: filtered) {
            assertEquals("Bean1", bean.getName());
        }
    }
}
