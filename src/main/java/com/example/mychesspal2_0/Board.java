package com.example.mychesspal2_0;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Board extends BorderPane {

    private static final int BOARD_SIZE = 8;


    public Board() {

        Button backBtn = new Button("Back");
        backBtn.setMaxSize(75, 50);
        this.setTop(backBtn);

        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                home homePage = new home();
                Stage s = (Stage) Board.this.getScene().getWindow();
                Scene homeScene = new Scene(homePage, s.getWidth(), s.getHeight());
                s.setScene(homeScene);
                s.setTitle("Home");
            }
        });


        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);

        // Add the chess pieces to the board
        Image whitePawn = new Image(getClass().getResourceAsStream("white_pawn.png"));
        Image blackPawn = new Image(getClass().getResourceAsStream("black_pawn.png"));
        Image whiteRook = new Image(getClass().getResourceAsStream("white_rook.png"));
        Image blackRook = new Image(getClass().getResourceAsStream("black_rook.png"));
        Image whiteKnight = new Image(getClass().getResourceAsStream("white_knight.png"));
        Image blackKnight = new Image(getClass().getResourceAsStream("black_knight.png"));
        Image whiteBishop = new Image(getClass().getResourceAsStream("white_bishop.png"));
        Image blackBishop = new Image(getClass().getResourceAsStream("black_bishop.png"));
        Image whiteQueen = new Image(getClass().getResourceAsStream("white_queen.png"));
        Image blackQueen = new Image(getClass().getResourceAsStream("black_queen.png"));
        Image whiteKing = new Image(getClass().getResourceAsStream("white_king.png"));
        Image blackKing = new Image(getClass().getResourceAsStream("black_king.png"));

        ImageView whiteRookView1 = new ImageView(whiteRook);
        ImageView whiteKnightView1 = new ImageView(whiteKnight);
        ImageView whiteBishopView1 = new ImageView(whiteBishop);
        ImageView whiteQueenView = new ImageView(whiteQueen);
        ImageView whiteKingView = new ImageView(whiteKing);
        ImageView whiteBishopView2 = new ImageView(whiteBishop);
        ImageView whiteKnightView2 = new ImageView(whiteKnight);
        ImageView whiteRookView2 = new ImageView(whiteRook);
        ImageView whitePawnView1 = new ImageView(whitePawn);
        ImageView whitePawnView2 = new ImageView(whitePawn);
        ImageView whitePawnView3 = new ImageView(whitePawn);
        ImageView whitePawnView4 = new ImageView(whitePawn);
        ImageView whitePawnView5 = new ImageView(whitePawn);
        ImageView whitePawnView6 = new ImageView(whitePawn);
        ImageView whitePawnView7 = new ImageView(whitePawn);
        ImageView whitePawnView8 = new ImageView(whitePawn);

        ImageView blackRookView1 = new ImageView(blackRook);
        ImageView blackKnightView1 = new ImageView(blackKnight);
        ImageView blackBishopView1 = new ImageView(blackBishop);
        ImageView blackQueenView = new ImageView(blackQueen);
        ImageView blackKingView = new ImageView(blackKing);
        ImageView blackBishopView2 = new ImageView(blackBishop);
        ImageView blackKnightView2 = new ImageView(blackKnight);
        ImageView blackRookView2 = new ImageView(blackRook);
        ImageView blackPawnView1 = new ImageView(blackPawn);
        ImageView blackPawnView2 = new ImageView(blackPawn);
        ImageView blackPawnView3 = new ImageView(blackPawn);
        ImageView blackPawnView4 = new ImageView(blackPawn);
        ImageView blackPawnView5 = new ImageView(blackPawn);
        ImageView blackPawnView6 = new ImageView(blackPawn);
        ImageView blackPawnView7 = new ImageView(blackPawn);
        ImageView blackPawnView8 = new ImageView(blackPawn);

        // Add the pieces to the board
        gridPane.add(blackRookView1, 0, 0);
        gridPane.add(blackKnightView1, 1, 0);
        gridPane.add(blackBishopView1, 2, 0);
        gridPane.add(blackQueenView, 3, 0);
        gridPane.add(blackKingView, 4, 0);
        gridPane.add(blackBishopView2, 5, 0);
        gridPane.add(blackKnightView2, 6, 0);
        gridPane.add(blackRookView2, 7, 0);

        gridPane.add(blackPawnView1, 0, 1);
        gridPane.add(blackPawnView2, 1, 1);
        gridPane.add(blackPawnView3, 2, 1);
        gridPane.add(blackPawnView4, 3, 1);
        gridPane.add(blackPawnView5, 4, 1);
        gridPane.add(blackPawnView6, 5, 1);
        gridPane.add(blackPawnView7, 6, 1);
        gridPane.add(blackPawnView8, 7, 1);

        gridPane.add(whitePawnView1, 0, 6);
        gridPane.add(whitePawnView2, 1, 6);
        gridPane.add(whitePawnView3, 2, 6);
        gridPane.add(whitePawnView4, 3, 6);
        gridPane.add(whitePawnView5, 4, 6);
        gridPane.add(whitePawnView6, 5, 6);
        gridPane.add(whitePawnView7, 6, 6);
        gridPane.add(whitePawnView8, 7, 6);

        gridPane.add(whiteRookView1, 0, 7);
        gridPane.add(whiteKnightView1, 1, 7);
        gridPane.add(whiteBishopView1, 2, 7);
        gridPane.add(whiteQueenView, 3, 7);
        gridPane.add(whiteKingView, 4, 7);
        gridPane.add(whiteBishopView2, 5, 7);
        gridPane.add(whiteKnightView2, 6, 7);
        gridPane.add(whiteRookView2, 7, 7);

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                Rectangle rect = new Rectangle(75, 75, (row + col) % 2 == 0 ? Color.WHITE : Color.LIGHTGRAY);
                gridPane.add(rect, col, row);
            }
        }

        setCenter(gridPane);

    }


}
