package com.sm2048.Scenes.MenuGame.Features;

import com.sm2048.Scenes.General.GeneralComponents;
import javafx.scene.Group;
import javafx.scene.control.Button;

/**
 * This class is used to display Quit Button in StartGame Menu
 *
 * @author En Xuan Tan
 * @version 1.0
 * @since 2022-11-11
 */
public class QuitMenuButton{
    static GeneralComponents g = new GeneralComponents();

    /**
     *
     *This method is used to display Quit Button in StartGame scene
     *
     *@param root use to add Quit button component into StartGame scene
     */
    public static void Quitbutton(Group root){
        //menu quit button
        Button menuquitButton = new Button("QUIT");
        g.btnstyle(menuquitButton, root);
        menuquitButton.relocate(520,400);
        //when the quit button is clicked, a window will pop out and ask for confirmation
        menuquitButton.setOnAction(actionEvent -> g.quitbtn(root));
    }

}