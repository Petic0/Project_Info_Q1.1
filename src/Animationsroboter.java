import java.awt.*;
import java.lang.Thread;

public class Animationsroboter extends Basisroboter {
    // K o n s t r u k t o r
    public Animationsroboter(int pXKoord, int pYKoord) {
        super(pXKoord, pYKoord);
    }

    // Methoden
    public void zeichneSprung(Graphics stift) {

    }
    public void map(Graphics stift) {
        stift.setColor(Color.DARK_GRAY);
        stift.fillRect(0,GROUND_HEIGHT,Project.WIDTH,Project.HEIGHT);
    }

    public void zeichnen(Graphics stift) {
        switch (getDirection()) {
            case 0 -> zeichneRechts(stift);
            case 1 -> zeichneLinks(stift);
        }
    }

    public void zeichneRechts(Graphics stift) {
        stift.setColor(Color.BLACK);
        stift.drawRect(getX()-15,getY()-30,30,30);
        stift.fillOval(getX()+10,getY()-20,5,5);
    }

    public void zeichneLinks(Graphics stift) {
        stift.setColor(Color.BLACK);
        stift.setColor(Color.BLACK);
        stift.drawRect(getX() - 15, getY() - 30, 30, 30);
        stift.fillOval(getX() -15, getY() - 20, 5, 5);
    }
    public void delete(Graphics stift) {
        stift.setColor(Color.WHITE);
        stift.fillRect(getX() - 45, getY() - 45, 90, 90);
    }

    public void warte(int pDauer) {
        try {
            Thread.sleep(pDauer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}