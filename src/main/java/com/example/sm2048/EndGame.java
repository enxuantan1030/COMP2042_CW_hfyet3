package com.example.sm2048;

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


public class EndGame {
    private static EndGame singleInstance = null;

    public static EndGame getInstance(){
        if(singleInstance == null)
            singleInstance= new EndGame();
        return singleInstance;
    }

    //used in GameScene.java line 302
    public void endGameShow(Scene endGameScene, Group root, Stage primaryStage,long score){
        Text text = new Text("GAME OVER");
        text.relocate(230,250);
        text.setFont(Font.font(80));
        root.getChildren().add(text);


        Text scoreText = new Text(score+"");
        scoreText.setFill(Color.rgb(0,0,102));
        scoreText.relocate(470,600);
        scoreText.setFont(Font.font(80));
        root.getChildren().add(scoreText);

        Button quitButton = new Button("QUIT");
        quitButton.setPrefSize(200,60);
        quitButton.setTextFill(Color.rgb(0,0,102));
        quitButton.setFont(Font.font(30));
        root.getChildren().add(quitButton);
        quitButton.relocate(500,700);
        quitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Quit Dialog");
                alert.setHeaderText("Quit from this page");
                alert.setContentText("Are you sure?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    root.getChildren().clear();
                    System.exit(1);
                }
            }
        });



    }
}
