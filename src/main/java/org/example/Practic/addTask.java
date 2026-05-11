package org.example.Practic;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;


public class addTask {
    TextField name;

    /*public Scene add_task_menu() {
        Scene scene = new Scene(root, 800, 500);


        return scene;
    }*/

    public String getName() {
        return name.getText();

    }
}
