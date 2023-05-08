package com.example.mychesspal2_0;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class slav extends BorderPane {

    public slav(){
        Button backBtn = new Button("Back");
        backBtn.setMaxSize(75, 50);
        this.setTop(backBtn);

        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                defenseLessons defense = new defenseLessons();
                Stage s = (Stage) slav.this.getScene().getWindow();
                Scene homeScene = new Scene(defense, s.getWidth(), s.getHeight());
                s.setScene(homeScene);
                s.setTitle("Defense Lessons");
            }
        });
    }
}
