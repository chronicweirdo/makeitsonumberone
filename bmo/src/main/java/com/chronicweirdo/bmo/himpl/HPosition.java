package com.chronicweirdo.bmo.himpl;

import javax.swing.text.Position;

/**
 * Created by scacoveanu on 4/14/2014.
 */
public class HPosition implements Position {

    private int offset;

    public HPosition(int offset) {
        this.offset = offset;
    }

    public int getOffset() {
        return offset;
    }
}
