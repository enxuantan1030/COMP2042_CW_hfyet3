package com.sm2048.Scenes.InGame;

import com.sm2048.Others.TextMaker;
import com.sm2048.ScenesAbstract.Scenesimple;
import com.sm2048.Others.Cell;
import javafx.animation.Timeline;
import javafx.scene.text.Text;


public abstract class InGameAbstractMethods extends Scenesimple implements InGameInterface {

    TextMaker textMaker = TextMaker.getSingleInstance();
    Cell[][] cells = new Cell[n][n];
    static int HEIGHT = 700;
    static int n = 4;
    final static int distanceBetweenCells = 10;
    static double LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n;
    long score = 0;
    Text time;
    Timeline timeline;
    int mins = 0, secs = 0, millis = 0;

    public static double getLENGTH() {
        return LENGTH;
    }

    public static void setN(int number) {
        n = number;
        LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n;
    }

    public boolean haveSameNumberNearly(int i, int j) {
        if (i < n - 1 && j < n - 1) {
            if (cells[i + 1][j].getNumber() == cells[i][j].getNumber())
                return true;
            return cells[i][j + 1].getNumber() == cells[i][j].getNumber();
        }
        return false;
    }

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

    int haveEmptyCell() {
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
