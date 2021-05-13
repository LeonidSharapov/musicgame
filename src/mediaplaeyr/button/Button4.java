package mediaplaeyr.button;

import javax.swing.*;

public class Button4 extends JButton {
    public Button4(){
        Icon next = new ImageIcon("next.png");
        super.setIcon(next);
        super.setOpaque(false);
        super.setContentAreaFilled(false);
        super.setBorderPainted(false);
        super.setFocusable(false);
        super.setBounds(580,65,50,50);
        super.setToolTipText("next");
    }
}
