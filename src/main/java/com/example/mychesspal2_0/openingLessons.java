package com.example.mychesspal2_0;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class openingLessons extends BorderPane {

    public openingLessons(){

        Button london = new Button("London System");
        london.setMaxSize(250, 100);
        london.setFont(Font.font("Cambria", 25));

        Button vienna = new Button("Vienna");
        vienna.setMaxSize(250, 100);
        vienna.setFont(Font.font("Cambria", 25));

        Button qGambit = new Button("Queens Gambit");
        qGambit.setMaxSize(250, 100);
        qGambit.setFont(Font.font("Cambria", 25));

        Button friedLiver = new Button("Fried Liver");
        friedLiver.setMaxSize(250, 100);
        friedLiver.setFont(Font.font("Cambria", 25));

        Button kGambit = new Button("Kings Gambit");
        kGambit.setMaxSize(250, 100);
        kGambit.setFont(Font.font("Cambria", 25));


        VBox openings = new VBox(london, vienna, qGambit, friedLiver, kGambit);
        openings.setSpacing(50);
        openings.setPadding(new Insets(285, 200, 275, 330));
        this.setCenter(openings);

        Button back = new Button("Back");
        back.setMaxSize(75, 50);
        this.setTop(back);

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                home homePage = new home();
                Stage s = (Stage) openingLessons.this.getScene().getWindow();
                Scene homeScene = new Scene(homePage, s.getWidth(), s.getHeight());
                s.setScene(homeScene);
                s.setTitle("Home");
            }
        });

        london.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                London london = new London();
                Stage s = (Stage) openingLessons.this.getScene().getWindow();
                Scene londonScene = new Scene(london, s.getWidth(), s.getHeight());
                s.setScene(londonScene);
                s.setTitle("The London System");
            }
        });

        vienna.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Vienna vienna = new Vienna();
                Stage s = (Stage) openingLessons.this.getScene().getWindow();
                Scene viennaScene = new Scene(vienna, s.getWidth(), s.getHeight());
                s.setScene(viennaScene);
                s.setTitle("The Vienna");
            }
        });

        qGambit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                queensGambit qGambit = new queensGambit();
                Stage s = (Stage) openingLessons.this.getScene().getWindow();
                Scene qGambitScene = new Scene(qGambit, s.getWidth(), s.getHeight());
                s.setScene(qGambitScene);
                s.setTitle("The Queens Gambit");
            }
        });

        friedLiver.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                friedLiver friedLiver = new friedLiver();
                Stage s = (Stage) openingLessons.this.getScene().getWindow();
                Scene friedLiverScene = new Scene(friedLiver, s.getWidth(), s.getHeight());
                s.setScene(friedLiverScene);
                s.setTitle("The London System");
            }
        });

        kGambit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                kingsGambit kingsGambit = new kingsGambit();
                Stage s = (Stage) openingLessons.this.getScene().getWindow();
                Scene kGambitScene = new Scene(kingsGambit, s.getWidth(), s.getHeight());
                s.setScene(kGambitScene);
                s.setTitle("The Kings Gambit");
            }
        });

    }
}
