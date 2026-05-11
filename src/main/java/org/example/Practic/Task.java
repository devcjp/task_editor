package org.example.Practic;

import org.example.Practic.save.load_save;
import org.example.Practic.save.save_saves;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task {
    private String name;
    private String task;
    private boolean completed;
    private List<String> notes = new ArrayList<>();


    public Task(String name, String task, boolean completed) {
        this.name = name;
        this.task = task;
this.completed = completed;
    }


    public void addNote(String note) {
        notes.add(note);
        try {
            // save_saves.save_tasks();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void changeNote(String note, String newNote) {
        int index = notes.indexOf(note);

        if (index != -1) {
            notes.set(index, newNote);
        }
        try {
            // save_saves.save_tasks();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
public void set_completed(boolean completed){
        this.completed = completed;
}
public boolean get_completed(){
        return completed;

}
    public List<String> get_notes() {
        return notes;
    }

    public void delNote(String note) {
        this.notes.remove(note);
        try {
            // save_saves.save_tasks();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setTask(String name, String task) {
        this.name = name;
        this.task = task;
        try {
            // save_saves.save_tasks();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public String getTask() {
        return task;
    }

    public String getName() {
        return name;
    }


}
