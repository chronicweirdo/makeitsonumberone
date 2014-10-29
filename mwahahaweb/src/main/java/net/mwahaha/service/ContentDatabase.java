package net.mwahaha.service;

import net.mwahaha.model.Page;
import net.mwahaha.model.Tag;

import java.util.List;

/**
 * Created by scacoveanu on 10/29/2014.
 */
public interface ContentDatabase {

    List<Page> getAllFor(List<Tag> tags);

    List<Page> getAll();
}
