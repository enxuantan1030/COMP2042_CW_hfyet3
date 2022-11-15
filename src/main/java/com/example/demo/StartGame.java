package com.example.demo;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Optional;

import static javafx.application.Application.launch;

/*
        if (GameScene.this.canNotMove()) {
            primaryStage.setScene(startGameScene);

             StartGame.getInstance().startGameShow(startGameScene, startGameRoot, primaryStage);
             root.getChildren().clear();
             score = 0;
                        }*/

public class StartGame {
    private static StartGame singleInstance = null;
    private StartGame(){

    }
    public static StartGame getInstance(){
        if(singleInstance == null)
            singleInstance= new StartGame();
        return singleInstance;
    }

    //used in GameScene.java line 302
    public void startGameShow(Scene startGameScene, Group root, Stage primaryStage){
        Text text = new Text("2048");
        text.relocate(230,250);
        text.setFont(Font.font(80));
        root.getChildren().add(text);

        Button menuquitButton = new Button("QUIT");
        menuquitButton.setPrefSize(200,60);
        menuquitButton.setTextFill(Color.rgb(0,0,102));
        menuquitButton.setFont(Font.font(30));
        root.getChildren().add(menuquitButton);
        menuquitButton.relocate(700,700);
        menuquitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Quit Dialog");
                alert.setHeaderText("Quit from this page");
                alert.setContentText("Are you sure?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    root.getChildren().clear();
                    //ButtonType.setOnAction(e -> Platform.exit());
                }
            }
        });

        Button startButton = new Button("START");
        startButton.setPrefSize(200,60);
        startButton.setTextFill(Color.rgb(0,0,102));
        startButton.setFont(Font.font(30));
        root.getChildren().add(startButton);
        startButton.relocate(400,700);

    }
}

