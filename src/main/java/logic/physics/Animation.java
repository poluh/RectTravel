package logic.physics;

import GUI.drawing.Drawer;
import javafx.scene.canvas.Canvas;

public class Animation {

    private Canvas canvas;
    private SquarePhysics squarePhysics;

    public Animation(Canvas canvas) {
        this.squarePhysics = new SquarePhysics(Drawer.getRadiusRect() << 1);
        this.canvas = canvas;
    }

    public void start() {
        var startY = canvas.getLayoutY();
        (new Thread(() -> squarePhysics.calculationOfJump().forEach(value -> {
            delay(30);
            canvas.setLayoutY(startY + value);
        }))).start();
    }

    private void delay(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
