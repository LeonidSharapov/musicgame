package mediaplaeyr.button;

import javax.swing.*;


public class VolumOffButton extends JButton {
    public VolumOffButton(){
        Icon off = new ImageIcon("volumeoff.png");
        super.setIcon(off);
        super.setOpaque(false);
        super.setContentAreaFilled(false);
        super.setBorderPainted(false);
        super.setFocusable(false);
        super.setBounds(0,2,50,50);
        super.setVisible(false);
    }
}
