package com.tuantai0625.chessgame.model;

import javafx.scene.layout.Pane;


public class Tile {
    public static final String DARK = "dark";
    public static final String LIGHT = "light";

    private Pane pane;
    private String color;
    private Piece piece;
    private int row, col;

    public Tile(int row, int col) {
        this.row = row;
        this.col = col;
        this.pane = new Pane();
        if ((row % 2 == 0 && col % 2 == 1) || (row % 2 == 1 && col % 2 == 0)) {
            this.color = DARK;
            pane.setStyle("-fx-background-color: #33939A");
        } else {
            this.color = LIGHT;
            pane.setStyle("-fx-background-color: #98DCE1");
        }
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        pane.getChildren().add(piece.getImage());
    }

    public void removePiece() {
        this.piece = null;
        pane.getChildren().removeAll();
    }

    public Pane getPane() {
        return this.pane;
    }
}
