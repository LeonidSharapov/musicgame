package mediaplaeyr;

import mediaplaeyr.Graphics.GraphicsClass;
import mediaplaeyr.labels.TimeSliderLabel;
import mediaplaeyr.panels.SoundPanel;
import mediaplaeyr.panels.TimeSliderPane;
import mediaplaeyr.panels.VolumePane;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class SoundFrame extends JFrame{
    public  static VolumePane vp = new VolumePane();
    private  String title = "Media Player";
    public SoundFrame() throws IOException, UnsupportedAudioFileException {
        GraphicsClass ghs = new GraphicsClass();
        SoundPanel sl = new SoundPanel();
        SoundMenuBar mb = new SoundMenuBar();
        super.add(mb);
        ghs.setBounds(0,0,1024,570);
        ghs.setOpaque(false);
        ghs.repaint();
        super.setTitle(title);
        super.setLayout(null);
        super.add(ghs);
        super.setSize(1024,768);
        super.add(vp);
        super.add(sl);
        super.setJMenuBar(mb);
        super.setDefaultCloseOperation(super.EXIT_ON_CLOSE);
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }

}