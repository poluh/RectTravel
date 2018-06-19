package logic.Animation;

import GUI.drawing.Drawer;
import javafx.scene.canvas.Canvas;
import logic.physics.SquarePhysics;

public class SquareAnimation implements Animation {

    private static int jumpDelay = 20;
    private Canvas canvas;
    private SquarePhysics squarePhysics;

    public SquareAnimation(Canvas canvas) {
        this.squarePhysics = new SquarePhysics(Drawer.getRadiusRect() << 1);
        this.canvas = canvas;
    }

    @Override
    public void start() {
        rotateSquare();
        var startY = canvas.getLayoutY();
        (new Thread(() -> squarePhysics.calculationOfJump().forEach(value -> {
            delay(jumpDelay);
            canvas.setLayoutY(startY + value);
        }))).start();
    }

    private void rotateSquare() {
        (new Thread(() -> {
            delay(jumpDelay);
            var rotateValue = 0;
            while (rotateValue <= 360) {
                delay(1);
                rotateValue++;
                canvas.setRotate(rotateValue);
            }
            canvas.setRotate(0);
        })).start();

    }
}
