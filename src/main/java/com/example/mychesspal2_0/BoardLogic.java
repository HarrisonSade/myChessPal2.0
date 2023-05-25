package com.example.mychesspal2_0;

public class BoardLogic {
    private int[][] board = new int[8][8];
    private boolean whiteQCastle = true;
    private boolean whiteKCastle = true;
    private boolean blackQCastle = true;
    private boolean blackKCastle = true;
    private boolean whiteQCastle1 = false;
    private boolean whiteKCastle1 = false;
    private boolean blackQCastle1 = false;
    private boolean blackKCastle1 = false;
    private boolean t = true;

    public BoardLogic(){
        fillBoard();
    }

    public boolean isFull(int x, int y){
        if(board[x][y]==0){
            return false;
        }
        return true;
    }

    public int get(int col, int row){ //4,6
        return board[row][col];//board[4,6]
    }


    public void fillBoard(){
        for(int i = 0; i< board.length; i++){
            for(int j = 0; j< board[i].length; j++){
                board[i][j] = 0;
            }
        }
        //Fill 1st row
        board[0][0] = 4;
        board[1][0] = 2;
        board[2][0] = 3;
        board[3][0] = 6;
        board[4][0] = 5;
        board[5][0] = 3;
        board[6][0] = 2;
        board[7][0] = 4;
//Fill 8th row
        board[0][7] = -4;
        board[1][7] = -2;
        board[2][7] = -3;
        board[3][7] = -6;
        board[4][7] = -5;
        board[5][7] = -3;
        board[6][7] = -2;
        board[7][7] = -4;
//Fill pawns
        for(int i = 0; i<board.length; i++) {
            board[i][1]= 1;
            board[i][6]= -1;
        }
        for (int j = 0; j < board.length; j++) {

            // Loop through all elements of current row
            for (int i = 0; i < board[j].length; i++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


    public boolean move(int iX, int iY, int tX, int tY){

        if (legalMove(board[iX][iY], iX, iY, tX, tY)) {
            if (board[iX][iY] > 0 && t || board[iX][iY] < 0 && !t) {
                if (t) {
                    t = false;
                } else {
                    t = true;
                }
                board[tX][tY] = board[iX][iY];
                board[iX][iY] = 0;
                return true;
            }
        }


        if (legalMove(board[iX][iY], iX, iY, tX, tY)) {
            if (board[iX][iY] > 0 && t || board[iX][iY] < 0 && !t) {
                if (t) {
                    t = false;
                } else {
                    t = true;
                }
                board[tX][tY] = board[iX][iY];
                board[iX][iY] = 0;
                return true;
            }
        }


        return false;
    }

    public boolean legalMove(int piece, int iX, int iY, int tX, int tY) {
        if(piece == 0){return false;}
        if (piece == 1) {return whitePawnLegalMove(iX, iY, tX, tY);}
        if (piece == -1) {return blackPawnLegalMove(iX, iY, tX, tY);}

        int color = 0;
        if (piece < 0) {
            color = -1;
        }
        else {
            color = 1;
        }

        if (Math.abs(piece) == 2) {return knightLegalMove(iX, iY, tX, tY, color);}
        if (Math.abs(piece) == 3) {return bishopLegalMove(iX, iY, tX, tY, color);}
        if (Math.abs(piece) == 4) {return rookLegalMove(iX, iY, tX, tY, color);}
        if (Math.abs(piece) == 5) {return queenLegalMove(iX, iY, tX, tY, color);}
        if (Math.abs(piece) == 6) {return kingLegalMove(iX, iY, tX, tY, color);}
        return false;
    }

    private boolean kingLegalMove(int iX, int iY, int tX, int tY, int color) {
        // Check that the target position is within the bounds of the board
        if (tX < 0 || tX > 7 || tY < 0 || tY > 7) {
            return false;
        }
        if(color > 0){
            if(tX == 1 && tY == 0){
                if(board[2][0] == 0 && board[1][0] == 0 && whiteKCastle && board[0][0] == 4){
                    whiteKCastle = false;
                    whiteKCastle1 = true;
                    return true;
                }
                return false;
            }
            if(tX == 5 && tY == 0){
                if(board[4][0] == 0 && board[5][0] == 0 && board[6][0] == 0 && whiteQCastle && board[7][0] == 4){
                    whiteQCastle = false;
                    whiteQCastle1 = true;
                    return true;
                }
                return false;
            }
        }
        else if(color < 0){
            if(tX == 1 && tY == 7){
                if(board[2][7] == 0 && board[1][7] == 0 && blackKCastle && board[0][7] == -4){
                    blackKCastle = false;
                    blackKCastle1 = true;
                    return true;
                }
                return false;
            }
            if(tX == 5 && tY == 7){
                if(board[4][7] == 0 && board[5][7] == 0 && board[6][7] == 0 && blackQCastle && board[7][7] == -4){
                    blackQCastle = false;
                    blackQCastle1 = true;
                    return true;
                }
                return false;
            }
        }

        // Check that the king is only moving one square in any direction
        // dx = distance piece is moving along x axis
        // dy = distance piece is moving along y axis
        int dx = Math.abs(tX - iX);
        int dy = Math.abs(tY - iY);
        if (dx > 1 || dy > 1) {
            return false;
        }
        //own capture check
        if(board[tX][tY] < 0 && color<0 || board[tX][tY] > 0 && color>0){
            return false;
        }
        //check if moving into check
        if(color < 0){
            if(blackIsInCheck(tX, tY)){
                return false;
            }
        }
        if(color > 0){
            if(whiteIsInCheck(tX, tY)){
                return false;
            }
        }

        if(color > 0){
            whiteKCastle = false;
            whiteQCastle = false;
        }
        return true;
    }

    private boolean queenLegalMove(int iX, int iY, int tX, int tY, int color) {
        System.out.println("Queen");
        return (bishopLegalMove(iX, iY, tX, tY, color) || rookLegalMove(iX, iY, tX, tY, color));
    }

    private boolean rookLegalMove(int iX, int iY, int tX, int tY, int color) {
        if (iX != tX && iY != tY) {
            return false;
        }
        if (iX == tX && iY == tY) {
            return false;
        }
        if (iX == tX) {
            if (tY > iY) {
                for (int i = iY + 1; i <= tY; i++) {
                    if (board[iX][i] < 0 && color < 0 || board[iX][i] > 0 && color > 0) {
                        return false;
                    }
                }
                return true;
            }
            if (tY < iY) {
                for (int i = iY - 1; i >= tY; i--) {
                    if (board[iX][i] < 0 && color < 0 || board[iX][i] > 0 && color > 0) {
                        return false;
                    }
                }
                return true;
            }
        }
        if (iY == tY) {
            if (tX > iX) {
                for (int i = iX + 1; i <= tX; i++) {
                    if (board[i][tY] < 0 && color < 0 || board[i][tY] > 0 && color > 0) {
                        return false;
                    }
                }
                return true;
            }
            if (tX < iX) {
                for (int i = iX - 1; i >= tX; i--) {
                    if (board[i][tY] < 0 && color < 0 || board[i][tY] > 0 && color > 0) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }


    private boolean bishopLegalMove(int iX, int iY, int tX, int tY, int color) {
        // is the move diagonal?
        if(iX == tX || iY == tY){return false;}
        if (Math.abs(iX-tX) != Math.abs(iY-tY)) {
            return false;
        }

        // which way should the while loop iterate?
        int x = iX;
        int y = iY;
        int deltaX = 0;
        int deltaY = 0;
        if (tX > iX) {
            deltaX = 1;
        }
        else {
            deltaX = -1;
        }
        if (tY > iY) {
            deltaY = 1;
        }
        else {
            deltaY = -1;
        }
        x += deltaX;
        y += deltaY;

        // is there a piece in the path of the bishop?
        while (x != tX && y != tY) {
            if (board[x][y] != 0) {
                return false;
            }
            x += deltaX;
            y += deltaY;
        }

        // is there a same color piece on the square?
        if (board[tX][tY] * color > 0) {
            return false;
        }

        // all conditions met
        return true;
    }

    private boolean knightLegalMove(int iX, int iY, int tX, int tY, int color) {
        // two horizontal, one vertical
        if (Math.abs(iX-tX) == 2 && Math.abs(iY-tY) == 1 || Math.abs(iX -tX) == 1 && Math.abs(iY - tY) == 2) {
            if (color == -1 && board[tX][tY] >= 0) {
                return true;
            }
            else if (board[tX][tY] * color <= 0) {
                return true;
            }
            else if(board[tX][tY] == 0){ return true;}
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
            if (iY + 1 == tY && board[iX][iY+1] == 0) {
                return true;
            }
            // two steps forward
            if (iY == 1 && tY == 3 && board[iX][iY + 2]==0) {
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

    private boolean whiteIsInCheck(int x, int y){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j< board[i].length; j++){
                if(board[j][i] < 0 && (x!= j && y!=i)){
                    if(legalMove(board[j][i], j, i, x, y)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean blackIsInCheck(int x, int y){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j< board[i].length; j++){
                if(board[i][j] > 0 && (x!= i && y!=j)){
                    if(legalMove(board[i][j], i, j, x, y)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}