package valueobjects;

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
        //
    }

}
