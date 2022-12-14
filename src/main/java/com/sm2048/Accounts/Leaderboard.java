package com.sm2048.Accounts;

import com.sm2048.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * This class is a controller for leaderboard.fxml,
 * it is used to open ShowScore.fxml file to display high score list based on difficulty which chosen by the users
 *
 * @author En Xuan Tan
 * @version 2.0
 * @since 2022-11-11
 */
public class Leaderboard {

    /**
     * This variable is used to display Leaderboard Title
     */
    public TextArea LeaderboardTitle;

    /**
     * This method is used to open Showscore.fxml
     */
    public void switchs() {

        Parent root1;
        try {
            root1 = FXMLLoader.load(Main.ShowScore);
            Stage stage = new Stage();
            stage.setTitle("High Score");
            Scene scene = new Scene(root1, 500, 400);
            stage.setScene(scene);
            stage.show();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This variable is used to set the Image in leaderboard
     */
    @FXML
    private ImageView imageView;

    /**
     * This method is used to initialize the image in leaderboard
     */
    public void initialize() {
        imageView.setImage(Main.image4);
    }

    /**
     * This method is used to handle 3x3 button on press in leaderboard.fxml
     */
    public void handleButtonPress3(){
        ShowScore.lvl = 3;
        switchs();

    }

    /**
     * This method is used to handle 4x4 button on press in leaderboard.fxml
     */
    public void handleButtonPress4(){
        ShowScore.lvl = 4;
        switchs();

    }

    /**
     * This method is used to handle 5x5 button on press in leaderboard.fxml
     */
    public void handleButtonPress5(){
        ShowScore.lvl = 5;
        switchs();

    }

    /**
     * This method is used to handle 6x6 button on press in leaderboard.fxml
     */
    public void handleButtonPress6(){
        ShowScore.lvl = 6;
        switchs();

    }

    /**
     * This method is used to handle 7x7 button on press in leaderboard.fxml
     */
    public void handleButtonPress7(){
        ShowScore.lvl = 7;
        switchs();

    }
}
