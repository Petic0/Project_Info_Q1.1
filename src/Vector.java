public class Vector { //Klasse Vektor
    private final double x, y; // x und y Werte

    public Vector(double x, double y) { //1ter Konstruktor mit konkreten Werten
        this.x = x;
        this.y = y;
    }

    public Vector() { //2ter Konstruktor, falls es keine Parameter gibt einfach 0
        this(0, 0);
    }

    public Vector add(Vector pVector) { // zwei Vektoren addieren
        return new Vector(pVector.x + this.x, pVector.y + this.y);
    }

    public Vector mul(double factor) {  // einen Vektor mit einem Faktor multiplizieren
        return new Vector(this.x * factor, this.y * factor);
    }

    //Getter Methoden
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
