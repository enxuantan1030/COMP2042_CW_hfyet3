package com.sm2048.Scenes.InGame;

import javafx.scene.text.Text;

public class Stopwatch extends GameMovement{

    void change(Text text) {
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