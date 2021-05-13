package mediaplaeyr;

import org.w3c.dom.Text;

import javax.annotation.processing.SupportedSourceVersion;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class SoundMenuBar extends JMenuBar {
    JMenu menu = new JMenu("setting");
    JMenuItem add = new JMenuItem("add");
    JMenuItem deletethis = new JMenuItem("delete this");
    String getsound;
    AudioInputStream aud;
    Clip clip;
    ArrayList<String> gg = new ArrayList<>();
  public static   String namesound = "";
   public static String save = "";

    public SoundMenuBar() {
        menu.add(add);
        menu.add(deletethis);
        deletethis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                namesound = Sound.arr.get(Sound.index);
                gg = Sound.arr;
                for (int i = 0; i < gg.size() - 1; i++) {
                    if (gg.get(i).equals(namesound)) {
                        gg.remove(i);
                    }
                }
                try {
                    retarray();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                Sound.arr = gg;
            }
        });
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser cheker = new JFileChooser();
                int open = cheker.showOpenDialog(null);
                if (open == JFileChooser.APPROVE_OPTION) {
                    try {

                        getsound = cheker.getSelectedFile().getAbsolutePath();
                        File iF = new File(getsound);
                        cheker.addChoosableFileFilter(new TextFileFilter(".wav"));
                        aud = AudioSystem.getAudioInputStream(iF);
                        clip = AudioSystem.getClip();
                        clip.open(aud);
                        clip.start();
                        clip.stop();

                        new SoundList().addmusic(getsound);


                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(new JFrame("error"), "No file find");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(new JFrame("error"), "format error");
                    }
                }

            }
        });
        super.add(menu);

    }

    public class TextFileFilter extends FileFilter {
        private String down;

        public TextFileFilter(String down) {
            this.down = down;
        }

        public boolean accept(java.io.File file) {
            if (file.isDirectory()) return true;
            return (file.getName().endsWith(down));
        }

        public String getDescription() {
            return down;
        }
    }

    public static void retarray() throws IOException {
        FileInputStream fis = new FileInputStream(TxtSoundArray.file);
        int i;

        while ((i = fis.read()) != -1) {
            if (fis == null) {
                fis.close();
            }
            save+= ((char)i);
            System.out.println(save);
        }
       save=save.replace(namesound,"");
        save= save.replace("\r\n","");
        namesound="";
       FileOutputStream fos = new FileOutputStream(TxtSoundArray.file,false);
        fos.write(save.getBytes());
        fos.flush();
        fos.close();
    }

}
