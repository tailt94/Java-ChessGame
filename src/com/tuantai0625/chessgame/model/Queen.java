package com.tuantai0625.chessgame.model;

/**
 * Created by Lionheart on 13-Jun-17.
 */
public class Queen extends Piece{
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getName() {
        return "queen";
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

         /*
         * Kiểm tra trên các đường chéo xem từ vị trí cũ tới vị trí mới
         * có bị chặn bởi quân cờ khác không, nếu có thì không hợp lệ
         */
        if (Math.abs(newRow - oldRow) == Math.abs(newCol - oldCol)) {
            /*
             * Kiểm tra đường chéo phần góc phải - dưới so với vị trí cũ
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
             * Kiểm tra đường chéo phần góc phải - trên so với vị trí cũ
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
             * Kiểm tra đường chéo phần góc trái - dưới so với vị trí cũ
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
             * Kiểm tra đường chéo phần góc trái - trên so với vị trí cũ
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
