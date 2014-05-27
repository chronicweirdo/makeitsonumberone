package org.chronicweirdo.tdd;

import org.junit.Assert;
import org.junit.Test;
import org.laughingpanda.beaninject.Inject;

/**
 * Created by scacoveanu on 5/27/2014.
 */
public class ServiceUserTest {

    private RandomService testRandomService = new RandomService() {
        public int randomInt() {
            return 0;
        }
    };

    @Test
    public void testServiceInjection() throws Exception {
        ServiceUser serviceUser = new ServiceUser();
        Inject.field("randomService").of(serviceUser).with(testRandomService);
        Assert.assertTrue(serviceUser.doWork());
    }
}
