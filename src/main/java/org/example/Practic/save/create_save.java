package org.example.Practic.save;

import java.io.File;
import java.io.IOException;



public class create_save {

    public static void create_dir()
            throws IOException {

        if (!AppFiles.dir.exists()) {
            AppFiles.dir.mkdirs();
        }

        if (!AppFiles.TASKS_FILE.exists()) {
            AppFiles.TASKS_FILE.createNewFile();
        }
    }
}