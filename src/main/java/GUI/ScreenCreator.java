package GUI;

import GUI.drawing.Drawer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.Animation.SquareAnimation;

public class ScreenCreator extends Application {
    private static final int HEIGHT = 400;
    private static final int WIDTH = 800;

    @Override
    public void start(Stage primaryStage) {

        Group root = new Group();

        Scene scene = new Scene(root, WIDTH, HEIGHT);

        Drawer drawer = new Drawer();
        drawer.createGameField();

        root.getChildren().addAll(drawer.getBackgroundCanvas(), drawer.getRectangleCanvas());

        drawer.getRectangleCanvas().setOnMouseClicked(event -> {
            SquareAnimation squareAnimation = new SquareAnimation(drawer.getRectangleCanvas());
            squareAnimation.start();
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

}
