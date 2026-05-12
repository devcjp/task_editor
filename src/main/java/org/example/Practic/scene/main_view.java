package org.example.Practic.scene;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import javafx.scene.text.TextAlignment;
import org.example.Practic.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class main_view extends BorderPane {


    private SortingParams sortParam = SortingParams.BY_TIME;

    public main_view(app app) {
        System.out.println(this);
        HBox header = new HBox();
        header.setPrefHeight(60);
        header.setStyle("-fx-background-color: #c9c9c9;");

        Button add_Task = new Button("Добавить");


        add_Task.setOnAction(e -> {
            app.show_add_task_scene();
        });



        Button open_sort_params = new Button("Сортировка");
        open_sort_params.setOnAction(e -> {
            app.show_windown_sort_params(this);

        });

        header.getChildren().addAll(add_Task, open_sort_params);
setCenter(buildTasksList(app));
        setTop(header);



    }


    public void setSortParam(SortingParams sortParam) {
        this.sortParam = sortParam;
        System.out.println(this);
        System.out.println(sortParam);
    }

    private ListView<Task> buildTasksList(app app) {

        ObservableList<Task> tasks =
                TaskRepository.getTasks();

        ListView<Task> listView =
                new ListView<>(tasks);

        listView.setFocusTraversable(false);
        listView.setStyle("""
        -fx-background-color: #1f1f1f;
        -fx-padding: 15;
    """);

        listView.setCellFactory(param -> new ListCell<>() {

            @Override
            protected void updateItem(Task task,
                                      boolean empty) {

                super.updateItem(task, empty);

                if (empty || task == null) {

                    setText(null);
                    setGraphic(null);

                    return;
                }

                Task_Pane pane =
                        new Task_Pane(app, task);

                pane.setMaxWidth(600);

                VBox wrapper = new VBox(pane);

                wrapper.setAlignment(Pos.TOP_CENTER);

                wrapper.setPadding(
                        new Insets(8, 0, 8, 0)
                );

                setText(null);

                setGraphic(wrapper);

                setContentDisplay(
                        ContentDisplay.GRAPHIC_ONLY
                );

                setStyle("""
                -fx-background-color: transparent;
                -fx-padding: 0;
            """);
            }
        });

        Label label =
                new Label(
                        "Похоже, у вас нет активных задач."
                );

        label.setStyle("""
        -fx-text-fill: #cfcfcf;
        -fx-font-size: 20px;
        -fx-font-weight: bold;

        -fx-background-color:
            linear-gradient(to bottom right,
            #2f2f2f,
            #252525);

        -fx-padding: 25 40 25 40;

        -fx-background-radius: 18;
        -fx-border-radius: 18;

        -fx-border-color: #3f3f3f;
        -fx-border-width: 1;
    """);
    listView.getStyleClass().add("list-view");
        listView.setPlaceholder(label);

        return listView;
    }



}