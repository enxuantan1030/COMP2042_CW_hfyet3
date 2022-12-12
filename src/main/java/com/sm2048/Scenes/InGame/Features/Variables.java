package com.sm2048.Scenes.InGame.Features;

import com.sm2048.Scenes.General.GeneralComponents;
import com.sm2048.Scenes.InGame.GenerateGameCells.Cell;
import com.sm2048.Scenes.InGame.InGameInterface;
import com.sm2048.Scenes.InGame.GenerateGameCells.TextMaker;
import javafx.scene.Group;

/**
 * This class is used to store all the variables required in-game
 *
 * @author En Xuan Tan
 * @version 1.0
 * @since 2022-11-11
 */
public abstract class Variables extends GeneralComponents implements InGameInterface {

    TextMaker textMaker = TextMaker.getSingleInstance();
    protected Cell[][] cells = new Cell[n][n];
    static int HEIGHT = 700;

    /**
     * Ths variable is used to determine the number of cells in the game
     */
    public static int n = 8;
    protected final static int distanceBetweenCells = 10;
    protected static double LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n;
    protected long score = 0;
    protected int mins = 0;
    protected int secs = 0;
    protected int millis = 0;
    protected Group GameRoot;

    /**
     * This method is an accessor for LENGTH
     *
     * @return LENGTH
     */
    public static double getLENGTH() {
        return LENGTH;
    }

    /**
     * This method is a modifier for n
     *
     * @param number to determine how many rows and column to generate in game
     */
    public static void setN(int number) {
        n = number;
        LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n;
    }

}
