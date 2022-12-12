package com.sm2048.Scenes.InGame.Features;

/**
 * This class is used to compare between numbered cells and determine to merge the same numbered cells
 *
 * @author En Xuan Tan
 * @version 1.0
 * @since 2022-11-11
 */
public abstract class SameCellNumber extends Variables {

    public boolean haveSameNumberNearly(int i, int j) {
        if (i < n - 1 && j < n - 1) {
            if (cells[i + 1][j].getNumber() == cells[i][j].getNumber())
                return true;
            return cells[i][j + 1].getNumber() == cells[i][j].getNumber();
        }
        return false;
    }

}
