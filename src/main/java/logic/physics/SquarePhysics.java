package logic.physics;

import java.util.ArrayList;
import java.util.List;

public class SquarePhysics {

    private static final double accelerationOfGravity = 4.9;
    private double speed;
    private int height;

    public SquarePhysics(int height) {
        this.height = height;
    }

    public List<Double> calculationOfJump() {
        var result = new ArrayList<Double>();
        var maxTime = Math.sqrt((height << 1) / accelerationOfGravity) / 2;
        speed = -(accelerationOfGravity * maxTime * maxTime * maxTime);
        var time = 0.0;
        while (time < maxTime) {
            speed += accelerationOfGravity * time;
            result.add(getHeightOfTime(time));

            time += 0.1;
        }
        return result;
    }

    private double getHeightOfTime(double time) {
        return speed * time + (accelerationOfGravity * time * time) / 2;
    }
}
