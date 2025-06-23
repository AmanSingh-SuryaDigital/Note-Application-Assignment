package org.example;

import java.util.Scanner;

public class Main {

    public static String folder = "NoteFolder";

    enum Task {
        Create, Read, Update, Delete, List, Exit
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Note Application");

        while (true) {
            System.out.println("Choose a option");
            System.out.println("0.Create");
            System.out.println("1.Read");
            System.out.println("2.Update");
            System.out.println("3.Delete");
            System.out.println("4.List");
            System.out.println("5.Exit");

            System.out.println("Enter the number in the range of 0 to 5");
            int option = scanner.nextInt();
            Task task = Task.values()[option];
            switch (task) {
                case Task.Create:
//                    TODO: add create flow [https://github.com/AmanSingh-SuryaDigital/Note-Application-Assignment/pull/3].
                    System.out.println("This feature is under development");
                    break;
                case Task.Read:
//                    TODO: add read flow [https://github.com/AmanSingh-SuryaDigital/Note-Application-Assignment/pull/5].
                     System.out.println("This feature is under development");
                    break;
                case Task.Update:
//                    TODO: add update flow [https://github.com/AmanSingh-SuryaDigital/Note-Application-Assignment/pull/6].
                    System.out.println("This feature is under development");
                case Task.Delete:
//                    TODO: add create flow [https://github.com/AmanSingh-SuryaDigital/Note-Application-Assignment/pull/7].
                    System.out.println("This feature is under development");                    break;
                case Task.List:
//                    TODO: add create flow [https://github.com/AmanSingh-SuryaDigital/Note-Application-Assignment/pull/4].
                    System.out.println("This feature is under development");                    break;
                case Task.Exit:
                    System.out.println("Exit from NoteApplication");
                    return;
            }
        }
    }
}