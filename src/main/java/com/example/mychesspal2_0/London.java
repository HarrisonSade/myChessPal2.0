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
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class London extends Board {

    private static final int BOARD_SIZE = 8;
    Button[][] squares = new Button[BOARD_SIZE][BOARD_SIZE];

    private int clickCount = 0;



    public London() {

        Button backBtn = new Button("Back");
        backBtn.setMaxSize(75, 50);

        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                openingLessons openingLessons = new openingLessons();
                Stage s = (Stage) London.this.getScene().getWindow();
                Scene homeScene = new Scene(openingLessons, s.getWidth(), s.getHeight());
                s.setScene(homeScene);
                s.setTitle("Opening Lessons");
            }
        });

        Button nextMove = new Button("Next Move");
        nextMove.setMaxSize(200, 200);
        nextMove.setPadding(new Insets(30));
        this.setBottom(nextMove);

        Text instructions = new Text("The first move of the London System is white moves queens pawn to D4");
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
                        // First click: Move the queen's pawn to d4
                        // Add your code here to move the pawn to d4

                        // Clear the current position of the pawn
                        squares[1][3].setText("");

                        // Update the new position of the pawn to d4
                        squares[3][3].setText("♙"); // Use the appropriate Unicode character for the pawn
                        break;
                    case 2:
                        // Second click: Perform a different action
                        // Add your code here for the second click
                        break;
                    // Add cases for subsequent clicks as needed

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
