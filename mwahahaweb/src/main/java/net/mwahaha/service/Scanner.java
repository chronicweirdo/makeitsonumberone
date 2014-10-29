package net.mwahaha.service;

import net.mwahaha.model.Page;

import java.util.Date;
import java.util.List;

/**
 * Scanner service, used to retrieve content from a data source.
 *
 * How are deleted pages updated? When trying to load one and find out it does not exist anymore we delete it?
 *
 * Created by scacoveanu on 10/29/2014.
 */
public interface Scanner {

    /**
     * Get all pages at this data source.
     */
    List<Page> scan();

    /**
     * Scan only pages modified after the specified date.
     */
    List<Page> scan(Date modifiedAfter);

    /**
     * Loads the binary content of the page from the data source.
     */
    Object load(Page page);
}
