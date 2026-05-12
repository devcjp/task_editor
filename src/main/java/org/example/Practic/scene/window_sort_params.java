package org.example.Practic.scene;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.example.Practic.SortingParams;
import org.example.Practic.app;

public class window_sort_params extends StackPane {

        public window_sort_params(app app, main_view mainView) {

            Button sort_bytime = new Button("Сортировка по времени +");
            sort_bytime.setOnAction(e -> {
                mainView.setSortParam(SortingParams.BY_TIME);
                app.show_main_scene();
            });

            Button sort_bybacktime = new Button("Сортировка по времени -");
            sort_bybacktime.setOnAction(e -> {
                mainView.setSortParam(SortingParams.BY_BACK_TIME);
                app.show_main_scene();
            });

            Button sort_bycompleted = new Button("Сортировка по выполненным +");
            sort_bycompleted.setOnAction(e -> {
                mainView.setSortParam(SortingParams.BY_COMPLETED);
                app.show_main_scene();
            });

            Button sort_bybackcompleted = new Button("Сортировка по выполненным -");
            sort_bybackcompleted.setOnAction(e -> {
                mainView.setSortParam(SortingParams.BY_BACK_COMPLETED);
                app.show_main_scene();
            });

            VBox content = new VBox();
            content.getChildren().addAll(
                    sort_bytime,
                    sort_bybacktime,
                    sort_bycompleted,
                    sort_bybackcompleted
            );

            getChildren().add(content);
        }
    }


