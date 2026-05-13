package org.example.Practic.scene;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import javafx.scene.text.TextAlignment;
import org.example.Practic.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class main_view extends BorderPane {


    public static SortingParams sortParam = SortingParams.BY_TIME;
    private Button sortButton;

    public main_view(app app) {
        getStyleClass().add("main-root");

//        HBox frame = new HBox();
//
//Button exit = new Button("к");
//exit.setOnAction(e->{
//    app.
//
//        }
//        );
//Button colapse = new Button("с");


        HBox header = new HBox(15);

        header.getStyleClass().add("header");

        header.setAlignment(Pos.CENTER_LEFT);

        header.setPadding(
                new Insets(15)
        );

        Button addTask =
                new Button("Добавить");

        addTask.getStyleClass()
                .add("accent-button");

        addTask.setOnAction(e -> {
            app.show_add_task_scene();
        });

        TextField searchTextField =
                new TextField();

        searchTextField.setPromptText(
                "Поиск по задачам"
        );

        HBox.setHgrow(
                searchTextField,
                Priority.ALWAYS
        );

        Button searchButton =
                new Button("Поиск");

        searchButton.getStyleClass()
                .add("button");
        searchTextField.textProperty().addListener(
                (obs, oldText, newText) -> {

                    searchButton.getStyleClass()
                            .remove("selected-orange");

                    if (!newText.isEmpty()) {

                        searchButton.getStyleClass()
                                .add("selected-orange");
                    }
                });
        searchButton.setOnAction(e -> {

            String query =
                    searchTextField.getText();

            if (query.isEmpty()) {

                setCenter(
                        buildTasksList(
                                app,
                                TaskRepository.getTasks()
                        )
                );

                return;
            }

            setCenter(
                    buildTasksList(
                            app,
                            TaskRepository.searchTasks(query)
                    )
            );
        });

        Button reset =
                new Button("Сброс");

        reset.getStyleClass()
                .add("secondary-button");

        reset.setOnAction(e -> {

            sortParam = SortingParams.BY_TIME;
            updateHeaderState();
            searchTextField.clear();

            setCenter(
                    buildTasksList(
                            app,
                            TaskRepository.getTasks()
                    )
            );
        });

        sortButton =
                new Button("Сортировка");

        sortButton.getStyleClass()
                .add("button");
        if (sortParam != SortingParams.BY_TIME) {
            sortButton.getStyleClass().add("selected-orange");

        }
        sortButton.setOnAction(e -> {
            app.show_windown_sort_params(this);
        });

        Region spacer = new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        header.getChildren().addAll(
                addTask,
                sortButton,
                spacer,
                searchTextField,
                searchButton,
                reset
        );

        setTop(header);

        setCenter(
                buildTasksList(
                        app,
                        TaskRepository.getTasks()
                )
        );
    }


    public void setSortParam(SortingParams sortParam) {
        this.sortParam = sortParam;
        updateHeaderState();
        System.out.println(this);
        System.out.println(sortParam);
    }

    private void updateHeaderState() {

        sortButton.getStyleClass()
                .remove("selected-orange");

        if (sortParam != SortingParams.BY_TIME) {

            sortButton.getStyleClass()
                    .add("selected-orange");
        }
    }

    public void refreshTasks(app app) {

        setCenter(buildTasksList(app, TaskRepository.getTasks()));
    }

    private ListView<Task> buildTasksList(app app, ObservableList<Task> tasksV) {

        ObservableList<Task> tasks = tasksV;

        tasks = sortingList(tasks);
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

    private ObservableList<Task> sortingList(ObservableList<Task> tasks) {
        ObservableList<Task> sorted = FXCollections.observableArrayList(tasks);

        switch (sortParam) {

            case BY_COMPLETED -> sorted = sorted.filtered(
                    Task::get_completed
            );
            case BY_BACK_COMPLETED -> sorted = sorted.filtered(
                    task -> !task.get_completed()
            );
            case BY_BACK_TIME -> FXCollections.reverse(sorted);
        }
        return sorted;


    }


}