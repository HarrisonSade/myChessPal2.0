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
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Board extends BorderPane {

    private static final int BOARD_SIZE = 8;
    Button[][] squares = new Button[BOARD_SIZE][BOARD_SIZE];

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

        //new for loop for the board
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                Button button = new Button();
                button.setPrefSize(75,75);
                button.setStyle("-fx-background-color: " + ((row + col) % 2 == 0 ? "white" : "lightgray"));
                squares[row][col] = button;

                //Rectangle rect = new Rectangle(75, 75, (row + col) % 2 == 0 ? Color.WHITE : Color.LIGHTGRAY);
                //squares[row][col] = rect;

                // Create ImageView and add it to a StackPane
                StackPane stackPane = new StackPane();
                stackPane.getChildren().add(button);
                ImageView imageView = new ImageView();
                imageView.setFitWidth(60);
                imageView.setFitHeight(60);
                stackPane.getChildren().add(imageView);

                // Set the image of the ImageView to the corresponding chess piece
                if (row == 0 && (col == 0 || col == 7)) {
                    imageView.setImage(new Image("white_rook.png"));
                } else if (row == 0 && (col == 1 || col == 6)) {
                    imageView.setImage(new Image("white_knight.png"));
                } else if (row == 0 && (col == 2 || col == 5)) {
                    imageView.setImage(new Image("white_bishop.png"));
                } else if (row == 0 && col == 3) {
                    imageView.setImage(new Image("white_king.png"));
                } else if (row == 0 && col == 4) {
                    imageView.setImage(new Image("white_queen.png"));
                } else if (row == 1) {
                    imageView.setImage(new Image("white_pawn.png"));
                } else if (row == 6) {
                    imageView.setImage(new Image("black_pawn.png"));
                } else if (row == 7 && (col == 0 || col == 7)) {
                    imageView.setImage(new Image("black_rook.png"));
                } else if (row == 7 && (col == 1 || col == 6)) {
                    imageView.setImage(new Image("black_knight.png"));
                } else if (row == 7 && (col == 2 || col == 5)) {
                    imageView.setImage(new Image("black_bishop.png"));
                } else if (row == 7 && col == 3) {
                    imageView.setImage(new Image("black_king.png"));
                } else if (row == 7 && col == 4) {
                    imageView.setImage(new Image("black_queen.png"));
                }

                int testRow = row;
                int testCol = col;
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        System.out.println("Button Clicked: Row = " + testRow + " Col = " + testCol);
                    }
                });
                gridPane.add(stackPane, col, row);
            }
        }

        setCenter(gridPane);

    }
}



