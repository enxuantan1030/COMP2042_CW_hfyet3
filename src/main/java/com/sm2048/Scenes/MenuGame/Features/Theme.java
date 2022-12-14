package com.sm2048.Scenes.MenuGame.Features;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

import java.util.Objects;

/**
 * This class is used to change theme in Game and EndGame scenes (get the theme chose by users from StartGame.java)
 *
 * @author En Xuan Tan
 * @version 1.0
 * @since 2022-11-11
 */
public class Theme  {

    /**
     *This method is used to modify theme for Game and EndGame scenes
     *
     *@param c1 first colour for gradient
     *@param c2 second colour for gradient
     *@param s1 modify GameScene theme
     *@param s2 modify EndGameScene theme
     */
    public static void ChooseTheme(String c1, String c2, Scene s1, Scene s2){
        //Gradient colour function referred to website -
        s1.setFill(new LinearGradient(
                0, 0, 1, 1, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.web(c1)),
                new Stop(1, Color.web(c2))));
        s2.setFill(new LinearGradient(
                0, 0, 1, 1, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.web(c1)),
                new Stop(1, Color.web(c2))));
    }

    /**
     * This method is used to get the colour option chosen by user from StartGame.java
     *
     *@param c get the colour option chosen by user from StartGame.java
     *@param gameScene use to modify GameScene scene theme
     *@param endGameScene use to modify EndGame scene theme
     */
    public static void DBChooseTheme(String c, Scene gameScene, Scene endGameScene){
        if (Objects.equals(c, "Blue")){

            ChooseTheme("#1A5276", "#AED6F1",gameScene, endGameScene);

        }else if (Objects.equals(c, "Yellow")){

            ChooseTheme("#7D6608", "#FAD7A0", gameScene, endGameScene);

        }else if (Objects.equals(c, "Black")){

            ChooseTheme("#1B2631", "#85929E", gameScene, endGameScene);

        }else if (Objects.equals(c, "Pink")){

            ChooseTheme("#78281F", "#FADBD8", gameScene, endGameScene);

        }else if (Objects.equals(c, "Purple")){

            ChooseTheme("#4A235A", "#D7BDE2", gameScene, endGameScene);

        }else{

            ChooseTheme("#0B5345", "#A9DFBF", gameScene, endGameScene);

        }
    }


}
