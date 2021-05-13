package valera;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.jar.JarEntry;

public class LogFrame extends JFrame {
    private String a;
    private char[] d;
    private  String vispass;
    private  String invispass;
    private  String t;
    ImageLabel il= new ImageLabel();


    LogFrame(){

        JPanel winlab= new JPanel();
        winlab.setLayout(null);

        JLabel ero = new JLabel();
        JTextField tfvisible = new JTextField();
        Icon vis = new ImageIcon("vis.png");
        JButton invisible = new JButton(vis);
        JButton ok = new JButton("ok");
       Icon invis = new ImageIcon("invis.png");
        JButton visible = new JButton(invis);
        JTextField tf = new JTextField();
        JPasswordField ps = new JPasswordField();
        JLabel log =  new JLabel("log");
        JLabel pass = new JLabel("password");
        log.setText("login");
       ero.setText("Incorrect login or password");
        ero.setFont(new Font( "Incorrect login or password",Font.PLAIN,18));
        log.setFont(new Font("Login",Font.PLAIN,20));
        log.setForeground(Color.red);
        log.setBounds(450,200,50,25);
        tf.setBounds(500,205,200,20);
        pass.setFont(new Font("Password",Font.PLAIN,20));
        pass.setBounds(405,250,100,33);
        ps.setBounds(500,258,200,20);
        pass.setForeground(Color.red);
        visible.setBounds(700,258,20,20);
        invisible.setBounds(700,258,20,20);
        ok.setBounds(530,300,130,50);
        tfvisible.setBounds(500,258,200,20);
        ero.setBounds(495,370,215,50);
        winlab.setBackground(new Color(252, 198, 3));
        winlab.add(ero);
        ero.setVisible(false);
        ero.setForeground(new Color(255, 0, 0));
        winlab.add(visible);
        winlab.add(invisible);
        visible.setVisible(false);
        winlab.add(log);
        winlab.add(tf);
        winlab.add(pass);
        winlab.add(ps);
        winlab.add(ok);
        winlab.setSize(1280,900);
        winlab.setOpaque(false);
        il.add(winlab);

        visible.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                invispass= String.valueOf(tfvisible.getText());
                ps.setText(invispass);
                winlab.remove(tfvisible);
                winlab.add(ps);
                invisible.setVisible(true);
                visible.setVisible(false);

            }
        });
        invisible.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vispass=String.valueOf(ps.getPassword());
                tfvisible.setText(vispass);

                winlab.remove(ps);
                winlab.add(tfvisible);
               visible.setVisible(true);
                invisible.setVisible(false);
            }
        });
        ok.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                a= tf.getText();
                String c = tfvisible.getText();
                d=ps.getPassword();
                t=String.valueOf(d);
                if(a.equals("admin")  && t.equals("admin") ||a.equals("admin")  && c.equals("admin") ){
                    LogFrame.super.dispose();
                    try {
                        MyFrame  frame= new MyFrame("hop hop");

                    } catch (IOException | UnsupportedAudioFileException ioException) {
                        ioException.printStackTrace();
                    } catch (IllegalAccessException illegalAccessException) {
                        illegalAccessException.printStackTrace();
                    } catch (InstantiationException instantiationException) {
                        instantiationException.printStackTrace();
                    } catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
                        unsupportedLookAndFeelException.printStackTrace();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    }
                }else{
                    ero.setVisible(true);
                }
            }
        });
       super.add(il);

       super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(1280,900);
        super.setResizable(false);
        super.setVisible(true);


    }
}
