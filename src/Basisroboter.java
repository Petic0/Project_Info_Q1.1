public class Basisroboter { //Klasse, die sich um die Grundfunktionen der Spielfigur kümmert
    public static final int GROUND_HEIGHT = Project.HEIGHT*7/10; //Bodenhöhe wird festgelegt
    int[] firstBox = {Project.WIDTH/10,Project.HEIGHT*5/9,Project.WIDTH/5,Project.HEIGHT/10};
    int cubelenght = Project.HEIGHT/36;
    private Vector p, v; //Vectoren für p(Position) und v(Velocity) werden erschaffen

    private int direction = 0; //Die Richtung in die die Spielfigur guckt bekommt eine Variable um die Spielfigut später richtig zu zeichnen können
    private double moved; // Variable für die Distanz der Bewegung (Wird beim KeyPressed Event verändert)
    private boolean jumped; // Variable die den KeyPressed "Space", Springen weitergibt
    private int onGround = 0; // Boolean das speichert, ob die Figur auf den Boden ist

    // Konstruktor
    public Basisroboter(int x, int y) { // Die Figur wird erstellt
        p = new Vector(x, y); // der Positionsvektor mit der Position wird erstellt
        v = new Vector(); // der Velocity Vektor mit einer Startgeschwindigkeit auf beiden Achsen von 0 wird erstellt
    }

    public void update() { // Die Methode "update", sie updatet die Positions der Figur
        Vector a = new Vector(0, 5); // ein Vector für die Beschleunigung wird erstellt, es gibt immer eine Gravität
        if (moved != 0) { // falls die Figur sich nach rechts oder nach links bewegen soll
            Vector movea = new Vector(moved, 0); //neuer Beschleunigungsvektor mit neuen Inputs
            a = a.add(movea); // Der alte und neue werden addiert (.add)
            moved = 0; // Bewegung wird wieder auf 0 gesetzt
        }
        if(jumped) { // falls die Figur springen soll
            Vector jumpa = new Vector(0,-70); //neuer Beschleunigungsvektor mit Beschleunigung des Sprunges
            a = a.add(jumpa); // Der alte und neue werden addiert (.add)
            jumped = false; // Sprung wird wieder auf false gesetzt
        }
        Vector drag = v.mul(-0.1); // abhängig von der Geschwindigkeit wird ein Luftwiederstand hinzugefügt
        a = a.add(drag); // dieser wird dem danach komplett geupdateten Beschleunigungs Veektor hinzugefügt
        v = v.add(a); // Beschleunigung wird auf die Geschwindigkeit addiert
        p = p.add(v); // Geschwindigkeit wird auf die Position addiert
        if(p.getY() >= GROUND_HEIGHT) {
            onGround = GROUND_HEIGHT;
        } else if ((p.getY() >= firstBox[1]) && (p.getY()<= firstBox[1]+30) && (p.getX()>firstBox[0]) && (p.getX() < (firstBox[0]+firstBox[2]))) {
            onGround = firstBox[1];
        }else
            onGround = 0;
        if (onGround != 0) { // wenn die Figur auf dem Boden ist
            p = new Vector(p.getX(), onGround); // dann kann sie nicht weiter runter und
            v = new Vector(v.getX(), 0); // ihre Beschleunigung auf der Y-Achse wird gestoppt
        }
        if(p.getX()>Project.WIDTH) {                 // Richtungswechsel und Teleport zur anderen Seite bei Übertreten des Randes
           p = new Vector(0, p.getY());
           v = new Vector(v.getX()*-1, 0);
        } else if (p.getX()<0) {
            p = new Vector(Project.WIDTH, p.getY());
            v = new Vector(v.getX()*-1, 0);
        }
        direction = v.getX()>0 ?0:1; // die Richtung, in die er gucken soll, ist die Richtung in die er sich bewegt (positiv negativ / rechts links)
    }

    public void move(double distance) { // diese Methode wird aus geführt, wenn der Spieler A oder D drückt und speichert den Input zwischen
        moved = distance;
    }

    public void jump() {  // diese Methode wird aus geführt, wenn der Spieler SPACE drückt und speichert den Input zwischen
        if(onGround != 0) { // der Sprung wird nur ausgeführt, wenn die Figur auf dem Boden steht
            jumped = true;
        }
    }

    // Getter Methoden
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

