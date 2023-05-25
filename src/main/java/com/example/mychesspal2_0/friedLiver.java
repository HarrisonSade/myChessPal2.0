package com.example.mychesspal2_0;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
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

public class friedLiver extends BorderPane {

    private static final int BOARD_SIZE = 8;
    Button[][] squares = new Button[BOARD_SIZE][BOARD_SIZE];

    private int clickCount = 0;



    public friedLiver() {

        Button backBtn = new Button("Back");
        backBtn.setMaxSize(75, 50);

        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                openingLessons openingLessons = new openingLessons();
                Stage s = (Stage) friedLiver.this.getScene().getWindow();
                Scene homeScene = new Scene(openingLessons, s.getWidth(), s.getHeight());
                s.setScene(homeScene);
                s.setTitle("Opening Lessons");
            }
        });

        Button nextMove = new Button("Next Move");
        nextMove.setMaxSize(200, 200);

        Text instructions = new Text("The first move of the Fried Liver is pawn to e4");
        instructions.setFont(Font.font(20));

        HBox things = new HBox(backBtn, instructions, nextMove);
        things.setSpacing(40);
        this.setTop(things);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);

        nextMove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                clickCount++;

                // Perform different actions based on the click count
                switch (clickCount) {
                    case 1:
                        instructions.setText("The first move of the Fried Liver is pawn to e4");
                        squares[1][3].setText("");
                        squares[3][3].setText("♙");

                        break;

                    case 2:
                        instructions.setText("Black will now respond with pawn to e5");
                        squares[6][3].setText("");
                        squares[4][3].setText("♟︎");
                        break;

                    case 3:
                        instructions.setText("White now plays knight to f3 ");
                        squares[0][1].setText("");
                        squares[2][2].setText("♘");
                        break;

                    case 4:
                        instructions.setText("Black responds with knight to c6");
                        squares[7][6].setText("");
                        squares[5][5].setText("♞");
                        break;

                    case 5:
                        instructions.setText("You will now play bishop to c4");
                        squares[0][2].setText("");
                        squares[3][5].setText("♗");
                        break;

                    case 6:
                        instructions.setText("Black will respond with knight to f6");
                        squares[7][1].setText("");
                        squares[5][2].setText("♞");
                        break;

                    case 7:
                        instructions.setText("White will now play knight to g5");
                        squares[2][2].setText("");
                        squares[4][1].setText("♘");
                        break;

                    case 8:
                        instructions.setText("Black responds with pawn to d5");
                        squares[6][4].setText("");
                        squares[4][4].setText("♟︎");
                        break;

                    case 9:
                        instructions.setText("White will now eat d5 pawn with the e4 pawn");
                        squares[3][3].setText("");
                        squares[4][4].setText("♙");
                        break;

                    case 10:
                        instructions.setText("Black now takes back with kings side knight");
                        squares[5][2].setText("");
                        squares[4][4].setText("♞");
                        break;

                    case 11:
                        instructions.setText("White now sacrifices the knight on f7 to finish the Fried Liver");
                        squares[4][1].setText("");
                        squares[6][2].setText("♘");
                        break;
                    default:
                        // Default action for any additional clicks
                        break;
                }
            }
        });

        //new for loop for the board
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                Button button = new Button();
                button.setPrefSize(75,75);
                button.setStyle("-fx-background-color: " + ((row + col) % 2 == 0 ? "white" : "lightgray"));
                button.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 32));
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
                    }
                });
                gridPane.add(stackPane, col, row);
            }
        }
    setCenter(gridPane);

    }}
