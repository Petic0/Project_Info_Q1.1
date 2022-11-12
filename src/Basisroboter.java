public class Basisroboter {
    public static final int GROUND_HEIGHT = Project.HEIGHT - 200;
    // Attribute
    private Vector p, v;

    private int direction = 0;
    private double moved;
    private boolean jumped;
    private boolean onGround;

    // Konstruktor
    public Basisroboter(int x, int y) {
        p = new Vector(x, y);
        v = new Vector();
    }

    // Methoden
    public void gibInfo() {
        System.out.print("Meine Position ist (" + p.getX() + "|" + p.getY() + ").");
    }

    public void update() {
        Vector a = new Vector(0, 7); //Gravity
        if (moved != 0) {
            Vector movea = new Vector(moved, 0);
            a = a.add(movea);
            moved = 0;
        }
        if(jumped) {
            Vector jumpa = new Vector(0,-70);
            a = a.add(jumpa);
            jumped = false;
        }
        Vector drag = v.mul(-0.1);
        a = a.add(drag);
        v = v.add(a);
        p = p.add(v);
        onGround = p.getY() > GROUND_HEIGHT;
        if (onGround) {
            p = new Vector(p.getX(), GROUND_HEIGHT);
            v = new Vector(v.getX(), 0);
        }
        direction = v.getX()>0 ?0:1;
    }

    public void move(double distance) {
        moved = distance;
    }

    public void jump() {
        if(onGround) {
            jumped = true;
        }
    }


    public int getX() {
        return (int) Math.round(p.getX());
    }

    public int getY() {
        return (int) Math.round(p.getY());
    }

    public int getDirection() {
        return direction;
    }
}

