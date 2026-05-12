package org.example.Practic.save;

import com.google.gson.reflect.TypeToken;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.Practic.Task;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static org.example.Practic.save.AppFiles.gson;


public class load_save {
    public static ObservableList<Task> load_save() throws Exception {
        Reader reader = new FileReader(AppFiles.TASKS_FILE);
        Type type = new TypeToken<ArrayList<Task>>() {
        }.getType();
        List<Task> loaded = gson.fromJson(reader, type);
        if(loaded == null){
            loaded = FXCollections.observableArrayList();

        }
        ObservableList<Task> tasks =  FXCollections.observableArrayList();
        tasks.setAll(loaded);
        reader.close();
        return tasks;
    }
}
