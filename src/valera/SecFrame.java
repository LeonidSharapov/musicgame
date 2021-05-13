package valera;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

public class SecFrame extends JFrame {
    private double mili = 00.00;
    private int min = 0;
    public static Timer time;
    double scale = Math.pow(10, 2);
    public static TimerTask timerTask;
   public static JLabel jl = new JLabel();
    SecFrame() {
        JButton b1 = new JButton("start");
        JButton b2 = new JButton("stop");
        JButton b3 = new JButton("restart");
        JPanel jp = new JPanel();
        JLabel jl = new JLabel();

        super.setSize(1222, 666);
        jp.setSize(1222, 666);
        jp.setLayout(null);
        super.setDefaultCloseOperation(SecFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
        b3.setBounds(590,80,80,60);
        b2.setBounds(510, 80, 80, 60);
        b1.setBounds(430, 80, 80, 60);
        jl.setBounds(490, 200, 200, 100);
        jl.setFont(new Font(String.valueOf(min) + ":" + String.valueOf(Math.ceil(mili * scale) / scale),Font.BOLD,50));
        jp.add(b1);
        jp.add(b2);
        jp.add (b3);
        jp.add(jl);
        super.add(jp);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jl.setText(String.valueOf(min) + ":" + String.valueOf(Math.ceil(mili * scale) / scale));
                time = new Timer(10, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(!SecFrame.super.isDisplayable()){
                            stopgg();
                        }
                        mili += 0.01;
                        jl.setText(String.valueOf(min) + ":" + String.valueOf(Math.ceil(mili * scale) / scale));
                        jl.setVisible(true);
                        if (mili >= 60.0) {
                            mili = 0;
                            min += 1;
                            System.out.println(min);
                        }

                    }
                });
                time.setRepeats(true);
                time.setCoalesce(true);
                time.setInitialDelay(0);
                time.start();
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopgg();
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopgg();
                restgg();
                jl.setText(String.valueOf(min) + ":" + String.valueOf(Math.ceil(mili * scale) / scale));
                jl.setVisible(true);

            }
        });
        super.setVisible(true);


    }
public  void  stopgg(){
       time.stop();
}
public  void restgg(){
    min=0;
    mili=00.00;


}


}
