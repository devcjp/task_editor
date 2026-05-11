package org.example.Practic.save;

import com.google.gson.Gson;

import java.io.File;

public class AppFiles {

    public static final File dir =
            new File(System.getenv("APPDATA")
                    + "\\TasksEditor");

    public static final File TASKS_FILE =
            new File(dir, "tasks.json");

    public static final Gson gson =
            new Gson();
}