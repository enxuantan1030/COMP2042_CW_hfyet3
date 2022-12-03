package com.sm2048.Accounts;

import com.sm2048.Main;

import java.io.*;
import java.util.Objects;

public class Test {
    private static long oldScore;

    public static void getStrScore(String line) {
        oldScore = Long.parseLong(line.substring(Integer.parseInt(String.valueOf(line.lastIndexOf(" ") + 1))));
    }

    public static void add(String name){

        try {

            Main.datafile.createNewFile(); // create file if Data.txt file does not exist
            File newFile = new File("newHighScoreList.txt");

            FileReader fReader = new FileReader(new File(Main.data_path));
            BufferedReader fileBuff = new BufferedReader(fReader);
            String line = fileBuff.readLine();

            FileWriter file_writer;
            file_writer = new FileWriter(Main.data_path, true);
            BufferedWriter buffered_Writer = new BufferedWriter(file_writer);

            while (line != null) {
                if (Objects.equals(name, line)){
                    System.out.println("found"+ name);
                    getStrScore(line);
                    break;
                }else{
                    System.out.println("Not Found");
                    buffered_Writer.write(line + "\n");
                }
                line = fileBuff.readLine();
            }
            buffered_Writer.write(name);
            buffered_Writer.flush();
            buffered_Writer.close();
            file_writer.close();
            fileBuff.close();

            Main.datafile.delete();
            newFile.renameTo(Main.datafile);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void compareScore(long newScore) throws IOException {
        FileWriter file_writer;
        file_writer = new FileWriter("highScoreList.txt", true);
        BufferedWriter buffered_Writer = new BufferedWriter(file_writer);

        if(newScore > oldScore) {
            buffered_Writer.write(newScore + "\n");
        } else {
            buffered_Writer.write(oldScore + "\n");
        }
        buffered_Writer.flush();
        buffered_Writer.close();
        file_writer.close();
    }


}