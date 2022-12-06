package com.sm2048.Scenes.InGame;

import com.sm2048.Main;
import com.sm2048.Scenes.General.GeneralComponents;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.text.Text;


public class Variables extends GeneralComponents {

    TextMaker textMaker = TextMaker.getSingleInstance();
    Cell[][] cells = new Cell[n][n];
    static int HEIGHT = 700;
    public static int n = 8;
    final static int distanceBetweenCells = 10;
    static double LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n;
    long score = 0;
    Text time;
    Timeline timeline;
    int mins = 0, secs = 0, millis = 0;
    Group GameRoot;
    Main main = new Main();

    public static double getLENGTH() {
        return LENGTH;
    }

    public static void setN(int number) {
        n = number;
        LENGTH = (HEIGHT - ((n + 1) * distanceBetweenCells)) / (double) n;
    }

}
