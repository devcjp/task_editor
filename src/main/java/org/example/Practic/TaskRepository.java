package org.example.Practic;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.Practic.save.load_save;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private static ObservableList<Task> tasks = FXCollections.observableArrayList();
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
public static ObservableList<Task> searchTasks(String string){
    ObservableList<Task> result =
            FXCollections.observableArrayList();
        for(Task task : TaskRepository.getTasks()){
            if(task.getName().toLowerCase().contains(string.toLowerCase()) || task.getTask().toLowerCase().contains(string.toLowerCase())){
                result.add(task);
            }

        }


        return result;
}


public static void removeTask(Task task){
        tasks.remove(task);

}

    public static ObservableList<Task> getTasks() {
        return tasks;
    }
}
