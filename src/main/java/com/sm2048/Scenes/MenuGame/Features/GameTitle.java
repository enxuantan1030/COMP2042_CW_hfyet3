package com.sm2048.Scenes.MenuGame.Features;

import javafx.scene.Group;
import javafx.scene.text.Text;

/**
 * This class is used to display Game Title
 *
 * @author En Xuan Tan
 * @version 1.0
 * @since 2022-11-11
 */
public abstract class GameTitle extends QuitMenuButton {

    public void GameTitle(Group root) {
        Text text = new Text("2048");
        text.relocate(350,300);
        textstyle(text, root, 100);
    }

}
