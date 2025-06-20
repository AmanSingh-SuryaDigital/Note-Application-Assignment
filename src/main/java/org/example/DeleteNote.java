package org.example;

import java.io.File;

public class DeleteNote {

    public static void toDeleteNote() {
        System.out.println("Select the note to be deleted");

        String noteTitle = NoteList.toGetNote();

        File file = new File(Main.folder, noteTitle);
        if (file.delete()) {
            System.out.println(noteTitle + " Note is Deleted");
        } else {
            System.out.println("This Note does Not Exit");
        }
    }
}

