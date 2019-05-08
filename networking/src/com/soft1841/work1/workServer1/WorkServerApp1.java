package com.soft1841.work1.workServer1;

import com.soft1841.work1.workClient1.WorkClientApp1;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WorkServerApp1 extends Application {
    public WorkServerApp1(){}
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(this.getClass().getResource("workServer1.fxml"));
        primaryStage.setTitle("服务器端");
        Scene scene = new Scene(root, 580, 600);
        scene.getStylesheets().add(WorkServerApp1.class.getResource("workServer1.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
