package com.example.sm2048;

import javafx.application.Application;
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

class StartGame{

        private static StartGame singleInstance = null;
        private Group root;

        public static StartGame getInstance(){
            if(singleInstance == null)
                singleInstance= new StartGame();
            return singleInstance;
        }

        void game(Scene startGameScene, Group root, Stage primaryStage, Scene gameScene, Scene endGameScene, Group GameRoot, Group EndGameRoot) {

            this.root = root;

            Text text = new Text("2048");
            text.relocate(230,250);
            text.setFont(Font.font(80));
            root.getChildren().add(text);

            GameScene game = new GameScene();

            Button startButton = new Button("START");
            startButton.setPrefSize(200,60);
            startButton.setTextFill(Color.rgb(0,0,102));
            startButton.setFont(Font.font(30));
            root.getChildren().add(startButton);
            startButton.relocate(430,700);
            startButton.setOnAction(actionEvent ->  {

                primaryStage.setScene(gameScene);
               GameScene.getInstance().play(primaryStage, gameScene, endGameScene, GameRoot, EndGameRoot);
                root.getChildren().clear();
            });

            Button menuquitButton = new Button("QUIT");
            menuquitButton.setPrefSize(200,60);
            menuquitButton.setTextFill(Color.rgb(0,0,102));
            menuquitButton.setFont(Font.font(30));
            root.getChildren().add(menuquitButton);
            menuquitButton.relocate(650,700);
            menuquitButton.setOnAction(actionEvent ->  {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Quit Dialog");
                alert.setHeaderText("Quit from this page");
                alert.setContentText("Are you sure?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    root.getChildren().clear();
                    System.exit(1);
                }
            });

        }

}