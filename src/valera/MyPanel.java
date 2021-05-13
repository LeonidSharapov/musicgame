package valera;

import mediaplaeyr.SoundFrame;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MyPanel extends JPanel {
 public  static int b=0;
   public MyPanel() throws IOException, UnsupportedAudioFileException, ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
      ///////
       super.setLayout(null);
       super.setPreferredSize(new Dimension(1280,1024));
       JLabel pl = new JLabel("paint");
       JLabel ml = new JLabel("music");
       JLabel cl = new JLabel("calcul");
       JLabel sm = new JLabel("stopwatch");

       //
       Icon sc = new ImageIcon("sec.png");
       JButton secm = new JButton(sc);
       secm.setOpaque(false);
       secm.setContentAreaFilled(false);
       secm.setBorderPainted(false);
       //
       Icon pp = new ImageIcon("paint.png");
       JButton paint = new JButton(pp);
       paint.setOpaque(false);
       paint.setContentAreaFilled(false);
       paint.setBorderPainted(false);
       //
       Icon imu = new ImageIcon("mus.png");
       JButton music = new JButton(imu);
       music.setOpaque(false);
       music.setContentAreaFilled(false);
       music.setBorderPainted(false);
      //
       Icon icon = new ImageIcon("calc.png");
       JButton calc = new JButton(icon);
       calc.setOpaque(false);
       calc.setContentAreaFilled(false);
       calc.setBorderPainted(false);
       //
      CalculatorFrame calcf = new CalculatorFrame();
      calcf.dispose();

      SecFrame sf = new SecFrame();
      sf.dispose();
      sm.setFont(new Font("Stopwatch",Font.PLAIN,14));
      sm.setBounds(15,305,80,40);
      sm.setForeground(Color.WHITE);
      ml.setFont(new Font("Music",Font.PLAIN,14));
      ml.setForeground(Color.WHITE);
      ml.setBounds(24,145,40,40);
      pl.setFont(new Font("Paint",Font.PLAIN,14));
      pl.setForeground(Color.WHITE);
      pl.setBounds(23,60,33,35);
      cl.setFont(new Font("Paint",Font.PLAIN,14));
      cl.setBounds(23,225,40,40);
      cl.setForeground(Color.WHITE);
       secm.setBounds(-10,240,100,100);
      calc.setBounds(-10,160,100,100);
      paint.setBounds(-10,-5,100,100);
      music.setBounds(-10,80,100,100);
      super.setOpaque(false);
//



////
super.add(secm);
super.add(pl);
super.add(ml);
super.add(cl);
super.add(sm);


      calc.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              if (!calcf.isActive()) {
                  calcf.setDefaultCloseOperation(calcf.DISPOSE_ON_CLOSE);
                  calcf.setResizable(false);
                  calcf.setVisible(true);
              }

          }
      });;

      paint.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {

                  new PaintFrame();



          }
      });
      secm.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              if (!sf.isActive()) {
                  sf.setDefaultCloseOperation(sf.DISPOSE_ON_CLOSE);
                  sf.setResizable(false);
                  sf.setVisible(true);


              }else{
                  sf.stopgg();
              }

          }
      });


      super.add(music);
       super.add(calc);
       super.add(paint);
       super.setVisible(true);





    }


}
