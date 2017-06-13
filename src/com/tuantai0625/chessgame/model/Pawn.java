package com.tuantai0625.chessgame.model;

/**
 * Created by Lionheart on 13-Jun-17.
 */
public class Pawn extends Piece{
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getName() {
        return "pawn";
    }
}
