package com.sm2048.Scenes.MenuGame.Features;

import java.util.Objects;

/**
 * This class is used to return difficulty value based of users' choice (get the value from StartGame.java)
 *
 * @author En Xuan Tan
 * @version 1.0
 * @since 2022-11-11
 */
public class Difficulty {

    /**
     *
     *This method is used to return the difficulty chose by user
     *
     *@param level get the value from StartMenu.java chose by users
     *@return value of the difficulty choose by the users
     */
    public static int ChooseDifficulty(String level){

        if (Objects.equals(level, "3 x 3")) {
            return 3;
        } else if (Objects.equals(level, "5 x 5")) {
            return 5;
        } else if (Objects.equals(level, "6 x 6")) {
            return 6;
        } else if (Objects.equals(level, "Default(4 x 4)")) {
            return 4;
        } else {
            return 7;
        }
    }

}
