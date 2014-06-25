package org.chronicweirdo.tdd.mockito;

/**
 * Created by scacoveanu on 6/25/2014.
 */
public class DynamicServiceImpl implements DynamicService {

    public String loadStatus(int id) {
        return id + " is now running";
    }
}
