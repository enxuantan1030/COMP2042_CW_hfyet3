package com.sm2048;

import java.io.File;
import java.io.IOException;

import com.sm2048.Scenes.MenuGame.StartGame;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;
import javafx.scene.media.*;
import javafx.util.Duration;

import java.util.Scanner;

/**
 *
 * This class is used to launch the program and triggers the program to open a window for the game
 *
 */
public class Main extends Application {
    static final int WIDTH = 1000;
    static final int HEIGHT = 800;
    private Group gameRoot = new Group();
    private Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(80, 71, 143));
    private static Scanner input= new Scanner(System.in);

    /**
     *
     * This method is used to modify the Scene
     * @param gameScene
     */
    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }

    /**
     *
     * This method is used to modify the root of the scene
     * @param gameRoot
     */
    public void setGameRoot(Group gameRoot) {
        this.gameRoot = gameRoot;
    }

    @Override

    public void start(Stage primaryStage) throws IOException {

        String path = "\\Users\\HP\\Documents\\GitHub\\COMP2042TanEnXuan\\2048ver2.mp3";
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            public void run() {
                mediaPlayer.seek(Duration.ZERO);
            }
        });
        mediaPlayer.play();

        /*Group menuRoot = new Group();
        Scene menuScene = new Scene(menuRoot, WIDTH, HEIGHT);
        Group accountRoot = new Group();
        Scene accountScene = new Scene(accountRoot, WIDTH, HEIGHT, Color.rgb(150, 20, 100, 0.2));
        Group getAccountRoot = new Group();
        Scene getAccountScene = new Scene(getAccountRoot, WIDTH, HEIGHT, Color.rgb(200, 20, 100, 0.2));
*/
        Group gameRoot = new Group();
        Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT);

        Group endgameRoot = new Group();
        Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT);

        /*Group rankRoot = new Group();
        Scene rankScene = new Scene(rankRoot, WIDTH, HEIGHT, Color.rgb(250, 50, 120, 0.3));
        BackgroundFill background_fill = new BackgroundFill(Color.rgb(120, 100, 100), CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        Rectangle backgroundOfMenu = new Rectangle(240, 120, Color.rgb(120, 120, 120, 0.2));
        backgroundOfMenu.setX(WIDTH / 2 - 120);
        backgroundOfMenu.setY(180);
        menuRoot.getChildren().add(backgroundOfMenu);
        Rectangle backgroundOfMenuForPlay = new Rectangle(240, 140, Color.rgb(80, 71, 143));
        backgroundOfMenuForPlay.setX(WIDTH / 2 - 120);
        backgroundOfMenuForPlay.setY(180);
        accountRoot.getChildren().add(backgroundOfMenuForPlay);*/

        Group startgameRoot = new Group();
        setGameRoot(startgameRoot);
        Scene startGameScene = new Scene(startgameRoot, WIDTH, HEIGHT);
        startGameScene.setFill(new LinearGradient(
                0, 0, 1, 1, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("#1B2631")),
                new Stop(1, Color.web("#85929E"))));
        setGameScene(startGameScene);
        primaryStage.setScene(startGameScene);
        primaryStage.setTitle("hfyet3_2048");
        StartGame game = new StartGame();
        game.game(startGameScene, startgameRoot, primaryStage, gameScene, endGameScene, gameRoot, endgameRoot);

        primaryStage.show();

    }

    /**
     *
     * This method is used to large the program
     *
     */
    public static void main(String[] args) {
        launch(args);
    }

}
