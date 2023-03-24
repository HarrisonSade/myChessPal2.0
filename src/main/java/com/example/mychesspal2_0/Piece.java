package com.example.mychesspal2_0;

public abstract class Piece {

    private boolean isAlive;

    //Coordinate values
    private int x,y;

    private int color;

    /**
     * Default constructor
     */
    public Piece(){}

    /**
     * Assigns the coordinates to the piece
     * @param inpX is the x coordinate of the piece
     * @param inpY is the y coordinate of the piece
     */
    public Piece(int inpX, int inpY, int c){
        //Assigns coordinate values
        x = inpX;
        y = inpY;
        color = c;
    }

    /**
     * Logically moves the piece if a valid coordinate is inputted
     * @param inpX is the input x coordinate
     * @param inpY is the input y coordinate
     */
    public abstract void move(int inpX, int inpY);

    /**
     * Checks if a piece can move to coordinate
     * @param inpX is the input x coordinate
     * @param inpY is the input y coordinate
     * @return true if able to move, false otherwise
     */
    public abstract boolean legalMove(int inpX, int inpY);


    public void setColor(int color) {
        this.color = color;
    }

    /**
     *
     * @return
     */
    public int getColor() {
        return color;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
