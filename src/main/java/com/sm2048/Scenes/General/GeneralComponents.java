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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
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

    public void LBbutton(Group root){
        //menu quit button
        Button menuquitButton = new Button("LEADER BOARD");
        btnstyle(menuquitButton, root);
        menuquitButton.relocate(700,700);
        //when the quit button is clicked, a window will pop out and ask for confirmation
        menuquitButton.setOnAction(event -> {
            Parent root1;
            try {
                System.out.println(Main.fxml);
                root1 = FXMLLoader.load(Main.fxml);
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

}
