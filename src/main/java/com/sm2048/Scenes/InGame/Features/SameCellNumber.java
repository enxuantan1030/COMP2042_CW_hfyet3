package com.sm2048.Scenes.InGame.Features;

import com.sm2048.Scenes.InGame.GenerateGameCells.TextMaker;

import static com.sm2048.Scenes.InGame.Features.GameMovement.cells;
import static com.sm2048.Scenes.InGame.Features.Variables.n;

/**
 * This class is used to compare between numbered cells and determine to merge the same numbered cells
 *
 * @author En Xuan Tan
 * @version 1.0
 * @since 2022-11-11
 */
public class SameCellNumber {
    private static SameCellNumber singleInstance = null;

    /**
     *
     * This method has used the Design Pattern Singleton which is the lazy instantiation
     * @return instance of class
     */
    public static SameCellNumber getSingleInstance() {
        if (singleInstance == null)
            singleInstance = new SameCellNumber();
        return singleInstance;
    }

    /**
     *This method is used to compare between numbered cells and determine to merge the same numbered cells
     *
     *@param i number of rows
     *@param j number of column
     *@return true if the same row/column have same numbered cells,else false
     */
    public boolean haveSameNumberNearly(int i, int j) {
        if (i < n - 1 && j < n - 1) {
            if (cells[i + 1][j].getNumber() == cells[i][j].getNumber())
                return true;
            return cells[i][j + 1].getNumber() == cells[i][j].getNumber();
        }
        return false;
    }

}
