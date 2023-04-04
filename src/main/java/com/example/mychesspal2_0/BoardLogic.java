package com.example.mychesspal2_0;

public class BoardLogic {
    public boolean legalMove(int piece, int iX, int iY, int tX, int tY) {
        if (piece == 1) {return whitePawnLegalMove(iX, iY, tX, tY);}
        if (piece == -1) {return blackPawnLegalMove(iX, iY, tX, tY);}
        if (piece == Math.abs(2)) {return knightLegalMove(iX, iY, tX, tY);}
        if (piece == Math.abs(3)) {return bishopLegalMove(iX, iY, tX, tY);}
        if (piece == Math.abs(4)) {return rookLegalMove(iX, iY, tX, tY);}
        if (piece == Math.abs(5)) {return queenLegalMove(iX, iY, tX, tY);}
        if (piece == Math.abs(6)) {return kingLegalMove(iX, iY, tX, tY);}
        return false;
    }

    private boolean kingLegalMove(int iX, int iY, int tX, int tY) {

    }

    private boolean queenLegalMove(int iX, int iY, int tX, int tY) {

    }

    private boolean rookLegalMove(int iX, int iY, int tX, int tY) {

    }

    private boolean bishopLegalMove(int iX, int iY, int tX, int tY) {

    }

    private boolean knightLegalMove(int iX, int iY, int tX, int tY) {

    }

    private boolean blackPawnLegalMove(int iX, int iY, int tX, int tY) {
        if (iX == tX) {
            if (iY - 1 == tY) {
                return true;
            }
            if (iY == 6 && tY == 4) {
                return true;
            }
        }
        if (Math.abs(iX-tX) == 1) {
            if (iY - 1 == tY) {
                return true;
            }
            if (()) {
                return true;
            }
        }
        return false;
    }


    private boolean whitePawnLegalMove(int iX, int iY, int tX, int tY) {
        if (iX == tX) {
            if (iY + 1 == tY) {
                return true;
            }
            if (iY == 1 && tY == 3) {
                return true;
            }
        }
        if (Math.abs(iX-tX) == 1) {
            if (iY + 1 == tY) {
                return true;
            }
            if (iY + 1 == tY && ) {
                return true;
            }
        }
        return false;
    }
}
