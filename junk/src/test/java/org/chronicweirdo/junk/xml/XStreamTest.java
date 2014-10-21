package org.chronicweirdo.junk.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by scacoveanu on 10/21/2014.
 */
public class XStreamTest {

    private XStream xStream;

    @Before
    public void setUp() throws Exception {
        xStream = new XStream();
        //XStream xStream = new XStream(new DomDriver());
        //XStream xStream = new XStream(new StaxDriver());

        xStream.alias("person", Person.class);
        xStream.alias("phone", Phone.class);
    }

    @Test
    public void testSave() throws Exception {
        Person git = new Person();
        git.setFirstname("git");
        git.setLastname("bash");

        Phone p = new Phone();
        p.setCode("111");
        p.setNumber("111 111");
        git.setPhone(p);

        Phone f = new Phone();
        f.setCode("222 222");
        git.setFax(f);

        String xml = xStream.toXML(git);
        System.out.println(xml);
    }

    @Test
    public void testLoad() throws Exception {
        String xml = "<person>\n" +
                "  <firstname>git</firstname>\n" +
                "  <lastname>bash</lastname>\n" +
                "  <phone>\n" +
                "    <code>111</code>\n" +
                "    <number>111 111</number>\n" +
                "  </phone>\n" +
                "  <fax>\n" +
                "    <code>222 222</code>\n" +
                "  </fax>\n" +
                "</person>";

        Person git = (Person) xStream.fromXML(xml);
        System.out.println(git);
    }
}
