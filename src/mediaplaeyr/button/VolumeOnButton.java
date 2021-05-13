package mediaplaeyr.button;

import javax.swing.*;

public class VolumeOnButton extends JButton {
    public VolumeOnButton(){
        Icon on = new ImageIcon("volumeon2.png");
        super.setIcon(on);
        super.setOpaque(false);
        super.setContentAreaFilled(false);
        super.setBorderPainted(false);
        super.setFocusable(false);
        super.setBounds(0,2,50,50);
    }
}
