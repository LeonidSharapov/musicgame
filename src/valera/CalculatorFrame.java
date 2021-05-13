package valera;

import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {
   public CalculatorFrame(){
        super.setSize(new Dimension(250,350));
        Calculator calc =new  Calculator();

        super.add(calc);
        super.setVisible(true);
    }
}
