package com.example.sm2048.Scenes;

import com.example.sm2048.Account;
import com.example.sm2048.Interfaces.Menu;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Optional;


import static javafx.application.Application.launch;


     /**
     *
     * This class is used for displaying Menu Scene, feature including:
     * display game title, able to start game and quit game, choose theme and difficulty
     *
     */
public class StartGame{

        private static StartGame singleInstance = null;
        private Group root;
        int lvln = 0;

        /**
        *
        * This class is used for displaying Menu Scene, feature including:
        *
        */
        public static StartGame getInstance(){
            if(singleInstance == null)
                singleInstance= new StartGame();
            return singleInstance;
        }

    /**
     *
     * This method is used to return the value of n value
     *
     * @param level
     * @return value is passed back to the method to create the level desired by the users
     */
    public int lvl(String level){
            if (level == "3 x 3") {
                return 3;
            } else if (level == "5 x 5") {
                return 5;
            } else if (level == "6 x 6") {
                return 6;
            } else if (level == "7 x 7") {
                return 7;
            } else {
                return 4;
            }
        }

    /**
     *
     * This method is used to create the Menu Scene
     *
     * @param startGameScene Scene to create Menu Scene
     * @param root root for startGameScene
     * @param primaryStage Stage which display the Scenes
     * @param gameScene Scene for playing the game 2048
     * @param endGameScene Scene when game is game is ended, which will display GAME OVER Scene 
     * @param GameRoot root for gameScene
     * @param EndGameRoot root for endgameScene
     */

        public void game(Scene startGameScene, Group root, Stage primaryStage, Scene gameScene, Scene endGameScene, Group GameRoot, Group EndGameRoot) {

            this.root = root;

            //game title
            Text text = new Text("2048");
            text.relocate(370,300);
            text.setFont(Font.font("Courier New", 100));
            text.setFill(Color.web("#E5E7E9"));
            root.getChildren().add(text);

            GameScene game = new GameScene();

            //Display "Theme"
            Text theme = new Text("Theme");
            theme.relocate(570,500);
            theme.setFont(Font.font("Courier New", 27));
            theme.setFill(Color.web("#E5E7E9"));
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
            themedropbox.setPrefSize(200,60);
            themedropbox.relocate(520,530);
            themedropbox.setValue("Default(Black)");

            //Display "Difficulty"
            Text level = new Text("Difficulty");
            level.relocate(290,500);
            level.setFont(Font.font("Courier New", 25));
            level.setFill(Color.web("#E5E7E9"));
            root.getChildren().add(level);

            //Drop down menu for choosing level difficulty
            final ComboBox leveldropbox = new ComboBox();
            leveldropbox.getItems().addAll(
                    "3 x 3",
                    "Default(4 x 4)",
                    "5 x 5",
                    "6 x 6",
                    "7 x 7"
            );
            root.getChildren().add(leveldropbox);
            leveldropbox.setPrefSize(200,60);
            leveldropbox.relocate(260,530);
            leveldropbox.setValue("Default(4 x 4)");

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
                    lvln = lvl((String)leveldropbox.getValue());
                    GameScene.setN(lvln);

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
                    lvln = lvl((String)leveldropbox.getValue());
                    GameScene.setN(lvln);

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
                    lvln = lvl((String)leveldropbox.getValue());
                    GameScene.setN(lvln);

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
                    lvln = lvl((String)leveldropbox.getValue());
                    GameScene.setN(lvln);

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
                    lvln = lvl((String)leveldropbox.getValue());
                    GameScene.setN(lvln);

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
                    lvln = lvl((String)leveldropbox.getValue());
                    GameScene.setN(lvln);

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

            //Display "ENTER YOUR NAME"
            Text reqname = new Text("ENTER YOUR NAME");
            reqname.relocate(377,620);
            reqname.setFont(Font.font("Courier New", 27));
            reqname.setFill(Color.web("#E5E7E9"));
            root.getChildren().add(reqname);

            //username
            TextField name= new TextField();
            name.setPrefSize(200,40);
            root.getChildren().add(name);
            name.relocate(400, 650);


        }
}
