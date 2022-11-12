import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Project extends Canvas implements KeyListener, ActionListener {

    public static final int WIDTH = 1920, HEIGHT = 1080;
    Animationsroboter robbi = new Animationsroboter (300,300);

    public void paint(Graphics stift) {
        robbi.map(stift);
        robbi.zeichnen(stift);
    }
    public static void main(String[] args) {

        JFrame f = new JFrame("Roboterwelt");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Project m = new Project();
        m.setBackground(Color.WHITE);
        m.addKeyListener(m);
        f.add(m);
        f.pack();
        f.setSize(WIDTH, HEIGHT);
        //f.setLayout(null);
        f.setVisible(true);
        Timer timer = new Timer(20, m);
        timer.start();
    }
    //region 3 KeyEvent Methods
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
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
        robbi.update();
        repaint();
    }
    //endregion
}
