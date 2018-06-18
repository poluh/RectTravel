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
        drawer.fillRectangle(10);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
