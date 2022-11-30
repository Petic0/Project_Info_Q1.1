import java.awt.*; //Zeichen-Methoden werden importiert

public class Animationsroboter extends Basisroboter { //Die Klasse, die für das Zeichnen zuständig ist, sie erweitert den Basisroboter
    public Animationsroboter(int pXKoord, int pYKoord) { // Konstruktor
        super(pXKoord, pYKoord);
    }

    // Methoden
    public void map(Graphics stift) { // Die Map wird gemalt
        stift.setColor(Color.DARK_GRAY);
        stift.fillRect(0,GROUND_HEIGHT,Project.WIDTH,Project.HEIGHT);
    }

    public void zeichnen(Graphics stift) {
        stift.setColor(Color.BLACK);
        cube(stift); // Cube wird gezeichnet
        switch (getDirection()) { // Auge wird dahin gezeichnet, wo die Figur hinguckt
            case 0 -> auge(stift,10);
            case 1 -> auge(stift,-15);
        }
    }

    public void auge(Graphics stift, int rl) { // das Auge
        stift.fillOval(getX()+rl,getY()-20,5,5);
    }

    public void cube(Graphics stift) { // der Cube
        stift.drawRect(getX()-15,getY()-30,30,30);
    }
}