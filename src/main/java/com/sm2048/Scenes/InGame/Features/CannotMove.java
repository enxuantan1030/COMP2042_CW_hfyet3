package com.sm2048.Scenes.InGame.Features;

/**
 * This method is used to determine the continuing of the game.
 * The game can be continued if movement can be made in the game
 *
 * @author En Xuan Tan
 * @version 1.0
 * @since 2022-11-11
 */
public abstract class CannotMove extends SameCellNumber {
    public boolean canNotMove() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (haveSameNumberNearly(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
