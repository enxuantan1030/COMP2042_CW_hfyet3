package com.sm2048.Scenes.EndGame.Features;

import javafx.scene.Group;
import javafx.scene.text.Text;

/**
 * This class is used for displaying EndGame Title based on whether the user wins the game
 *
 * @author En Xuan Tan
 * @version 2.0
 * @since 2022-11-11
 */
public abstract class GameOverTitle extends DisplayTime {

    public void GameOver(Group root, boolean title) {
        Text text;
        if(title){
            text = new Text("YOU WIN!!!");
        }else {
            text = new Text("GAME OVER");
        }
        text.relocate(230,250);
        textstyle(text, root, 100);
    }
}
