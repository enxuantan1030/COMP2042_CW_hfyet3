package com.sm2048.Scenes.MenuGame.Features;

import com.sm2048.Scenes.General.GeneralComponents;
import javafx.scene.Group;
import javafx.scene.text.Text;

/**
 * This class is used to display Game Title
 *
 * @author En Xuan Tan
 * @version 1.0
 * @since 2022-11-11
 */
public class GameTitle{
    static GeneralComponents g = new GeneralComponents();

    /**
     * This method is used to display Game Title in StartGame scene
     *
     * @param root use to add Game Title component into EndGame scene
     */
    public static void GameTitle(Group root) {
        Text text = new Text("2048");
        text.relocate(350,300);
        g.textstyle(text, root, 100);
    }

}
