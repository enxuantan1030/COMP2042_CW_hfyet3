package com.sm2048.Scenes.EndGame;

import javafx.scene.Group;
import javafx.scene.text.Text;

/**
 *
 * This interface allows multiple inheritance for EndGame
 *
 * @author En Xuan Tan
 * @version 1.0
 * @since 2022-11-11
 */
public interface EndGameInterface {

    /**
     * This method is used to display EndGame Title
     *
     * @param root use to add either "Game Over" or "You Win" component into EndGame scene
     * @param title parameter who determine which GameOver Title to be displayed, it is set in GameScene.java
     */
    void GameOver(Group root, boolean title);

    /**
     *
     * This method is used to display Quit Button
     * @param root use to add Quit button component into EndGame scene
     */
    void Quitbutton(Group root);
    /**
     * @param root use to add Score component into EndGame scene
     * @param score Score earned in the game
     */
    void Score(Group root, long score);

    /**
     * This method is used to display "Time used"
     *
     * @param root use to add the word "Time Used" component into EndGame scene
     */
    void Timeused(Group root);

    /**
     * This method is used to display time used in the game
     *
     * @param root use to add Time used component into EndGame scene
     * @param time Time used in the game
     */
    void Time(Group root, Text time);

}
