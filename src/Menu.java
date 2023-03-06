
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class Menu implements KeyListener {

    private JFrame fr;
    private JPanel pn;

    private Image bg = new ImageIcon("photo/wallgame.png").getImage();
    private Image how = new ImageIcon("photo/how.png").getImage();
    private Image play = new ImageIcon("photo/play.png").getImage();
    private Image exit = new ImageIcon("photo/exit.png").getImage();
    private Image howto = new ImageIcon("photo/howto.png").getImage();
    private Image crop = new ImageIcon("photo/mcrop.png").getImage();
    private Image icon = new ImageIcon("photo/icon.png").getImage();
    private Image choice = new ImageIcon("photo/choice.png").getImage();
    private int num = 0, select = 1;
    private PlayMusic music = new PlayMusic();

    public Menu() {
        music.playaudio("Music/open.wav");
        music.music();
        fr = new JFrame();
        pn = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(bg, 0, 0, 1270, 720, null);
                g.drawImage(icon, 480, 50, 346, 180, null);
                g.drawImage(play, 500, 300, 300, 70, null);
                g.drawImage(how, 500, 400, 300, 70, null);
                g.drawImage(exit, 500, 500, 300, 70, null);
                g.drawImage(choice, 1000, 200, 216, 180, null);
                g.setColor(Color.black);
                if (select == 1) {
                    g.drawImage(crop, 500, 300, 300, 70, null);
                } else if (select == 2) {
                    g.drawImage(crop, 500, 400, 300, 70, null);
                } else if (select == 3) {
                    g.drawImage(crop, 498, 500, 300, 70, null);
                }
                if (num == 2) {
                    g.drawImage(howto, 0, 0, 1270, 720, null);
                }

            }
        };
        pn.setLayout(null);
        fr.addKeyListener(this);
        fr.setResizable(false);
        fr.add(pn);
        fr.setVisible(true);
        fr.setSize(1275, 750);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == 38) { //Up

            if (select > 1) {
                select -= 1;
            }
        } else if (ke.getKeyCode() == 40) { //Down
            if (select < 3) {
                select += 1;
            }
        } else if (ke.getKeyCode() == 10) { // Enter
            if (select == 1) {
                fr.setVisible(false);
                JFrame frr = new JFrame();
                frr.add(new GameFrame());
                frr.setVisible(true);
                frr.setSize(1285, 725);
                frr.setResizable(false);
                frr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            } else if (select == 2) {
                num = 2;
            } else if (select == 3) {
                System.exit(0);
            }
        } else if (ke.getKeyCode() == 27) { // esc
            if (num == 2) {
                num = 1;
                pn.repaint();
            }
        }
        pn.repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

    public static void main(String[] args) {
        new Menu();
    }
}
