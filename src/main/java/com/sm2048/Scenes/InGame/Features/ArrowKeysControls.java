package com.sm2048.Scenes.InGame.Features;

import static com.sm2048.Scenes.InGame.Features.Variables.n;

/**
 * This class is used to make movement when key buttons are pressed
 *
 * @author En Xuan Tan
 * @version 1.0
 * @since 2022-11-11
 */
public class ArrowKeysControls {
    GameMovement gm = GameMovement.getSingleInstance();

    /**
     *This method is used to make movement when left key is pressed
     */
    public void moveLeft() {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                gm.moveHorizontally(i, j, gm.passDestination(i, j, 'l'), -1);
            }
            for (int j = 0; j < n; j++) {
                gm.cells[i][j].setModify(false);
            }
        }
    }

    /**
     *This method is used to make movement when right key is pressed
     */
    public void moveRight() {
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                gm.moveHorizontally(i, j, gm.passDestination(i, j, 'r'), 1);
            }
            for (int j = 0; j < n; j++) {
                gm.cells[i][j].setModify(false);
            }
        }
    }

    /**
     *This method is used to make movement when up key is pressed
     */
    public void moveUp() {
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < n; i++) {
                gm.moveVertically(i, j, gm.passDestination(i, j, 'u'), -1);
            }
            for (int i = 0; i < n; i++) {
                gm.cells[i][j].setModify(false);
            }
        }

    }

    /**
     *This method is used to make movement when down key is pressed
     */
    public void moveDown() {
        for (int j = 0; j < n; j++) {
            for (int i = n - 1; i >= 0; i--) {
                gm.moveVertically(i, j, gm.passDestination(i, j, 'd'), 1);
            }
            for (int i = 0; i < n; i++) {
                gm.cells[i][j].setModify(false);
            }
        }

    }
}
