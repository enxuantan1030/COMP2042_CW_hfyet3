package com.sm2048.Scenes.EndGame;

import javafx.scene.Group;
import javafx.scene.text.Text;

public interface EndGameInterface {
    void GameOver(Group root);
    void Quitbutton(Group root);
    void Score(Group root, long score);
    void Timeused(Group root);
    void Time(Group root, Text time);

}
