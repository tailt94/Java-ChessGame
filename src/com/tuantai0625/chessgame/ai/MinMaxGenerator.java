package com.tuantai0625.chessgame.ai;

import com.tuantai0625.chessgame.model.ChessBoard;
import com.tuantai0625.chessgame.model.Move;
import com.tuantai0625.chessgame.model.Piece;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Lionheart on 22-Jun-17.
 */
public class MinMaxGenerator extends AI {
    private static final int DEPTH = 1;
    private int numTurns;

    @Override
    public String makeMove(ChessBoard board) {
        Move bestMove;
        int bestMoveScore;

        ArrayList<ChessBoard> possibleBoards = new ArrayList<>();
        ArrayList<Move> moves = new ArrayList<>();

        /*
         * Lưu lại tất cả các bước di chuyển có thể xảy ra
         */
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (board.hasPiece(row, col)) {
                    if (board.getPiece(row, col).getColor().equals(Piece.BLACK)) {
                        Piece piece = board.getPiece(row, col);
                        for (int newRow = 0; newRow < 8; newRow++) {
                            for (int newCol = 0; newCol < 8; newCol++) {
                                if (piece.isLegalMove(board, newRow, newCol)) {
                                    Move move = new Move(row, col, newRow, newCol);
                                    moves.add(new Move(row, col, newRow, newCol));
                                    ChessBoard newBoard = new ChessBoard(board);
                                    newBoard.updateBoard(move);
                                    possibleBoards.add(newBoard);
                                }
                            }
                        }
                    }
                }
            }
        }

        //Khởi tạo bước di chuyển tốt nhất
        bestMove = moves.get(0);
        bestMoveScore = evaluatePosition(possibleBoards.get(0), Integer.MIN_VALUE, Integer.MAX_VALUE, DEPTH, Piece.WHITE);


        /*
         *
         */
        if (numTurns > 0) {
            for (int i = 1; i < possibleBoards.size(); i++) {
                int j = evaluatePosition(possibleBoards.get(i), Integer.MIN_VALUE, Integer.MAX_VALUE, DEPTH, Piece.WHITE);
                if (j >= bestMoveScore) {
                    bestMove = moves.get(i);
                    bestMoveScore = j;
                }
            }
        } else {
            Random random = new Random();
            int index = random.nextInt(moves.size());
            bestMove = moves.get(index);

        }
        numTurns++;
        board.updateBoard(bestMove);
        return bestMove.toBoardMove();
    }

    public int evaluatePosition(ChessBoard board, int alpha, int beta, int depth, String color) {
        /*
         *
         */
        if (depth == 0) {
            return evaluate(board);
        }

        if (color.equals(Piece.WHITE)) {
            ArrayList<Move> moves = getPossibleMoves(board, color);

            /*
             *
             */
            int newBeta = beta;
            for (Move move : moves) {
                ChessBoard successorBoard = new ChessBoard(board);
                successorBoard.updateBoard(move);
                String newColor = color.equals(Piece.WHITE) ? Piece.BLACK : Piece.WHITE;
                newBeta = Math.min(newBeta, evaluatePosition(successorBoard, alpha, beta, depth - 1, newColor));
                if (newBeta <= alpha) break;
            }
            return newBeta;
        } else {
            ArrayList<Move> moves = getPossibleMoves(board, color);

            /*
             *
             */
            int newAlpha = alpha;
            for (Move move : moves) {
                ChessBoard successorBoard = new ChessBoard(board);
                successorBoard.updateBoard(move);
                String newColor = color.equals(Piece.WHITE) ? Piece.BLACK : Piece.WHITE;
                newAlpha = Math.max(newAlpha, evaluatePosition(successorBoard, alpha, beta, depth - 1, newColor));
                if (beta <= newAlpha) break;
            }
            return newAlpha;
        }
    }

    public int evaluate(ChessBoard board) {
        int whiteScore = 0;
        int blackScore = 0;

        /*
         * Duyệt bàn cờ
         */
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (board.hasPiece(row, col)) {
                    Piece piece = board.getPiece(row, col);
                    String pieceName = piece.getName();
                    if (piece.getColor().equals(Piece.WHITE)) {
                        switch (pieceName) {
                            case "queen":
                                whiteScore += 9;
                                break;
                            case "rook":
                                whiteScore += 5;
                                break;
                            case "knight":
                            case "bishop":
                                whiteScore += 3;
                                break;
                            case "pawn":
                                whiteScore += 1;
                                break;
                            case "king":
                                whiteScore += 10000000;
                                break;
                        }
                    } else if (piece.getColor().equals(Piece.BLACK)) {
                        switch (pieceName) {
                            case "queen":
                                blackScore += 9;
                                break;
                            case "rook":
                                blackScore += 5;
                                break;
                            case "knight":
                            case "bishop":
                                blackScore += 3;
                                break;
                            case "pawn":
                                blackScore += 1;
                                break;
                            case "king":
                                blackScore += 10000000;
                                break;
                        }
                    }
                }
            }
        }

        return blackScore - whiteScore;
    }
}
