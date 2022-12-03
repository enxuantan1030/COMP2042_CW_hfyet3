package com.sm2048.Scenes.MenuGame.Features;

import javafx.scene.Group;
import javafx.scene.text.Text;

public abstract class GameTitle extends QuitMenuButton {

    public void GameTitle(Group root) {
        Text text = new Text("2048");
        text.relocate(370,300);
        textstyle(text, root, 100);
    }

}
