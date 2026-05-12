package org.example.Practic;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.example.Practic.save.create_save;
import org.example.Practic.save.save_saves;
import org.example.Practic.scene.*;

import java.io.IOException;

public class app extends Application {
    private Stage stage;
    private Scene scene;
    private StackPane root;
    private main_view mainView;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        create_save.create_dir();
        TaskRepository.load_save();
        mainView = new main_view(this);
        stage.setOnCloseRequest(e -> {

            try {
                save_saves.save_tasks();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            Platform.exit();
            System.exit(0);

        });




        show_main_scene();
        stage.setScene(scene);
        stage.setTitle("Редактор задач");
        Image icon = new Image(getClass().getResourceAsStream("/images/icon.png"));
        System.out.println("Icon status error: " + icon.isError());
        stage.getIcons().add(icon);

        show();
    }

    public void show_windown_sort_params(main_view main_view) {
        root.getChildren().clear();
        window_sort_params win = new window_sort_params(this, main_view);
        root.getChildren().add(win);

    }

    public void show_window_change_note(Task task, String text) {
        root.getChildren().clear();
        window_change_note sta = new window_change_note(this, task, text);
        root.getChildren().add(sta);

    }

    public void show_window_add_note(Task task) {

        window_add_note window =
                new window_add_note(this, task);

        root.getChildren().add(window);
    }

    public void show_change_task_menu_scene(Task task) {
        scene = new Scene(new change_task_menu(this, task), 800, 600);
        show();
    }

    public void show_main_scene() {

        root = new StackPane();
        root.getChildren().add(mainView);
        scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(getClass().getResource("/main.css").toExternalForm());
        show();
    }

    public void show_add_task_scene() {
        scene = new Scene(new add_task_view(this), 800, 600);
        show();
    }

    public void show() {
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}
