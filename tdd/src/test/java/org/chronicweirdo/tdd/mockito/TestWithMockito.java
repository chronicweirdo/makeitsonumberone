package org.chronicweirdo.tdd.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.*;

/**
 * Created by scacoveanu on 6/25/2014.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest( { StaticProvider.class })
public class TestWithMockito {

    @Test
    public void testService() throws Exception {
        DynamicService service = Mockito.mock(DynamicService.class);

        Mockito.when(service.loadStatus(0)).thenReturn("test status");

        assertEquals("test status", service.loadStatus(0));
    }

    @Test
    public void testStaticService() throws Exception {
        mockStatic(StaticProvider.class);

        PowerMockito.when(StaticProvider.provideMessage()).thenReturn("static test message");

        assertEquals("static test message", StaticProvider.provideMessage());
    }
}
