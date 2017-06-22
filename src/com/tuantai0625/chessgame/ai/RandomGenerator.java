package com.tuantai0625.chessgame.ai;

import com.tuantai0625.chessgame.model.ChessBoard;
import com.tuantai0625.chessgame.model.Move;
import com.tuantai0625.chessgame.model.Piece;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Lionheart on 22-Jun-17.
 */
public class RandomGenerator implements AI {
    @Override
    public String makeMove(ChessBoard board) {
        ArrayList<Move> moves = new ArrayList<>();
        Random random = new Random();

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (board.hasPiece(row, col)) {
                    if (board.getPiece(row, col).getColor().equals(Piece.BLACK)) {
                        Piece piece = board.getPiece(row, col);
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

        //Lấy số random
        int index = random.nextInt(moves.size());
        Move randomMove = moves.get(index);
        board.updateBoard(randomMove);

        return randomMove.toBoardMove();
    }
}
