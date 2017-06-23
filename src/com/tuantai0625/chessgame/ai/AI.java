package com.tuantai0625.chessgame.ai;

import com.tuantai0625.chessgame.model.ChessBoard;
import com.tuantai0625.chessgame.model.Move;
import com.tuantai0625.chessgame.model.Piece;

import java.util.ArrayList;

/**
 * Created by Lionheart on 22-Jun-17.
 */
public abstract class AI {
    /**
     * Lấy ra danh sách tất cả các bước di chuyển hợp lệ
     * @param board Bàn cờ cần duyệt
     * @param color Màu của phe cần duyệt
     * @return Danh sách các bước di chuyển hợp lệ
     */
    protected ArrayList<Move> getPossibleMoves(ChessBoard board, String color) {
        ArrayList<Move> moves = new ArrayList<>();

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (board.hasPiece(row, col)) {
                    Piece piece = board.getPiece(row, col);
                    if (piece.getColor().equals(color)) {
                        for (int newRow = 0; newRow < 8; newRow++) {
                            for (int newCol = 0; newCol < 8; newCol++) {
                                if (piece.isLegalMove(board, newRow, newCol)) {
                                    moves.add(new Move(row, col, newRow, newCol));
                                }
                            }
                        }
                    }
                }
            }
        }

        return moves;
    }

    /**
     * Thực hiện di chuyển quân cờ
     * @param board Bàn cờ
     * @return Tên nước di chuyển
     */
    public abstract String makeMove(ChessBoard board);
}
