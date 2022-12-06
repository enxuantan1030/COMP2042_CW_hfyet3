package com.sm2048.Accounts;


import java.io.*;




public class AddName {

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

                fw.write(name + " " + 0);
                fw.newLine();
            }
            fw.close();
            br.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}