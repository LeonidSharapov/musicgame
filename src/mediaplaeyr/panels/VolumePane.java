package mediaplaeyr.panels;


import mediaplaeyr.Slider.VolumeSlider;
import mediaplaeyr.Sound;
import mediaplaeyr.button.VolumOffButton;
import mediaplaeyr.button.VolumeOnButton;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VolumePane extends JPanel {
    public static boolean off = false;
    public static VolumeOnButton vonb = new VolumeOnButton();
    public static VolumOffButton voffb = new VolumOffButton();
    VolumeSlider vs = new VolumeSlider();
    public VolumePane(){
        super.setLayout(null);
        super.setOpaque(false);
        super.setBounds(750,620,200,50);
        super.add(vs);
        super.add(voffb);
        super.add(vonb);

        voffb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Sound.clip.isActive()) {

                    VolumeSlider.onvolume();
                }
                off=false;
                vonb.setVisible(true);
                voffb.setVisible(false);

            }
        });
       vonb.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               if(Sound.clip.isActive()) {

                   VolumeSlider.offvolume();
               }
               off = true;
                   vonb.setVisible(false);
                   voffb.setVisible(true);

           }
       });
    }
}
