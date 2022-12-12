package com.sm2048.Scenes.EndGame.Features;

import com.sm2048.Scenes.General.GeneralComponents;
import com.sm2048.Scenes.EndGame.EndGameInterface;
import javafx.scene.Group;
import javafx.scene.control.Button;

/**
 * This class is used to inherit GeneralComponents and implement EndGameInterface and display Quit Button
 *
 * @author En Xuan Tan
 * @version 1.0
 * @since 2022-11-11
 *
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