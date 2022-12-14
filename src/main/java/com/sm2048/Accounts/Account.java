package com.sm2048.Accounts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.text.Text;

/**
 * This class is used to Store information for a user and display it at ShowScore.fxml
 *
 *  @author En Xuan Tan-modified
 *  @version 2.0
 *  @since 2022-11-11
 */
public class Account {

    private Text username;
    private Long score;
    private String time;
    static ObservableList<Account> highscore = FXCollections.observableArrayList();

    /**
     * This method is used to add users' info into arraylist Account
     *
     * @param username users' name
     * @param score users' highest score
     * @param time users' time used to get their highest score
     */
    public Account(Text username, Long score, String time) {
        this.username = username;
        this.score = score;
        this.time = time;
    }

    /**
     * This method is used to access the value of username
     *
     * @return users' name
     */
    public Text getUsername() {
        return username;
    }

    /**
     * This method is used to access the value of score
     *
     * @return users' highest score
     */
    public Long getScore() {
        return score;
    }

    /**
     * This method is used to access the value of time
     *
     * @return users' time used to get their highest score
     */
    public String getTime() {
        return time;
    }

}
