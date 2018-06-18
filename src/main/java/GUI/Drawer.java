package GUI;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import logic.Point;

import java.util.stream.IntStream;

public class Drawer {

    private GraphicsContext context;
    private int height;
    private int width;
    private Point centerRect;
    private final int radiusRect = 20;

    public Drawer(Canvas canvas) {
        context = canvas.getGraphicsContext2D();
        height = (int) canvas.getHeight();
        width = (int) canvas.getWidth();
        centerRect = new Point(width / 2, height / 2);
    }

    public void fillBackground() {
        context.setFill(Color.AQUA);
        context.fillRect(0, 0, height, width);
    }

    public void fillRectangle(int angle) {
        context.fillOval(centerRect.x - radiusRect, centerRect.y - radiusRect,
                radiusRect * 2, radiusRect * 2);
        var pointOfRect = IntStream.range(0, 4).mapToObj(i ->
                getPointOfCircle(angle + (90 * i))).toArray(Point[]::new);
        IntStream.range(0, 3).forEachOrdered(i -> paintLine(pointOfRect[i], pointOfRect[i + 1]));
    }

    private void paintLine(Point start, Point end) {
        context.setStroke(Color.RED);
        context.moveTo(start.x, start.y);
        context.lineTo(end.x, end.y);
        context.stroke();
    }

    private Point getPointOfCircle(int angle) {
        return new Point((int) (centerRect.x + radiusRect * Math.cos(angle)),
                (int) (centerRect.y + radiusRect * Math.sin(angle)));
    }
}
