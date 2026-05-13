package org.example.Practic;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class Task_Pane extends HBox {
    public Task_Pane(app app, Task task) {

        setSpacing(10);
        setPadding(new Insets(10));

        setStyle(
                "-fx-background-color: #2b2b2b;" +
                        "-fx-background-radius: 12;"
        );

        // --- Заголовок ---
        Label name = new Label(task.getName());
        name.setStyle(
                "-fx-text-fill: white;" +
                        "-fx-font-size: 16px;" +
                        "-fx-font-weight: bold;"
        );
        name.setWrapText(true);
        name.setMaxWidth(400);
        // --- Основной текст ---
        Label text = new Label(task.getTask());
        text.setStyle(
                "-fx-text-fill: #d0d0d0;" +
                        "-fx-font-size: 14px;"
        );
        text.setWrapText(true);
        text.setMaxWidth(Double.MAX_VALUE);


        HBox tools = new HBox(25);


        Button change_task = new Button("Редактировать задачу");
        change_task.setOnAction(e -> {
            app.show_change_task_menu_scene(task);

        });

        Button delete_task = new Button("Удалить задачу");
        delete_task.setOnAction(e -> {
            TaskRepository.removeTask(task);
            app.show_main_scene();

        });
        Button note_op = new Button("Заметки");
        note_op.setOnAction(e -> {
            app.show_window_add_note(task);

        });
        // Button add_note = new Button("Добавить заметку.");
        // Button change_note = new Button("Переименовать заметку.");
        // Button delete_note = new Button("Удалить заметку");
        VBox textBox = new VBox(5);
        textBox.getChildren().addAll(name, text);


        VBox content = new VBox(10);

        tools.getChildren().addAll(change_task, delete_task, note_op);


        HBox.setHgrow(textBox, Priority.ALWAYS);
        textBox.setMaxWidth(Double.MAX_VALUE);

        Button completed_button = new Button("Выполнено");
        completed_button.setOnAction(e -> {
            task.set_completed(!task.get_completed());
            updateStyle(task);


        });



        content.getChildren().addAll(textBox, tools,completed_button, buildNoteList(app, task));

        getChildren().add(content);
        updateStyle(task);
    }
    private void updateStyle(Task task) {
        getStyleClass().removeAll("task-pane","task-completed");
        if (task.get_completed()) {
            getStyleClass().add("task-completed");
        } else {
            getStyleClass().add("task-pane");
        }
    }
    public VBox buildNoteList(app app, Task task) {

        VBox notes = new VBox(10);

        for (String note : task.get_notes()) {

            Label label = new Label(note);

            label.setWrapText(true);

            label.setStyle("""
                        -fx-background-color: #3a3a3a;
                        -fx-text-fill: #e0e0e0;
                        -fx-padding: 10;
                        -fx-background-radius: 10;
                        -fx-font-size: 13px;
                    """);
            label.setOnMousePressed(e -> {

                app.show_window_change_note(task, label.getText());
                System.out.println("!!!!!");
            });
            notes.getChildren().add(label);
        }

        return notes;
    }

}