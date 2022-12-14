package com.sm2048.Accounts;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.*;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

import static com.sm2048.Accounts.Account.highscore;

/**
 * This class is a controller for ShowScore.fxml
 *
 *  @author En Xuan Tan
 *  @version 1.0
 *  @since 2022-11-11
 */
public class ShowScore implements Initializable {

    @FXML
    private GridPane grid;

    @FXML
    private TableView<Account> tableView;

    @FXML
    private TableColumn<Account, String> tusername;

    @FXML
    private TableColumn<Account, Long> tscore;

    @FXML
    private TableColumn<Account, String> ttime;

    /**
     * This method is used to initialize the background color, datas in the column in ShowScore.fxml
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        grid.setBackground(new Background(new BackgroundFill(Color.web("#A9DFBF"), new CornerRadii(0), new Insets(0))));
        tusername.setCellValueFactory(new PropertyValueFactory<Account, String>("username"));
        tscore.setCellValueFactory(new PropertyValueFactory<Account, Long>("score"));
        ttime.setCellValueFactory(new PropertyValueFactory<Account, String>("time"));

        try{
            readFile();
        }catch(Exception e){
            System.out.println("Error");
        }
        Comparator<? super Account> comparator = Comparator.comparingLong(Account::getScore).reversed();
        FXCollections.sort(highscore, comparator);
        tableView.setItems(highscore);

    }

    /**
     * This is used to get the difficulty chosen by users
     * its value is modified in Leaderboard.java as different button being press will have different value
     */
    public static int lvl;

    /**
     * This method is used to read all the data in a file, and split the data for different column in the table
     */
    public static void readFile(){
        String pathfile = ChooseFile.File(lvl);

        assert pathfile != null;
        File file = new File(pathfile);
        highscore.clear();
        try{

            BufferedReader br =new BufferedReader(new FileReader(file));
            Object[] lines = br.lines().toArray();

            for(int i= 0; i < lines.length; i++){
                String[] row = lines[i].toString().split(" ");
                Text user  = new Text(row[0]);
                highscore.add(new Account(user,Long.parseLong(row[1]),row[2]));

            }

            br.close();

        }
        catch(Exception e){
            System.out.println("Error");
        }
    }


}