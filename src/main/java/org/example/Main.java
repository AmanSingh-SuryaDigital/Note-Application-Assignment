package org.example;

import java.io.File;
import java.util.Scanner;

public class Main {
//    public static String folder=Main.folderCreation();

    public static String folder = "NoteFolder";

//    public static String folderCreation(){
//        System.out.println("Enter the folder Name");
//        Scanner scanner = new Scanner(System.in);
//
//        String folderName=scanner.nextLine();
//        File dir = new File(folderName);
//
//        if (dir.mkdir()) {
//            System.out.println("Folder Created with name " + folderName);
//        }else {
//            System.out.println("Folder exits  Carry with your Task");
//        }
//        return folderName;
//    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Note Application");

        while (true) {

            System.out.println("Choose a option");
            System.out.println("1.Create");
            System.out.println("2.Read");
            System.out.println("3.Update");
            System.out.println("4.Delete");
            System.out.println("5.List");
            System.out.println("6.Exit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
//                    TODO: add create flow [https://github.com/AmanSingh-SuryaDigital/Note-Application-Assignment/pull/3].
                    System.out.println("This feature is under development");
                    break;
                case 2:
                    ReadNote.toReadNote();
                    break;
                case 3:
                    UpdateNote.toUpdateNote();
                    break;
                case 4:
                    DeleteNote.toDeleteNote();
                    break;
                case 5:
                    NoteList.toDisplayNoteList();
                    break;
                case 6:
                    System.out.println("Exit from NoteApplication");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
