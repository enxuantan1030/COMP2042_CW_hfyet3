package com.sm2048.Scenes.General;

import com.sm2048.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * This class is used to implement GeneralizedComponents and stores general functions can be used by every scene
 * such as Quit button alert window, button style, text style, Mute music button and leaderboard button
 *
 * @author En Xuan Tan
 * @version 1.0
 * @since 2022-11-11
 */
public class GeneralComponents implements GeneralizedComponents {

    /**
     * set the style of button when button is not hovered
     */
    private static final String Idle = "-fx-background-color: -fx-shadow-highlight-color;";

    /**
     * set the style of button when button is hovered
     */
    private static final String hover = "-fx-background-color: #B3B3B3;";

    public void quitbtn(Group root) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quit Dialog");
        alert.setHeaderText("Quit from this page");
        alert.setContentText("Are you sure?");

        //when "ok" is clicked, it will terminate the program
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            root.getChildren().clear();
            System.exit(1);
        }

    }

    @Override
    public void btnstyle(Button b, Group root) {
        b.setPrefSize(200,60);
        b.setTextFill(Color.rgb(0,0,102));
        b.setFont(Font.font("Monaco", FontWeight.BOLD, 20));
        b.setStyle("-fx-background-color: -fx-shadow-highlight-color;");
        b.setOnMouseEntered(e -> b.setStyle(hover));
        b.setOnMouseExited(e -> b.setStyle(Idle));
        root.getChildren().add(b);
    }

    @Override
    public void textstyle(Text t, Group root, int size) {
        t.setFont(Font.font("Lucida Handwriting", size));
        t.setFill(new LinearGradient(
                0, 0, 1, 1, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("#EAEDED")),
                new Stop(1, Color.web("#CACFD2"))));
        root.getChildren().add(t);
    }

    public void LBbutton(Group root){
        Button lbButton = new Button("LEADER BOARD");
        btnstyle(lbButton, root);
        lbButton.relocate(700,700);
        lbButton.setOnAction(event -> {
            Parent root1;
            try {
                root1 = FXMLLoader.load(Main.leaderboard);
                Stage stage = new Stage();
                stage.setTitle("Leader Board");
                stage.setScene(new Scene(root1, 500, 400));
                stage.show();

            }
            catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void Mutebutton(Group root){
        AtomicBoolean mute = new AtomicBoolean(true);
        //menu quit button
        Button mButton = new Button("M");
        btnstyle(mButton, root);
        mButton.setPrefSize(50,50);
        mButton.relocate(920,30);
        //when the quit button is clicked, a window will pop out and ask for confirmation
        mButton.setOnAction(event -> {
            if(mute.get()){
                Main.mediaPlayer.pause();
                mute.set(false);
            }else{
                Main.mediaPlayer.play();
                mute.set(true);
            }

        });
    }

}