import javax.swing.*;                       // Importieren von den Zeichenklassen und den Klassen um die Key-Inputs zu bekommen
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Project extends Canvas implements KeyListener, ActionListener { //extend Canvas für das Fenster & Bild, implement Key- und ActionListener für die Inputs

    public static final int WIDTH = 1600, HEIGHT = 900;
             //statische Variablen für die Fenstergröße
    Animationsroboter robbi = new Animationsroboter (400,300); //Der Animationroboter (Die Spielfigur) wird erstellt an einer angegebenen Koordinate

    public void paint(Graphics stift) { // Die von Canvas stammende Klasse paint, die man überschreiben muss und die für das Malen zuständlich ist
        robbi.map(stift); // das Malen der "map" (bis jetzt nur der Boden)
        robbi.zeichnen(stift); //das Malen der Spielfigur
    }
    public static void main(String[] args) { //Main Klasse, die man beim Start ausführen muss

        JFrame f = new JFrame("Roboterwelt"); // Fenster wird erstellt
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fenster soll sich schließen beim schließen
        Project m = new Project(); // neues Projekt (Canvas) wird erstellt
        m.setBackground(Color.WHITE);
        m.addKeyListener(m); //Keylistener wird dem Fenster hinzugefügt
        f.add(m); // Das Project (mit robbi drin) wird dem Fenster hinzugefügt
        f.pack();
        f.setSize(WIDTH, HEIGHT);  //Fenster Größe wird auf die vorher statisch festgelegten Variablen gesetzt
        //f.setLayout(null);
        f.setVisible(true);
        Timer timer = new Timer(15, m); //Clock, die das Fenster immer updateted wird erstellt und gestartet
        timer.start();
    }
    // die drei Standardmethoden von KeyListener werden hinzugefügt
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) { //in der Methode "keyPressed" wird hinzugefügt, was bei Tastendruck passiert
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_A -> robbi.move(-1);
            case KeyEvent.VK_D -> robbi.move(1);
            case KeyEvent.VK_SPACE -> robbi.jump();

        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        robbi.update(); //Position von robbi wird geupdated
        repaint(); //Das Fenster wird neu gemalt (Ähnlich wie methode "paint" ist diese Methode gegeben)
    }
}
