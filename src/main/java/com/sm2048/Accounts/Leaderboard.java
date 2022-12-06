package com.sm2048.Accounts;

import com.sm2048.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

import static com.sm2048.Accounts.ChooseFile.File;

public class Leaderboard {

    public void switchs3(){
        Parent root1;
        try {

            root1 = FXMLLoader.load(Main.score3x3);
            Stage stage = new Stage();
            stage.setTitle("High Score 3x3");
            stage.setScene(new Scene(root1, 500, 400));
            stage.show();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void switchs4(){
        Parent root1;
        try {

            root1 = FXMLLoader.load(Main.score4x4);
            Stage stage = new Stage();
            stage.setTitle("High Score 4x4");
            stage.setScene(new Scene(root1, 500, 400));
            stage.show();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void switchs5(){
        Parent root1;
        try {

            root1 = FXMLLoader.load(Main.score5x5);
            Stage stage = new Stage();
            stage.setTitle("High Score 5x5");
            stage.setScene(new Scene(root1, 500, 400));
            stage.show();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void switchs6(){
        Parent root1;
        try {

            root1 = FXMLLoader.load(Main.score6x6);
            Stage stage = new Stage();
            stage.setTitle("High Score 6x6");
            stage.setScene(new Scene(root1, 500, 400));
            stage.show();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void switchs7(){
        Parent root1;
        try {

            root1 = FXMLLoader.load(Main.score7x7);
            Stage stage = new Stage();
            stage.setTitle("High Score 7x7");
            stage.setScene(new Scene(root1, 500, 400));
            stage.show();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleButtonPress3() {
        switchs3();
    }

    public void handleButtonPress4() {
        switchs4();
    }

    public void handleButtonPress5() {
        switchs5();
    }

    public void handleButtonPress6() {
        switchs6();
    }

    public void handleButtonPress7() {
        switchs7();
    }
}
