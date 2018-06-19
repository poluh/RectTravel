package logic.physics;

import java.util.ArrayList;
import java.util.List;

public class SquarePhysics {

    private static final double accelerationOfGravity = 4.9;
    private int height;

    public SquarePhysics(int height) {
        this.height = height;
    }

    public List<Double> calculationOfJump() {
        var result = new ArrayList<Double>();
        var maxTime = Math.sqrt((height << 1) / accelerationOfGravity);
        var currentTime = 0.0;

        var currentSpeed = -(accelerationOfGravity * maxTime * maxTime);
        while (currentTime < maxTime) {
            currentTime += 0.1;
            currentSpeed += accelerationOfGravity * currentTime;

            var height = getHeightOfTime(currentTime, currentSpeed);
            if (height < 0) {
                result.add(height);
            } else {
                result.add(0.0);
                break;
            }
        }
        return result;
    }

    private double getHeightOfTime(double time, double speed) {
        return speed * time + (accelerationOfGravity * time * time) / 2;
    }
}
