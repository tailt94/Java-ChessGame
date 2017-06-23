package com.tuantai0625.chessgame.ai;

import com.tuantai0625.chessgame.model.ChessBoard;
import com.tuantai0625.chessgame.model.Move;
import com.tuantai0625.chessgame.model.Piece;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Lionheart on 22-Jun-17.
 */
public class RandomGenerator extends AI {
    @Override
    public String makeMove(ChessBoard board) {
        ArrayList<Move> moves = getPossibleMoves(board, Piece.BLACK);
        Random random = new Random();

        int index = random.nextInt(moves.size());
        Move randomMove = moves.get(index);
        board.updateBoard(randomMove);

        return randomMove.toBoardMove();
    }
}
