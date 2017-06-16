package com.tuantai0625.chessgame.model;

import com.tuantai0625.chessgame.factory.PieceFactory;
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
                tiles[row][col] = new Tile(this, row, col);
                setInitPieces(row, col);
            }
        }
    }

    public Tile[][] getTiles() {
        return this.tiles;
    }

    public Tile getTile(int row, int col) {
        return this.tiles[row][col];
    }

    private void setInitPieces(int row, int col) {
        String pieceName = "";
        String pieceColor = "";

        if (row == 1) {
            pieceName = "pawn";
            pieceColor = Piece.BLACK;
            tiles[row][col].setPiece(PieceFactory.getPiece(pieceName, pieceColor));
        } else if (row == 6) {
            pieceName = "pawn";
            pieceColor = Piece.WHITE;
            tiles[row][col].setPiece(PieceFactory.getPiece(pieceName, pieceColor));
        } else if (row == 0 || row == 7) {
            if (row == 0)   pieceColor = Piece.BLACK;
            if (row == 7)   pieceColor = Piece.WHITE;

            switch (col) {
                case 0:
                case 7:
                    pieceName = "rook";
                    break;
                case 1:
                case 6:
                    pieceName = "knight";
                    break;
                case 2:
                case 5:
                    pieceName = "bishop";
                    break;
                case 3:
                    pieceName = "queen";
                    break;
                case 4:
                    pieceName = "king";
                    break;
            }

            tiles[row][col].setPiece(PieceFactory.getPiece(pieceName, pieceColor));
        }
    }

    public boolean hasPiece(int row, int col) {
        return tiles[row][col].hasPiece();
    }

    public Piece getPiece(int row, int col) {
        return tiles[row][col].getPiece();
    }
}
