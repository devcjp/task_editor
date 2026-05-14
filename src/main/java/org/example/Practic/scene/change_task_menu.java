package org.example.Practic.scene;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.example.Practic.Task;
import org.example.Practic.app;


public class change_task_menu extends VBox {
    public change_task_menu(app app, Task task) {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(16);
        this.setPadding(new Insets(32));

        TextField input_name = new TextField();
        input_name.getStyleClass().add("text-field");
        input_name.setPromptText(task.getName());

        TextField input_task = new TextField();
        input_task.getStyleClass().add("text-field");
        input_task.setPromptText(task.getTask());

        Button button_save_and_exit = new Button("Сохранить");
        button_save_and_exit.getStyleClass().add("accent-button");
        button_save_and_exit.setOnAction(e -> {
            String newName = input_name.getText().isBlank() ? task.getName() : input_name.getText();
            String newTask = input_task.getText().isBlank() ? task.getTask() : input_task.getText();
            task.setTask(newName, newTask);
            app.show_main_scene();


        });

        this.getChildren().addAll(input_name, input_task, button_save_and_exit);
    }
}
