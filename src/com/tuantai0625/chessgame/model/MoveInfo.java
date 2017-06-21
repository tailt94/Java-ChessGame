package com.tuantai0625.chessgame.model;

import java.io.Serializable;

/**
 * Created by Lionheart on 15-Jun-17.
 */
public class MoveInfo {
    private int oldRow;
    private int oldCol;
    private int newRow;
    private int newCol;

    public MoveInfo(int oldRow, int oldCol, int newRow, int newCol) {
        this.oldRow = oldRow;
        this.oldCol = oldCol;
        this.newRow = newRow;
        this.newCol = newCol;
    }
}
