package com.sm2048.Scenes.MenuGame;

import com.sm2048.Others.Account;
import com.sm2048.Scenes.InGame.GameScene;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static com.sm2048.Others.Account.accounts;
import static javafx.application.Application.launch;


     /**
     *
     * This class is used for displaying Menu Scene, feature including:
     * display game title, able to start game and quit game, choose theme and difficulty
     *
     */
public class StartGame extends MenuAbstractMethods{

        private static StartGame singleInstance = null;
        private Group root;
        int lvln = 0;
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

            //Menu start button
            Button startButton = new Button("START");
            btnstyle(startButton, root);
            startButton.relocate(260,400);
            //when start button is clicked, it will be directed to the game scene
            startButton.setOnAction(actionEvent ->  {
                /*game scene background colour is based on user selection
                  so if user choose blue, the background colour for gamescene and endgameScene will be blue*/
                if (themedropbox.getValue() == "Blue"){
                    lvln = ChooseDifficulty((String)leveldropbox.getValue());
                    GameScene.setN(lvln);
                    ChooseTheme("#1A5276", "#AED6F1",gameScene, endGameScene);

                }else if (themedropbox.getValue() == "Yellow"){
                    lvln = ChooseDifficulty((String)leveldropbox.getValue());
                    GameScene.setN(lvln);
                    ChooseTheme("#7D6608", "#FAD7A0", gameScene, endGameScene);

                }else if (themedropbox.getValue() == "Green"){
                    lvln = ChooseDifficulty((String)leveldropbox.getValue());
                    GameScene.setN(lvln);
                    ChooseTheme("#0B5345", "#A9DFBF", gameScene, endGameScene);

                }else if (themedropbox.getValue() == "Pink"){
                    lvln = ChooseDifficulty((String)leveldropbox.getValue());
                    GameScene.setN(lvln);
                    ChooseTheme("#78281F", "#FADBD8", gameScene, endGameScene);

                }else if (themedropbox.getValue() == "Purple"){
                    lvln = ChooseDifficulty((String)leveldropbox.getValue());
                    GameScene.setN(lvln);
                    ChooseTheme("#4A235A", "#D7BDE2", gameScene, endGameScene);

                }else{
                    lvln = ChooseDifficulty((String)leveldropbox.getValue());
                    GameScene.setN(lvln);
                    ChooseTheme("#1B2631", "#85929E", gameScene, endGameScene);

                }
                //switch Scene to gameScene
                primaryStage.setScene(gameScene);

                //links the Scene to GameScene.play method
                GameScene.getInstance().play(startGameScene, root, primaryStage, gameScene, endGameScene, GameRoot, EndGameRoot);
                root.getChildren().clear();

            });

            //Create Quit button
            Quitbutton(root);

            //Display "ENTER YOUR NAME"
            Text reqname = new Text("ENTER YOUR NAME");
            reqname.relocate(377,620);
            textstyle(reqname, root, 27);

            //username
            TextField name= new TextField();
            name.setPrefSize(200,40);
            root.getChildren().add(name);
            name.relocate(400, 650);
            accounts.add(new Account(name.getText()));

        }
}