package com.example.mychesspal2_0;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class caro extends BorderPane {

    private int clickCount = 0;


    private static final int BOARD_SIZE = 8;
    Button[][] squares = new Button[BOARD_SIZE][BOARD_SIZE];

    public caro(){
        Button backBtn = new Button("Back");
        backBtn.setMaxSize(75, 50);

        Button nextMove = new Button("Next Move");
        nextMove.setMaxSize(200, 200);
        nextMove.setPadding(new Insets(30));
        this.setBottom(nextMove);

        Text instructions = new Text("The first move of the Caro Kann is white's king pawn to E4");
        instructions.setFont(Font.font(20));

        HBox things = new HBox(backBtn, instructions, nextMove);
        things.setSpacing(40);
        this.setTop(things);

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

                                squares[1][3].setText("");


                                squares[3][3].setText("♙"); // Use the appropriate Unicode character for the pawn
                                break;
                            case 2:

                                squares[6][5].setText("");
                                squares[5][5].setText("♟︎");
                                break;


                            case 3:
                                squares[1][4].setText("");
                                squares[3][4].setText("♙");
                                break;

                            case 4:
                                squares[6][4].setText("");
                                squares[4][4].setText("♟");
                                break;

                            case 5:
                                squares[0][6].setText("");
                                squares[2][5].setText("♘");
                                break;

                            case 6:
                                squares[4][4].setText("");
                                squares[3][3].setText("♟");
                                break;

                            case 7:
                                squares[2][5].setText("");
                                squares[3][3].setText("♘");
                                break;

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
