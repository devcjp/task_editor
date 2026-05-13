package org.example.Practic.scene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.example.Practic.Task;
import org.example.Practic.TaskRepository;
import org.example.Practic.app;

public class add_task_view extends VBox {

    public add_task_view(app app) {

        setSpacing(15);

        setPadding(new Insets(30));

        setAlignment(Pos.TOP_CENTER);

        Label label =
                new Label(
                        "Добавление новой задачи"
                );

        TextField name =
                new TextField();

        name.setPromptText("Имя задачи");

        TextField task =
                new TextField();

        task.setPromptText("Описание");

        Button add =
                new Button("Добавить");

        Button exit =
                new Button("Назад");

        add.setOnAction(e -> {

            if (!name.getText().isEmpty()
                    && !task.getText().isEmpty()) {

                TaskRepository.addTask(
                        new Task(
                                name.getText(),
                                task.getText(),
                                false
                        )
                );

                app.show_main_scene();
            }
        });

        exit.setOnAction(e -> {
            app.show_main_scene();
        });
        getStyleClass().add("add-task-root");

        label.getStyleClass().add("title-label");

        add.getStyleClass().add("accent-button");

        exit.getStyleClass().add("secondary-button");
        getChildren().addAll(
                label,
                name,
                task,
                add,
                exit
        );
    }
}