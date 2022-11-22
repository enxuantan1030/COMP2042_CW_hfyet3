package com.example.sm2048;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Optional;

import static javafx.application.Application.launch;

public class StartGame{

        private static StartGame singleInstance = null;
        private Group root;

        public static StartGame getInstance(){
            if(singleInstance == null)
                singleInstance= new StartGame();
            return singleInstance;
        }

    /**
     *
     * This method is used to create the Menu Scene
     *
     * @param startGameScene Scene to create Menu Scene
     * @param root root for startGameScene
     * @param primaryStage Stage which display the Scenes
     * @param gameScene Scene for playing the game 2048
     * @param endgameScene Scene when game is game is ended, which will display GAME OVER Scene 
     * @param GameRoot root for gameScene
     * @param Endgame Root root for endgameScene
     */

        void game(Scene startGameScene, Group root, Stage primaryStage, Scene gameScene, Scene endGameScene, Group GameRoot, Group EndGameRoot) {

            this.root = root;

            //game title
            Text text = new Text("2048");
            text.relocate(370,300);
            text.setFont(Font.font("Courier New", 100));
            text.setFill(Color.web("#E5E7E9"));
            root.getChildren().add(text);

            GameScene game = new GameScene();

            //Display "Choose colour theme"
            Text theme = new Text("Choose colour theme");
            theme.relocate(310,500);
            theme.setFont(Font.font("Courier New", 30));
            root.getChildren().add(theme);

            //Drop down menu for choosing theme colour in game
            Group gameRooot = new Group();
            final ComboBox themedropbox = new ComboBox();
            themedropbox.getItems().addAll(
                    "Default(Black)",
                    "Blue",
                    "Yellow",
                    "Green",
                    "Pink",
                    "Purple"
            );
            root.getChildren().add(themedropbox);
            themedropbox.setPrefSize(200,50);
            themedropbox.relocate(390,530);
            themedropbox.setValue("Default(Black)");

            //Menu start button
            Button startButton = new Button("START");
            startButton.setPrefSize(200,60);
            startButton.setTextFill(Color.rgb(0,0,102));
            startButton.setFont(Font.font("Courier New", FontWeight.BOLD, 20));
            root.getChildren().add(startButton);
            startButton.relocate(260,400);
            //when start button is clicked, it will be directed to the game scene
            startButton.setOnAction(actionEvent ->  {
                /*game scene background colour is based on user selection
                  so if user choose blue, the background colour for gamescene and endgameScene will be blue*/
                if (themedropbox.getValue() == "Blue"){
                        //Gradient colour function referred to website -  
                    gameScene.setFill(new LinearGradient(
                            0, 0, 1, 1, true,
                            CycleMethod.NO_CYCLE,
                            new Stop(0, Color.web("#1A5276")),
                            new Stop(1, Color.web("#AED6F1"))));
                    endGameScene.setFill(new LinearGradient(
                            0, 0, 1, 1, true,
                            CycleMethod.NO_CYCLE,
                            new Stop(0, Color.web("#1A5276")),
                            new Stop(1, Color.web("#AED6F1"))));
                }
                //Option Yellow
                else if (themedropbox.getValue() == "Yellow"){
                    gameScene.setFill(new LinearGradient(
                            0, 0, 1, 1, true,
                            CycleMethod.NO_CYCLE,
                            new Stop(0, Color.web("#7D6608")),
                            new Stop(1, Color.web("#FAD7A0"))));
                    endGameScene.setFill(new LinearGradient(
                            0, 0, 1, 1, true,
                            CycleMethod.NO_CYCLE,
                            new Stop(0, Color.web("#7D6608")),
                            new Stop(1, Color.web("#FAD7A0"))));
                }
                //Option Green
                else if (themedropbox.getValue() == "Green"){
                    gameScene.setFill(new LinearGradient(
                            0, 0, 1, 1, true,
                            CycleMethod.NO_CYCLE,
                            new Stop(0, Color.web("#0B5345")),
                            new Stop(1, Color.web("#A9DFBF"))));
                    endGameScene.setFill(new LinearGradient(
                            0, 0, 1, 1, true,
                            CycleMethod.NO_CYCLE,
                            new Stop(0, Color.web("#0B5345")),
                            new Stop(1, Color.web("#A9DFBF"))));
                }
                //Option Pink
                else if (themedropbox.getValue() == "Pink"){
                    gameScene.setFill(new LinearGradient(
                            0, 0, 1, 1, true,
                            CycleMethod.NO_CYCLE,
                            new Stop(0, Color.web("#78281F")),
                            new Stop(1, Color.web("#FADBD8"))));
                    endGameScene.setFill(new LinearGradient(
                            0, 0, 1, 1, true,
                            CycleMethod.NO_CYCLE,
                            new Stop(0, Color.web("#78281F")),
                            new Stop(1, Color.web("#FADBD8"))));
                }
                //Option Purple
                else if (themedropbox.getValue() == "Purple"){
                    gameScene.setFill(new LinearGradient(
                            0, 0, 1, 1, true,
                            CycleMethod.NO_CYCLE,
                            new Stop(0, Color.web("#4A235A")),
                            new Stop(1, Color.web("#D7BDE2"))));
                    endGameScene.setFill(new LinearGradient(
                            0, 0, 1, 1, true,
                            CycleMethod.NO_CYCLE,
                            new Stop(0, Color.web("#4A235A")),
                            new Stop(1, Color.web("#D7BDE2"))));
                }
                //Default Colour set to Black
                else{
                    gameScene.setFill(new LinearGradient(
                            0, 0, 1, 1, true,
                            CycleMethod.NO_CYCLE,
                            new Stop(0, Color.web("#1B2631")),
                            new Stop(1, Color.web("#85929E"))));
                    endGameScene.setFill(new LinearGradient(
                            0, 0, 1, 1, true,
                            CycleMethod.NO_CYCLE,
                            new Stop(0, Color.web("#1B2631")),
                            new Stop(1, Color.web("#85929E"))));
                }
                //switch Scene to gameScene
                primaryStage.setScene(gameScene);
                //links the Scene to GameScene.play method
                GameScene.getInstance().play(startGameScene, root, primaryStage, gameScene, endGameScene, GameRoot, EndGameRoot);
                root.getChildren().clear();

            });

            
            //menu quit button
            Button menuquitButton = new Button("QUIT");
            menuquitButton.setPrefSize(200,60);
            //set button word colour
            menuquitButton.setTextFill(Color.rgb(0,0,102));
            //set font type, bold and size for menu quit button
            menuquitButton.setFont(Font.font("Courier New", FontWeight.BOLD, 20));
            //add menu quite button to the root
            root.getChildren().add(menuquitButton);
            menuquitButton.relocate(520,400);
            //when the quit button is clicked, a wondpw will pop out and ask for confirmation
            menuquitButton.setOnAction(actionEvent ->  {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Quit Dialog");
                alert.setHeaderText("Quit from this page");
                alert.setContentText("Are you sure?");
                
                //when "ok" is clickeed, it will terminate the program
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    root.getChildren().clear();
                    System.exit(1);
                }
            });
            
        }

}
