package com.tuantai0625.chessgame.model;

import javafx.scene.image.ImageView;

/**
 * Created by Lionheart on 12-Jun-17.
 */
public abstract class Piece {
    public static final String BLACK = "black";
    public static final String WHITE = "white";

    protected ImageView image;
    protected String color;

    public Piece(String color) {
        this.color = color;
        String filePath = "com/tuantai0625/chessgame/assets/pieces/" + this.getColor() + "_" + this.getName() + ".png";
        image = new ImageView(filePath);
    }

    public ImageView getImage() {
        return this.image;
    }

    public String getColor() {
        return this.color;
    }

    public abstract String getName();
}
