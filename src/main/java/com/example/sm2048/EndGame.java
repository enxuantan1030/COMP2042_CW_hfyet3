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
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Optional;


public class EndGame {
    private static EndGame singleInstance = null;
    private Group endGameRoot;

    public static EndGame getInstance(){
        if(singleInstance == null)
            singleInstance= new EndGame();
        return singleInstance;
    }

    //used in GameScene.java line 302
    public void endGameShow(Scene startgameScene, Group root, Stage primaryStage,Scene gameScene, Scene endGameScene, Group GameRoot, Group EndGameRoot, long score){
        this.endGameRoot = EndGameRoot;
        Text text = new Text("GAME OVER");
        text.relocate(250,250);
        text.setFont(Font.font("Courier New", 100));
        text.setFill(Color.web("#E5E7E9"));
        endGameRoot.getChildren().add(text);

        Text scoreText = new Text(score+"");
        scoreText.relocate(450,400);
        scoreText.setFont(Font.font("Courier New", 50));
        scoreText.setFill(Color.web("#E5E7E9"));
        endGameRoot.getChildren().add(scoreText);

        //back to menu button
        Button backmenuButton = new Button("RESTART");
        backmenuButton.setPrefSize(200,60);
        backmenuButton.setTextFill(Color.rgb(0,0,102));
        backmenuButton.setFont(Font.font("Courier New", FontWeight.BOLD, 20));
        endGameRoot.getChildren().add(backmenuButton);
        backmenuButton.relocate(260,550);
        //when the quit button is clicked, it will terminate the program
        backmenuButton.setOnAction(actionEvent ->  {
            Alert gamealert = new Alert(Alert.AlertType.CONFIRMATION);
            gamealert.setTitle("Dialog Menu");
            gamealert.setHeaderText("Back to Menu");
            gamealert.setContentText("All the progress made will not be saved, Continue?");

            //alert window
            Optional<ButtonType> gameresult = gamealert.showAndWait();
            if (gameresult.get() == ButtonType.OK){
                primaryStage.setScene(startgameScene);
                StartGame.getInstance().game(startgameScene, root, primaryStage, gameScene, endGameScene, GameRoot, EndGameRoot);
                endGameRoot.getChildren().clear();
            }
        });

        Button quitButton = new Button("QUIT");
        quitButton.setPrefSize(200,60);
        quitButton.setTextFill(Color.rgb(0,0,102));
        quitButton.setFont(Font.font("Courier New", FontWeight.BOLD, 20));
        endGameRoot.getChildren().add(quitButton);
        quitButton.relocate(520,550);
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
