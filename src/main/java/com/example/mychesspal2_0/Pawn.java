package com.example.mychesspal2_0;

public class Pawn extends Piece{
    private boolean firstMoveMade = false;

    public void move(int inpX, int inpY) {
        if (this.legalMove(inpX, inpY)) {
            this.setX(inpX);
            this.setY(inpY);
        }
    }

    public boolean legalMove(int inpX, int inpY) {
        if (this.getColor() == 0) {

        }
        return true;
    }
