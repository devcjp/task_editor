package org.example.Practic.scene;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import javafx.scene.text.TextAlignment;
import org.example.Practic.Task;
import org.example.Practic.TaskRepository;
import org.example.Practic.Task_Pane;
import org.example.Practic.app;

public class main_view extends BorderPane {

    public main_view(app app) {

        HBox header = new HBox();
        header.setPrefHeight(60);
        header.setStyle("-fx-background-color: #c9c9c9;");

        Button add_Task = new Button("Добавить");

        add_Task.setOnAction(e -> {
            app.show_add_task_scene();
        });

        header.getChildren().add(add_Task);

        VBox tasksBox = buildTasksList(app);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(tasksBox);
        scrollPane.setFitToWidth(true);

        setTop(header);
        setCenter(scrollPane);
    }


    private VBox buildTasksList(app app) {

        VBox content = new VBox(10);
        content.setLayoutX(50);
        content.setLayoutY(100);
        if (TaskRepository.getTasks().isEmpty()) {
            Label label = new Label("Похоже, у вас нет активных задач.");
            label.setStyle("""
                        -fx-text-fill: #cfcfcf;
                        -fx-font-size: 20px;
                        -fx-font-weight: bold;
                    
                        -fx-background-color:
                            linear-gradient(to bottom right, #2f2f2f, #252525);
                    
                        -fx-padding: 25 40 25 40;
                    
                        -fx-background-radius: 18;
                        -fx-border-radius: 18;
                    
                        -fx-border-color: #3f3f3f;
                        -fx-border-width: 1;
                    """);
            label.setWrapText(true);
            label.setMaxWidth(420);
            label.setAlignment(Pos.CENTER);
            label.setTextAlignment(TextAlignment.CENTER);


            content.setAlignment(Pos.CENTER);
            content.getChildren().add(label);
            System.out.println("build_tasks_list null!");
            return content;
        }

        for (Task task_out : TaskRepository.getTasks()) {
                Task_Pane task_pane =
                        new Task_Pane(app, task_out);
                content.getChildren().add(task_pane);

        }

        return content;
    }
}