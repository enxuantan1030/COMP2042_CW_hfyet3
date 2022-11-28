package com.sm2048.Scenes.MenuGame;

import com.sm2048.ScenesAbstract.Scenesimple;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Text;

import java.util.Objects;

/**
 * This class is used to extract methods out from StartGame.java
 * So that it is easier to read the codes
 */
public abstract class MenuAbstractMethods extends Scenesimple implements MenuInterface {

    public void GameTitle(Group root) {
        Text text = new Text("2048");
        text.relocate(370,300);
        textstyle(text, root, 100);
    }

    @Override
    public void Quitbutton(Group root){
        //menu quit button
        Button menuquitButton = new Button("QUIT");
        btnstyle(menuquitButton, root);
        menuquitButton.relocate(520,400);
        //when the quit button is clicked, a wondpw will pop out and ask for confirmation
        menuquitButton.setOnAction(actionEvent -> quitbtn(root));
    }

    /**
     *
     * This method is used to return the value of n value
     *
     * @param level difficulty chose by users
     * @return value is passed back to the method to create the level desired by the users
     */
    @Override
    public int ChooseDifficulty(String level){
        if (Objects.equals(level, "3 x 3")) {
            return 3;
        } else if (Objects.equals(level, "5 x 5")) {
            return 5;
        } else if (Objects.equals(level, "6 x 6")) {
            return 6;
        } else if (Objects.equals(level, "7 x 7")) {
            return 7;
        } else {
            return 4;
        }
    }

    @Override
    public void ChooseTheme(String c1, String c2, Scene s1, Scene s2){
        //Gradient colour function referred to website -
        s1.setFill(new LinearGradient(
                0, 0, 1, 1, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.web(c1)),
                new Stop(1, Color.web(c2))));
        s2.setFill(new LinearGradient(
                0, 0, 1, 1, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.web(c1)),
                new Stop(1, Color.web(c2))));
    }

}