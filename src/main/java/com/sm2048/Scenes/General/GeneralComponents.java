package com.sm2048.Scenes.General;

import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.Optional;

public abstract class GeneralComponents implements GeneralizedComponents {

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
        b.setFont(Font.font("Courier New", FontWeight.BOLD, 20));
        root.getChildren().add(b);
    }

    @Override
    public void textstyle(Text t, Group root, int size) {
        t.setFont(Font.font("Courier New", size));
        t.setFill(Color.web("#E5E7E9"));
        root.getChildren().add(t);
    }

}
