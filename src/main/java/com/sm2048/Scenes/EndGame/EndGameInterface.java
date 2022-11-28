package com.sm2048.Scenes.EndGame;

import javafx.scene.Group;
import javafx.scene.Scene;

public interface EndGameInterface {
    void GameOver(Group root);
    void Quitbutton(Group root);
    void Score(Group root, long score);

}
