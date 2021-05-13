package mediaplaeyr;

import javax.swing.*;

public class SoundLabel extends JLabel {
   String name;
    public static String  newname = "";
    public SoundLabel(){
        name="";
        name= Sound.arr.get(Sound.index);
        char[] b = name.toCharArray();
        for (int namechek = 0; namechek < b.length; namechek++) {
            newname += b[namechek];
            if (String.valueOf(b[namechek]).endsWith("\\")) {
               newname = "";

            }
        }
        super.setText(newname);
    }
}
