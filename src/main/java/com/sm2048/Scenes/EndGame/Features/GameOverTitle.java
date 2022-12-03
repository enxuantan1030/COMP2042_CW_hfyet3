package com.sm2048.Scenes.EndGame.Features;

import javafx.scene.Group;
import javafx.scene.text.Text;

public abstract class GameOverTitle extends DisplayTime {
    public void GameOver(Group root) {
        Text text = new Text("GAME OVER");
        text.relocate(230,250);
        textstyle(text, root, 100);
    }
}
