package com.sm2048.Scenes.InGame.Features;

import static com.sm2048.Scenes.InGame.Features.Variables.n;

/**
 * This method is used to determine the continuing of the game.
 * The game can be continued if movement can be made in the game
 *
 * @author En Xuan Tan
 * @version 1.0
 * @since 2022-11-11
 */
public class CannotMove{
    static SameCellNumber scn = SameCellNumber.getSingleInstance();

    /**
     *This method is to determine whether there's any movement can be made in the game
     *@return return false if the game can be continued else true
     */
    public static boolean canNotMove() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (scn.haveSameNumberNearly(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
