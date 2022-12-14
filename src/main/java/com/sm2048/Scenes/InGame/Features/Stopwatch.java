package com.sm2048.Scenes.InGame.Features;

import javafx.scene.text.Text;

import static com.sm2048.Scenes.InGame.Features.Variables.*;

/**
 * This class is used to change the text of the Stopwatch in GameScene
 *
 * @author En Xuan Tan
 * @version 1.0
 * @since 2022-11-11
 */
public class Stopwatch{

    /**
     *This method is used to change the text of the Stopwatch in GameScene
     *
     *@param text get the value of time from GameScene.java and modify it based on real-time
     */
    public static void change(Text text) {
        if(millis == 1000) {
            secs++;
            millis = 0;
        }
        if(secs == 60) {
            mins++;
            secs = 0;
        }
        text.setText((((mins/10) == 0) ? "0" : "") + mins + ":"
                + (((secs/10) == 0) ? "0" : "") + secs + ":"
                + (((millis/10) == 0) ? "00" : (((millis/100) == 0) ? "0" : "")) + millis++);
    }

}