package com.sm2048.Scenes.EndGame.Features;

import com.sm2048.Scenes.General.GeneralComponents;
import javafx.scene.Group;
import javafx.scene.text.Text;

/**
 * This class is just used for display score of the game in EndGame scene
 *
 * @author En Xuan Tan
 * @version 1.0
 * @since 2022-11-11
 */
public class DisplayScore {

    static GeneralComponents g = new GeneralComponents();

    /**
     * This method is used to display score of the game EndGame scene
     *
     * @param root use to add time used component into EndGame scene
     * @param score get the score from the game
     */
    public static void Score(Group root, long score){
        Text scoreText = new Text("SCORE:"+ score + ""); //Display Score
        scoreText.relocate(400,350); //set the location of Score
        g.textstyle(scoreText, root, 35); //Style the text for Score
    }
}
