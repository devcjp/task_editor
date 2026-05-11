package org.example.Practic.scene;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import org.example.Practic.Task;
import org.example.Practic.app;


public class window_change_note extends StackPane {
    public window_change_note(app app, Task task, String text) {
        HBox main = new HBox();


        Button change_note = new Button("Изменить");
        change_note.setOnAction(e -> {
            main.getChildren().clear();
            TextField text_new = new TextField();
            text_new.setPromptText("Новая заметка.");

            Button save = new Button("Сохранить и выйти");
            save.setOnAction(e1 -> {
                task.changeNote(text, text_new.getText());
                main.getChildren().clear();
                app.show_main_scene();
            });

            main.getChildren().addAll(text_new,save);

        });
        Button delete_note = new Button("Удалить");
        delete_note.setOnAction(e1->{
            task.delNote(text);
            app.show_main_scene();
        });
        Button close = new Button("-");
        close.setOnAction(e2->{
            app.show_main_scene();

        });
main.getChildren().addAll(change_note, delete_note, close);
this.getChildren().add(main);
    }

}
