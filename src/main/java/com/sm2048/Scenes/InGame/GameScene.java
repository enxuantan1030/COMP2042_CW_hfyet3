package com.sm2048.Scenes.InGame;

import com.sm2048.Accounts.UpdateScore;
import com.sm2048.Main;
import com.sm2048.Scenes.EndGame.EndGame;
import com.sm2048.Scenes.General.GeneralComponents;
import com.sm2048.Scenes.InGame.Features.*;
import com.sm2048.Scenes.InGame.GenerateGameCells.Cell;
import com.sm2048.Scenes.MenuGame.StartGame;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.sm2048.Scenes.InGame.Features.GameMovement.cells;
import static com.sm2048.Scenes.InGame.Features.Variables.*;

/**
    *
    * This class is used for displaying Game Scene, feature including:
    * display total score, stopwatch, the game itself, able to return to menu and quit game
    *
    * @author En Xuan Tan-modified
    * @version 2.0
    * @since 2022-11-11
    */

public class GameScene extends ArrowKeysControls {
    boolean title;
    private static GameScene singleInstance = null;
    Text time;
    Timeline timeline;
    /**
     * Root for GameScene and it is set as public so that other class are able to access it
     */
    public Group GameRoot;
    Main main = new Main();
    GeneralComponents g = new GeneralComponents();
    /**
     * This method is to prevent the instantiation from any other class.
     */
    public GameScene(){}

    /**
     *
     * This method has used the Design Pattern Singleton which is the lazy instantiation
     * @return instance of class
     */
    public static GameScene getSingleInstance() {
        if (singleInstance == null)
            singleInstance = new GameScene();
        return singleInstance;
    }

    /**
     *
     * This method is used to create the Game Scene
     *
     * @param username user's name based on their input, in here, it is used to update the users' score
     * @param startgameScene Scene to create Menu Scene
     * @param startroot root for startGameScene
     * @param primaryStage Stage which display the Scenes
     * @param gameScene Scene for playing the game 2048
     * @param endGameScene Scene when game is game is ended, which will display GAME OVER Scene
     * @param GameRoot root for gameScene
     * @param endGameRoot Root root for endgameScene
     */
    public void play(String username, Scene startgameScene, Group startroot, Stage primaryStage, Scene gameScene, Scene endGameScene, Group GameRoot, Group endGameRoot) {
        this.GameRoot = GameRoot;
        //resets stopwatch and score to 0
        Variables.mins = 0;
        Variables.secs = 0;
        Variables.millis = 0;
        Variables.score = 0;
        AtomicBoolean mute = new AtomicBoolean(true);

        //display "TIME USED" text
        Text timeused = new Text();
        timeused.setText("TIME USED :");
        g.textstyle(timeused, GameRoot, 30);
        timeused.relocate(750, 200);

        //display the stopwatch
        time = new Text("00:00:000");
        timeline = new Timeline(new KeyFrame(Duration.millis(1), event -> Stopwatch.change(time))); // change text of stopwatch
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);
        timeline.play(); //start stopwatch
        g.textstyle(time, GameRoot, 30);
        time.relocate(750, 250);

        //create number of cells
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                cells[i][j] = new Cell((j) * LENGTH + (j + 1) * distanceBetweenCells,
                        (i) * LENGTH + (i + 1) * distanceBetweenCells, LENGTH, GameRoot);
            }

        }

        //display "SCORE" text
        Text score = new Text();
        score.setText("SCORE :");
        g.textstyle(score, GameRoot, 30);
        score.relocate(750, 100);

        //display score earned by users
        Text scoreText = new Text();
        scoreText.relocate(750, 150);
        g.textstyle(scoreText, GameRoot, 30);
        scoreText.setText("0");

        //display shortcuts instructions
        Text intruct = new Text();
        GameRoot.getChildren().add(intruct);
        intruct.setText("Shortcuts:\nPress M - Return Menu\nPress Esc - Quit Game\nPress P - Control Music");
        intruct.setFont(Font.font("Courier New", FontWeight.BOLD,20));
        intruct.setFill(Color.web("#E5E7E9"));
        intruct.relocate(710, 605);

        //Create two numbered cells start of the game
        GameMovement.randomFillNumber();
        GameMovement.randomFillNumber();

        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, key -> Platform.runLater(() -> {
            int haveEmptyCell;
            if (key.getCode() == KeyCode.DOWN) {
                GameScene.this.moveDown();
            } else if (key.getCode() == KeyCode.UP) {
                GameScene.this.moveUp();
            } else if (key.getCode() == KeyCode.LEFT) {
                GameScene.this.moveLeft();
            } else if (key.getCode() == KeyCode.RIGHT) {
                GameScene.this.moveRight();
            } else if (key.getCode() == KeyCode.ESCAPE) {
                g.quitbtn(GameRoot);
            } else if (key.getCode() == KeyCode.M) {
                //return to menu
                Alert gamealert = new Alert(Alert.AlertType.CONFIRMATION);
                gamealert.setTitle("Dialog Menu");
                gamealert.setHeaderText("Back to Menu");
                gamealert.setContentText("All the progress made will not be saved, Continue?");

                //when "ok" is clicked, it will return user to menu page
                Optional<ButtonType> gameresult = gamealert.showAndWait();
                if (gameresult.get() == ButtonType.OK){
                    n = 7;
                    LENGTH = 0;
                    timeline.stop();
                    main.restart(primaryStage);

                }
            }else if (key.getCode() == KeyCode.P){
                //Create M button to control music play/pause
                if(mute.get()){
                    Main.mediaPlayer.pause();
                    mute.set(false);
                }else{
                    Main.mediaPlayer.play();
                    mute.set(true);
                }
            }

            //Display score
            scoreText.setText(Variables.score + "");
            haveEmptyCell = MovementEmptyCell.haveEmptyCell();
            //if all the cells are fully filled and no movement can be made furthermore
            if (haveEmptyCell == -1) {
                if (CannotMove.canNotMove()) {
                    //Update the score of the users in the file
                    UpdateScore.modifyScore(username, Variables.score, time, StartGame.diff);
                    //means that users lose the game
                    this.title = false;
                    //Pause the stopwatch
                    timeline.stop();
                    //switch scene
                    primaryStage.setScene(endGameScene);
                    EndGame.getInstance().endGameShow(this.title, startgameScene, startroot, primaryStage, gameScene, endGameScene, GameRoot, endGameRoot, Variables.score, this.time);
                    GameRoot.getChildren().clear();

                }
            //if users manage to have a numbered cell of 2048
            }else if(haveEmptyCell == 0){
                UpdateScore.modifyScore(username, Variables.score, time, StartGame.diff);
                //means that users win the game
                this.title = true;
                timeline.stop();
                primaryStage.setScene(endGameScene);
                EndGame.getInstance().endGameShow(this.title,startgameScene, startroot, primaryStage, gameScene, endGameScene, GameRoot, endGameRoot, Variables.score, this.time);
                GameRoot.getChildren().clear();

                //if the cells are not fully filled
            }else if(haveEmptyCell == 1 && key.getCode() == KeyCode.DOWN || key.getCode() == KeyCode.UP || key.getCode() == KeyCode.LEFT || key.getCode() == KeyCode.RIGHT)
                //create numbered cell in game
                GameMovement.randomFillNumber();
        }));

    }

}
