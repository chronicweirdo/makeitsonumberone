package org.chronicweirdo.tdd;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by scacoveanu on 5/22/2014.
 */
public class TestTemplatePerformance {

    private Template template;

    @Before
    public void setUp() throws Exception {
        template = new Template("Lorem ipsum dolor. Sit amet auctor. ${v01} Ultricies justo fringilla. Dui blandit " +
                "posuere. Erat ut quis ${v02}. Elit ${v16} pretium per interdum enim donec ${v03} ${v19} suspendisse " +
                "sollicitudin inceptos. ${v04} Ipsum ${v05} pharetra consequat ${v06} ut sodales diam arcu a amet " +
                "${v07} arcu dictumst hymenaeos ut sit ${v08} pellentesque inceptos proin curabitur ${v09} rutrum " +
                "risus ridiculus. Sit ut vitae. ${v10} Id ac neque dui nonummy ${v17} ultrices aliquam tempus " +
                "lobortis massa erat fringilla. Metus nullam vestibulum. Nunc ut ${v20} nonummy ullamcorper integer " +
                "venenatis. Non id imperdiet. Elit in etiam ${v11} ${v12} vestibulum maecenas tristique erat mus " +
                "${v18} velit id velit tristique turpis purus magna. ${v13} Mauris sed sed. Sed quis ${v14} " +
                "penatibus. Ante mauris ipsum. Amet ${v15} nam cras interdum.");
        template.set("v01", "defrefasdfaeefasfda");
        template.set("v02", "dfaddgdcdagasgr");
        template.set("v03", "sdasdsdadsads csdcasacd");
        template.set("v04", "asdaawagaewqewdsadsxcaxa");
        template.set("v05", "ascsdcsgfdgascds");
        template.set("v06", "casgfhsahgjytsdsdsdsdssadasdq");
        template.set("v07", "dddsadfasfdagewddsdaddad");
        template.set("v08", "sdasdadsafgghted");
        template.set("v09", "sdasdasdsadsdsadasgag");
        template.set("v10", "sfasfsafsafregdsffhyjtrg");
        template.set("v11", "dffrehrhdfgryhtjyjhfgsff");
        template.set("v12", "dfsfsdhthyukyrtrcdcsdghh");
        template.set("v13", "dfererwfwdfwwgfffdfdwdgg");
        template.set("v14", "defrefasdfaeefdfsdffasfda");
        template.set("v15", "sdasdfkilkuin");
        template.set("v16", "ggbgbgfbgfbgrtgerg");
        template.set("v17", "fsdfdsfsdfdhfhfj");
        template.set("v18", "dgfdgdshdgsdgsdgdgsdgsdgsdg");
        template.set("v19", "defrefasdfaeedgtyrjrfasfda");
        template.set("v20", "defrefasdfaeefasfda");
    }

    @Test
    public void templateWith100WordsAnd20Variables() throws Exception {
        long expected = 200l;
        long time = System.currentTimeMillis();
        template.evaluate();
        time = System.currentTimeMillis() - time;
        assertTrue("Rendering the template took " + time + "ms while the target was " + expected + "ms", time <= expected);
    }
}
