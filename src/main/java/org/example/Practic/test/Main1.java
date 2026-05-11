package org.example.Practic.test;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.embed.swing.SwingFXUtils;

import javax.imageio.ImageIO;
import java.io.File;

public class Main1 extends Application {

    private ImageView imageView = new ImageView();
    private WritableImage currentImage;

    @Override
    public void start(Stage stage) {
        Button loadBtn = new Button("Load");
        Button saveBtn = new Button("Save");
        Button grayBtn = new Button("Grayscale");

        Slider brightnessSlider = new Slider(-0.5, 0.5, 0);
        Slider contrastSlider = new Slider(0.5, 2, 1);

        // 🔴 стили
        loadBtn.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        loadBtn.setOnMouseEntered(e -> loadBtn.setStyle("-fx-background-color: #45a049; -fx-text-fill: white;"));
        loadBtn.setOnMouseExited(e -> loadBtn.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;"));

        // 📂 Загрузка
        loadBtn.setOnAction(e -> {
            FileChooser fc = new FileChooser();
            File file = fc.showOpenDialog(stage);
            if (file != null) {
                Image img = new Image(file.toURI().toString());
                currentImage = new WritableImage(img.getPixelReader(),
                        (int) img.getWidth(),
                        (int) img.getHeight());
                imageView.setImage(currentImage);
            }
        });

        // 💾 Сохранение
        saveBtn.setOnAction(e -> {
            try {
                FileChooser fc = new FileChooser();
                File file = fc.showSaveDialog(stage);
                if (file != null && currentImage != null) {
                    ImageIO.write(SwingFXUtils.fromFXImage(currentImage, null), "png", file);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // 🌫 Grayscale
        grayBtn.setOnAction(e -> {
            if (currentImage == null) return;

            PixelReader pr = currentImage.getPixelReader();
            WritableImage newImg = new WritableImage(
                    (int) currentImage.getWidth(),
                    (int) currentImage.getHeight()
            );
            PixelWriter pw = newImg.getPixelWriter();

            for (int x = 0; x < currentImage.getWidth(); x++) {
                for (int y = 0; y < currentImage.getHeight(); y++) {
                    Color c = pr.getColor(x, y);
                    double gray = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
                    pw.setColor(x, y, new Color(gray, gray, gray, c.getOpacity()));
                }
            }

            currentImage = newImg;
            imageView.setImage(currentImage);
        });

        // 🎚 Яркость / контраст
        Runnable applyAdjustments = () -> {
            ColorAdjust adjust = new ColorAdjust();
            imageView.setEffect(adjust);

            brightnessSlider.setMin(-1);
            brightnessSlider.setMax(1);

            contrastSlider.setMin(-1);
            contrastSlider.setMax(1);

            brightnessSlider.valueProperty().addListener((obs, o, n) -> {
                adjust.setBrightness(n.doubleValue());
            });

            contrastSlider.valueProperty().addListener((obs, o, n) -> {
                adjust.setContrast(n.doubleValue());
            });
        };

        // 🧱 Layout
        HBox controls = new HBox(10,
                loadBtn,
                saveBtn,
                grayBtn,
                new Label("Brightness"),
                brightnessSlider,
                new Label("Contrast"),
                contrastSlider
        );

        controls.setPadding(new Insets(10));

        BorderPane root = new BorderPane();
        root.setTop(controls);
        root.setCenter(new ScrollPane(imageView));

        Scene scene = new Scene(root, 800, 600);

        stage.setTitle("Mini Photoshop");
        stage.setScene(scene);
        stage.show();
    }

    private double clamp(double v) {
        return Math.max(0, Math.min(1, v));
    }

    public static void main(String[] args) {
        launch();
    }
}