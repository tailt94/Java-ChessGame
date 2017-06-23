package com.tuantai0625.chessgame.model;

/**
 * Created by Lionheart on 13-Jun-17.
 */
public class Pawn extends Piece{
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getName() {
        return "pawn";
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

        if (this.getColor().equals(Piece.WHITE)) {
            if (oldRow == 6) { //Pawn can move 2 step only if it's on original position
                if (Math.abs(newCol - oldCol) == 1 && newRow == oldRow - 1 && b.hasPiece(newRow, newCol)) {
                    return true;
                } else if (newCol == oldCol && newRow == oldRow - 1 && !b.hasPiece(newRow, newCol)) {
                    return true;
                } else if (newCol == oldCol && newRow == oldRow - 2 && !b.hasPiece(newRow, newCol) && !b.hasPiece(newRow + 1, newCol)) {
                    return true;
                }
                return false;
            } else { //Pawn is not on original position anymore
                if (Math.abs(newCol - oldCol) == 1 && newRow == oldRow - 1 && b.hasPiece(newRow, newCol)) {
                    return true;
                } else if (newCol == oldCol && newRow == oldRow - 1 && !b.hasPiece(newRow, newCol)) {
                    return true;
                }
                return false;
            }
        } else {
            if (oldRow == 1) { //Pawn can move 2 step only if it's on original position
                if (Math.abs(newCol - oldCol) == 1 && newRow == oldRow + 1 && b.hasPiece(newRow, newCol)) {
                    return true;
                } else if (newCol == oldCol && newRow == oldRow + 1 && !b.hasPiece(newRow, newCol)) {
                    return true;
                } else if (newCol == oldCol && newRow == oldRow + 2 && !b.hasPiece(newRow, newCol) && !b.hasPiece(newRow - 1, newCol)) {
                    return true;
                }
                return false;
            } else { //Pawn is not on original position anymore
                if (Math.abs(newCol - oldCol) == 1 && newRow == oldRow + 1 && b.hasPiece(newRow, newCol)) {
                    return true;
                } else if (newCol == oldCol && newRow == oldRow + 1 && !b.hasPiece(newRow, newCol)) {
                    return true;
                }
                return false;
            }
        }
    }
}
