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

        /*
         * Check if new position on diagonal line is blocked
         * by another piece
         */
        if (Math.abs(newRow - oldRow) == Math.abs(newCol - oldCol)) {
            /*
             * Check right - bottom part
             */
            if (newRow > oldRow && newCol > oldCol) {
                for (int i = 1; i < newRow - oldRow; i++) {
                    if (b.hasPiece(oldRow + i, oldCol + i)) {
                        return false;
                    }
                }
                return true;
            }

            /*
             * Check right - top part
             */
            if (newRow < oldRow && newCol > oldCol) {
                for (int i = 1; i < newCol - oldCol; i++) {
                    if (b.hasPiece(oldRow - i, oldCol + i)) {
                        return false;
                    }
                }
                return true;
            }

            /*
             * Check left - bottom part
             */
            if (newRow > oldRow && newCol < oldCol) {
                for (int i = 1; i < newRow - oldRow; i++) {
                    if (b.hasPiece(oldRow + i, oldCol - i)) {
                        return false;
                    }
                }
                return true;
            }

            /*
             * Check left - top part
             */
            if (newRow < oldRow && newCol < oldCol) {
                for (int i = 1; i < oldCol - newCol; i++) {
                    if (b.hasPiece(oldRow - i, oldCol - i)) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        return false;
    }
}
