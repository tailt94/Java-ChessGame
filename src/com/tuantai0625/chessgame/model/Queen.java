package com.tuantai0625.chessgame.model;

/**
 * Created by Lionheart on 13-Jun-17.
 */
public class Queen extends Piece{
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getName() {
        return "queen";
    }
}
