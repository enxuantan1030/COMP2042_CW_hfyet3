package com.sm2048.Accounts;

import java.io.*;

/**
 * This class is used for adding new names into file based on the difficulty
 * as different difficulty have different files
 *
 * @author En Xuan Tan
 * @version 2.0
 * @since 2022-11-11
 */
public class AddName {

    /**
     * This method would take the input from user and compare every name in the file,
     * initialize score and time for new name
     *
     * @param name input from user which would store into file
     * @param lvl difficulty which choose by users
     * @throws IOException to catch error for input and output
     */
    public static void add(String name, int lvl) throws IOException {
        boolean valid = false;

        try {

            File f = new File(ChooseFile.File(lvl));
            BufferedReader br =new BufferedReader(new FileReader(ChooseFile.File(lvl)));
            Object[] lines = br.lines().toArray();
            BufferedWriter fw = new BufferedWriter(new FileWriter(f,true));

            for(int i= 0; i < lines.length; i++){
                String[] row = lines[i].toString().split(" ");
                if(row[0].equals(name)){
                    valid = true;
                    break;
                }

            }

            if(!valid){

                fw.write(name + " " + 0 + " " + "00:00:000");
                fw.newLine();
            }
            fw.close();
            br.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}