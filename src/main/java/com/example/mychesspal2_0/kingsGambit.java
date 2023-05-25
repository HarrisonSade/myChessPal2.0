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

public class kingsGambit extends BorderPane {

    private static final int BOARD_SIZE = 8;
    Button[][] squares = new Button[BOARD_SIZE][BOARD_SIZE];

    private int clickCount = 0;



    public kingsGambit() {

        Button backBtn = new Button("Back");
        backBtn.setMaxSize(75, 50);

        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                openingLessons openingLessons = new openingLessons();
                Stage s = (Stage) kingsGambit.this.getScene().getWindow();
                Scene homeScene = new Scene(openingLessons, s.getWidth(), s.getHeight());
                s.setScene(homeScene);
                s.setTitle("Opening Lessons");
            }
        });

        Button nextMove = new Button("Next Move");
        nextMove.setMaxSize(200, 200);
        nextMove.setPadding(new Insets(30));
        this.setBottom(nextMove);

        Text instructions = new Text("The first move of the Vienna is pawn to e4");
        instructions.setFont(Font.font(20));

        HBox things = new HBox(backBtn, instructions);
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
                        instructions.setText("The Kings Gambit starts off with pawn to d4");
                        squares[1][3].setText("");
                        squares[3][3].setText("♙");
                       break;

                    case 2:
                        instructions.setText("Black will now respond with pawn to d5");
                        squares[6][3].setText("");
                        squares[4][3].setText("♟︎");
                        break;

                    case 3:
                        instructions.setText("And the kings Gambit is offically finished when pawn to f4 is played");
                        squares[1][2].setText("");
                        squares[3][2].setText("♙");
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
