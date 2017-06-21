package com.tuantai0625.chessgame.model;

import java.io.Serializable;

/**
 * Created by Lionheart on 15-Jun-17.
 */
public class Move {
    private int oldRow;
    private int oldCol;
    private int newRow;
    private int newCol;

    public Move(int oldRow, int oldCol, int newRow, int newCol) {
        this.oldRow = oldRow;
        this.oldCol = oldCol;
        this.newRow = newRow;
        this.newCol = newCol;
    }

    @Override
    public String toString() {
        return (Integer.toString(oldRow) + "_"
                + Integer.toString(oldCol) + "_"
                + Integer.toString(newRow) + "_"
                + Integer.toString(newCol));
    }
}
