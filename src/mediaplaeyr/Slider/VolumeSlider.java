package mediaplaeyr.Slider;

import mediaplaeyr.Sound;
import mediaplaeyr.panels.VolumePane;
import javax.sound.sampled.FloatControl;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.event.*;

public class VolumeSlider extends JSlider  {
    private static float retvol;
    private static double vol=0;


    public VolumeSlider(){
        this.vol=vol;
        this.retvol=retvol;
        super.setMaximum(100);
        super.setFocusable(false);
        super.setValue(100);
        super.setOpaque(false);
        super.setBounds(60,2,100,50);
        super.setToolTipText(super.getValue()+"%");
        vol=VolumeSlider.super.getValue()/100.0;
        super.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(Sound.clip.isActive()) {
                    VolumeSlider.super.setToolTipText(VolumeSlider.super.getValue() + "%");
                    VolumePane.off = false;
                    VolumePane.voffb.setVisible(false);
                    VolumePane.vonb.setVisible(true);
                    vol = VolumeSlider.super.getValue() / 100.0;
                    FloatControl vol2 = (FloatControl) Sound.clip.getControl(FloatControl.Type.MASTER_GAIN);
                    float DB = (float) (Math.log(vol) / Math.log(10.0) * 20.0);
                    vol2.setValue(DB);
                }
                else{
                    VolumeSlider.super.setToolTipText(VolumeSlider.super.getValue() + "%");
                    VolumePane.off = false;
                    VolumePane.voffb.setVisible(false);
                    VolumePane.vonb.setVisible(true);
                    vol = VolumeSlider.super.getValue() / 100.0;
                    retvol= (float) (Math.log(vol) / Math.log(10.0) * 20.0);
                }
            }
        });
        super.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(Sound.clip.isActive()) {
                    JSlider sourceSlider = (JSlider) e.getSource();
                    BasicSliderUI ui = (BasicSliderUI) sourceSlider.getUI();
                    int value = ui.valueForXPosition(e.getX());
                    VolumeSlider.super.setValue(value);
                    vol = VolumeSlider.super.getValue() / 100.0;
                    FloatControl vol2 = (FloatControl) Sound.clip.getControl(FloatControl.Type.MASTER_GAIN);
                    float DB = (float) (Math.log(vol) / Math.log(10.0) * 20.0);
                    vol2.setValue(DB);
                }else{
                    JSlider sourceSlider = (JSlider) e.getSource();
                    BasicSliderUI ui = (BasicSliderUI) sourceSlider.getUI();
                    int value = ui.valueForXPosition(e.getX());
                    VolumeSlider.super.setValue(value);
                    vol = VolumeSlider.super.getValue() / 100.0;
                    retvol= (float) (Math.log(vol) / Math.log(10.0) * 20.0);
                }
            }

            @Override
            public void mousePressed(MouseEvent c) {
                if (Sound.clip.isActive()) {
                    JSlider sourceSlider = (JSlider) c.getSource();
                    BasicSliderUI ui = (BasicSliderUI) sourceSlider.getUI();
                    int value = ui.valueForXPosition(c.getX());
                    VolumeSlider.super.setValue(value);
                    vol = VolumeSlider.super.getValue() / 100.0;
                    FloatControl vol2 = (FloatControl) Sound.clip.getControl(FloatControl.Type.MASTER_GAIN);
                    float DB = (float) (Math.log(vol) / Math.log(10.0) * 20.0);

                    vol2.setValue(DB);
                    }else{
                    JSlider sourceSlider = (JSlider) c.getSource();
                    BasicSliderUI ui = (BasicSliderUI) sourceSlider.getUI();
                    int value = ui.valueForXPosition(c.getX());
                    VolumeSlider.super.setValue(value);
                    vol = VolumeSlider.super.getValue() / 100.0;
                    retvol= (float) (Math.log(vol) / Math.log(10.0) * 20.0);
                }
                }


            @Override

                public  void mouseReleased(MouseEvent c) {
                if (Sound.clip.isActive()) {
                    JSlider sourceSlider = (JSlider) c.getSource();
                    BasicSliderUI ui = (BasicSliderUI) sourceSlider.getUI();
                    int value = ui.valueForXPosition(c.getX());
                    VolumeSlider.super.setValue(value);
                    vol = VolumeSlider.super.getValue() / 100.0;
                    FloatControl vol2 = (FloatControl) Sound.clip.getControl(FloatControl.Type.MASTER_GAIN);
                    float DB = (float) (Math.log(vol) / Math.log(10.0) * 20.0);
                    vol2.setValue(DB);
                    }else{
                    JSlider sourceSlider = (JSlider) c.getSource();
                    BasicSliderUI ui = (BasicSliderUI) sourceSlider.getUI();
                    int value = ui.valueForXPosition(c.getX());
                    VolumeSlider.super.setValue(value);
                    vol = VolumeSlider.super.getValue() / 100.0;
                    retvol= (float) (Math.log(vol) / Math.log(10.0) * 20.0);
                }

                }
        });

    }
    public static void offvolume(){
        
            FloatControl vol2 = (FloatControl) Sound.clip.getControl(FloatControl.Type.MASTER_GAIN);
            retvol=(float) (Math.log(vol) / Math.log(10.0) * 20.0);;
            vol2.setValue(-80);

    }
    public  static void onvolume(){
        FloatControl vol2 = (FloatControl) Sound.clip.getControl(FloatControl.Type.MASTER_GAIN);

        System.out.println(retvol);
        float DB = retvol;
        vol2.setValue(DB);
    }
}

