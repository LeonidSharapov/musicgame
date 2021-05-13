package mediaplaeyr.button;

import javax.swing.*;

public class Button5 extends JButton {
    public Button5(){
        Icon stop = new ImageIcon("break.png");
        super.setIcon(stop);
        super.setOpaque(false);
        super.setContentAreaFilled(false);
        super.setBorderPainted(false);
        super.setFocusable(false);
        super.setBounds(510,65,50,50);
        super.setToolTipText("break");
    }
}
