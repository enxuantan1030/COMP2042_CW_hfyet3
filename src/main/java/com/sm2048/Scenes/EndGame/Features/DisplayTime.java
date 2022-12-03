package com.sm2048.Scenes.EndGame.Features;

import javafx.scene.Group;
import javafx.scene.text.Text;

public abstract class DisplayTime extends Quit_button {

    public void Timeused(Group root){
        Text scoreText = new Text("TIME USED:");
        scoreText.relocate(400,400);
        textstyle(scoreText, root, 35);
    }

    public void Time(Group root, Text time){
        time.relocate(400,430);
        textstyle(time, root, 32);
    }
}
