package logic.Animation;

import GUI.drawing.Drawer;
import javafx.scene.canvas.Canvas;
import logic.GameProcessor;

public class ObstaclesAnimation implements Animation {

    private Canvas canvas;
    private Drawer drawer;

    public ObstaclesAnimation(Drawer drawer) {
        this.canvas = drawer.getObstaclesCanvas();
        this.drawer = drawer;
    }


    @Override
    public void start() {
        (new Thread(() -> {
            var startValue = canvas.getLayoutX();
            var endValue = 0 - canvas.getWidth();
            while (GameProcessor.isGameRunning()) {
                delay(10);
                canvas.setLayoutX(startValue);
                startValue--;
                if (startValue <= endValue) {
                    drawer.createObstacles();
                    canvas = drawer.getObstaclesCanvas();
                    startValue = canvas.getLayoutX();
                    endValue = 0 - canvas.getWidth();
                }
            }
        })).start();
    }
}
