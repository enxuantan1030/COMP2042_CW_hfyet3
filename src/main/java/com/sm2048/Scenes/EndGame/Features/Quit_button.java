package com.sm2048.Scenes.EndGame.Features;

import com.sm2048.Scenes.General.GeneralComponents;
import javafx.scene.Group;
import javafx.scene.control.Button;

/**
 * This class is used to display Quit Button in EndGame Scene
 *
 * @author En Xuan Tan
 * @version 1.0
 * @since 2022-11-11
 *
 */
public class Quit_button{
    static GeneralComponents g = new GeneralComponents();

    /**
     *
     *This method is used to display Quit Button in EndGame scene
     *
     *@param root use to add Quit button component into EndGame scene
     */
    public static void Quitbutton(Group root){
        //menu quit button
        Button quitButton = new Button("QUIT");
        g.btnstyle(quitButton, root); //Style the button for Quit
        quitButton.relocate(520,550); //set the location of quit button
        //when the quit button is clicked, a window will pop out and ask for confirmation
        quitButton.setOnAction(actionEvent -> g.quitbtn(root));
    }

}