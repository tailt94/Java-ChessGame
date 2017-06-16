package com.tuantai0625.chessgame.model;

/**
 * Created by Lionheart on 13-Jun-17.
 */
public class Bishop extends Piece{
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getName() {
        return "bishop";
    }

    @Override
    public boolean isLegalMove(ChessBoard b, int newRow, int newCol) {
        return true;
    }
}
