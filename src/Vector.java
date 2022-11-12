public class Vector {
    private final double x, y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector() {
        this(0, 0);
    }

    public Vector add(Vector pVector) {
        return new Vector(pVector.x + this.x, pVector.y + this.y);
    }

    public Vector mul(double factor) {
        return new Vector(this.x * factor, this.y * factor);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
