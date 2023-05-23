package com.example.mychesspal2_0;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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

public class caro extends BorderPane {

    private ImageView selectedPiece;


    private static final int BOARD_SIZE = 8;
    Button[][] squares = new Button[BOARD_SIZE][BOARD_SIZE];

    public caro(){
        Button backBtn = new Button("Back");
        backBtn.setMaxSize(75, 50);
        this.setTop(backBtn);

        Button nextMove = new Button("Next Move");
        nextMove.setMaxSize(200, 200);
        nextMove.setPadding(new Insets(30));
        this.setBottom(nextMove);

        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                defenseLessons defense = new defenseLessons();
                Stage s = (Stage) caro.this.getScene().getWindow();
                Scene homeScene = new Scene(defense, s.getWidth(), s.getHeight());
                s.setScene(homeScene);
                s.setTitle("Defense Lessons");
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

                // Create ImageView and add it to a StackPane
                StackPane stackPane = new StackPane();
                stackPane.getChildren().add(button);
                ImageView imageView = new ImageView();
                imageView.setFitWidth(60);
                imageView.setFitHeight(60);
                stackPane.getChildren().add(imageView);

                // Set the image of the ImageView to the corresponding chess piece
                if (row == 0 && (col == 0 || col == 7)) {
                    squares[row][col].setText("♖");
                } else if (row == 0 && (col == 1 || col == 6)) {
                    squares[row][col].setText("♘");
                } else if (row == 0 && (col == 2 || col == 5)) {
                    squares[row][col].setText("♗");
                } else if (row == 0 && col == 3) {
                    squares[row][col].setText("♔");
                } else if (row == 0 && col == 4) {
                    squares[row][col].setText("♕");
                } else if (row == 1) {
                    squares[row][col].setText("♙");
                } else if (row == 6) {
                    squares[row][col].setText("♟︎");
                } else if (row == 7 && (col == 0 || col == 7)) {
                    squares[row][col].setText("♜");
                } else if (row == 7 && (col == 1 || col == 6)) {
                    squares[row][col].setText("♞");
                } else if (row == 7 && (col == 2 || col == 5)) {
                    squares[row][col].setText("♝");
                } else if (row == 7 && col == 3) {
                    squares[row][col].setText("♚");
                } else if (row == 7 && col == 4) {
                    squares[row][col].setText("♛");
                }

                int testRow = row;
                int testCol = col;
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        System.out.println("Button Clicked: Row = " + testRow + " Col = " + testCol);
                        selectedPiece = imageView; // Assign the clicked ImageView to selectedPiece
                    }
                });

                gridPane.add(stackPane, col, row);
            }
        }

        setCenter(gridPane);
    }


}
