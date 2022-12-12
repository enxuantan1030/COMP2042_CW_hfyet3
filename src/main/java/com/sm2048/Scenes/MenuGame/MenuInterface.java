package com.sm2048.Scenes.MenuGame;

import javafx.scene.Group;
import javafx.scene.Scene;

/**
 * @author En Xuan Tan
 * @version 1.0
 * @since 2022-11-11
 */
public interface MenuInterface {

    /**
     * This method is used to set the Game Title
     *
     * @param root use to add Game Title component into StartGame scene
     */
    void GameTitle(Group root);


    /**
     *
     * This method is used to display Quit Button
     *
     * @param root use to add Quit button component into EndGame scene
     */
    void Quitbutton(Group root);

    /**
     *
     * This method is used to return the value of n value
     *
     * @param level difficulty chose by users
     * @return value is passed back to the method to create the level desired by the users
     */
    int ChooseDifficulty(String level);

    /**
     * This method is used to modify theme for In-Game and EndGame scenes
     *
     * @param c1 first colour for gradient
     * @param c2 second colour for gradient
     * @param s1 modify In-Game Scene theme
     * @param s2 modify EndGame Scene theme
     */
    void ChooseTheme(String c1, String c2, Scene s1, Scene s2);

    /**
     * @param c colour option chosen by user
     * @param gameScene use to modify In-Game Scene theme
     * @param endGameScene use to modify EndGame Scene theme
     */
    void DBChooseTheme(String c, Scene gameScene, Scene endGameScene);

}
