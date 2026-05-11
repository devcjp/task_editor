package org.example.Practic.scene;


import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import org.example.Practic.Task;
import org.example.Practic.app;


public class change_task_menu extends Pane {
    public change_task_menu(app app, Task task) {
        TextField input_name = new TextField(task.getName());
        input_name.setLayoutX(0);
        input_name.setLayoutY(0);
        TextField input_task = new TextField(task.getTask());
        input_task.setLayoutX(0);
        input_task.setLayoutY(50);
        Button button_save_and_exit = new Button("save and exit");
        button_save_and_exit.setLayoutX(150);
        button_save_and_exit.setLayoutY(0);
        button_save_and_exit.setOnAction(e -> {
            task.setTask(input_name.getText(), input_task.getText());
            app.show_main_scene();
        });
        this.getChildren().addAll(input_name, input_task, button_save_and_exit);


    }
}
