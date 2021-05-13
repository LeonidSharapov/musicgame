package mediaplaeyr;

import mediaplaeyr.Graphics.GraphicsClass;
import mediaplaeyr.Slider.SoundSlider;
import mediaplaeyr.panels.SoundPanel;
import mediaplaeyr.panels.VolumePane;

import javax.sound.sampled.*;
import javax.swing.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Sound {

    public  static  String sl="";
    public  static  Timer timers;
    public static int index = 0;
    public static int  mod =0;
    public static double done;
    public  static SoundList sr;
    public static  String lt=rettime();
    public static float cont=0;
    public static float cont2=0;



    static {
        try {
            sr = new SoundList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Clip clip;
    static {
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String > arr;
    static {
        try {

            arr = new ArraySound();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Sound() throws IOException, UnsupportedAudioFileException {

       File tf = new File(arr.get(index));
        AudioInputStream Aud = AudioSystem.getAudioInputStream(tf);
        AudioFormat chek = Aud.getFormat();
        long frames = Aud.getFrameLength();
        done = (frames+0.0) / chek.getFrameRate();
        lt=musictime();
        sl=arr.get(index);
    }


    //////
    public static void brr(ArrayList<String> area, int t) throws IOException, UnsupportedAudioFileException, LineUnavailableException {


        File sb = new File(area.get(t));
       AudioInputStream Aud = AudioSystem.getAudioInputStream(sb);
        AudioFormat chek = Aud.getFormat();
        long frames = Aud.getFrameLength();
        done = (frames+0.0) / chek.getFrameRate();
        lt=musictime();
System.out.println(arr.get(index));


        if (mod == 1) {
            clip.open(Aud);
            clip.setFramePosition((int) cont2);
            clip.start();
            timers = new Timer(10, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (clip.isActive()) {
                       cont=clip.getFramePosition();
                       cont2=cont;

                        if(SoundSlider.click==true){
                            SoundSlider.click=false;
                           stopsou();
                           cont2=SoundSlider.vremay;


                            try {
                                supstart();

                            } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                                unsupportedAudioFileException.printStackTrace();
                            } catch (LineUnavailableException lineUnavailableException) {
                                lineUnavailableException.printStackTrace();
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                        }
                    } else {
                        try {

                            nextSound(0);


                        } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                            unsupportedAudioFileException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        } catch (LineUnavailableException lineUnavailableException) {
                            lineUnavailableException.printStackTrace();
                        }
                    }

                }
            });
            timers.setRepeats(true);
            timers.setCoalesce(true);
            timers.setInitialDelay(0);
            timers.start();
        }

        }

///////
    public static void statrsou() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        stopsou();

         mod=1;
        brr(arr,index);


    }
    public static void  supstart() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
      sr.returnMet(arr);

        statrsou();
        SoundLabel.newname="";
        SoundPanel.soundlabel.setText(new SoundLabel().newname);
    }
    public static void breakmet(){
        cont=0;
        cont2=0;
        stopsou();

    }
    public  void contin() throws  UnsupportedAudioFileException, LineUnavailableException, IOException {
        supstart();

    }

    public static void stopsou() {
        mod =0;

        try {
            timers.stop();
        }catch (Exception e){

        }

        clip.stop();
        clip.drain();
        clip.close();


    }

    public static void nextSound(int tt) throws UnsupportedAudioFileException, IOException, LineUnavailableException {


        stopsou();

        mod=1;
        if(mod==1 ||tt==1 || mod==1 && tt==1) {
        if(index<arr.size()-1) {
            index += 1;


        }
        else{
            index=0;

        }
            System.out.println("ok");

            cont=0;
            cont2=0;
            try {
                SoundPanel.labeltimes.restart();
                SoundPanel.labeltimes.stop();
                SoundPanel.labeltimes.start();
            }catch (NullPointerException ignored){

            }
           SoundFrame.vp.setVisible(true);
            supstart();

            SoundPanel.firsttime=0;
            SoundPanel.t=0;
            SoundPanel.t2=0;
        SoundPanel.sliderlength();

            SoundPanel.runtime=0;
            SoundPanel.runtime1=0;
        }

    }
    public void backSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        cont=0;
        cont2=0;
        stopsou();
        if (index == 0) {
            index = arr.size() - 1;
        }else{

            index-=1;
        }
        try {


                SoundPanel.labeltimes.restart();
                SoundPanel.labeltimes.stop();
        }catch (NullPointerException ignored){

        }
        supstart();

        SoundPanel.firsttime=0;
        SoundPanel.t=0;
        SoundPanel.t2=0;
        SoundPanel.sliderlength();
        SoundPanel.runtime=0;
        SoundPanel.runtime1=0;

    }



public static String musictime(){

        done=Math.ceil(done);
    int b =(int) Math.round(done%60);
        int a = (int) Math.round(done/60);
        if(a!=0 ){
            if(b>30) {
                a -= 1;
            }
        }

        if(b!=0){
            b-=1;
        }
    String one = (a) + ":" + (b);
        return one;
}
public  static String rettime(){
        String gg =lt;
        return gg;
}
///inti
  }
