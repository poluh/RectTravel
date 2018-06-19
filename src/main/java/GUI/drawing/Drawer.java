package GUI.drawing;

import GUI.ScreenCreator;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Drawer {

    private static final int RADIUS_RECT = 35;
    private Canvas backgroundCanvas;
    private Canvas rectangleCanvas;
    private GraphicsContext backgroundContext;
    private GraphicsContext rectangleContext;

    public void createGameField() {
        createBackground();
        createRectangle();
        shiftGameSpace(0);
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

    public void rotateRectangle(double angle) {
        rectangleContext.getCanvas().setRotate(angle);
    }

    public Canvas getBackgroundCanvas() {
        return backgroundCanvas;
    }

    public Canvas getRectangleCanvas() {
        return rectangleCanvas;
    }

    private static void clearLayer(GraphicsContext context) {
        context.clearRect(0, 0, context.getCanvas().getWidth(), context.getCanvas().getHeight());
    }

    public static int getRadiusRect() {
        return RADIUS_RECT;
    }
}
