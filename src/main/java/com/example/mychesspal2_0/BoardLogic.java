package com.example.mychesspal2_0;

public class BoardLogic {
    private int[][] board = new int[8][8];



    public boolean isFull(int x, int y){
        if(board[x][y]==0){
            return false;
        }
        return true;
    }
    public void fillBoard(){
        //Fill 1st row
        board[0][0] = 4;
        board[1][0] = 2;
        board[2][0] = 3;
        board[3][0] = 5;
        board[4][0] = 6;
        board[5][0] = 3;
        board[6][0] = 2;
        board[7][0] = 4;
//Fill 8th row
        board[0][7] = -4;
        board[1][7] = -2;
        board[2][7] = -3;
        board[3][7] = -5;
        board[4][7] = -6;
        board[5][7] = -3;
        board[6][7] = -2;
        board[7][7] = -4;
//Fill pawns
        for(int i = 0; i<board.length; i++) {
            board[i][1]= 1;
            board[i][6]= -1;
        }
    }

    public boolean legalMove(int piece, int iX, int iY, int tX, int tY) {
        if (piece == 1) {return whitePawnLegalMove(iX, iY, tX, tY);}
        if (piece == -1) {return blackPawnLegalMove(iX, iY, tX, tY);}

        int color = 0;
        if (piece < 0) {
            color = -1;
        }
        else {
            color = 1;
        }

        if (piece == Math.abs(2)) {return knightLegalMove(iX, iY, tX, tY, color);}
        if (piece == Math.abs(3)) {return bishopLegalMove(iX, iY, tX, tY, color);}
        if (piece == Math.abs(4)) {return rookLegalMove(iX, iY, tX, tY, color);}
        if (piece == Math.abs(5)) {return queenLegalMove(iX, iY, tX, tY, color);}
        if (piece == Math.abs(6)) {return kingLegalMove(iX, iY, tX, tY, color);}
        return false;
    }

    private boolean kingLegalMove(int iX, int iY, int tX, int tY, int color) {
        // Check that the target position is within the bounds of the board
        if (tX < 0 || tX > 7 || tY < 0 || tY > 7) {
            return false;
        }

        // Check that the king is only moving one square in any direction
        // dx = distance piece is moving along x axis
        // dy = distance piece is moving along y axis
        int dx = Math.abs(tX - iX);
        int dy = Math.abs(tY - iY);
        if (dx > 1 || dy > 1) {
            return false;
        }

        // still need to check if king is moving into check

        return true;
    }

    private boolean queenLegalMove(int iX, int iY, int tX, int tY, int color) {
        // Check that the target position is within the bounds of the board
        if (tX < 0 || tX > 7 || tY < 0 || tY > 7) {
            return false;
        }

        // Check that the queen is moving in a straight line (either horizontally, vertically, or diagonally)
        int dx = Math.abs(tX - iX);
        int dy = Math.abs(tY - iY);
        if (dx != 0 && dy != 0 && dx != dy) {
            return false;
        }

        // check that no pieces are in way of target position

        //check that no friendly pieces are in the way



        return true;
    }

    private boolean rookLegalMove(int iX, int iY, int tX, int tY, int color) {
            if(iX != tX && iY != tY){
                return false;
            }
            if(iX == tX && iY == tY){
                return false;
            }
            if(iX==tX){
                if(tY>iY){
                    for(int i = iY+1; i<= tY; i++){
                        if(board[iX][i]<0 && color < 0 || board[iX][i] >0 && color > 0){
                            return false;
                        }
                    }
                    return true;
                }
                if(tY<iY){
                    for(int i = iY-1; i>= tY; i--){
                        if(board[iX][i]<0 && color < 0 || board[iX][i] >0 && color > 0){
                            return false;
                        }
                    }
                    return true;
                }
            }
            if(iY == tY){
                if(tX>iX){
                    for(int i = iX+1; i<= tX; i++){
                        if(board[i][tY]<0 && color < 0 || board[i][tY] >0 && color > 0){
                            return false;
                        }
                    }
                    return true;
                }
                if(tX<iX){
                    for(int i = iX-1; i>= tX; i--){
                        if(board[i][tY]<0 && color < 0 || board[i][tY] >0 && color > 0){
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }


    private boolean bishopLegalMove(int iX, int iY, int tX, int tY, int color) {
        return false;
    }

    private boolean knightLegalMove(int iX, int iY, int tX, int tY, int color) {
        if (Math.abs(iX-tX) == 2 && Math.abs(iY-tY) == 1) {
            return true;
        }
        return false;
    }

    private boolean blackPawnLegalMove(int iX, int iY, int tX, int tY) {
        // forward movement
        if (iX == tX) {
            // one step forward
            if (iY - 1 == tY) {
                return true;
            }
            // two steps forward
            if (iY == 6 && tY == 4) {
                return true;
            }
        }
        // captures
        if (Math.abs(iX-tX) == 1) {
            // normal captures
            if (iY - 1 == tY) {
                return true;
            }
            // en passant
            if (iY - 1 == tY && iY == 3 && board[tX][iY] == 1) {
                board[tX][iY] = 0;
                return true;
            }
        }
        return false;
    }


    private boolean whitePawnLegalMove(int iX, int iY, int tX, int tY) {
        // forward movement
        if (iX == tX) {
            // one step forward
            if (iY + 1 == tY) {
                return true;
            }
            // two steps forward
            if (iY == 1 && tY == 3) {
                return true;
            }
        }
        // captures
        if (Math.abs(iX-tX) == 1) {
            // normal capture
            if (iY + 1 == tY && board[tX][tY] < 0) {
                return true;
            }
            // en passant
            if (iY + 1 == tY && iY == 4 && board[tX][iY] == -1) {
                board[tX][iY] = 0;
                return true;
            }
        }
        return false;
    }
}
