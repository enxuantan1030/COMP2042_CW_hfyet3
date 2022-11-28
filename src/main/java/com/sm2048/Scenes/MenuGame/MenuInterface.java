package com.sm2048.Scenes.MenuGame;

import javafx.scene.Group;
import javafx.scene.Scene;

public interface MenuInterface {
    void GameTitle(Group root);
    void Quitbutton(Group root);
    int ChooseDifficulty(String level);
    void ChooseTheme(String c1, String c2, Scene s1, Scene s2);

}
