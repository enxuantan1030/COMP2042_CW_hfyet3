package com.sm2048.Scenes.EndGame.Features;

import com.sm2048.Scenes.General.GeneralComponents;
import javafx.scene.Group;
import javafx.scene.text.Text;

/**
 * This class is used for displaying EndGame Title based on whether the user wins the game
 *
 * @author En Xuan Tan
 * @version 2.0
 * @since 2022-11-11
 */
public class GameOverTitle {

    static GeneralComponents g = new GeneralComponents();

    /**
     *This method is used to set the EndGame Title
     *
     * @param root use to add EndGame Title component into EndGame scene
     * @param title indicator for the users win the game
     */
    public static void GameOver(Group root, boolean title) {
        Text text;

        if(title){
            text = new Text("YOU WIN!!!"); //if users manage to reach 2048 in game
        }else {
            text = new Text("GAME OVER");
        }
        text.relocate(210,250); //set the location of GameOver Title
        g.textstyle(text, root, 100); //Style the text for GameOver Title
    }
}
