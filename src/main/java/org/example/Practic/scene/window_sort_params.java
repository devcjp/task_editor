package org.example.Practic.scene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.example.Practic.SortingParams;
import org.example.Practic.app;

import static org.example.Practic.scene.main_view.sortParam;

public class window_sort_params extends StackPane {

    public window_sort_params(
            app app,
            main_view mainView
    ) {

        getStyleClass().add("overlay-root");

        VBox window =
                new VBox(15);

        window.getStyleClass().add("sort-window");

        window.setAlignment(Pos.CENTER);

        window.setPadding(new Insets(25));

        Label title =
                new Label("Сортировка");

        title.getStyleClass().add("title-label");

        Button sortByTime =
                new Button("По времени ↑");

        Button sortByBackTime =
                new Button("По времени ↓");

        Button sortByCompleted =
                new Button("Выполненные ↑");

        Button sortByBackCompleted =
                new Button("Выполненные ↓");

        Button close =
                new Button("Закрыть");

        close.getStyleClass().add(
                "button"
        );

        sortByTime.getStyleClass().add(
                "button"
        );

        sortByBackTime.getStyleClass().add(
                "button"
        );

        sortByCompleted.getStyleClass().add(
                "button"
        );

        sortByBackCompleted.getStyleClass().add(
                "button"
        );

        sortByTime.setMaxWidth(Double.MAX_VALUE);
        sortByBackTime.setMaxWidth(Double.MAX_VALUE);
        sortByCompleted.setMaxWidth(Double.MAX_VALUE);
        sortByBackCompleted.setMaxWidth(Double.MAX_VALUE);

        sortByTime.setOnAction(e -> {

            mainView.setSortParam(
                    SortingParams.BY_TIME
            );
            app.show_main_scene();
        });

        sortByBackTime.setOnAction(e -> {

            mainView.setSortParam(
                    SortingParams.BY_BACK_TIME
            );
            app.show_main_scene();
        });

        sortByCompleted.setOnAction(e -> {

            mainView.setSortParam(
                    SortingParams.BY_COMPLETED
            );
            app.show_main_scene();
        });

        sortByBackCompleted.setOnAction(e -> {
            mainView.setSortParam(
                    SortingParams.BY_BACK_COMPLETED
            );
            app.show_main_scene();
        });

        close.setOnAction(e -> {
            app.show_main_scene();
        });

        exSorts(sortByTime, SortingParams.BY_TIME);
        exSorts(sortByBackTime, SortingParams.BY_BACK_TIME);
        exSorts(sortByCompleted, SortingParams.BY_COMPLETED);
        exSorts(sortByBackCompleted, SortingParams.BY_BACK_COMPLETED);

        window.getChildren().addAll(
                title,
                sortByTime,
                sortByBackTime,
                sortByCompleted,
                sortByBackCompleted,
                close
        );

        getChildren().add(window);
    }

    private void exSorts(Button button, SortingParams param) {
        // Подсветка определенного типа сортировки, если она активна.
        button.getStyleClass()
                .remove("selected-sort");
        if (param==sortParam) button.getStyleClass().add("selected-sort");
    }
}