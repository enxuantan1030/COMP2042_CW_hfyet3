package com.sm2048.Accounts;

import com.sm2048.Main;

public class ChooseFile {
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
