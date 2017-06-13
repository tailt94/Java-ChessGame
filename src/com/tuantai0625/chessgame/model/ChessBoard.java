package com.tuantai0625.chessgame.model;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Created by Lionheart on 13-Jun-17.
 */
public class ChessBoard {
    private Tile[][] tiles ;

    public ChessBoard() {
        tiles = new Tile[8][8];
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                tiles[row][col] = new Tile(row, col);
                setInitPieces(row, col);
            }
        }
    }

    public Tile[][] getTiles() {
        return this.tiles;
    }

    private void setInitPieces(int row, int col) {
        if (row == 0) {
            switch (col) {
                case 0:
                case 7:
                    tiles[row][col].setPiece(new Rook(Piece.BLACK));
                    break;
                case 1:
                case 6:
                    tiles[row][col].setPiece(new Knight(Piece.BLACK));
                    break;
                case 2:
                case 5:
                    tiles[row][col].setPiece(new Bishop(Piece.BLACK));
                    break;
                case 3:
                    tiles[row][col].setPiece(new Queen(Piece.BLACK));
                    break;
                case 4:
                    tiles[row][col].setPiece(new King(Piece.BLACK));
                    break;
            }
        } else if (row == 1) {
            tiles[row][col].setPiece(new Pawn(Piece.BLACK));
        } else if (row == 6) {
            tiles[row][col].setPiece(new Pawn(Piece.WHITE));
        } else if (row == 7) {
            switch (col) {
                case 0:
                case 7:
                    tiles[row][col].setPiece(new Rook(Piece.WHITE));
                    break;
                case 1:
                case 6:
                    tiles[row][col].setPiece(new Knight(Piece.WHITE));
                    break;
                case 2:
                case 5:
                    tiles[row][col].setPiece(new Bishop(Piece.WHITE));
                    break;
                case 3:
                    tiles[row][col].setPiece(new Queen(Piece.WHITE));
                    break;
                case 4:
                    tiles[row][col].setPiece(new King(Piece.WHITE));
                    break;
            }
        }
    }
}
