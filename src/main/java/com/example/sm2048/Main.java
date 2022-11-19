package com.example.sm2048;

import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

import java.util.Scanner;

public class Main extends Application {
    static final int WIDTH = 1000;
    static final int HEIGHT = 800;
    private Group gameRoot = new Group();
    private Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(80, 71, 143));
    private static Scanner input= new Scanner(System.in);

    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }

    public void setGameRoot(Group gameRoot) {
        this.gameRoot = gameRoot;
    }

    @Override

    public void start(Stage primaryStage) throws IOException {

        Group menuRoot = new Group();
        Scene menuScene = new Scene(menuRoot, WIDTH, HEIGHT);
        Group accountRoot = new Group();
        Scene accountScene = new Scene(accountRoot, WIDTH, HEIGHT, Color.rgb(150, 20, 100, 0.2));
        Group getAccountRoot = new Group();
        Scene getAccountScene = new Scene(getAccountRoot, WIDTH, HEIGHT, Color.rgb(200, 20, 100, 0.2));

        Group gameRoot = new Group();
        Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(80, 71, 143));

        Group endgameRoot = new Group();
        Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, Color.rgb(80, 71, 143));

        Group rankRoot = new Group();
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
        accountRoot.getChildren().add(backgroundOfMenuForPlay);

        Group startgameRoot = new Group();
        setGameRoot(startgameRoot);
        Scene startGameScene = new Scene(startgameRoot, WIDTH, HEIGHT, Color.rgb(80, 71, 143));
        setGameScene(startGameScene);
        primaryStage.setScene(startGameScene);
        StartGame game = new StartGame();
        game.game(startGameScene, startgameRoot, primaryStage, gameScene, endGameScene, gameRoot, endgameRoot);

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
