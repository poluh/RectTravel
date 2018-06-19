package GUI;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

import static java.lang.Thread.sleep;

public class ScreenCreator extends Application {
    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(300, 300);

        Group root = new Group();
        root.getChildren().addAll(canvas);

        Scene scene = new Scene(root, 300, 300);

        Drawer drawer = new Drawer(canvas);
        drawer.fillBackground();
        drawer.fillRectangle();

        canvas.setOnMouseClicked(event -> jump(drawer));

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void jump(Drawer drawer) {
        (new Thread(() -> {
            var angle = 0.0;
            var slowing = 2;
            while (angle < 90 * 6) {
                try {
                    sleep(slowing);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                var finalAngle = angle;
                Platform.runLater(() -> drawer.jump(finalAngle));
                angle += 1.5;
            }
        })).start();
    }

}
