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
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
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
                        squares[1][4].setText("");

                        // Update the new position of the pawn to d4
                        squares[3][4].setText("♙"); // Use the appropriate Unicode character for the pawn
                        break;
                    case 2:

                        instructions.setText("Now, black might respond with pawn to d5 ");
                        // Second click: Perform a different action
                        // Add your code here for the second click
                        squares[6][4].setText("");
                        squares[4][4].setText("♟︎");
                        break;
                    // Add cases for subsequent clicks as needed

                    case 3:
                        instructions.setText("You will now respond with knight to f3");
                        squares[0][1].setText("");
                        squares[2][2].setText("♘");
                        break;

                    case 4:
                        instructions.setText("Black may now mirror your move with knight to f6");
                        squares[7][1].setText("");
                        squares[5][2].setText("♞");
                        break;

                    case 5:
                        instructions.setText("The next step is bringing your queens side bishop in front of your knight");
                        squares[0][5].setText("");
                        squares[3][2].setText("♗");
                        break;

                    case 6:
                        instructions.setText("Black can repspond with pawn to e6");
                        //pawn to e6
                        squares[6][3].setText("");
                        squares[5][3].setText("♟︎");
                        break;
                    case 7:
                        instructions.setText("You will now play pawn to e3");
                        //pawn to e3
                        squares[1][3].setText("");
                        squares[2][3].setText("♙");
                        break;
                    case 8:
                        instructions.setText("Black could then play knight e6");
                        //knight e6
                        squares[7][6].setText("");
                        squares[5][5].setText("♞");
                        break;

                    case 9:
                        instructions.setText("You will not play bishop to d3");
                        //bishop to d3
                        squares[0][2].setText("");
                        squares[2][4].setText("♗");
                        break;

                    case 10:
                        instructions.setText("Black might possibly play bishop to d7");
                        squares[7][5].setText("");
                        squares[6][4].setText("♝");
                        break;

                    case 11:
                        instructions.setText("You will now play knight to d2");
                        squares[0][6].setText("");
                        squares[1][4].setText("♘");
                        break;

                    case 12:
                        instructions.setText("This could be followed up with bishop to d7");
                        squares[7][2].setText("");
                        squares[6][3].setText("♝");
                        break;

                    case 13:
                        instructions.setText("This will be followed up with pawn to c3");
                        squares[1][5].setText("");
                        squares[2][5].setText("♙");
                        break;

                    case 14:
                        instructions.setText("Now lets say black castles on kings side");
                        //kings side castle
                        squares[7][3].setText("");
                        squares[7][1].setText("♚");
                        squares[7][0].setText("");
                        squares[7][2].setText("♜");
                        break;

                    case 15:
                        instructions.setText("You will officially finish the London system with a kings side castle");
                        squares[0][3].setText("");
                        squares[0][1].setText("♔");
                        squares[0][0].setText("");
                        squares[0][2].setText("♖");
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
    }


}
