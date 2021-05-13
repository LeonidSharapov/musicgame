package mediaplaeyr.panels;

import mediaplaeyr.Slider.SoundSlider;
import mediaplaeyr.Slider.VolumeSlider;
import mediaplaeyr.Sound;
import mediaplaeyr.SoundFrame;
import mediaplaeyr.SoundLabel;
import mediaplaeyr.button.*;
import mediaplaeyr.labels.StartTime;
import mediaplaeyr.labels.TimeLabel;
import mediaplaeyr.labels.TimeSliderLabel;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.util.Random;

public class SoundPanel extends JPanel {
    public static int runtime;
    public static int runtime1;
    public static  int t=0;
    public static int  t2=0;
    public  static int mods=0;
    public  static Timer times;
    public static Timer  labeltimes;
    public static  StartTime st = new StartTime();
    public  static  SoundSlider js= new SoundSlider();
    public static String s="0:0";
  public static  SoundLabel soundlabel = new SoundLabel();
  public static  TimeLabel tl = new TimeLabel();
 public  static TimeSliderLabel tsl = new TimeSliderLabel();
  public static   Timer timetimer;
  public static  SliderTimePane stp = new SliderTimePane();


    public  SoundPanel() throws IOException, UnsupportedAudioFileException {
        stp.add(tsl);
        super.add(stp);
        Sound music = new Sound();
        super.setBounds(0, 570,1024,150);
        super.setLayout(null);
        js.setValue(0);
        super.setBackground(new Color(new Random().nextInt(200), new Random().nextInt(200)
                , new Random().nextInt(200)));
        //super.setOpaque(false);
        tl.setText(Sound.lt);
        tl.setForeground(Color.white);
        Button1 b1 = new Button1();
        Button2 b2 = new Button2();
        Button3 b3 = new Button3();
        Button4 b4 = new Button4();
        Button5 b5 = new Button5();

        soundlabel.setHorizontalAlignment(SwingConstants.CENTER);
        soundlabel.setForeground(Color.white);
        soundlabel.setFont(new Font("ss",Font.BOLD,15));
        js.setBounds(250,45,500,19);
        soundlabel.setBounds(300,12,400,50);
        st.setBounds(235,12,50,50);
        st.setForeground(Color.white);
        tl.setBounds(750,12,50,50);
        b3.setVisible(false);

        super.add(b1);
        super.add(b2);
        super.add(b3);
        super.add(b4);
        super.add(soundlabel);
        super.add(tl);
        super.add(st);
        super.add(b5);
        super.add(js);
        sliderlength();
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              Sound.breakmet();
              soundVisiblename();
              try {
                  stoptimers();
                  timetimer.stop();
              }catch (NullPointerException ignored){

              }

              t=0;
              t2=0;
                b3.setVisible(false);
                b2.setVisible(true);
                st.setText(t+":"+t2);
                SoundPanel.super.remove(st);
                SoundPanel.super.add(st);
                js.setValue(0);
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    music.supstart();
                    volummet();
                    times = new Timer(500, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (!Sound.clip.isActive()) {

                                mods = 0;
                                Sound.stopsou();
                                times.stop();

                            }
                        }
                    });

                    times.setRepeats(true);
                    times.setCoalesce(true);
                    times.setInitialDelay(0);
                    times.start();
                    soundVisiblename();

                } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                    unsupportedAudioFileException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (LineUnavailableException lineUnavailableException) {
                    lineUnavailableException.printStackTrace();

                }
                timers();
                timetimers();
                b2.setVisible(false);
                b3.setVisible(true);


            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mods = 0;

                Sound.stopsou();
               stoptimers();
               stoptimertimers();

                b3.setVisible(false);
                b2.setVisible(true);

            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mods = 1;
                t=0;
                t2=0;
                try {
                    music.nextSound(mods);
                    volummet();
                    tl.setText(Sound.rettime());
                    SoundPanel.super.remove(tl);
                    SoundPanel.super.add(tl);
                   soundVisiblename();

                } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                    unsupportedAudioFileException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (LineUnavailableException lineUnavailableException) {
                    lineUnavailableException.printStackTrace();
                }
               try {
                   if (labeltimes.isCoalesce()) {
                       labeltimes.restart();
                       stoptimers();

                   }
               }catch (NullPointerException c){

               }
               try{
               if(timetimer.isCoalesce()) {
                   timetimer.restart();
                   stoptimertimers();
               }
               }catch(NullPointerException ignored){

                   }
                firsttime=0;
                js.setValue(0);
                runtime=0;
                runtime1=0;
                timetimers();
                timers();
                b2.setVisible(false);
                b3.setVisible(true);

            }
        });
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    music.backSound();
                    volummet();

                    soundVisiblename();
                } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                    unsupportedAudioFileException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (LineUnavailableException lineUnavailableException) {
                    lineUnavailableException.printStackTrace();
                }
                try {
                        labeltimes.restart();
                        stoptimers();


                }catch (NullPointerException ignored){

                }
                try {
                        timetimer.restart();
                        timetimer.stop();


                }catch (NullPointerException ignored){

                }
                firsttime=0;
                js.setValue(0);
                runtime=0;
                runtime1=0;
                timetimers();
                timers();
                b2.setVisible(false);
                b3.setVisible(true);
            }
        });


    }
    public static int firsttime=0;
    public void  tml(){
        if(SoundSlider.mods==1) {
            runtime = SoundSlider.d;
        }
        SoundSlider.mods=0;
        t2+=1;
        if(t2==60){
            t+=1;
            t2=0;
        }
        if(t2==1 && firsttime ==0){
            firsttime=1;
            t2=0;
        }
        if(firsttime==1) {



            s = t + ":" + t2;
            st.setText(s);
            super.remove(st);

            super.add(st);
        }
    }
    public void timers(){
        if(Sound.clip.isActive()) {
            labeltimes = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(soundlabel.getText());

                    runtime += 1;
                    if(runtime>=2) {
                        runtime1+=1;
                        System.out.println(runtime + "run");
                        js.setValue(runtime1);
                        SoundPanel.super.remove(js);
                        SoundPanel.super.add(js);
                    }
                        if (runtime == 1) {
                            tl.setText(Sound.lt);
                            SoundPanel.super.remove(soundlabel);
                            SoundPanel.super.add(soundlabel);
                            SoundPanel.super.remove(tl);
                            SoundPanel.super.add(tl);

                        }

                    }

            });
            labeltimes.setRepeats(true);
            labeltimes.setCoalesce(true);
            labeltimes.setInitialDelay(0);
            labeltimes.start();
        }
    }
    public static void stoptimers(){

        labeltimes.stop();
    }
    public void timetimers(){
        timetimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tml();
            }
        });
        timetimer.setRepeats(true);
        timetimer.setCoalesce(true);
        timetimer.setInitialDelay(0);
        timetimer.start();

    }
    public void stoptimertimers(){
        timetimer.stop();
    }

    public static void sliderlength(){

        StringBuilder slidtime1= new StringBuilder();
        int slidtimeint1=0;

        String length= Sound.rettime();
        char[] slid = length.toCharArray();
        for(int j =0; j<slid.length;j++){
           if(String.valueOf(slid[j]).equals(":")){
               slidtimeint1=Integer.valueOf(slidtime1.toString())*60;
               slidtime1 = new StringBuilder();
           }else {
               slidtime1.append(slid[j]);
           }
        }
        slidtimeint1+=Integer.valueOf(slidtime1.toString());
        js.setMaximum(slidtimeint1);
    }
public  static void volummet(){
        if(Sound.clip.isActive()) {
            if (VolumePane.off) {
                VolumeSlider.offvolume();
            } else {
                VolumeSlider.onvolume();
            }
        }
}
public void soundVisiblename(){
    SoundLabel.newname="";
    SoundPanel.soundlabel.setText(new SoundLabel().newname);
    SoundPanel.super.remove(soundlabel);
    SoundPanel.super.add(soundlabel);
}
}
