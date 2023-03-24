package com.example.mychesspal2_0;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

import static javafx.application.Application.launch;

public class Main extends Application {

    public static void main(String[] args){
        launch();

    }

    public void start(Stage stage) throws IOException {
        home home = new home();
        Scene scene = new Scene(home, 900, 900);
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
    }
}




