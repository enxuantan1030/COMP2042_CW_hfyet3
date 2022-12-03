package com.sm2048;

import java.io.File;
import com.sm2048.Scenes.MenuGame.StartGame;
import javafx.application.Application;
import javafx.beans.binding.StringExpression;
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
 */
public class Main extends Application {
    static final int WIDTH = 1000;
    static final int HEIGHT = 800;
    public static ImageView imageView1;
    public static ImageView imageView2;
    public static ImageView imageView3;
    public static ImageView imageView4;
    public static String data_path;
    public static File datafile;
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

    public void restart(Stage stage) {
        startGame(stage);
    }

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

    @Override

    public void start(Stage primaryStage) throws URISyntaxException, FileNotFoundException {

        URL gif_resource = getClass().getResource("koroks1.gif");
        assert gif_resource != null;
        String gif_path = Paths.get(gif_resource.toURI()).toString();
        Image image = new Image(new FileInputStream(gif_path));
        imageView1 = new ImageView(image);

        URL gif2_resource = getClass().getResource("koroks4.gif");
        assert gif2_resource != null;
        String gif2_path = Paths.get(gif2_resource.toURI()).toString();
        Image image2 = new Image(new FileInputStream(gif2_path));
        imageView2 = new ImageView(image2);

        URL gif3_resource = getClass().getResource("koroks3.gif");
        assert gif3_resource != null;
        String gif3_path = Paths.get(gif3_resource.toURI()).toString();
        Image image3 = new Image(new FileInputStream(gif3_path));
        imageView3 = new ImageView(image3);

        URL gif4_resource = getClass().getResource("koroks4.gif");
        assert gif4_resource != null;
        String gif4_path = Paths.get(gif4_resource.toURI()).toString();
        Image image4 = new Image(new FileInputStream(gif4_path));
        imageView4 = new ImageView(image4);

        URL resource = getClass().getResource("2048.mp3");
        assert resource != null;
        String path = Paths.get(resource.toURI()).toString();
        File file = new File(path);
        Media media = new Media(file.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));
        mediaPlayer.play();

        URL Data = getClass().getResource("Data.txt");
        assert Data != null;

        data_path = Paths.get(Data.toURI()).toString();
        datafile = new File(data_path);

        startGame(primaryStage);
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
