package org.chronicweirdo.tdd.framework;

import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

/**
 * Created by scacoveanu on 7/9/2014.
 */
public class CaptureCallParametersTest {

    @Test
    public void captureMethodCallParameters() throws Exception {
        // instantiate service and inject mock DAO
        String id = "uuid";
        String result = "result";
        DataDAO dao = Mockito.mock(DataDAO.class);
        Mockito.when(dao.load(Mockito.any(DataID.class))).thenReturn(result);
        DataService service = new DataService();
        service.setDao(dao);
        // make service call for data
        String actualResult = service.loadData(id);
        // verify that mock DAO received the correct parameter and that the service returns the value returned by the DAO
        ArgumentCaptor<DataID> idCaptor = ArgumentCaptor.forClass(DataID.class);
        Mockito.verify(dao).load(idCaptor.capture());
        assertEquals(id, idCaptor.getValue().getUuid());
        assertEquals(result, actualResult);
    }
}
