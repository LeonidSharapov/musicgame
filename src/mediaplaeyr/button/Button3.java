package mediaplaeyr.button;

import javax.swing.*;

public class Button3 extends JButton {
    public Button3(){
        Icon stop = new ImageIcon("stop.png");
        super.setIcon(stop);
        super.setOpaque(false);
        super.setContentAreaFilled(false);
        super.setBorderPainted(false);
        super.setFocusable(false);
        super.setBounds(440,65,50,50);
        super.setToolTipText("break");
    }
}
