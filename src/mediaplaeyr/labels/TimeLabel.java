package mediaplaeyr.labels;

import mediaplaeyr.Sound;

import javax.swing.*;
import java.awt.*;

public class TimeLabel extends JLabel {
    String b;
    public TimeLabel(){
        b= Sound.rettime();
        super.setText(b);
        System.out.println(Sound.musictime()+"time");
    }
}
