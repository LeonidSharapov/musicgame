package mediaplaeyr.button;

import javax.swing.*;


public class Button1 extends JButton {
    public Button1() {
        Icon back = new ImageIcon("back.png");
        super.setIcon(back);
        super.setOpaque(false);
        super.setContentAreaFilled(false);
        super.setBorderPainted(false);
        super.setFocusable(false);
        super.setToolTipText("back");
        super.setBounds(370,65,50,50);
    }
}
