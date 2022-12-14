package com.sm2048.Scenes.EndGame.Features;

import com.sm2048.Scenes.General.GeneralComponents;
import javafx.scene.Group;
import javafx.scene.text.Text;

/**
 * This class is used to display Time used of the game in EndGame scene
 *
 * @author En Xuan Tan
 * @version 1.0
 * @since 2022-11-11
 */
public class DisplayTime extends GeneralComponents {

    static GeneralComponents g = new GeneralComponents();

    /**
     * This method is used to display time used of the game in EndGame scene
     *
     * @param root use to add time used component into EndGame scene
     * @param time get the time used from the game
     */
    public static void Timeused(Group root, Text time) {
        Text scoreText = new Text("TIME USED: " + time.getText() + ""); //Display time used in the game
        scoreText.relocate(300, 400); //set the location of time used
        g.textstyle(scoreText, root, 35); //Style the text for time used
    }
}
