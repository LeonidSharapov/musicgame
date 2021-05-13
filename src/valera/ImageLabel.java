package valera;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageLabel extends JLabel {
    ImageLabel(){

    }
    public void paintComponent (Graphics g){
        Image im = null;
        try {
            im = ImageIO.read(new File("fon.jpg"));
        } catch (IOException e) {
        }
        g.drawImage(im, 0, 0, null);
    }
}
