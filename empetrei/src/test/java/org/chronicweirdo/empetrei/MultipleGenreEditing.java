package org.chronicweirdo.empetrei;

import org.junit.Test;

import javax.swing.*;
import java.util.List;

/**
 * Created by Silviu on 6/15/14.
 */
public class MultipleGenreEditing extends AbstractTagTest {

    @Test
    public void insertGenre() throws Exception {
        List<String> originalGenres = GenreUtil.getGenres(filePathWithMultipleGenres);
        System.out.println(originalGenres);
        GenreUtil.addGenre(filePathWithMultipleGenres, "test genre");
        originalGenres.add("test genre");
        List<String> newGenres = GenreUtil.getGenres(filePathWithMultipleGenres);
        System.out.println(newGenres);
    }
}
