package com.example.mychesspal2_0;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class dutch extends BorderPane {

    private int clickCount = 0;


    private static final int BOARD_SIZE = 8;
    Button[][] squares = new Button[BOARD_SIZE][BOARD_SIZE];

    public dutch(){
        Button backBtn = new Button("Back");
        backBtn.setMaxSize(75, 50);

        Button nextMove = new Button("Next Move");
        nextMove.setMaxSize(200, 200);

        Text instructions = new Text("White starts with pawn to d4");
        instructions.setFont(Font.font(20));

        HBox things = new HBox(backBtn, instructions, nextMove);
        things.setSpacing(40);
        this.setTop(things);

        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                defenseLessons defense = new defenseLessons();
                Stage s = (Stage) dutch.this.getScene().getWindow();
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
                button.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 32));

                // Create ImageView and add it to a StackPane
                StackPane stackPane = new StackPane();
                stackPane.getChildren().add(button);


                // Set the image of the button to the corresponding chess piece
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

                gridPane.add(stackPane, col, row);
                nextMove.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        clickCount++;

                        // Perform different actions based on the click count
                        switch (clickCount) {
                            case 1:
                                instructions.setText("White starts with pawn to d4, a strong move to strengthen central presence");
                                squares[1][4].setText("");
                                squares[3][4].setText("♙");
                                break;

                            case 2:
                                instructions.setText("Black responds with pawn to f5, aiming to control the center");
                                squares[6][2].setText("");
                                squares[4][2].setText("♟");
                                break;

                            case 3:
                                instructions.setText("You completed the Dutch Defense!");
                            default:
                                // Default action for any additional clicks
                                break;
                        }
                    }
                });

            }
        }

        setCenter(gridPane);
    }


}
