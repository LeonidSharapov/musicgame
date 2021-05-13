package valera;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;

public class TimePanel extends JPanel {
    public static LocalDate date = LocalDate.now();
    public static LocalTime time = LocalTime.now();
    public  static String sec=String.valueOf(time.getSecond());
    public static  String min= String.valueOf(time.getMinute());
    public static String hour = String.valueOf(time.getHour());

    public static JLabel lab = new JLabel(date.getYear() + " " + date.getMonth() + " " + date.getDayOfMonth()
            + " " + hour + ":" + min + ":" + sec);
    public TimePanel(){

        super.add(lab);
        super.setBackground(new Color(3, 250, 250));

        lab.setOpaque(false);
        lab.setHorizontalAlignment(SwingConstants.CENTER);
        lab.setBackground(Color.green);
        lab.setPreferredSize(new Dimension(1280,50));
        lab.setFont(new Font(date.getYear() + " " + date.getMonth() + " " + date.getDayOfMonth()
                + " " + hour + ":" + min + ":" + sec,Font.BOLD,30));
        Timer times = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                repl();
            }
        });


        times.setRepeats(true);
        times.setCoalesce(true);
        times.setInitialDelay(0);
        times.start();
    }



    public static void repl(){
        time= LocalTime.now();
        date=LocalDate.now();
        sec = String.valueOf(time.getSecond());

        min = String.valueOf(time.getMinute());

        hour = String.valueOf(time.getHour());
        String a=(date.getYear()+" "+ date.getMonth()+" " + date.getDayOfMonth()
                +"        "+hour+":"+ min+":"+sec);
        lab.setText(a);
        lab.setHorizontalAlignment(SwingConstants.CENTER);
        lab.setFont(new Font(a,Font.BOLD,30));


    }
    }

