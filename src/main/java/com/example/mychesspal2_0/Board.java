package com.example.mychesspal2_0;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Board extends BorderPane {

    private static final int BOARD_SIZE = 8;
    private Button[][] board;
    private int sX = -1;
    private int sY = -1;
    private BoardLogic boardLogic;
    private GridPane gridPane;

    public Board() {
        Button backBtn = new Button("Back");
        backBtn.setMaxSize(75, 50);
        this.setTop(backBtn);
        boardLogic = new BoardLogic();

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

        gridPane = createGridPane();
        gridPane.setAlignment(Pos.CENTER);
        setCenter(gridPane);
    }

    private GridPane createGridPane() {
        GridPane gridPane = new GridPane();

        for (int row = 0; row < BOARD_SIZE; row++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPercentHeight(100.0 / BOARD_SIZE);
            gridPane.getRowConstraints().add(rowConstraints);
        }

        for (int col = 0; col < BOARD_SIZE; col++) {
            ColumnConstraints colConstraints = new ColumnConstraints();
            colConstraints.setPercentWidth(100.0 / BOARD_SIZE);
            gridPane.getColumnConstraints().add(colConstraints);
        }

        board = new Button[BOARD_SIZE][BOARD_SIZE];

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                Button button = new Button();
                button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                GridPane.setFillHeight(button, true);
                GridPane.setFillWidth(button, true);

                boolean isDarkSquare = (col + row) % 2 != 0;
                String backgroundColor = isDarkSquare ? "#A9A9A9" : "#FFFFFF";
                button.setStyle("-fx-background-color: " + backgroundColor);
                button.setUserData(new Space(row, col));
                button.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DOTTED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));


                String s = setImageForPiece(boardLogic.get(row, col));
                button.setText(s);
                button.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 45));



                button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        Button clickedButton = (Button) mouseEvent.getSource();
                        Space space = (Space) clickedButton.getUserData();

                        if (sX < 0 || sY < 0) {
                            sX = space.col;
                            sY = space.row;
                            button.setStyle("-fx-background-color: #E2C3C3");

                        } else {
                            int piece = boardLogic.get(sY, sX);//6,4
                            System.out.println(piece + "-" + sX + "-" + sY + "-" + space.col + "-" + space.row);


                            if (boardLogic.move(sX, sY, space.col, space.row)==true) {

                                System.out.println("here");

                                updateGraphics();

                            }
                            else {
                                System.out.println("else");

                            }

                            if(sX % 2 == 0 && sY % 2 == 0 || sX % 2 == 1 && sY % 2 == 1) {
                                board[sY][sX].setStyle("-fx-background-color: #FFFFFF");
                            }
                            else{
                                board[sY][sX].setStyle("-fx-background-color: #A9A9A9");
                            }

                            sX = -1;
                            sY = -1;
                        }
                    }
                });

                board[row][col] = button;
                gridPane.add(button, col, row);

            }
        }

        return gridPane;
    }

    private String setImageForPiece(int piece) {
        String image = null;

        switch (piece) {
            case 1:
                return "♙";
            case 2:
                return "♘";
            case 3:
                return "♗";
            case 4:
                return "♖";
            case 5:
                return "♕";
            case 6:
                return "♔";
            case -1:
                return "♟︎";
            case -2:
                return "♞";
            case -3:
                return "♝";
            case -4:
                return "♜";
            case -5:
                return "♛";
            case -6:
                return "♚";
            default:
                // Handle any other cases or set a default image
                break;
        }

        return "";
    }

    private void updateGraphics(){
        for (int col = 0; col < BOARD_SIZE; col++) {
            for (int row = 0; row < BOARD_SIZE; row++) {
                System.out.print(boardLogic.get(col, row) + " ");
                String s = setImageForPiece(boardLogic.get(col, row));
                board[col][row].setText(s);
            }
            System.out.println();
        }

    }

    private class Space {
        private int row, col;

        public Space(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}

