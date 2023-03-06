
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameFrame extends JPanel implements KeyListener {

    private int px = 210, py = 230, start = 0, day = 1;
    private int checkx = 95, checky = 170, size_block = 30, size_char = 35, size_char2 = 30, size_char3 = 28;
    private int left = 0, right = 0, up = 0, down = 0;
    private int soil = 0, sleep = 0, money = 250, cost = 50;
    private int plant = 0, blockx, blocky, select = 1;
    private ArrayList<Soil> pos = new ArrayList<Soil>();
    private ArrayList<Plant> id = new ArrayList<Plant>();
    private IDPlant idplant = new IDPlant();
    private JLabel lb, lmoney, lday, lcost;
    private JPanel pn;
    private PlayMusic music = new PlayMusic();

    private ImageIcon bt = new ImageIcon("photo/bday.png");
    private ImageIcon bg = new ImageIcon("photo/map1.png");
    private ImageIcon character = new ImageIcon("photo/character1.png");
    private ImageIcon charl_l = new ImageIcon("photo/characterl_l.png");
    private ImageIcon charl_r = new ImageIcon("photo/characterl_r.png");
    private ImageIcon charr_l = new ImageIcon("photo/characterr_l.png");
    private ImageIcon charr_r = new ImageIcon("photo/characterr_r.png");
    private ImageIcon chard_l = new ImageIcon("photo/characterd_l.png");
    private ImageIcon chard_r = new ImageIcon("photo/characterd_r.png");
    private ImageIcon charu_l = new ImageIcon("photo/characteru_l.png");
    private ImageIcon charu_r = new ImageIcon("photo/characteru_r.png");
    private ImageIcon img_soil = new ImageIcon("photo/1b.png");
    private ImageIcon frame = new ImageIcon("photo/frame.png");
    private ImageIcon box1 = new ImageIcon("photo/boxcorn.png");
    private ImageIcon box2 = new ImageIcon("photo/boxradish.png");
    private ImageIcon box3 = new ImageIcon("photo/boxpumkin.png");
    private ImageIcon box4 = new ImageIcon("photo/boxcarrot.png");
    private ImageIcon box5 = new ImageIcon("photo/boxstrawberry.png");
    private ImageIcon box6 = new ImageIcon("photo/boxtomato.png");
    private ImageIcon night = new ImageIcon("photo/night.png");
    private Time time;

    public GameFrame() {
        time = new Time();
        Thread t;
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    start();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        t.start();
        pn = new JPanel();
        lb = new JLabel("Sleep (Spacebar)");
        lmoney = new JLabel();
        lday = new JLabel();
        lcost = new JLabel();
        this.setLayout(null);
        this.add(time);
        this.add(lmoney);
        this.add(lday);
        this.add(lcost);
        lcost.setSize(200, 50);
        lcost.setLocation(625, 630);
        lcost.setVerticalAlignment(SwingConstants.CENTER);
        lcost.setFont(new Font("Helvetica", Font.BOLD, 28));
        lcost.setForeground(Color.yellow);
        lmoney.setSize(200, 50);
        lmoney.setLocation(1078, 88);
        lmoney.setFont(new Font("Helvetica", Font.PLAIN, 18));
        lmoney.setForeground(Color.black);
        lday.setFont(new Font("Helvetica", Font.PLAIN, 18));
        lday.setSize(200, 50);
        lday.setLocation(1095, 63);
        lday.setForeground(Color.black);

        pn.add(lb);
        pn.setBackground(Color.WHITE);
        lb.setFont(new Font("Helvetica", Font.PLAIN, 18));
        this.add(pn);
        time.setBackground(Color.yellow);
        time.setSize(50, 20);
        time.setLocation(1100, 55);

        time.setVisible(true);
        pn.setSize(145, 35);
        pn.setLocation(105, 100);
        pn.setVisible(false);
        lb.setVisible(false);
        setFocusable(true);
        addKeyListener(this);

    }

    public void start() {
        repaint();
        while (true) {
            if (px >= 125 && px <= 225 && py == 230) {
                this.getPn().setVisible(true);
                this.getLb().setVisible(true);
            } else {
                this.getPn().setVisible(false);
                this.getLb().setVisible(false);
            }

            if (py >= 510) {
                blocky = 520;
            } else {
                blocky = (py / size_block) * size_block + 40;
            }

            if (px <= 65) {
                blockx = 70;
            } else {
                blockx = (px / size_block) * size_block + 10;
            }

            lmoney.setText("Money : " + money);
            lday.setText("Day : " + day);
            lcost.setText("$" + cost);
            if (sleep == 1) {
                try {
                    checkwater();
                    day += 1;
                    lmoney.setVisible(false);
                    lday.setVisible(false);
                    time.setVisible(false);
                    lcost.setVisible(false);
                    Thread.sleep(1000);
                    time.setSec(0);
                    Thread.sleep(1000);
                    time.setVisible(true);
                    lmoney.setVisible(true);
                    lday.setVisible(true);
                    lcost.setVisible(true);
                    sleep = 0;
                    music.playaudio("Music/day.wav");
                    repaint();
                } catch (InterruptedException ex) {
                    Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (time.getHour() == 22) {
                sleep = 1;
                repaint();
            }
        }
    }

    public void upstate(Plant plant) {
        if (plant.getState() < 3) {
            plant.setState(plant.getState() + 1);
        }
    }

    public void checkwater() {
        for (int i = 0; i < id.size(); i++) {
            if (id.get(i).getWater() == 1) {
                upstate(id.get(i));
                id.get(i).setWater(0);
            } else if (id.get(i).getWater() != -2) {
                id.get(i).setWater(id.get(i).getWater() - 1);
            }
        }
    }

    public void remove() {
        for (int i = 0; i < id.size(); i++) {
            if (id.get(i).getX() == blockx && id.get(i).getY() == blocky) {
                id.remove(i);
                music.play("remove");
            }
        }
    }

    public void harvest() {
        for (int i = 0; i < id.size(); i++) {
            if (id.get(i).getX() == blockx && id.get(i).getY() == blocky) {
                if (id.get(i).getState() == 3) {
                    music.play("harvest");
                    sell(id.get(i));
                    id.remove(i);
                    for (int j = 0; j < pos.size(); j++) {
                        if (pos.get(j).getLoca_x() == blockx && pos.get(j).getLoca_y() == blocky) {
                            pos.remove(j);
                        }
                    }
                }
            }
        }
    }

    public void sell(Plant plant) {
        if (plant.getId() == 1) {
            this.money += 100;
        } else if (plant.getId() == 2) {
            this.money += 150;
        } else if (plant.getId() == 3) {
            this.money += 110;
        } else if (plant.getId() == 4) {
            this.money += 180;
        } else if (plant.getId() == 5) {
            this.money += 105;
        } else if (plant.getId() == 6) {
            this.money += 130;
        }
    }

    public void paintComponent(Graphics g) {

        g.drawImage(bg.getImage(), 0, 0, 1280, 720, null);
        g.drawImage(bt.getImage(), 1050, 40, 150, 100, null);
        g.drawImage(frame.getImage(), 600, 570, 100, 100, null);

        if (select == 1) {
            g.drawImage(box1.getImage(), 625, 590, 50, 50, null);
        } else if (select == 2) {
            g.drawImage(box2.getImage(), 625, 590, 50, 50, null);
        } else if (select == 3) {
            g.drawImage(box3.getImage(), 625, 590, 50, 50, null);
        } else if (select == 4) {
            g.drawImage(box4.getImage(), 625, 590, 50, 50, null);
        } else if (select == 5) {
            g.drawImage(box5.getImage(), 625, 590, 50, 50, null);
        } else if (select == 6) {
            g.drawImage(box6.getImage(), 630, 590, 35, 50, null);
        }

        for (int i = 0; i < pos.size(); i++) {
            g.drawImage(img_soil.getImage(), pos.get(i).getLoca_x(), pos.get(i).getLoca_y(), size_block, size_block, null);
        }
        for (int i = 0; i < id.size(); i++) {
            g.drawImage(idplant.getplant(id.get(i)), id.get(i).getX(), id.get(i).getY(), size_block, size_block, null);
        }

        if (start == 0) {
            g.drawImage(character.getImage(), px, py, 32, 38, null);
        } else if (soil == 1) {
            int check = 1;
            for (int i = 0; i < pos.size(); i++) {
                if (pos.get(i).getLoca_x() == blockx && pos.get(i).getLoca_y() == blocky) {
                    check = 0;
                }
            }
            if (check == 1) {
                music.play("dig");
                pos.add(new Soil(blockx, blocky));
                g.drawImage(img_soil.getImage(), blockx, blocky, size_block, size_block, null);
            }
            g.drawImage(character.getImage(), px, py, 35, 38, null);
            soil = 0;
        } else if (plant == 1) {
            int check = 1;
            for (int j = 0; j < pos.size(); j++) {
                if (pos.get(j).getLoca_x() == blockx && pos.get(j).getLoca_y() == blocky) {
                    for (int k = 0; k < id.size(); k++) {
                        if (id.get(k).getX() == blockx && id.get(k).getY() == blocky) {
                            check = 0;
                        }
                    }
                    if (check == 1 && money >= cost) {
                        music.play("plant");
                        money -= cost;
                        id.add(new Plant(select, blockx, blocky, 1, 0));
                        g.drawImage(idplant.getplant(new Plant(select, blockx, blocky, 1, 0)), pos.get(j).getLoca_x(), pos.get(j).getLoca_y(), size_block, size_block, null);
                    }
                }
            }

            g.drawImage(character.getImage(), px, py, 35, 38, null);
            plant = 0;
        } else if (px <= 45 && py == checky) {
            px = 45;
            g.drawImage(charl_l.getImage(), px, py, size_char3, size_char, null);
        } else if (px >= 1225 && py == checky) {
            px = 1225;
            g.drawImage(charr_r.getImage(), px, py, size_char3, size_char, null);
        } else if (py <= 230 && px == checkx) {
            py = 230;
            g.drawImage(charu_l.getImage(), px, py, size_char2, size_char, null);
        } else if (py >= 540 && px == checkx) {
            py = 540;
            g.drawImage(chard_l.getImage(), px, py, size_char2, size_char, null);
        } else if (checkx < px) {
            if (right == 0) {
                g.drawImage(charr_l.getImage(), px, py, size_char3, size_char, null);
                right = 1;
            } else {
                g.drawImage(charr_r.getImage(), px, py, size_char3, size_char, null);
                right = 0;
            }
        } else if (checkx > px) {
            if (left == 0) {
                g.drawImage(charl_l.getImage(), px, py, size_char3, size_char, null);
                left = 1;
            } else {
                g.drawImage(charl_r.getImage(), px, py, size_char3, size_char, null);
                left = 0;
            }
        } else if (checky < py) {
            if (down == 0) {
                g.drawImage(chard_l.getImage(), px, py, size_char2, size_char, null);
                down = 1;
            } else {
                g.drawImage(chard_r.getImage(), px, py, size_char2, size_char, null);
                down = 0;
            }
        } else if (checky > py) {
            if (up == 0) {
                g.drawImage(charu_l.getImage(), px, py, size_char2, size_char, null);
                up = 1;
            } else {
                g.drawImage(charu_r.getImage(), px, py, size_char2, size_char, null);
                up = 0;
            }
        } else {
            g.drawImage(character.getImage(), px, py, 35, 38, null);
        }

        checky = py;
        checkx = px;
        g.drawRect(blockx - 1, blocky - 1, size_block + 1, size_block + 1);

        if (sleep == 1) {
            g.drawImage(night.getImage(), 0, 0, 1280, 720, null);
            pn.setVisible(false);
            lb.setVisible(false);
        }
    }

    public void keyTyped(KeyEvent ke) {
    }

    public void keyPressed(KeyEvent ke) {
        if (sleep == 0) {
            if (ke.getKeyCode() >= 37 && ke.getKeyCode() <= 40) {
                if (ke.getKeyCode() == 37) { //Left
                    start = 1;
                    if (px > 45) {
                        this.px -= 5;
                    }
                } else if (ke.getKeyCode() == 38) { //Up
                    start = 1;
                    if (py > 230) {
                        this.py -= 5;
                    }

                } else if (ke.getKeyCode() == 39) { //Right
                    start = 1;
                    if (px < 1225) {
                        this.px += 5;
                    }
                } else if (ke.getKeyCode() == 40) { //Down
                    start = 1;
                    if (py < 540) {
                        this.py += 5;
                    }
                }
            } else if (ke.getKeyCode() == 32) { //space bar
                if (px >= 125 && px <= 225 && py == 230) {
//                        checkwater();
                    sleep = 1;
                }
            } else if (!(px >= 125 && px <= 225 && py == 230)) {
                if (ke.getKeyCode() == 90) { //Z (din)
                    this.soil = 1;
                } else if (ke.getKeyCode() == 88) { //X (plant)
                    this.plant = 1;
                } else if (ke.getKeyCode() == 69) { //E (water)
                    for (int k = 0; k < id.size(); k++) {
                        if (id.get(k).getX() == blockx && id.get(k).getY() == blocky && id.get(k).getWater() != -2) {
                            music.play("water");
                            id.get(k).setWater(1);
                        }
                    }
                } else if (ke.getKeyCode() == 70) { // f (harvest)
                    this.harvest();
                } else if (ke.getKeyCode() == 82) { // r (remove)
                    this.remove();
                }

            }
            if (ke.getKeyCode() == 49 && select != 1) {
                music.playaudio("Music/swap.wav", 5);
                cost = 50;
                select = 1;
            } else if (ke.getKeyCode() == 50 && select != 2) {
                music.playaudio("Music/swap.wav", 5);
                cost = 75;
                select = 2;
            } else if (ke.getKeyCode() == 51 && select != 3) {
                music.playaudio("Music/swap.wav", 5);
                cost = 55;
                select = 3;
            } else if (ke.getKeyCode() == 52 && select != 4) {
                music.playaudio("Music/swap.wav", 5);
                cost = 90;
                select = 4;
            } else if (ke.getKeyCode() == 53 && select != 5) {
                music.playaudio("Music/swap.wav", 5);
                cost = 35;
                select = 5;
            } else if (ke.getKeyCode() == 54 && select != 6) {
                music.playaudio("Music/swap.wav", 5);
                cost = 65;
                select = 6;
            }
            repaint();
        }
    }

    public void keyReleased(KeyEvent ke) {
    }

    public JLabel getLb() {
        return lb;
    }

    public JPanel getPn() {
        return pn;
    }

}
