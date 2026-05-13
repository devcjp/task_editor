package org.example.Practic.scene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.example.Practic.Task;
import org.example.Practic.app;

public class window_add_note extends StackPane {

    public window_add_note(
            app app,
            Task task
    ) {

        getStyleClass().add("overlay-root");

        VBox root =
                new VBox(18);

        root.getStyleClass()
                .add("note-window");

        root.setAlignment(Pos.CENTER);

        root.setPadding(new Insets(25));

        Label title =
                new Label("Новая заметка");

        title.getStyleClass()
                .add("title-label");

        TextField note =
                new TextField();

        note.setPromptText(
                "Введите заметку"
        );

        note.getStyleClass()
                .add("text-field");

        Button add =
                new Button("Добавить");

        add.getStyleClass()
                .add("accent-button");

        Button exit =
                new Button("Закрыть");

        exit.getStyleClass()
                .add("secondary-button");

        HBox controls =
                new HBox(12);

        controls.setAlignment(
                Pos.CENTER
        );

        controls.getChildren().addAll(
                add,
                exit
        );

        add.setOnAction(e -> {

            if(!note.getText().isEmpty()) {

                task.addNote(
                        note.getText()
                );

                app.show_main_scene();
            }
        });

        exit.setOnAction(e -> {

            this.setVisible(false);

            this.setManaged(false);
        });

        root.getChildren().addAll(
                title,
                note,
                controls
        );

        getChildren().add(root);
    }
}