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
         * Kiểm tra ô được di chuyển tới có tồn tại quân cờ cùng phe hay không
         */
        if (b.hasPiece(newRow, newCol)) {
            if (b.getPiece(newRow, newCol).getColor().equals(getColor())) {
                return false;
            }
        }

        if (this.getColor().equals(Piece.WHITE)) {
            if (oldRow == 6) { //Cho phép tốt di chuyển 2 ô khi quân tốt đang ở vị trí ban đầu
                if (Math.abs(newCol - oldCol) == 1 && newRow == oldRow - 1 && b.hasPiece(newRow, newCol)) {
                    return true;
                } else if (newCol == oldCol && newRow == oldRow - 1 && !b.hasPiece(newRow, newCol)) {
                    return true;
                } else if (newCol == oldCol && newRow == oldRow - 2 && !b.hasPiece(newRow, newCol) && !b.hasPiece(newRow + 1, newCol)) {
                    return true;
                }
                return false;
            } else { //Khi quân tốt không còn ở vị trí ban đầu
                if (Math.abs(newCol - oldCol) == 1 && newRow == oldRow - 1 && b.hasPiece(newRow, newCol)) {
                    return true;
                } else if (newCol == oldCol && newRow == oldRow - 1 && !b.hasPiece(newRow, newCol)) {
                    return true;
                }
                return false;
            }
        } else {
            if (oldRow == 1) { //Cho phép tốt di chuyển 2 ô khi quân tốt đang ở vị trí ban đầu
                if (Math.abs(newCol - oldCol) == 1 && newRow == oldRow + 1 && b.hasPiece(newRow, newCol)) {
                    return true;
                } else if (newCol == oldCol && newRow == oldRow + 1 && !b.hasPiece(newRow, newCol)) {
                    return true;
                } else if (newCol == oldCol && newRow == oldRow + 2 && !b.hasPiece(newRow, newCol) && !b.hasPiece(newRow - 1, newCol)) {
                    return true;
                }
                return false;
            } else { //Khi quân tốt không còn ở vị trí ban đầu
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
