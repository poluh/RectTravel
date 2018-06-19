package GUI;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import logic.Point;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Drawer {

    private GraphicsContext context;
    private int height;
    private int width;
    private Point centerRect;
    private final int radiusRect = 35;

    public Drawer(Canvas canvas) {
        context = canvas.getGraphicsContext2D();
        height = (int) canvas.getHeight();
        width = (int) canvas.getWidth();
        centerRect = new Point(width / 2, height / 2);
        context.setLineWidth(3);
    }

    public void fillBackground() {
        context.setFill(Color.WHITE);
        context.fillRect(0, 0, height, width);
    }

    public void fillRectangle() {
        context.setFill(Color.RED);
        context.fillRect(centerRect.x - radiusRect, centerRect.y - radiusRect,
                radiusRect << 1, radiusRect << 1);
    }

    public void jump(double angle) {
        context.getCanvas().setRotate(angle);
    }

    private void clearLayer(GraphicsContext context) {
        context.clearRect(0, 0, context.getCanvas().getWidth(), context.getCanvas().getHeight());
    }
}
