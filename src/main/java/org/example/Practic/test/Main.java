package org.example.Practic.test;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javafx.scene.image.ImageView;
import javafx.util.Duration;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        System.out.println(getClass().getResource("/images/icon.jpeg"));
        Pane root = new Pane();

        Label label = new Label("Привет!");
        label.setLayoutX(35);
        label.setLayoutY(55);
        label.getStyleClass().add("label_hello");
        label.setOnMouseClicked(e -> {
            System.out.println("Клик по тексту!!!");
        });


        Button button = new Button("Кликни!");
        button.setLayoutX(35);
        button.setLayoutY(100);
        button.getStyleClass().add("button_click");

        Button button_exit = new Button("✕");
        button_exit.getStyleClass().add("button_exit");
        button.setLayoutX(100);
        button.setLayoutY(0);
        button_exit.setOnAction(e -> {
            stage.close();

        });


        ScrollPane scrollPane = new ScrollPane();
        VBox content = new VBox(10);
        for (int i = 0; i <= 10; i++) {
            Label label1 = new Label("Элемент" + i);
            content.getChildren().add(label1);
        }
        scrollPane.setLayoutX(350);
        scrollPane.setLayoutY(450);
        scrollPane.getStyleClass().add("scroll-pane");
        scrollPane.setContent(content);

        TextField input = new TextField();
        // PasswordField для паролей.
        input.setPromptText("Введите текст...");
        input.setLayoutX(750);
        input.setLayoutY(50);

        ToggleGroup group = new ToggleGroup();
        RadioButton r1 = new RadioButton("варик 1");
        RadioButton r2 = new RadioButton("варик 2");
        r1.setToggleGroup(group);
        r2.setToggleGroup(group);
        r1.setLayoutX(150);
        r1.setLayoutY(200);
        r2.setLayoutX(175);
        r2.setLayoutY(200);


        Image icon = new Image(getClass().getResource("/images/icon.jpeg").toExternalForm());
        System.out.println(icon.isError());
        System.out.println(icon.getWidth() + " x " + icon.getHeight());
        ImageView icon1 = new ImageView(icon);

        icon1.setFitWidth(32);
        icon1.setFitHeight(32);

        Button btn_with_icon = new Button("Жми!");
        btn_with_icon.setGraphic(icon1);
        btn_with_icon.setContentDisplay(ContentDisplay.LEFT);


        ToggleButton t = new ToggleButton("ON/OFF");
        t.setLayoutX(499);
        t.setLayoutY(155);

        CheckBox checkBox = new CheckBox("Согласен");
        checkBox.setLayoutY(255);
        Pane background = new Pane();
        background.getStyleClass().add("pane_main");
        background.prefWidthProperty().bind(stage.widthProperty());
        background.prefHeightProperty().bind(stage.heightProperty());


        Rectangle rect = new Rectangle(50, 50, Color.BLUE);
        rect.setLayoutY(750);
        rect.setLayoutX(500);


        TranslateTransition tt = new TranslateTransition(Duration.seconds(1), rect);
        tt.setByX(200);
        tt.setAutoReverse(true);
        tt.setCycleCount(TranslateTransition.INDEFINITE);

        FadeTransition ft = new FadeTransition(Duration.seconds(2), rect);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setAutoReverse(true);
        ft.setCycleCount(Animation.INDEFINITE);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, e -> rect.setX(0)),
                new KeyFrame(Duration.seconds(2), e -> rect.setX(200))
        );

        timeline.setAutoReverse(true);
        timeline.setCycleCount(Animation.INDEFINITE);

        ScaleTransition st = new ScaleTransition(Duration.seconds(1), rect);
        st.setToX(1.5);
        st.setToY(1.5);
        st.setAutoReverse(true);
        st.setCycleCount(Animation.INDEFINITE);
        GaussianBlur blur = new GaussianBlur();
        Bloom bloom = new Bloom();
        ParallelTransition pt = new ParallelTransition(rect, tt, ft, st, timeline);
        //btn_with_icon.setOnAction(e ->
        //        ft.play());


        button.setOnAction(e ->
                pt.play());
        rect.setEffect(bloom);
        rect.setEffect(blur);
        System.out.println("Кликнул!🥳: " + input.getText());


        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("one", "two", "tree");
        comboBox.setLayoutX(450);
        comboBox.setLayoutY(550);


        ListView<String> list = new ListView<>();
        list.getItems().addAll("I 1", "I 2");
        list.setLayoutX(585);
        list.setLayoutY(966);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/icon.jpeg")));
        root.getChildren().addAll(background, label, button,
                button_exit,
                scrollPane,
                input, r1, r2, checkBox,
                list, comboBox, t, btn_with_icon, rect);

        Scene scene = new Scene(root, 1000, 1000);
        scene.getStylesheets().add(getClass().getResource("/main.css").toExternalForm());

        stage.setResizable(false);
        // stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Мое первое JavaFX приложение!!!");
        stage.setScene(scene);
        stage.show();
    }
}