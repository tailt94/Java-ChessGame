package com.tuantai0625.chessgame.model;

/**
 * Created by Lionheart on 13-Jun-17.
 */
public class King extends Piece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getName() {
        return "king";
    }
}
