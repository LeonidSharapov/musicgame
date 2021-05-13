package mediaplaeyr.button;

import javax.swing.*;

public class Button2 extends JButton {
    public Button2(){
        Icon play = new ImageIcon("play.png");
        super.setIcon(play);
        super.setOpaque(false);
        super.setBounds(440,65,50,50);
        super.setContentAreaFilled(false);
        super.setBorderPainted(false);
        super.setFocusable(false);
        super.setToolTipText("start");


    }
}
