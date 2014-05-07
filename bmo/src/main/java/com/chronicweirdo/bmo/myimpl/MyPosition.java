package com.chronicweirdo.bmo.myimpl;

import javax.swing.text.Position;

/**
 * Created by scacoveanu on 4/14/2014.
 */
public class MyPosition implements Position {

    private int offset;

    public MyPosition(int offset) {
        this.offset = offset;
    }

    public int getOffset() {
        return offset;
    }
}
