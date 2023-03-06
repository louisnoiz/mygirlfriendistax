
import java.awt.*;
import javax.swing.*;

public class Time extends JLabel implements Runnable {

    private int sec = 0, min = 0, hour = 7;
    private Thread t;
    private JPanel pn1;

    public Time() {
        pn1 = new JPanel();
        t = new Thread(this);
        t.start();
        pn1.add(this);
        this.setSize(500, 500);
    }
    
    public void run() {
        while (true) {
            try {
                String time = String.format("%02d:%02d", (hour) % 24, min);
                setFont(new Font("Helvetica", Font.PLAIN, 18));
                setText(time);
                setForeground(Color.black);
                Thread.sleep(1000);
                sec += 1;
                min = sec*10%60;
                hour = (sec/6) + 7;
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

}
