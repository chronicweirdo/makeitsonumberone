package org.chronicweirdo.junk.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by scacoveanu on 10/21/2014.
 */
public class XStreamTestAdvanced {

    private XStream xStream;

    @Before
    public void setUp() throws Exception {
        xStream = new XStream() {
            @Override
            protected MapperWrapper wrapMapper(MapperWrapper next) {
                return new MapperWrapper(next) {
                    @Override
                    public boolean shouldSerializeMember(Class definedIn, String fieldName) {
                        if (definedIn == Object.class) {
                            return false;
                        }
                        return super.shouldSerializeMember(definedIn, fieldName);
                    }
                };
            }
        };

        xStream.alias("person", Person.class);
        xStream.alias("phone", Phone.class);
    }

    @Test
    public void testLoadIgnoreProperty() throws Exception {
        String xml = "<person>\n" +
                "  <firstname>git</firstname>\n" +
                "  <lastname>bash</lastname>\n" +
                "  <phone>\n" +
                "    <code>111</code>\n" +
                "    <number>111 111</number>\n" +
                "  </phone>\n" +
                "  <fax>\n" +
                "    <code>222 222</code>\n" +
                "    <missing>3</missing>\n" +
                "  </fax>\n" +
                "</person>";

        Person git = (Person) xStream.fromXML(xml);
        System.out.println(git);
    }
}
