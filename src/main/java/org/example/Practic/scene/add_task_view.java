package org.example.Practic.scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import org.example.Practic.Task;
import org.example.Practic.TaskRepository;
import org.example.Practic.app;

public class add_task_view extends Pane {
    public add_task_view(app app) {
        Label label = new Label("Добавление новой задачи.");

        javafx.scene.control.TextField name = new TextField("имя задачи");
        TextField task = new TextField("таск");
        task.setLayoutX(450);

        Button exit = new Button("эксит");
        exit.setLayoutY(455);
        exit.setOnAction(e -> {
            app.show_main_scene();
        });
        Button button = new Button();
        button.setLayoutX(15);
        button.setLayoutY(35);

        button.setOnAction(e -> {
            System.out.println(task.getText());
            System.out.println(name.getText());
            if (!name.getText().isEmpty() && !task.getText().isEmpty()) {
                TaskRepository.addTask(new Task(name.getText(), task.getText(), false));
                System.out.println("zadacha dobavlena!");
            } else {
                System.out.println("polya pustie");
            }


        });
        Button button1 = new Button("vivod zadach");
        button1.setOnAction(e1->{
            System.out.println(TaskRepository.getTasks());

        });
        button1.setLayoutY(199);
        button1.setLayoutX(350);

        this.getChildren().addAll(label, button, name, task, exit, button1);
    }
}
