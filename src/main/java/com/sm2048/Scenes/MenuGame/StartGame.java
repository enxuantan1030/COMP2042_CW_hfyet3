package com.sm2048.Scenes.MenuGame;

import com.sm2048.Accounts.AddName;
import com.sm2048.Main;
import com.sm2048.Scenes.General.GeneralComponents;
import com.sm2048.Scenes.InGame.GameScene;
import com.sm2048.Scenes.InGame.Features.Variables;
import com.sm2048.Scenes.MenuGame.Features.Difficulty;
import com.sm2048.Scenes.MenuGame.Features.GameTitle;
import com.sm2048.Scenes.MenuGame.Features.QuitMenuButton;
import com.sm2048.Scenes.MenuGame.Features.Theme;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

import static javafx.application.Application.launch;


/**
 * This class is used for displaying Menu Scene, feature including:
 * display game title, leader board, start game and quit game, choose theme and difficulty
 *
 * @author En Xuan Tan
 * @version 1.0
 * @since 2022-11-11
 */
public class StartGame {

    /**
     * This variable is use to get the difficulty chosen by users
     */
    public static int diff;
    private static StartGame singleInstance = null;
    private Group root;
    static int lvln = 7;
    String c1, c2;
    GeneralComponents g = new GeneralComponents();
    /**
     *
     * This method has used the Design Pattern Singleton which is the lazy instantiation
     * @return instance of class
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

        //set the location, size and add koroks1.gif component into StartGame scene
        Main.imageView1.relocate(630,230);
        Main.imageView1.setFitHeight(120);
        Main.imageView1.setFitWidth(100);
        Main.imageView1.setPreserveRatio(true);
        root.getChildren().add(Main.imageView1);

        //set the location, size and add koroks1.gif component into StartGame scene
        Main.imageView3.relocate(800,600);
        Main.imageView3.setFitHeight(120);
        Main.imageView3.setFitWidth(100);
        Main.imageView3.setPreserveRatio(true);
        root.getChildren().add(Main.imageView3);

        GameScene game = new GameScene();
        //game title
        GameTitle.GameTitle(root);

        //Display "Theme"
        Text theme = new Text("Theme");
        theme.relocate(570,500); //set the location of Theme word
        g.textstyle(theme, root, 27); // style the text Theme

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
        root.getChildren().add(themedropbox); //add themedropbox component into StartGame scene
        themedropbox.setPrefSize(200,60);//set the size of the drop down menu
        themedropbox.relocate(520,530); //set the location of Theme word
        themedropbox.setValue("Default(Green)"); //set the Default value for drop down menu

        //Display "Difficulty"
        Text level = new Text("Difficulty");
        level.relocate(290,500);
        g.textstyle(level, root, 25);

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
        g.textstyle(reqname, root, 27);

        //username
        TextField name= new TextField();
        name.setPrefSize(200,40);
        root.getChildren().add(name);
        name.setPromptText("Please enter your name here");
        name.relocate(400, 650);

        //Menu start button
        Button startButton = new Button("START");
        g.btnstyle(startButton, root);
        startButton.relocate(260,400);
        //when start button is clicked, it will be directed to the game scene
        startButton.setOnAction(actionEvent -> {
            String value = leveldropbox.getValue();
            diff = Difficulty.ChooseDifficulty(value);
            //restricts the users' name as characters A-Z only
            if (name.getText().toString().matches("^[a-zA-Z]+$")|| name.getText() == null){
                try {
                    AddName.add(name.getText(), diff);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //sets the value on n in Variable, which is used to create difficulty based on users' inputs
                Variables.setN(diff);
                Theme.DBChooseTheme(themedropbox.getValue(), gameScene, endGameScene);

                //switch Scene to gameScene
                primaryStage.setScene(gameScene);

                //links the Scene to GameScene.play method
                GameScene.getSingleInstance().play(name.getText(), startGameScene, root, primaryStage, gameScene, endGameScene, GameRoot, EndGameRoot);
                root.getChildren().clear();

            }else{

                //Alert window when user does not enter a name or inputs String other than characters
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Name");
                alert.setHeaderText("Please enter your name only with characters[A-Z]");
                alert.setContentText("Re-enter your name");

                //when "ok" is clicked, it will close the alert window
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {

                }
            }
        });

        //Create Quit button
        QuitMenuButton.Quitbutton(root);

        //Create leaderboard button
        g.LBbutton(root);

        //Create M button
        g.Mutebutton(root);

    }

}