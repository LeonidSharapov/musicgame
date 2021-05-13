package mediaplaeyr;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class TxtSoundArray {

    public static File file;
    static {
        file= new File("sound.txt");
        try {
        while (file.createNewFile()) {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static FileInputStream cheker;
    static {

                try {

                    cheker = new FileInputStream(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }


  private   TxtSoundArray(){

    }
    public static ArrayList<String> addStyle(ArrayList arr) throws IOException {
        String ct = "";
        String tt = "";
        int c =0;
        int i;
        while ((i = cheker.read()) != -1) {
            if (cheker == null) {
                cheker.close();
            }
            if(ct.endsWith("\r\n")) {
                ct = "";
            }
                ct += (char) i;
                if (ct.endsWith(".wav")) {


                    arr.add(ct);
                    ct ="";

                    }

                }

        return arr;
        }
    }

