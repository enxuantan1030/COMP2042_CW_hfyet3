package com.sm2048.Scenes.InGame.GenerateGameCells;

import com.sm2048.Scenes.InGame.Features.Variables;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * This class is used for generating text for numbered cells
 *
 * @author En Xuan Tan-modified
 * @version 2.0
 * @since 2022-11-11
 */
public class TextMaker {
    private static TextMaker singleInstance = null;

    /**
     * This method is to prevents the instantiation from any other class.
     */
    private TextMaker() {

    }

    /**
     * This method has used the Design Pattern Singleton which is the lazy instantiation
     * @return instance of class
     */
    public static TextMaker getSingleInstance() {
        if (singleInstance == null)
            singleInstance = new TextMaker();
        return singleInstance;
    }

    /**
     *
     * This class is used for generating text for numbered cells
     *
     * @param input Text in the cell
     * @param xCell x-axis of cell
     * @param yCell y-axis of cell
     * @return text in the cell
     */
    public Text madeText(String input, double xCell, double yCell) {
        double length = Variables.getLENGTH();
        double fontSize = (3 * length) / 7.0;
        Text text = new Text(input);
        text.setFont(Font.font(fontSize));
        text.relocate((xCell + (1.2)* length / 7.0), (yCell + 2 * length / 7.0));
        text.setFill(Color.WHITE);

        return text;
    }

    /**
     * This method is used to modify texts inside two cells
     *
     * @param first first cell
     * @param second second cell
     */
    public static void changeTwoText(Text first, Text second) {
        String temp;
        temp = first.getText();
        first.setText(second.getText());
        second.setText(temp);

        double tempNumber;
        tempNumber = first.getX();
        first.setX(second.getX());
        second.setX(tempNumber);

        tempNumber = first.getY();
        first.setY(second.getY());
        second.setY(tempNumber);

    }

}
