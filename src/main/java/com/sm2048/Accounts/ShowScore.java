package com.sm2048.Accounts;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * This class is used to show score in ShowScore.fxml based on difficulty choose by users
 *
 * @author En Xuan Tan
 * @version 2.0
 * @since 2022-11-11
 */
public class ShowScore {

    /**
     * This is used to get the difficulty chosen by users
     */
    public static int Content;

    private static ShowScore singleInstance = null;

    /**
     * Returns an active instance of the class if it exists.
     *
     * @return instance of class
     */
    public static ShowScore getInstance() {
        if (singleInstance == null)
            singleInstance = new ShowScore();
        return singleInstance;
    }

    /**
     * Text field which to display all Contents from the file
     */
    @FXML
    public TextArea highScoreList;

    /**
     * Sets the text for the high score list when the contents of the fxml file have been completely loaded.
     *
     * @throws IOException if fail to load file
     */

    public void initialize() throws IOException{

        highScoreList.setText(readFile());
    }

    /**
     * Reads all the content from a file,
     * Sorts the scores of all users in descending order and returns a sorted high score list.
     *
     * @return sorted high score list
     * @throws IOException if fail to load file
     */

    public String readFile() throws IOException {
        String FilePath = ChooseFile.File(Content);
        assert FilePath != null;
        String allContent = new String(Files.readAllBytes(Paths.get(FilePath)));

        ArrayList<String> str = new ArrayList<>(Arrays.asList(allContent.split("\n")));

        return String.join("\n", str);
    }

}
