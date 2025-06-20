package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadNote {

    public static void toReadNote() {
        System.out.println("Enter the note number to be delete");
        String noteToRead= NoteList.toGetNote();

        File file = new File(Main.folder,noteToRead);
        if(!file.exists()){
            System.out.println("Note Does Not Exit");
            return;
        }

        BufferedReader bufferedReader =null;

        try  {

            bufferedReader = new BufferedReader(new FileReader(file));

            String line = bufferedReader.readLine() ;

            while ( line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {

            System.out.println("Exception in reading the note: " + e.getMessage());
        }
        finally {
            try {

                if(bufferedReader!=null){
                    bufferedReader.close();
                }
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }

    }

}

