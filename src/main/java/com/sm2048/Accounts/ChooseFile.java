package com.sm2048.Accounts;

import com.sm2048.Main;

/**
 * This class is used to choose which file to read/write based on user input
 *
 * @author En Xuan Tan
 * @version 2.0
 * @since 2022-11-11
 */
public class ChooseFile {

    /**
     * @param n difficulty chosen by the user
     * @return Path for the file
     */
    public static String File(int n){

        if(n == 3){
            return Main.data_path3x3;
        }
        else if(n == 4){
            return Main.data_path4x4;
        }

        else if(n == 5){
            return Main.data_path5x5;
        }

        else if(n == 6){
            return Main.data_path6x6;
        }

        else if(n == 7){
            return Main.data_path7x7;
        }

        return null;
    }
}
