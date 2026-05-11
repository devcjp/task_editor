package org.example.Practic.scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import org.example.Practic.Task;
import org.example.Practic.app;

public class window_add_note extends StackPane {
    public window_add_note(app app, Task task) {
        this.setHeight(400);
        this.setWidth(500);


        String btnStyle = """
                    -fx-background-color: #3c3f41;
                    -fx-text-fill: white;
                    -fx-background-radius: 10;
                    -fx-padding: 8 16 8 16;
                    -fx-font-size: 13px;
                    -fx-cursor: hand;
                """;


        Button add = new Button("add note");

        add.setOnAction(e -> {

            this.getChildren().clear();

            VBox root = new VBox(15);

            root.setStyle("""
                        -fx-background-color:
                            linear-gradient(to bottom right, #2b2b2b, #1f1f1f);
                    
                        -fx-padding: 20;
                        -fx-background-radius: 16;
                        -fx-border-radius: 16;
                        -fx-border-color: #3d3d3d;
                    """);

            root.setPrefWidth(420);

            Label title = new Label("New note");

            title.setStyle("""
                        -fx-text-fill: white;
                        -fx-font-size: 18px;
                        -fx-font-weight: bold;
                    """);

            TextField note = new TextField();

            note.setPromptText("Write note...");

            note.setStyle("""
                        -fx-background-color: #3a3a3a;
                        -fx-text-fill: white;
                        -fx-background-radius: 10;
                        -fx-padding: 10;
                        -fx-font-size: 14px;
                    """);

            HBox controls = new HBox(10);

            Button add_new_note = new Button("Add");

            Button exit = new Button("Exit");

            exit.setOnAction(e2 -> {
                this.setVisible(false);
                this.setManaged(false);

            });

            add_new_note.setStyle(btnStyle);
            exit.setStyle(btnStyle);

            controls.getChildren().addAll(
                    add_new_note,
                    exit
            );

            root.getChildren().addAll(
                    title,
                    note,
                    controls
            );

            add_new_note.setOnAction(e1 -> {

                task.addNote(note.getText());

                this.setVisible(false);
                this.setManaged(false);

                app.show_main_scene();
            });

            this.getChildren().add(root);
        });
        //Button change_note = new Button("Change note");
//
        //change_note.setOnAction(e -> {
        //    this.getContent().clear();
        //    HBox hBox = new HBox();
        //    hBox.getChildren().addAll(buildNoteList(task));
        //    this.getContent().addAll(hBox);
        //});

        Button save_and_axit = new Button("+");
        save_and_axit.setOnAction(e2 -> {
            this.setVisible(false);
            this.setManaged(false);
// change_note.setVisible(false);
        });


        add.setStyle(btnStyle);
        // change_note.setStyle(btnStyle);
        save_and_axit.setStyle(btnStyle);


        VBox root = new VBox(15);

        root.setStyle("""
                    -fx-background-color:
                        linear-gradient(to bottom right, #2b2b2b, #1e1e1e);
                
                    -fx-padding: 20;
                    -fx-background-radius: 18;
                    -fx-border-radius: 18;
                    -fx-border-color: #3a3a3a;
                    -fx-border-width: 1;
                """);


        root.getChildren().addAll(add, save_and_axit);
        this.getChildren().addAll(root);
    }

}
