package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculatorGUI extends Application{
    public static void main(String[] args) {
        CalculatorGUI.launch(args);
    }

    public void start(Stage s) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/calculator.fxml"));
        Scene scene = new Scene(root);

        s.setTitle("Calculator");
        s.setScene(scene);
        s.setResizable(false);
        s.show();
    }
}
