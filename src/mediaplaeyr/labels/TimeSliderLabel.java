package mediaplaeyr.labels;

import javax.swing.*;
import java.awt.*;

public class TimeSliderLabel extends JLabel {
    public  static  String returntime="0:0";
   public TimeSliderLabel(){
       super.setText(returntime);
       super.setBounds(10,10,30,30);
       super.setOpaque(false);
       super.setHorizontalAlignment(SwingConstants.CENTER);
       super.setForeground(Color.white);
        super.setVisible(false);
    }
}
