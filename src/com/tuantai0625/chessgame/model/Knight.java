package com.tuantai0625.chessgame.model;

/**
 * Created by Lionheart on 13-Jun-17.
 */
public class Knight extends Piece {
    public Knight(String color) {
        super(color);
    }

    @Override
    public String getName() {
        return "knight";
    }

    @Override
    public boolean isLegalMove(ChessBoard b, int newRow, int newCol) {
        return true;
    }
}
