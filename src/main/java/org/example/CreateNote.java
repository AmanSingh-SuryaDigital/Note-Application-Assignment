package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CreateNote {

    public static void toCreateNote() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the note Title");
        String noteTitle = scanner.next();
        if (Utils.noteTitleValidation(noteTitle)) {
            System.out.println(" This is invalid note title ");
            return;
        }

        File file = new File(Main.folder, noteTitle);
        try {
            if (file.createNewFile()) {
                System.out.println("Note is created with title " + noteTitle);
            } else {
                System.out.println("This note is already exits. ");
                return;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Write the body of the note and Type 'Exit' on a new line to finish");
        StringBuilder bodyOfNote = new StringBuilder();
        while (true) {
            String line = scanner.nextLine();
            if (line.trim().equalsIgnoreCase("Exit")) {
                break;
            }
            bodyOfNote.append(line).append("\n");
        }

        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(bodyOfNote.toString());
            System.out.println("Note is saved successfully.");
        } catch (IOException e) {
            System.out.println("Exception in saving note: " + e.getMessage());
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


