package com.sm2048.Scenes.General;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 * This interface is used to implement abstraction which only store method without body
 *
 * @author En Xuan Tan
 * @version 1.0
 * @since 2022-11-11
 */
public interface GeneralizedComponents {

    /**
     * This is used display a pop-out windows after Quit button being clicked
     *
     * @param root use to clear components in a scene
     */
    void quitbtn(Group root);

    /**
     * This method id used to style a button
     *
     * @param b to get the button from the scene
     * @param root use to add button component into scene
     */
    void btnstyle(Button b, Group root);

    /**
     * This method id used to style text
     *
     * @param t to get the text from the scene
     * @param root use to add text component into scene
     * @param size use to set the size of the text
     */
    void textstyle(Text t, Group root, int size);

    /**
     * This method is used to create leaderboard button into scene
     *
     * @param root use to add leaderboard component into scene
     */
    void LBbutton(Group root);

    /**
     * This method is used to control audio mute or unmute
     *
     * @param root use to add Mutebutton component into scene
     */
    void Mutebutton(Group root);
}
