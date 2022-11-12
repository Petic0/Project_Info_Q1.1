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

    public void zeichneFront(Graphics stift) {
        stift.setColor(Color.BLACK);
        // Der Kopf :
        stift.drawRect(getX() - 15, getY() - 40, 30, 20);
        stift.setColor(Color.BLUE);
        stift.fillOval(getX() - 10, getY() - 35, 5, 5);
        stift.fillOval(getX() + 5, getY() - 35, 5, 5);
        stift.setColor(Color.BLACK);

        stift.drawRect(getX() - 5, getY() - 25, 10, 2);
        stift.fillRect(getX() - 5, getY() - 25, 10, 2);
        // Der Hals :
        stift.drawRect(getX() - 5, getY() - 20, 10, 10);
        // Der Koerper :
        stift.drawRect(getX() - 25, getY() - 10, 50, 30);
        // Die Arme :
        stift.drawRect(getX() - 30, getY() - 10, 5, 20);
        stift.drawRect(getX() + 25, getY() - 10, 5, 20);
        // Die Beine :
        stift.drawRect(getX() - 25, getY() + 20, 10, 20);
        stift.drawRect(getX() + 15, getY() + 20, 10, 20);
    }

    public void zeichneRechts(Graphics stift) {
        stift.setColor(Color.BLACK);
        // Der Kopf :
        stift.drawRect(getX() - 20, getY() - 40, 20, 20);
        stift.drawOval(getX() - 5, getY() - 35, 5, 5);
        stift.drawRect(getX() - 5, getY() - 25, 5, 2);
        stift.fillRect(getX() - 5, getY() - 25, 5, 2);
        // Der Hals + Arme :
        stift.drawRect(getX() - 15, getY() - 20, 10, 30);
        // Der Koerper :
        stift.drawRect(getX() - 25, getY() - 10, 30, 30);
        // Die Beine :
        stift.drawRect(getX() - 15, getY() + 20, 10, 20);
    }

    public void zeichneLinks(Graphics stift) {
        stift.setColor(Color.BLACK);
        // Der Kopf :
        stift.drawRect(getX() - 20, getY() - 40, 15, 20);
        stift.drawOval(getX() - 20, getY() - 35, 5, 5);
        stift.drawRect(getX() - 20, getY() - 25, 5, 2);
        stift.fillRect(getX() - 20, getY() - 25, 5, 2);
        // Der Hals + Arme :
        stift.drawRect(getX() - 17, getY() - 20, 10, 30);
        // Der Koerper :
        stift.drawRect(getX() - 25, getY() - 10, 25, 30);
        // Die Beine :
        stift.drawRect(getX() - 17, getY() + 20, 10, 15);
    }

    public void zeichneRueck(Graphics stift) {
        stift.setColor(Color.BLACK);
        // Der Kopf :
        stift.drawRect(getX() - 15, getY() - 40, 30, 20);
        // Der Hals :
        stift.drawRect(getX() - 5, getY() - 20, 10, 10);
        // Der Koerper :
        stift.drawRect(getX() - 25, getY() - 10, 50, 30);
        // Die Arme :
        stift.drawRect(getX() - 30, getY() - 10, 5, 20);
        stift.drawRect(getX() + 25, getY() - 10, 5, 20);
        // Die Beine :
        stift.drawRect(getX() - 25, getY() + 20, 10, 20);
        stift.drawRect(getX() + 15, getY() + 20, 10, 20);
    }
    // . . .

    public void zeichnen(Graphics stift) {
        switch (getDirection()) {
            case 0 -> zeichneRueck(stift);
            case 1 -> zeichneRechts(stift);
            case 2 -> zeichneFront(stift);
            case 3 -> zeichneLinks(stift);
        }
    }
    public void delete(Graphics stift) {
        // L o e s c h t den Bereich , i n dem d e r Roboter s t e h t .
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