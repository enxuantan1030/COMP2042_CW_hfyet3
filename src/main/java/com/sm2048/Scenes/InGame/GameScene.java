package com.sm2048.Scenes.InGame;

import com.sm2048.Others.Cell;
import com.sm2048.Scenes.EndGame.EndGame;
import com.sm2048.Scenes.MenuGame.StartGame;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

/**
    *
    * This class is used for displaying Game Scene, feature including:
    * display total score, 2048 mechanical, able to return to menu and quit game
    *
    */

public class GameScene extends ArrowKeysControls {

    void change(Text text) {
        if(millis == 1000) {
            secs++;
            millis = 0;
        }
        if(secs == 60) {
            mins++;
            secs = 0;
        }
        text.setText((((mins/10) == 0) ? "0" : "") + mins + ":"
                + (((secs/10) == 0) ? "0" : "") + secs + ":"
                + (((millis/10) == 0) ? "00" : (((millis/100) == 0) ? "0" : "")) + millis++);
    }

    private static GameScene singleInstance = null;

    //prevents the instantiation from any other class.
    public GameScene(){}

    /**
    *
    * This method is used to
    *
    */
    public static GameScene getInstance(){
        if(singleInstance == null)
            singleInstance= new GameScene();
        return singleInstance;
    }

    /**
     *
     * This method is used to create the Game Scene
     *
     * @param startgameScene Scene to create Menu Scene
     * @param startroot root for startGameScene
     * @param primaryStage Stage which display the Scenes
     * @param gameScene Scene for playing the game 2048
     * @param endGameScene Scene when game is game is ended, which will display GAME OVER Scene
     * @param GameRoot root for gameScene
     * @param endGameRoot Root root for endgameScene
     */
    public void play(Scene startgameScene,Group startroot, Stage primaryStage, Scene gameScene, Scene endGameScene, Group GameRoot, Group endGameRoot) {
        this.mins = 0 ;
        this.secs = 0;
        this.millis = 0;
        this.GameRoot = GameRoot;

        Text timeused = new Text();
        timeused.setText("TIME USED :");
        textstyle(timeused, GameRoot, 30);
        timeused.relocate(750, 200);

        time = new Text("00:00:000");
        timeline = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                change(time);
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);
        timeline.play();
        time.relocate(750, 250);
        textstyle(time, GameRoot, 30);


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j] = new Cell((j) * LENGTH + (j + 1) * distanceBetweenCells,
                        (i) * LENGTH + (i + 1) * distanceBetweenCells, LENGTH, GameRoot);
            }

        }

        Text score = new Text();
        score.setText("SCORE :");
        textstyle(score, GameRoot, 30);
        score.relocate(750, 100);

        Text scoreText = new Text();
        scoreText.relocate(750, 150);
        textstyle(scoreText, GameRoot, 30);
        scoreText.setText("0");

        Text intruct = new Text();
        GameRoot.getChildren().add(intruct);
        intruct.setText("Shortcuts:\nPress M - Return Menu\nPress Esc - Quit Game");
        intruct.setFont(Font.font("Courier New", FontWeight.BOLD,20));
        intruct.setFill(Color.web("#E5E7E9"));
        intruct.relocate(720, 625);

        randomFillNumber(1);
        randomFillNumber(1);

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
                quitbtn(GameRoot);
            } else if (key.getCode() == KeyCode.M) {
                Alert gamealert = new Alert(Alert.AlertType.CONFIRMATION);
                gamealert.setTitle("Dialog Menu");
                gamealert.setHeaderText("Back to Menu");
                gamealert.setContentText("All the progress made will not be saved, Continue?");

                //when "ok" is clicked, it will return user to menu page
                Optional<ButtonType> gameresult = gamealert.showAndWait();
                if (gameresult.get() == ButtonType.OK){
                    primaryStage.setScene(startgameScene);
                    //link back to menu

                    StartGame.getInstance().game(startgameScene, startroot, primaryStage, gameScene, endGameScene, GameRoot, endGameRoot);
                    GameRoot.getChildren().clear();

                }
            }

            scoreText.setText(this.score + "");
            haveEmptyCell = GameScene.this.haveEmptyCell();
            if (haveEmptyCell == -1) {
                if (GameScene.this.canNotMove()) {
                    //pause timer
                    timeline.pause();

                    primaryStage.setScene(endGameScene);

                    EndGame.getInstance().endGameShow(startgameScene, startroot, primaryStage, gameScene, endGameScene, GameRoot, endGameRoot, this.score, this.time);
                    GameRoot.getChildren().clear();
                    this.score = 0;
                }
            } else if(haveEmptyCell == 1 && key.getCode() == KeyCode.DOWN || key.getCode() == KeyCode.UP || key.getCode() == KeyCode.LEFT || key.getCode() == KeyCode.RIGHT)
                GameScene.this.randomFillNumber(2);
        }));

    }

}
