package org.example.Practic;

import org.example.Practic.save.load_save;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private static List<Task> tasks = new ArrayList<>();
    public static void load_save() throws Exception {
        tasks = load_save.load_save();
    }

    public static void addTask(Task task) {
        tasks.add(task);
        try {
            // save_saves.save_tasks();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("zadach dobavlena(task).");
    }

public static void removeTask(Task task){
        tasks.remove(task);

}


    public void setTask(Task task_, String name, String task) {
        task_.setTask(name,task);
        try {
            // save_saves.save_tasks();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static List<Task> getTasks() {
        return tasks;
    }
}
