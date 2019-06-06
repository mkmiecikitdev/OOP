package valueobjects;

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

    static private float calculateX(float x, float y) {
        // TODO
        return 0;
    }

    static private float calculateY(float x, float y) {
        // TODO
        return 0;
    }

}
