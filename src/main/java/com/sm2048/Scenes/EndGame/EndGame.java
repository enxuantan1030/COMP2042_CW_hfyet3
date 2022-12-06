package com.sm2048.Scenes.EndGame;

import com.sm2048.Main;
import com.sm2048.Scenes.EndGame.Features.DisplayAllScore;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Optional;

    /**
    *
    * This class is used for displaying End Game Scene, feature including:
    * display total score, restart game and quit game
    *
    */

public class EndGame extends DisplayAllScore {
    private Group endGameRoot;

    //static member holds only one instance of the Endgame class
    private static EndGame singleInstance = null;

    //prevents the instantiation from any other class.
    private EndGame(){}
    /**
    *
    * This method has used the Design Pattern Singleton which is the lazy instantiation
    * @return
    */
    public static EndGame getInstance(){
        if(singleInstance == null)
            singleInstance= new EndGame();
        return singleInstance;
    }

    /**
     *
     * This method is used to create the Game Over Scene
     *
     * @param title
     * @param startgameScene Scene to create Menu Scene
     * @param root root for startGameScene
     * @param primaryStage Stage which display the Scenes
     * @param gameScene Scene for playing the game 2048
     * @param endGameScene Scene when game is game is ended, which will display GAME OVER Scene
     * @param GameRoot root for gameScene
     * @param EndGameRoot Root root for endgameScene
     * @param score argument which stores score earned by user
     */
    
    public void endGameShow(boolean title, Scene startgameScene, Group root, Stage primaryStage, Scene gameScene, Scene endGameScene, Group GameRoot, Group EndGameRoot, long score, Text time){
        this.endGameRoot = EndGameRoot;
        Main main = new Main();
        //display GAME OVER text
        GameOver(endGameRoot, title);

        //display Score earned by user
        Score(endGameRoot, score);

        //display Time used
        Timeused(endGameRoot);
        Time(endGameRoot, time);

        //Restart button
        Button backmenuButton = new Button("RESTART");
        btnstyle(backmenuButton, endGameRoot);
        backmenuButton.relocate(260,550);
        //when the quit button is clicked, a window will pop out and ask for confirmation
        backmenuButton.setOnAction(actionEvent ->  {
            Alert gamealert = new Alert(Alert.AlertType.CONFIRMATION);
            gamealert.setTitle("Dialog Menu");
            gamealert.setHeaderText("Back to Menu");
            gamealert.setContentText("All the progress made will not be saved, Continue?");

            //when "ok" is clicked, it will return user to menu page
            Optional<ButtonType> gameresult = gamealert.showAndWait();
            if (gameresult.get() == ButtonType.OK){

                main.restart(primaryStage);

                /*primaryStage.setScene(startgameScene);

                //link back to menu
                StartGame.getInstance().game(startgameScene, root, primaryStage, gameScene, endGameScene, GameRoot, EndGameRoot);
                endGameRoot.getChildren().clear();*/

            }
        });

        //Quit button
        Quitbutton(endGameRoot);

        //Display All Score
        LBbutton(endGameRoot);

    }
}
