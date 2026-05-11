package org.example.Practic.save;

import com.google.gson.reflect.TypeToken;
import org.example.Practic.Task;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import static org.example.Practic.save.AppFiles.gson;


public class load_save {
    public static ArrayList<Task> load_save() throws Exception {
        Reader reader = new FileReader(AppFiles.TASKS_FILE);
        Type type = new TypeToken<ArrayList<Task>>() {
        }.getType();
        ArrayList<Task> tasks = gson.fromJson(reader, type);
        if(tasks == null){
            tasks = new ArrayList<>();
        }
        reader.close();
        return tasks;
    }
}
