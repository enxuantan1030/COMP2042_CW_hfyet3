package com.sm2048.Scenes.InGame.Features;

import com.sm2048.Scenes.InGame.GameScene;
import com.sm2048.Scenes.InGame.GenerateGameCells.Cell;
import com.sm2048.Scenes.InGame.GenerateGameCells.TextMaker;
import javafx.scene.text.Text;

import java.util.Random;

import static com.sm2048.Scenes.InGame.Features.Variables.n;

/**
 * This class is used to make movement in the game
 *
 * @author En Xuan Tan
 * @version 1.0
 * @since 2022-11-11
 */
public class GameMovement {

    private static GameMovement singleInstance = null;

    /**
     * This method is to prevents the instantiation from any other class.
     */
    private GameMovement() {

    }

    /**
     * This class is used for generating text
     * @return singleInstance
     */
    public static GameMovement getSingleInstance() {
        if (singleInstance == null)
            singleInstance = new GameMovement();
        return singleInstance;
    }

    static GameScene GS = GameScene.getSingleInstance();
    static TextMaker textMaker = TextMaker.getSingleInstance();
    /**
     * Cells in game
     */
    public static Cell[][] cells = new Cell[n][n];

    /**
     *This method is used to generate random numbered cells in the game
     *
     */

     public static void randomFillNumber() {

        Cell[][] emptyCells = new Cell[n][n];
        int a = 0;
        int b = 0;
        int aForBound=0,bForBound=0;
        outer:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cells[i][j].getNumber() == 0) {
                    emptyCells[a][b] = cells[i][j];
                    if (b < n-1) {
                        bForBound=b;
                        b++;

                    } else {
                        aForBound=a;
                        a++;
                        b = 0;
                        if(a==n)
                            break outer;
                    }
                }
            }
        }



        Text text;
        Random random = new Random();
        boolean putTwo = random.nextInt() % 2 != 0;
         int xCell, yCell;
        xCell = random.nextInt(aForBound+1);
        yCell = random.nextInt(bForBound+1);
        if (putTwo) {
            text = textMaker.madeText("2", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY());
            emptyCells[xCell][yCell].setTextClass(text);
            GS.GameRoot.getChildren().add(text);
            emptyCells[xCell][yCell].setColorByNumber(2);
        } else {
            text = textMaker.madeText("4", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY());
            emptyCells[xCell][yCell].setTextClass(text);
            GS.GameRoot.getChildren().add(text);
            emptyCells[xCell][yCell].setColorByNumber(4);
        }
    }

    /**
     * This method is used to check whether all the cells can be moved to leftest/rightest side
     *
     *@param i number of rows
     *@param j number of column
     *@param des new locations for all the cells
     *@param sign -1 if it's an up movement,1 if it's a down movement
     *@return return true if cells can be move up/down,else false
     */
    public boolean isValidDesH(int i, int j, int des, int sign) {
        if (des + sign < n && des + sign >= 0) {
            return cells[i][des + sign].getNumber() == cells[i][j].getNumber() && !cells[i][des + sign].getModify()
                    && cells[i][des + sign].getNumber() != 0;
        }
        return false;
    }

    /**
     * This method is used to check whether all the cells can be moved to highest/lowest(vertically) side
     *
     *@param i number of rows
     *@param j number of column
     *@param des new locations for all the cells
     *@param sign -1 if it's a left movement,1 if it's a right movement
     *@return return true if cells can be move left/right,else false
     */
    public boolean isValidDesV(int i, int j, int des, int sign) {
        if (des + sign < n && des + sign >= 0)
            return cells[des + sign][j].getNumber() == cells[i][j].getNumber() && !cells[des + sign][j].getModify()
                    && cells[des + sign][j].getNumber() != 0;
        return false;
    }
    /**
     * This method is used to determine the locations of all cells when users make movements in the game(up/down/left/right)
     *
     *@param i number of rows
     *@param j number of column
     *@param direct gets the movement made by users(up/down/left/right)
     *@return new locations of all cells
     */
    public int passDestination(int i, int j, char direct) {
        int coordinate = j;
        if (direct == 'l') {
            for (int k = j - 1; k >= 0; k--) {
                if (cells[i][k].getNumber() != 0) {
                    coordinate = k + 1;
                    break;
                } else if (k == 0) {
                    coordinate = 0;
                }
            }
            return coordinate;
        }
        coordinate = j;
        if (direct == 'r') {
            for (int k = j + 1; k <= n - 1; k++) {
                if (cells[i][k].getNumber() != 0) {
                    coordinate = k - 1;
                    break;
                } else if (k == n - 1) {
                    coordinate = n - 1;
                }
            }
            return coordinate;
        }
        coordinate = i;
        if (direct == 'd') {
            for (int k = i + 1; k <= n - 1; k++) {
                if (cells[k][j].getNumber() != 0) {
                    coordinate = k - 1;
                    break;

                } else if (k == n - 1) {
                    coordinate = n - 1;
                }
            }
            return coordinate;
        }
        coordinate = i;
        if (direct == 'u') {
            for (int k = i - 1; k >= 0; k--) {
                if (cells[k][j].getNumber() != 0) {
                    coordinate = k + 1;
                    break;
                } else if (k == 0) {
                    coordinate = 0;
                }
            }
            return coordinate;
        }
        return -1;
    }

    /**
     * This method is used to check whether all the cells can be moved to highest/lowest(vertically) side
     *
     *@param i number of rows
     *@param j number of column
     *@param des new locations for all the cells
     *@param sign -1 if it's an up movement,1 if it's a down movement
     */
    public void moveHorizontally(int i, int j, int des, int sign) {
        if (isValidDesH(i, j, des, sign)) {
            Variables.score += cells[i][j].getNumber()*2;
            cells[i][j].adder(cells[i][des + sign]);
            cells[i][des].setModify(true);
        } else if (des != j) {
            cells[i][j].changeCell(cells[i][des]);
        }
    }

    /**
     * This method is used to check whether all the cells can be moved to highest/lowest(vertically) side
     *
     *@param i number of rows
     *@param j number of column
     *@param des new locations for all the cells
     *@param sign -1 if it's a left movement,1 if it's a right movement
     */
    public void moveVertically(int i, int j, int des, int sign) {
        if (isValidDesV(i, j, des, sign)) {
            Variables.score += cells[i][j].getNumber()*2;
            cells[i][j].adder(cells[des + sign][j]);
            cells[des][j].setModify(true);
        } else if (des != i) {
            cells[i][j].changeCell(cells[des][j]);
        }
    }

}
