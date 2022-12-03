package com.sm2048.Scenes.MenuGame;

import com.sm2048.Accounts.Test;
import com.sm2048.Main;
import com.sm2048.Accounts.Account;
import com.sm2048.Scenes.InGame.GameScene;
import com.sm2048.Scenes.InGame.Variables;
import com.sm2048.Scenes.MenuGame.Features.Theme;
import javafx.css.PseudoClass;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

import static com.sm2048.Accounts.Account.accounts;
import static javafx.application.Application.launch;


     /**
     *
     * This class is used for displaying Menu Scene, feature including:
     * display game title, able to start game and quit game, choose theme and difficulty
     *
     */
public class StartGame extends Theme {

        private static StartGame singleInstance = null;
        private Group root;
        static int lvln = 7;
        String c1, c2;

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

            Main.imageView1.relocate(610,230);
            Main.imageView1.setFitHeight(120);
            Main.imageView1.setFitWidth(100);
            Main.imageView1.setPreserveRatio(true);
            root.getChildren().add(Main.imageView1);

            /*Main.imageView2.relocate(700,600);
            Main.imageView2.setFitHeight(120);
            Main.imageView2.setFitWidth(140);
            Main.imageView2.setPreserveRatio(true);
            root.getChildren().add(Main.imageView2);

            Main.imageView3.relocate(800,600);
            Main.imageView3.setFitHeight(120);
            Main.imageView3.setFitWidth(100);
            Main.imageView3.setPreserveRatio(true);
            root.getChildren().add(Main.imageView3);

            Main.imageView4.relocate(900,600);
            Main.imageView4.setFitHeight(120);
            Main.imageView4.setFitWidth(100);
            Main.imageView4.setPreserveRatio(true);
            root.getChildren().add(Main.imageView4);*/

            GameScene game = new GameScene();
            //game title
            GameTitle(root);

            //Display "Theme"
            Text theme = new Text("Theme");
            theme.relocate(570,500);
            textstyle(theme, root, 27);

            //Drop down menu for choosing theme colour in game
            final ComboBox<String> themedropbox = new ComboBox<>();
            themedropbox.getItems().addAll(
                    "Default(Green)",
                    "Blue",
                    "Yellow",
                    "Black",
                    "Pink",
                    "Purple"
            );
            root.getChildren().add(themedropbox);
            themedropbox.setPrefSize(200,60);
            themedropbox.relocate(520,530);
            themedropbox.setValue("Default(Green)");

            //Display "Difficulty"
            Text level = new Text("Difficulty");
            level.relocate(290,500);
            textstyle(level, root, 25);

            //Drop down menu for choosing level difficulty
            final ComboBox<String> leveldropbox = new ComboBox<>();
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

            //Display "ENTER YOUR NAME"
            Text reqname = new Text("ENTER YOUR NAME");
            reqname.relocate(377,620);
            textstyle(reqname, root, 27);

            //username
            TextField name= new TextField();
            name.setPrefSize(200,40);
            root.getChildren().add(name);
            name.setPromptText("Please enter your name here");
            name.relocate(400, 650);

            //Menu start button
            Button startButton = new Button("START");
            btnstyle(startButton, root);
            startButton.relocate(260,400);
            //when start button is clicked, it will be directed to the game scene
            startButton.setOnAction(actionEvent ->  {

                Test.add(name.getText());

                    Variables.setN(ChooseDifficulty(leveldropbox.getValue()));
                    DBChooseTheme(themedropbox.getValue(), gameScene, endGameScene);

                //switch Scene to gameScene
                primaryStage.setScene(gameScene);

                //links the Scene to GameScene.play method
                GameScene.getInstance().play(startGameScene, root, primaryStage, gameScene, endGameScene, GameRoot, EndGameRoot);
                root.getChildren().clear();

            });

            //Create Quit button
            Quitbutton(root);

        }

        }