package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class UpdateNote {

    public static void toRenameNote(String oldName, String newName) {
        File oldfile = new File(Main.folder, oldName);

        File newFile = new File(Main.folder, newName);

        if (oldfile.renameTo(newFile)) {
            System.out.println("File renamed successfully.");
        } else {
            System.out.println("Failed to rename the file.");
        }

    }

    public static void toUpdateNote() {

        Scanner scanner = new Scanner(System.in);

        String noteToUpdate = NoteList.toGetNote();

        while (true) {
            System.out.println("Chose option 1 for rename");
            System.out.println("Chose option 2 for content Update");
            System.out.println("Chose option 3 for Exit from UpdateNote");

            int choose = scanner.nextInt();

            switch (choose) {

                case 1:
                    System.out.println("Enter the new Note");
                    Scanner scanner1 = new Scanner(System.in);
                    String newFile = scanner1.nextLine();
                    if (Utils.inputValidation(newFile)) {
                        System.out.println(" This is invalid Input ");
                        return;
                    }
                    UpdateNote.toRenameNote(noteToUpdate, newFile);
                    System.out.println("UpdateNote Name");
                    break;
                case 2:
                    System.out.println("UpdateNote Body");
                    UpdateNote.toUpdateNoteBody(noteToUpdate);
                    break;
                case 3:
                    System.out.println("Exit from Update");
                    return;
            }
        }
    }

    public static void toUpdateNoteBody(String noteName) {

        File fileName = new File(Main.folder, noteName);

        Scanner scanner = new Scanner(System.in);
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

            bufferedWriter = new BufferedWriter(new FileWriter(fileName));
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


    public static void main(String[] args) {
        UpdateNote.toUpdateNote();
    }
}
