package GUI.drawing;

import GUI.ScreenCreator;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class Drawer {

    private static final int RADIUS_RECT = 35;
    private Canvas backgroundCanvas;
    private Canvas rectangleCanvas;
    private Canvas obstaclesCanvas;
    private static GraphicsContext obstaclesContex;
    private static GraphicsContext backgroundContext;
    private static GraphicsContext rectangleContext;

    public void createGameField() {
        createBackground();
        createRectangle();
        shiftGameSpace(0);
    }

    public void createObstacles() {
        var height = new Random().nextInt(RADIUS_RECT) + RADIUS_RECT;
        var width = new Random().nextInt(10) + 10;

        obstaclesCanvas = new Canvas(width, height);
        obstaclesContex = obstaclesCanvas.getGraphicsContext2D();
        obstaclesContex.setFill(Color.FIREBRICK);
        obstaclesContex.fillRect(0, 0, width, height);
    }

    private void createBackground() {
        backgroundCanvas = new Canvas(ScreenCreator.getWIDTH(), ScreenCreator.getHEIGHT());
        backgroundContext = backgroundCanvas.getGraphicsContext2D();
        backgroundContext.setFill(Color.GRAY);
        backgroundContext.fillRect(0, 0, ScreenCreator.getWIDTH(), ScreenCreator.getHEIGHT());
    }

    private void createGameSpace(int layoutY) {
        backgroundContext.setFill(Color.FIREBRICK);
        backgroundContext.fillRect(0, layoutY, ScreenCreator.getWIDTH(), ScreenCreator.getHEIGHT());
    }

    private void createRectangle() {
        rectangleCanvas = new Canvas(RADIUS_RECT << 1, RADIUS_RECT << 1);
        rectangleCanvas.setLayoutY((ScreenCreator.getHEIGHT() >> 1) - RADIUS_RECT);
        rectangleCanvas.setLayoutX((ScreenCreator.getWIDTH() >> 1) - RADIUS_RECT);
        rectangleContext = rectangleCanvas.getGraphicsContext2D();
        rectangleContext.setFill(Color.RED);
        rectangleContext.fillRect(0, 0, RADIUS_RECT << 1, RADIUS_RECT << 1);
    }

    public void shiftGameSpace(int shift) {
        clearLayer(backgroundContext);
        createBackground();
        createGameSpace((ScreenCreator.getHEIGHT() >> 1) + RADIUS_RECT + shift);
    }

    public Canvas getBackgroundCanvas() {
        return backgroundCanvas;
    }

    public Canvas getRectangleCanvas() {
        return rectangleCanvas;
    }

    public Canvas getObstaclesCanvas() {
        return obstaclesCanvas;
    }

    private static void clearLayer(GraphicsContext context) {
        context.clearRect(0, 0, context.getCanvas().getWidth(), context.getCanvas().getHeight());
    }

    public static int getRadiusRect() {
        return RADIUS_RECT;
    }
}
