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
        int oldRow = this.tileOn.getRow();
        int oldCol = this.tileOn.getCol();

        /*
         * Check if new tile has the piece of same side
         */
        if (b.hasPiece(newRow, newCol)) {
            if (b.getPiece(newRow, newCol).getColor().equals(getColor())) {
                return false;
            }
        }

        return ((Math.abs(newRow - oldRow) == 2 && Math.abs(newCol - oldCol) == 1)
                || (Math.abs(newRow - oldRow) == 1 && Math.abs(newCol - oldCol) == 2));
    }
}
