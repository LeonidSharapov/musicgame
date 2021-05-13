package mediaplaeyr.Slider;


import mediaplaeyr.Sound;
import mediaplaeyr.labels.TimeSliderLabel;
import mediaplaeyr.panels.SoundPanel;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class SoundSlider extends JSlider {
    public static boolean click;
    public static int mods =0;
    private static int a;
    public static int d;
    private  static int b;
    private static int  e;
    private static int modorutime =0;
    private static boolean pressed = false;
    public static float vremay;
    public static String rets="";
    private static String label ="";
    double tt;
    private  int modslider=0;
    public SoundSlider() {
        super.setFocusable(false);
        super.setForeground(Color.cyan);
        super.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                pressed=true;
                if(pressed==true) {

                    TimeSliderLabel.returntime=label;
                    SoundPanel.tsl.setText(TimeSliderLabel.returntime);
                    System.out.println(label);
                    SoundPanel.tsl.setVisible(true);
                    SoundPanel.stp.setVisible(true);

                }


            }
        });
        super.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(modslider==0){
                    try {
                        Sound.supstart();
                        Sound.stopsou();
                    } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                        unsupportedAudioFileException.printStackTrace();
                    } catch (LineUnavailableException lineUnavailableException) {
                        lineUnavailableException.printStackTrace();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    modslider =1;

                }
            timelibel();
             tt=SoundSlider.super.getMaximum()+SoundSlider.super.getValue();
             int move = SoundSlider.super.getX()-15+(484-0)*(SoundSlider.super.getValue()-0)/
                     (SoundSlider.super.getMaximum()-SoundSlider.super.getMinimum())+0;
                SoundPanel.stp.setBounds(move,SoundSlider.super.getY()-45,45,30);
            TimeSliderLabel.returntime=label;
            SoundPanel.tsl.setFont(new Font("sda",Font.PLAIN,15));

            SoundPanel.tsl.setText(TimeSliderLabel.returntime);
            rettime();



            }
        });
        super.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JSlider sourceSlider = (JSlider) e.getSource();
                BasicSliderUI ui = (BasicSliderUI) sourceSlider.getUI();
                int value = ui.valueForXPosition(e.getX());
                SoundSlider.super.setValue(value);
                a = SoundSlider.super.getValue();
                d = a;
                mods = 1;
                click = true;
                if (mods == 1) {
                    timetime();

                }

                rets = "";

            }

            @Override
            public void mouseReleased(MouseEvent e) {

                JSlider sourceSlider = (JSlider) e.getSource();
                BasicSliderUI ui = (BasicSliderUI) sourceSlider.getUI();
                int value = ui.valueForXPosition(e.getX());
                SoundSlider.super.setValue(value);
                a = SoundSlider.super.getValue();
                d = a;
                mods = 1;
                click = true;
                if (mods == 1) {
                    timetime();

                }
             SoundPanel.labeltimes.start();


                SoundPanel.runtime1=modorutime;

                SoundPanel.stp.setVisible(false);

                rets = "";

            }

        });


        super.setOpaque(false);
    }

    public  static void  timetime(){

        if(a>=0) {

            b=a/60;
            e=a%60;
            SoundPanel.s=b+":"+e;
            vremay=a*44100;
            a=0;
            rets=SoundPanel.s;
            SoundPanel.t=b;
            SoundPanel.t2=e;
        }


        System.out.println(SoundPanel.s+"test s");
    }
public void timelibel(){
   int g=SoundSlider.super.getValue();
   int g1= g/60;
   int g2=g%60;
   label=g1+":"+g2;
}

public  void rettime(){
        char[]tr = label.toCharArray();
        String aa ="";
        String bb ="";
        for(int i=0;i<tr.length;i++){
      if(!String.valueOf(tr[i]).equals(":")){
          aa+=tr[i];
      }else{
          bb=aa;
          aa="";
      }
        }
        modorutime=Integer.parseInt(bb)*60+Integer.valueOf(aa);
}

}
