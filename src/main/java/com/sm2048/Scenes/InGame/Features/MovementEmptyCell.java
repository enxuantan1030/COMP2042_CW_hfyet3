package com.sm2048.Scenes.InGame.Features;

import static com.sm2048.Scenes.InGame.Features.GameMovement.cells;
import static com.sm2048.Scenes.InGame.Features.Variables.n;

/**
 * This class is to search for empty cells in the game
 *
 * @author En Xuan Tan
 * @version 1.0
 * @since 2022-11-11
 */
public class MovementEmptyCell {

    /**
     *This method is used to check each cell in the game whether it is empty and numbered cell 2048
     *
     *@return return -1 if there's empty cells in game, return 0 if numbered cell 2048 is in game,return 1 if numbered cell 0
     */
    public static int haveEmptyCell() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cells[i][j].getNumber() == 0)
                    return 1;
                if(cells[i][j].getNumber() == 2048)
                    return 0;
            }
        }
        return -1;
    }
}
