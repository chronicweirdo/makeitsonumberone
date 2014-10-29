package net.mwahaha.service;

import net.mwahaha.model.Page;

/**
 * Used to scan content and extract meta-data like title and tags.
 *
 * Created by scacoveanu on 10/29/2014.
 */
public interface Interpreter {

    boolean accepted(Object source);

    Page interpret(Object source);
}
