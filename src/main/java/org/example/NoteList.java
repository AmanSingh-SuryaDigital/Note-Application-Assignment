package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;


public class NoteList {

    public static String toGetNote() {
        System.out.println("List of note");
        File folder = new File(Main.folder);
        Scanner scanner = new Scanner(System.in);

        File[] files = folder.listFiles();

        if (files == null) {
            System.out.println("No notes found in the directory or directory does not exist.");
            return null;
        }

        ArrayList<File> fileList = new ArrayList<>();
        for (File file : files) {
            if (file.isFile()) {
                fileList.add(file);
            }
        }

        DateCompare dateCompare = new DateCompare();
        Collections.sort(fileList, dateCompare);

        int count = 0;

        for (File file : fileList) {
            System.out.println(++count + ". " + file.getName());
        }
        System.out.println("Enter the note number");
        int userInput = scanner.nextInt();

        return fileList.get(userInput - 1).getName();
    }

    public static void toDisplayNoteList() {

        File folder = new File(Main.folder);

        File[] files = folder.listFiles();
        if (files == null) {
            System.out.println("No notes found in the directory or directory does not exist.");
            return;
        }

        List<File> fileList = new ArrayList<>();
        for (File file : files) {
            fileList.add(file);
        }

        DateCompare dateCompare = new DateCompare();
        Collections.sort(fileList, dateCompare);

        System.out.println("List of notes");
        int count = 0;

        for (File file : fileList) {
            System.out.println(++count + ". " + file.getName());
        }
    }

    public static class DateCompare implements Comparator<File> {

        @Override
        public int compare(File noteName1, File noteName2) {
            try {
                FileTime creationTime1 = Files.readAttributes(noteName1.toPath(), BasicFileAttributes.class).creationTime();
                FileTime creationTime2 = Files.readAttributes(noteName2.toPath(), BasicFileAttributes.class).creationTime();
                return creationTime2.compareTo(creationTime1);
            } catch (IOException e) {
                System.err.println("Error comparing notes: " + e.getMessage());
                return 0;
            }
        }
    }
}
