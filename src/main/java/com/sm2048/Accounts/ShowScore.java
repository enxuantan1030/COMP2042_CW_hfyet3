package com.sm2048.Accounts;

import com.sm2048.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class ShowScore {

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

    @FXML
    private TextArea highScoreList3;

    /**
     * Sets the text for the high score list when the contents of the fxml file have been completely loaded.
     *
     * @throws IOException if fail to load file
     */
    public void initialize() throws IOException {
        highScoreList3.setText(sortLines3());
    }

    /**
     * Reads all the content from a file,
     * <a href="file:C:\Users\lisah\IdeaProjects\COMP2042_CW_hfylh2\highScoreList.txt">
     *  * highScoreList.txt</a>, which includes usernames and scores.
     * Sorts the scores of all users in descending order and returns a sorted high score list.
     *
     * @return sorted high score list
     * @throws IOException if fail to load file
     */
    private String sortLines3() throws IOException {
        String allContent = new String(Files.readAllBytes(Paths.get(Main.data_path3x3)));
        ArrayList<String> str = new ArrayList<>(Arrays.asList(allContent.split("\n")));

        // sort in descending order
//        str.sort((o1, o2) -> Integer.compare(
//                Integer.parseInt(o2.substring(o2.indexOf(" ") + 1)),
//                Integer.parseInt(o1.substring(o1.indexOf(" ") + 1))));

        return String.join("\n", str);
    }

}
