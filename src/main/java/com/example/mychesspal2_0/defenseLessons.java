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

public class defenseLessons extends BorderPane {

    public defenseLessons(){

            Button caro = new Button("Caro Kann");
            caro.setMaxSize(250, 100);
            caro.setFont(Font.font("Cambria", 25));

            Button scandinavian = new Button("Scandinavian");
            scandinavian.setMaxSize(250, 100);
            scandinavian.setFont(Font.font("Cambria", 25));

            Button french = new Button("The French");
            french.setMaxSize(250, 100);
            french.setFont(Font.font("Cambria", 25));

            Button dutch = new Button("The Dutch");
            dutch.setMaxSize(250, 100);
            dutch.setFont(Font.font("Cambria", 25));

            Button slav = new Button("The Slav");
            slav.setMaxSize(250, 100);
            slav.setFont(Font.font("Cambria", 25));

            VBox defenses = new VBox(caro, scandinavian, french, dutch, slav);
            defenses.setSpacing(50);
            defenses.setPadding(new Insets(275, 200, 275, 330));
            this.setCenter(defenses);



            Button back = new Button("Back");
            back.setMaxSize(75,50);
            this.setTop(back);

            back.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    home homePage = new home();
                    Stage s = (Stage) defenseLessons.this.getScene().getWindow();
                    Scene homeScene = new Scene(homePage, s.getWidth(), s.getHeight());
                    s.setScene(homeScene);
                    s.setTitle("Home");
                }
            });

            caro.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    caro carokhan = new caro();
                    Stage s = (Stage) defenseLessons.this.getScene().getWindow();
                    Scene caro = new Scene(carokhan, s.getWidth(), s.getHeight());
                    s.setScene(caro);
                    s.setTitle("Caro Khan");
                }
            });

            dutch.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    dutch dutch1 = new dutch();
                    Stage s = (Stage) defenseLessons.this.getScene().getWindow();
                    Scene dutch = new Scene(dutch1, s.getWidth(), s.getHeight());
                    s.setScene(dutch);
                    s.setTitle("The Dutch");
                }
            });

            slav.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    slav slav1 = new slav();
                    Stage s = (Stage) defenseLessons.this.getScene().getWindow();
                    Scene slav = new Scene(slav1, s.getWidth(), s.getHeight());
                    s.setScene(slav);
                    s.setTitle("The Slav");
                }
            });

            scandinavian.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    scandanavian scanda = new scandanavian();
                    Stage s = (Stage) defenseLessons.this.getScene().getWindow();
                    Scene scandanavian = new Scene(scanda, s.getWidth(), s.getHeight());
                    s.setScene(scandanavian);
                    s.setTitle("The Scandanavian");
                }
            });

            french.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    french french1 = new french();
                    Stage s = (Stage) defenseLessons.this.getScene().getWindow();
                    Scene french = new Scene(french1, s.getWidth(), s.getHeight());
                    s.setScene(french);
                    s.setTitle("The French");
                }
            });


        }

}
