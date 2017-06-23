package com.tuantai0625.chessgame.model;

/**
 * Created by Lionheart on 13-Jun-17.
 */
public class Rook extends Piece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getName() {
        return "rook";
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

        /*
         * Trường hợp nhập thành
         */
        if (color.equals(Piece.WHITE)) {
            if (oldRow == 7 && oldCol == 7 && newRow == 7 && newCol == 5) {
                if (b.hasPiece(7, 6)) {
                    Piece piece = b.getPiece(7, 6);
                    if (piece.getName().equals("king") && piece.getColor().equals(Piece.WHITE)) {
                        return true;
                    }
                }
            }
            if (oldRow == 7 && oldCol == 0 && newRow == 7 && newCol == 3) {
                if (b.hasPiece(7, 2) && !b.hasPiece(7, 1) && !b.hasPiece(7, 3)) {
                    Piece piece = b.getPiece(7, 2);
                    if (piece.getName().equals("king") && piece.getColor().equals(Piece.WHITE)) {
                        return true;
                    }
                }
            }
        } else if (color.equals(Piece.BLACK)) {
            if (oldRow == 0 && oldCol == 7 && newRow == 0 && newCol == 5) {
                if (b.hasPiece(0, 6)) {
                    Piece piece = b.getPiece(0, 6);
                    if (piece.getName().equals("king") && piece.getColor().equals(Piece.BLACK)) {
                        return true;
                    }
                }
            }
            if (oldRow == 0 && oldCol == 0 && newRow == 0 && newCol == 3) {
                if (b.hasPiece(0, 2) && !b.hasPiece(0, 1) && !b.hasPiece(0, 3)) {
                    Piece piece = b.getPiece(0, 2);
                    if (piece.getName().equals("king") && piece.getColor().equals(Piece.BLACK)) {
                        return true;
                    }
                }
            }
        }

        /*
         * Kiểm tra tính hợp lệ khi ô được di chuyển tới nằm cùng hàng ngang
         */
        if (newRow == oldRow) {
            if (newCol > oldCol) {
                for (int i = oldCol + 1; i < newCol; i++) {
                    if (b.hasPiece(oldRow, i)) {
                        return false;
                    }
                }
                return true;
            }
            if (newCol < oldCol) {
                for (int i = oldCol - 1; i > newCol; i--) {
                    if (b.hasPiece(oldRow, i)) {
                        return false;
                    }
                }
                return true;
            }
            if (newCol == oldCol) {
                return true;
            }
            return true;
        }

        /*
         * Kiểm tra tính hợp lệ khi ô được di chuyển tới nằm cùng hàng dọc
         */
        if (newCol == oldCol) {
            if (newRow > oldRow) {
                for (int i = oldRow + 1; i < newRow; i++) {
                    if (b.hasPiece(i, oldCol)) {
                        return false;
                    }
                }
                return true;
            }
            if (newRow < oldRow) {
                for (int i = oldRow - 1; i > newRow; i--) {
                    if (b.hasPiece(i, oldCol)) {
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
