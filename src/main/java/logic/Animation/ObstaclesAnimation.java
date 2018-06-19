package logic.Animation;

import GUI.drawing.Drawer;
import javafx.scene.canvas.Canvas;

public class ObstaclesAnimation implements Animation {

    private Canvas canvas;
    private Drawer drawer;

    public ObstaclesAnimation(Drawer drawer) {
        drawer.createObstacles();
        this.canvas = canvas;
        this.drawer = drawer;
    }


    @Override
    public void start() {
        (new Thread(() -> {
            var startValue = canvas.getLayoutX();
            var endValue = 0 - canvas.getWidth();
            while (startValue >= endValue) {
                delay(10);
                canvas.setLayoutX(startValue);
                startValue--;
            }
        })).start();
    }
}
