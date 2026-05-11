package org.example.Practic.save;

import com.google.gson.Gson;
import org.example.Practic.Task;
import org.example.Practic.TaskRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static org.example.Practic.save.AppFiles.dir;
import static org.example.Practic.save.AppFiles.gson;

public class save_saves {

    public static void save_tasks() throws Exception {
        try (FileWriter writer = new FileWriter(dir + "\\tasks.json")) {
            gson.toJson(TaskRepository.getTasks(), writer);
        }catch (Exception e){e.printStackTrace();}





    }
}
