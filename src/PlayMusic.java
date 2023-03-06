
import java.io.*;
import javax.swing.JOptionPane;
import javax.sound.sampled.*;

public class PlayMusic {

    public void play(String action) {
        if (action.equals("dig")) {
            playaudio("Music/Dig.wav");
        } else if (action.equals("water")) {
            playaudio("Music/Water.wav");
        } else if (action.equals("plant")) {
            playaudio("Music/Dig.wav");
        } else if (action.equals("harvest")) {
            playaudio("Music/Cash.wav");
        } else if (action.equals("remove")) {
            playaudio("Music/Dig.wav");
        }
    }

    public void playaudio(String file) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(file));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-20.0f); // Reduce volume by 10 decibels.
            clip.start();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void playaudio(String file, float f) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(file));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(f); // Reduce volume
            clip.start();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void music() {
        try {
            
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Music/Bye.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-20.0f); // Reduce volume
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
