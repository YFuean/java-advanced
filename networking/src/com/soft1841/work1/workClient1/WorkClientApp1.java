package com.soft1841.work1.workClient1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WorkClientApp1 extends Application {
    public WorkClientApp1(){}
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(this.getClass().getResource("workClient1.fxml"));
        primaryStage.setTitle("客户端");
        Scene scene = new Scene(root, 580, 600);
        scene.getStylesheets().add(WorkClientApp1.class.getResource("workClient1.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
