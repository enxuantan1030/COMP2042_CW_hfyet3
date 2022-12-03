package com.sm2048.Scenes.MenuGame.Features;

import java.util.Objects;

public abstract class Difficulty extends GameTitle {

    /**
     *
     * This method is used to return the value of n value
     *
     * @param level difficulty chose by users
     * @return value is passed back to the method to create the level desired by the users
     */
    @Override
    public int ChooseDifficulty(String level){

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
