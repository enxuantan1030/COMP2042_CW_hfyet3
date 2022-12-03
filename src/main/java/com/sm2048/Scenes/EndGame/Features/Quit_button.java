package com.sm2048.Scenes.EndGame.Features;

import com.sm2048.Scenes.General.GeneralComponents;
import com.sm2048.Scenes.EndGame.EndGameInterface;
import javafx.scene.Group;
import javafx.scene.control.Button;

/**
 * This class is used to extract methods out from StartGame.java
 * So that it is easier to read the codes
 */
public abstract class Quit_button extends GeneralComponents implements EndGameInterface {

    @Override
    public void Quitbutton(Group root){
        //menu quit button
        Button menuquitButton = new Button("QUIT");
        btnstyle(menuquitButton, root);
        menuquitButton.relocate(520,550);
        //when the quit button is clicked, a window will pop out and ask for confirmation
        menuquitButton.setOnAction(actionEvent -> quitbtn(root));
    }

}