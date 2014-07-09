package org.chronicweirdo.tdd.framework;

/**
 * Created by scacoveanu on 7/9/2014.
 */
public class DataService {

    private DataDAO dao;

    public void setDao(DataDAO dao) {
        this.dao = dao;
    }

    public String loadData(String id) {
        DataID dID = new DataID();
        dID.setUuid(id);
        return dao.load(dID);
    }
}
