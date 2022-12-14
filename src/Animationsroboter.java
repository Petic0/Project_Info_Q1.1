import java.awt.*; //Zeichen-Methoden werden importiert
import java.lang.reflect.Array;

public class Animationsroboter extends Basisroboter { //Die Klasse, die für das Zeichnen zuständig ist, sie erweitert den Basisroboter
    public Animationsroboter(int pXKoord, int pYKoord) { // Konstruktor
        super(pXKoord, pYKoord);
    }

    // Methoden
    public void map(Graphics stift) { // Die Map wird gemalt
        stift.setColor(Color.DARK_GRAY);
        stift.fillRect(0,GROUND_HEIGHT,Project.WIDTH,Project.HEIGHT);
        stift.setColor(Color.GREEN);
        stift.fillRect(firstBox[0],firstBox[1],firstBox[2],firstBox[3]);
        stift.setColor(Color.RED);
        stift.fillRect(firstBox[0],firstBox[1],5,5);
    }

    public void zeichnen(Graphics stift) {
        stift.setColor(Color.BLACK);
        cube(stift); // Cube wird gezeichnet
        stift.setColor(Color.BLUE);
        switch (getDirection()) { // Auge wird dahin gezeichnet, wo die Figur hinguckt
            case 0 -> auge(stift,1); //rechts
            case 1 -> auge(stift,-1); //links
        }
    }

    public void auge(Graphics stift, int rl) { // das Auge
        stift.fillOval(getX()+rl*(cubelenght/2),getY()-cubelenght/3*2,-(rl*cubelenght/6),cubelenght/6);
    }

    public void cube(Graphics stift) { // der Cube
        stift.drawRect(getX()-cubelenght/2,getY()-cubelenght,cubelenght,cubelenght);
    }
}