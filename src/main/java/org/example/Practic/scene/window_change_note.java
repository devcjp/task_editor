package org.example.Practic.scene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.example.Practic.Task;
import org.example.Practic.app;

public class window_change_note extends StackPane {

    public window_change_note(
            app app,
            Task task,
            String text
    ) {

        getStyleClass().add("overlay-root");

        VBox root =
                new VBox(18);

        root.getStyleClass().add(
                "note-window"
        );

        root.setAlignment(Pos.CENTER);

        root.setPadding(new Insets(25));

        Button change_note =
                new Button("Изменить");

        change_note.getStyleClass()
                .add("accent-button");

        Button delete_note =
                new Button("Удалить");

        delete_note.getStyleClass()
                .add("danger-button");

        Button close =
                new Button("Закрыть");

        close.getStyleClass()
                .add("secondary-button");

        VBox editorBox =
                new VBox(12);

        change_note.setOnAction(e -> {

            editorBox.getChildren().clear();

            TextField text_new =
                    new TextField();

            text_new.setPromptText(
                    "Новая заметка"
            );

            text_new.getStyleClass()
                    .add("text-field");

            HBox.setHgrow(
                    text_new,
                    Priority.ALWAYS
            );

            Button save =
                    new Button(
                            "Сохранить"
                    );

            save.getStyleClass()
                    .add("accent-button");

            save.setOnAction(e1 -> {

                task.changeNote(
                        text,
                        text_new.getText()
                );

                app.show_main_scene();
            });

            HBox controls =
                    new HBox(10);

            controls.setAlignment(
                    Pos.CENTER
            );

            controls.getChildren().addAll(
                    text_new,
                    save
            );

            editorBox.getChildren()
                    .add(controls);
        });

        delete_note.setOnAction(e1 -> {

            task.delNote(text);

            app.show_main_scene();
        });

        close.setOnAction(e2 -> {
            app.show_main_scene();
        });

        HBox buttons =
                new HBox(12);

        buttons.setAlignment(Pos.CENTER);

        buttons.getChildren().addAll(
                change_note,
                delete_note,
                close
        );

        root.getChildren().addAll(
                buttons,
                editorBox
        );

        getChildren().add(root);
    }
}