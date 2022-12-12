package com.sm2048.Scenes.InGame;

import javafx.scene.text.Text;

/**
 * This interface allows multiple inheritance for GameScene
 *
 * @author En Xuan Tan
 * @version 1.0
 * @since 2022-11-11
 */
public interface InGameInterface {

    /**
     * This method is to determine whether there's any movement can be made in the game
     * @return it will return false if the game can be continued else false
     */
    boolean canNotMove();

    /**
     * This method is used to check each cell in the game whether it is empty or there's numbered 2048
     *
     * @return return -1 if there's empty cells in game, return 0 if cell numbered 2048, return 1 if cell numbered 0(which is impossible)
     */
    int haveEmptyCell();

    /**
     * This method is used to generate random numbers in the game
     *
     * @param turn for 1, it indicates generating numbers at the beginning of the game, for 2, it indicates generating numbers during in-game
     */
    void randomFillNumber(int turn);

    /**
     * @param i number of rows
     * @param j number of column
     * @param des new locations for all the cells
     * @param sign -1 if up, 1 if down
     * @return true if cells can be moved up/down, else false
     */
    boolean isValidDesH(int i, int j, int des, int sign);

    /**
     * @param i number of rows
     * @param j number of column
     * @param des new locations for all the cells
     * @param sign -1 if left, 1 if right
     * @return true if cells can be moved up/down, else false
     */
    boolean isValidDesV(int i, int j, int des, int sign);

    /**
     * @param i number of rows
     * @param j number of column
     * @param direct new locations for all the cells
     * @return true if cells can be moved up/down, else false
     */
    int passDestination(int i, int j, char direct);

    /**
     * @param i number of rows
     * @param j number of column
     * @param des new locations for all the cells
     * @param sign -1 if up, 1 if down
     */
    void moveHorizontally(int i, int j, int des, int sign);

    /**
     * This method is used to move all the numbered cells either to left or right
     *
     * @param i number of rows
     * @param j number of column
     * @param des new locations for all the cells
     * @param sign -1 if left, 1 if right
     */
    void moveVertically(int i, int j, int des, int sign);


    /**
     * This method is used to compare between numbered cells and determine to merge the same numbered cells
     *
     * @param i number of rows
     * @param j number of column
     * @return true if the same row/column have same numbered cells, else false
     */
    boolean haveSameNumberNearly(int i, int j);


    /**
     * This method is used to change the text of the Stopwatch in game
     *
     * @param text to set the Text to time
     */
    void change(Text text);

    /**
     * This method is used to make movement when left key is pressed
     */
    void moveLeft();

    /**
     * This method is used to make movement when right key is pressed
     */
    void moveRight();

    /**
     * This method is used to make movement when up key is pressed
     */
    void moveUp();

    /**
     * This method is used to make movement when down key is pressed
     */
    void moveDown();
}
