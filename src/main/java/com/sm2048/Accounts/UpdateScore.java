package com.sm2048.Accounts;

import javafx.scene.text.Text;
import java.io.*;

/**
 * This class is used for update the name's score and time after finishing a game
 * However, it only saves the highest score played by each name
 *
 * @author En Xuan Tan
 * @version 1.0
 * @since 2022-11-11
 */
public class UpdateScore {

    /**
     * @param username used to find user's name from the file and update the score
     * @param score score earned in a game, it is then compared to user's old score and determined to update the score
     * @param time time used in a game
     * @param lvl difficulty choose by users, used to choose which file to update with
     */
    public static void modifyScore(String username, long score, Text time, int lvl){
        boolean modify = false;
        String pathfile = ChooseFile.File(lvl);
        String tempfile = "newData.txt";
        assert pathfile != null;
        File oldfile = new File(pathfile);
        File newfile = new File(tempfile);
        String delete = null;

        try{

            BufferedWriter fw = new BufferedWriter(new FileWriter(newfile,true));
            BufferedReader br =new BufferedReader(new FileReader(oldfile));
            Object[] lines = br.lines().toArray();

            for(int i= 0; i < lines.length; i++){
                String[] row = lines[i].toString().split(" ");
                if(row[0].equals(username)){

                    int oldscore = Integer.parseInt(row[1]);//get old score from oldfile
                    String oldtime = row[2]; //get old time from oldfile
                    //update user's score if the newest score is higher than the old score
                    if(score > oldscore) {
                        fw.write(username + " " + score + " " + time.getText());
                        fw.newLine();
                    }else{
                        fw.write(username + " " + oldscore + " " + oldtime);
                        fw.newLine();
                    }
                } else{
                    fw.write(row[0]+ " " + row[1] + " " + row[2]);
                    fw.newLine();
                }
            }

            br.close();
            fw.close();
            oldfile.delete();
            File dump = new File(pathfile);
            newfile.renameTo(dump);
        }
        catch(Exception e){
            System.out.println("Error");
        }
    }
}
