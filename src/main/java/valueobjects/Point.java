package valueobjects;

import java.util.Random;

public class Point {

    private float x;
    private float y;

    public Point(float x, float y, boolean cartesian) {
        if(cartesian) {
            initFromCartesianCoords(x, y);
        }
        else {
            initFromPolarCoords(x, y);
        }
    }

    private void initFromCartesianCoords(float x, float y) {
        this.x = x;
        this.y = y;
    }

    private void initFromPolarCoords(float r, float fi) {
        this.x = calculateX(r, fi);
        this.y = calculateY(r, fi);
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
