package com.sm2048.Scenes.EndGame;

import com.sm2048.ScenesAbstract.Scenesimple;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 * This class is used to extract methods out from StartGame.java
 * So that it is easier to read the codes
 */
public abstract class EndGameAbstractMethods extends Scenesimple implements EndGameInterface {

    public void GameOver(Group root) {
        Text text = new Text("GAME OVER");
        text.relocate(230,250);
        textstyle(text, root, 100);
    }

    @Override
    public void Quitbutton(Group root){
        //menu quit button
        Button menuquitButton = new Button("QUIT");
        btnstyle(menuquitButton, root);
        menuquitButton.relocate(520,550);
        //when the quit button is clicked, a window will pop out and ask for confirmation
        menuquitButton.setOnAction(actionEvent -> quitbtn(root));
    }

    public void Score(Group root, long score){
        Text scoreText = new Text("SCORE:"+score+"");
        scoreText.relocate(400,350);
        textstyle(scoreText, root, 35);
    }

    public void Timeused(Group root){
        Text scoreText = new Text("TIME USED:");
        scoreText.relocate(400,400);
        textstyle(scoreText, root, 35);
    }

    public void Time(Group root, Text time){
        time.relocate(400,430);
        textstyle(time, root, 32);
    }

}