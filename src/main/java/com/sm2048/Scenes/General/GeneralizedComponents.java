package com.sm2048.Scenes.General;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public interface GeneralizedComponents {
    void quitbtn(Group root);
    void btnstyle(Button b, Group root);
    void textstyle(Text t, Group root, int size);
    void LBbutton(Group root);
}
