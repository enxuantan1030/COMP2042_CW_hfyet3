package com.sm2048.Scenes.InGame.Features;

import com.sm2048.Scenes.InGame.GenerateGameCells.Cell;
import com.sm2048.Scenes.InGame.GenerateGameCells.TextMaker;
import javafx.scene.Group;

/**
 * This class is used to store all the variables for GameScene
 *
 * @author En Xuan Tan
 * @version 1.0
 * @since 2022-11-11
 */
public class Variables {

    static int HEIGHT = 700;

    /**
     * Ths variable is used to determine the number of cells in the game
     */
    public static int n = 7;
    /**
     * This variable is used to set the size of the gap between cells
     */
    public static int distanceBetweenCells = 10;
    /**
     * This variable is used to set the length of each cell
     */
    public static double LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n;
    static TextMaker textMaker = TextMaker.getSingleInstance();
    /**
     * Cells in game
     */
    public static Cell[][] cells = new Cell[n][n];
    /**
     * This variable is used to initialize the value for score in the game
     */
    public static long score = 0;
    /**
     * This variable is used to initialize the value for minute for stopwatch
     */
    public static int mins = 0;
    /**
     * This variable is used to initialize the value for second for stopwatch
     */
    public static int secs = 0;
    /**
     * This variable is used to initialize the value for millisecond for stopwatch
     */
    public static int millis = 0;

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
