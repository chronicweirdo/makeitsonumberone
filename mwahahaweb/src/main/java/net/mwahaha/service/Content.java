package net.mwahaha.service;

import net.mwahaha.model.Page;
import net.mwahaha.model.Tag;

import java.util.List;

/**
 * Content service, used to retrive content from the two databases (content DB and statistics DB).
 *
 * Created by scacoveanu on 10/29/2014.
 */
public interface Content {

    List<Tag> getTags();

    List<Page> getPages();

    List<Page> getPages(List<Tag> tags);
}
