package com.sm2048.Scenes.EndGame.Features;

import javafx.scene.Group;
import javafx.scene.text.Text;

public class DisplayScore extends GameOverTitle {
    public void Score(Group root, long score){
        Text scoreText = new Text("SCORE:"+score+"");
        scoreText.relocate(400,350);
        textstyle(scoreText, root, 35);
    }
}
