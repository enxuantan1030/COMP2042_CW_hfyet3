package com.sm2048;

import java.io.File;
import com.sm2048.Scenes.MenuGame.StartGame;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;
import javafx.scene.media.*;
import javafx.util.Duration;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * This class is used to launch the program and triggers the program to open a window for the game
 *
 * @author En Xuan Tan-modified
 * @version 1.0
 * @since 2022-11-11
 */
public class Main extends Application {
    static final int WIDTH = 1000;
    static final int HEIGHT = 800;
    /**
     * This variable is used to store the imageview for koroks1.gif
     */
    public static ImageView imageView1;
    /**
     * This variable is used to store the imageview for koroks3.gif
     */
    public static ImageView imageView3;
    /**
     * This variable is used to store the path to Account3x3.txt
     */
    public static String data_path3x3;
    /**
     * This variable is used to store the path to Account4x4.txt
     */
    public static String data_path4x4;
    /**
     * This variable is used to store the path to Account5x5.txt
     */
    public static String data_path5x5;
    /**
     * This variable is used to store the path to Account6x6.txt
     */
    public static String data_path6x6;
    /**
     * This variable is used to store the path to Account7x7.txt
     */
    public static String data_path7x7;
    /**
     * This variable is used to store the path to leaderboard.fxml
     */
    public static URL fxml;
    /**
     * This variable is used to store the path to ShowScore.fxml
     */
    public static URL ShowScore;
    /**
     * This variable is used to store the imageview for koroks4.gif
     */
    public static Image image4;
    /**
     * This variable is used to play the audio 2048.mp3
     */
    public static MediaPlayer mediaPlayer;
    private Group gameRoot = new Group();
    private Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(80, 71, 143));
    private static Scanner input= new Scanner(System.in);

    /**
     *
     * This method is used to modify the Scene
     * @param gameScene modify gamescene
     */
    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }

    /**
     *
     * This method is used to modify the root of the scene
     * @param gameRoot modify gameRoot
     */
    public void setGameRoot(Group gameRoot) {
        this.gameRoot = gameRoot;
    }

    /**
     * This method is used to restart game
     *
     * @param stage Stage to restart game
     */
    public void restart(Stage stage) {
        startGame(stage);
    }

    /**
     * This method is used to setting up Scene, root for the program
     *
     * @param stage Stage to start game
     */
    public void startGame(Stage stage){

        Group gameRoot = new Group();
        Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT);

        Group endgameRoot = new Group();
        Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT);

        Group startgameRoot = new Group();
        setGameRoot(startgameRoot);
        Scene startGameScene = new Scene(startgameRoot, WIDTH, HEIGHT);
        startGameScene.setFill(new LinearGradient(
                0, 0, 1, 1, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("#0B5345")),
                new Stop(1, Color.web("#A9DFBF"))));

        setGameScene(startGameScene);
        stage.setScene(startGameScene);
        stage.setTitle("hfyet3_2048");
        StartGame game = new StartGame();
        game.game(startGameScene, startgameRoot, stage, gameScene, endGameScene, gameRoot, endgameRoot);

        stage.show();
    }

    /**
     * This method is mainly used to get path to resources
     *
     * @param primaryStage stage for the program
     */
    @Override

    public void start(Stage primaryStage) throws URISyntaxException, FileNotFoundException {

        URL gif_resource = getClass().getResource("koroks1.gif");
        assert gif_resource != null;
        String gif_path = Paths.get(gif_resource.toURI()).toString();
        Image image = new Image(new FileInputStream(gif_path));
        imageView1 = new ImageView(image);

        URL gif3_resource = getClass().getResource("koroks3.gif");
        assert gif3_resource != null;
        String gif3_path = Paths.get(gif3_resource.toURI()).toString();
        Image image3 = new Image(new FileInputStream(gif3_path));
        imageView3 = new ImageView(image3);

        URL gif4_resource = getClass().getResource("koroks4.gif");
        assert gif4_resource != null;
        String gif4_path = Paths.get(gif4_resource.toURI()).toString();
        image4 = new Image(new FileInputStream(gif4_path));

        URL resource = getClass().getResource("2048.mp3");
        assert resource != null;
        String path = Paths.get(resource.toURI()).toString();
        File file = new File(path);
        Media media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));
        mediaPlayer.play();

        URL data3x3 = getClass().getResource("Account3x3.txt");
        assert data3x3 != null;
        data_path3x3 = Paths.get(data3x3.toURI()).toString();

        URL data4x4 = getClass().getResource("Account4x4.txt");
        assert data4x4 != null;
        data_path4x4 = Paths.get(data4x4.toURI()).toString();

        URL data5x5 = getClass().getResource("Account5x5.txt");
        assert data5x5 != null;
        data_path5x5 = Paths.get(data5x5.toURI()).toString();

        URL data6x6 = getClass().getResource("Account6x6.txt");
        assert data6x6 != null;
        data_path6x6 = Paths.get(data6x6.toURI()).toString();

        URL data7x7 = getClass().getResource("Account7x7.txt");
        assert data7x7 != null;
        data_path7x7 = Paths.get(data7x7.toURI()).toString();

        fxml = getClass().getResource("leaderboard.fxml");
        ShowScore = getClass().getResource("ShowScore.fxml");

        startGame(primaryStage);
    }

    /**
     *
     * This method is used to large the program
     * @param args used to start the program
     */
    public static void main(String[] args) {
        launch(args);
    }

}
