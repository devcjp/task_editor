package org.example.Practic.scene;


import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import org.example.Practic.Task;
import org.example.Practic.app;


public class change_task_menu extends Pane {
    public change_task_menu(app app, Task task) {
        TextField input_name = new TextField();
        input_name.getStyleClass().add("text-field");
        input_name.setPromptText(task.getName());
        TextField input_task = new TextField();
        input_task.setPromptText(task.getTask());
        Button button_save_and_exit = new Button("save and exit");
        button_save_and_exit.getStyleClass().add("danger-button");
        button_save_and_exit.setOnAction(e -> {
            task.setTask(input_name.getText(), input_task.getText());
            app.show_main_scene();
        });
        this.getChildren().addAll(input_name, input_task, button_save_and_exit);


    }
}
