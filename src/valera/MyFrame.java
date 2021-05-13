package valera;

import javax.imageio.ImageIO;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MyFrame extends JFrame {
    String title;
    public MyFrame(String title) throws IOException, UnsupportedAudioFileException, ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        MyPanel my = new MyPanel();
        my.setOpaque(false);
        JMenuBar mb = new JMenuBar();
        JMenu menu = new JMenu("setting ");
        JMenu size = new JMenu("size");
        JMenuItem s1 = new JMenuItem("1920x1280");
        JMenuItem s2 = new JMenuItem("1280x1024");
        TimePanel tm = new TimePanel();
        BgPanel tt = new BgPanel();
        mb.add(menu);
        menu.add(size);
        size.add(s1);
        size.add(s2);



        super.setJMenuBar(mb);
       super.setSize(1280,1024);
        super.setResizable(false);
        s1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyFrame.super.setSize(1920,1280);
                tt.setSize(1920,1280);
                my.setPreferredSize(new Dimension(1920,1280));
                MyFrame.super.setLocationRelativeTo(null);

            }
        });
        s2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyFrame.super.setSize(1280,1024);
                tt.setPreferredSize(new Dimension(1280,1024));
                my.setPreferredSize(new Dimension(1280,1024));
                MyFrame.super.setLocationRelativeTo(null);
            }
        });


        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       super.setLocationRelativeTo(null);
        tt.add(my);
       super.add(tt);

       super.add(tm,BorderLayout.AFTER_LAST_LINE);

        super.setVisible(true);
    }


}
