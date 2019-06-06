package valueobjects;

import java.util.Random;

public class Point2 {

    private float x;
    private float y;

    private Point2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    static Point2 ofCartesian(float x, float y) {
        return new Point2(x, y);
    }

    static Point2 ofPolar(float r, float fi) {
        return new Point2(calculateX(r, fi), calculateY(r, fi));
    }

    private static float calculateX(float r, float fi) {
        // TODO
        return new Random().nextFloat();
    }

    private static float calculateY(float r, float fi) {
        // TODO
        return new Random().nextFloat();
    }
}
