package valera;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Calculator extends JPanel {

    public static int i = 0;
    public static int mods = 1;
    protected static String lab = "";


    public Calculator() {
        JLabel label = new JLabel();
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton b0 = new JButton("0");
        JButton bplus = new JButton("+");
        JButton bminus = new JButton("-");
        JButton bdel = new JButton("/");
        JButton bmulti = new JButton("*");
        JButton bpasent = new JButton("%");
        JButton bpov = new JButton("=");
        JButton intb = new JButton("int");
        JButton intd = new JButton("dou");
        super.setLayout(null);
        b1.setBounds(26,37,42,40);
        b2.setBounds( 71,37,42,40);
        b3.setBounds(116,37,42,40);
        bmulti.setBounds(161,37,42,40);
        b4.setBounds(26,85,42,40);
        b5.setBounds(71,85,42,40);
        b6.setBounds(116,85,42,40);
        bdel.setBounds(161,85,42,40);
        b7.setBounds(26,133,42,40);
        b8.setBounds(71,133,42,40);
        b9.setBounds(116,133,42,40);
        bpasent.setBounds(161,133,43,40);
        bplus.setBounds(26,181,43,40);
        b0.setBounds(71,181,43,40);
        bminus.setBounds(116,181,43,40);
        bpov.setBounds(161,181,43,40);
        intb.setBounds(26,229,43,40);
        intd.setBounds(71,229,43,40);
        label.setBounds(50,1,100,30);
        super.add(label, BorderLayout.CENTER);

        super.add(b1);
        super.add(b2);
        super.add(b3);
        super.add(bminus);
        super.add(b4);
        super.add(b5);
        super.add(b6);
        super.add(bplus);
        super.add(b7);
        super.add(b8);
        super.add(b9);
        super.add(bdel);
        super.add(bmulti);
        super.add(b0);
        super.add(bpasent);
        super.add(bpov);
        super.add(intb);
        super.add(intd);
        bpasent.setEnabled(false);
        intb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mods=1;
                lab="";
                label.setText(lab);
                bpasent.setEnabled(false);
                intb.setEnabled(false);
                intd.setEnabled(true);
                bpov.setEnabled(false);

            }
        });
        intd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mods=2;
                lab="";
                label.setText(lab);
                bpasent.setEnabled(true);
                intb.setEnabled(true);
                intd.setEnabled(false);
                bpov.setEnabled(false);
            }
        });

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                lab += "1";
                label.setText(lab);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                lab += "2";
                label.setText(lab);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                lab += "3";
                label.setText(lab);
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                lab += "4";
                label.setText(lab);
            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                lab += "5";
                label.setText(lab);
            }
        });
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                lab += "6";
                label.setText(lab);

            }
        });
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                lab += "7";
                label.setText(lab);
            }
        });
        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                lab += "8";
                label.setText(lab);
            }
        });
        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                lab =lab+ "9";
                label.setText(lab);
            }
        });
        b0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                lab += "0";
                label.setText(lab);
            }
        });
        bplus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lab.isEmpty()) {
                    label.setText(lab);
                } else {
                    int a = lab.length();
                    if (lab.substring(a - 1).equals("-")||lab.substring(a - 1).equals("+")||lab.substring(a - 1).equals("*")
                            ||lab.substring(a - 1).equals("/") ||lab.substring(a - 1).equals("%")||lab.substring(a - 1).equals("=")) {

                    } else {
                        lab += "+";
                        i++;
                        label.setText(lab);
                        bpov.setEnabled(true);
                    }
                }
                if (i == 2) {
                    char [] chek = lab.toCharArray();
                    for(int j =0; j<chek.length;j++) {
                        if (chek[j] == '+') {
                            lab = plus(lab)+"+";
                            break;
                        }
                        else if (chek[j]=='-'){
                            lab=minus(lab)+"+";
                            break;
                        }
                        else if (chek[j]=='/'){
                            lab=hard(lab)+"+";
                            break;
                        }
                        else if (chek[j]=='*'){
                            lab=multi(lab)+"+";
                            break;
                        }
                        else if (chek[j]=='%'){
                            lab=pas(lab)+"+";
                            break;
                        }
                    }
                    label.setText(lab);
                    i = 1;

                }
            }

        });

        bminus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lab.isEmpty()) {
                    label.setText(lab);
                } else {
                    int a = lab.length();
                    if (lab.substring(a - 1).equals("-")||lab.substring(a - 1).equals("+")||lab.substring(a - 1).equals("*")
                            ||lab.substring(a - 1).equals("/") ||lab.substring(a - 1).equals("%")||lab.substring(a - 1).equals("=")) {

                    } else {
                        lab += "-";
                        i++;
                        label.setText(lab);
                        bpov.setEnabled(true);
                    }
                }
                if (i == 2) {
                    char [] chek = lab.toCharArray();
                    for(int j =0; j<chek.length;j++) {
                        if (chek[j] == '+') {
                            lab = plus(lab)+"-";
                            break;
                        }
                        else if (chek[j]=='-'){
                            lab=minus(lab)+"-";
                            break;

                        }
                        else if (chek[j]=='/'){
                            lab=hard(lab)+"-";
                            break;
                        }
                        else if (chek[j]=='*'){
                            lab=multi(lab)+"-";
                            break;
                        }
                        else if (chek[j]=='%'){
                            lab=pas(lab)+"-";
                            break;
                        }
                    }
                    label.setText(lab);
                    i =1;

                }
            }
        });
        bdel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lab.isEmpty()) {
                    label.setText(lab);
                } else {
                    int a = lab.length();
                    if (lab.substring(a - 1).equals("-")||lab.substring(a - 1).equals("+")||lab.substring(a - 1).equals("*")
                            ||lab.substring(a - 1).equals("/") ||lab.substring(a - 1).equals("%")||lab.substring(a - 1).equals("=")) {

                    } else {
                        lab += "/";
                        i++;
                        label.setText(lab);
                        bpov.setEnabled(true);
                    }
                }
                if (i == 2) {
                    char [] chek = lab.toCharArray();
                    for(int j =0; j<chek.length;j++) {
                        if (chek[j] == '+') {
                            lab = plus(lab)+"/";
                            break;
                        }
                        else if (chek[j]=='-'){
                            lab=minus(lab)+"/";
                            break;
                        }
                        else if (chek[j]==':'){
                            System.out.println(lab);
                            lab=hard(lab)+"/";
                            break;
                        }
                        else if (chek[j]=='*'){
                            lab=multi(lab)+"/";
                            break;
                        }
                        else if (chek[j]=='%'){
                            lab=pas(lab)+"/";
                            break;
                        }
                    }
                    label.setText(lab);
                    i = 1;

                }
            }


        });
        bmulti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lab.isEmpty()) {
                    label.setText(lab);
                } else {
                    int a = lab.length();
                    if (lab.substring(a - 1).equals("-")||lab.substring(a - 1).equals("+")||lab.substring(a - 1).equals("*")
                            ||lab.substring(a - 1).equals("/") ||lab.substring(a - 1).equals("%")||lab.substring(a - 1).equals("=")) {

                    } else {
                        lab += "*";
                        i++;
                        label.setText(lab);
                        bpov.setEnabled(true);
                    }
                }
                if (i == 2) {
                    char [] chek = lab.toCharArray();
                    for(int j =0; j<chek.length;j++) {
                        if (chek[j] == '+') {
                            lab = plus(lab)+"*";
                            break;
                        }
                        else if (chek[j]=='-'){
                            lab=minus(lab)+"*";
                            break;
                        }
                        else if (chek[j]=='/'){
                            lab=hard(lab)+"*";
                            break;
                        }
                        else if (chek[j]=='*'){
                            lab=multi(lab)+"*";
                            break;
                        }
                        else if (chek[j]=='%'){
                            lab=pas(lab)+"*";
                            break;
                        }
                    }
                    label.setText(lab);
                    i = 1;

                }

            }
        });
        bpasent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lab.isEmpty()) {
                    label.setText(lab);
                } else {
                    int a = lab.length();
                    if (lab.substring(a - 1).equals("-")||lab.substring(a - 1).equals("+")||lab.substring(a - 1).equals("*")
                            ||lab.substring(a - 1).equals("/") ||lab.substring(a - 1).equals("%")||lab.substring(a - 1).equals("=")) {

                    } else {
                        lab += "%";
                        i++;
                        label.setText(lab);
                        bpov.setEnabled(true);
                    }
                }
                if (i == 2) {
                    char [] chek = lab.toCharArray();
                    for(int j =0; j<chek.length;j++) {
                        if (chek[j] == '+') {
                            lab = plus(lab)+"%";
                            break;
                        }
                        else if (chek[j]=='-'){
                            lab=minus(lab)+"%";
                            break;
                        }
                        else if (chek[j]=='/'){
                            lab=hard(lab)+"%";
                            break;
                        }
                        else if (chek[j]=='*'){
                            lab=multi(lab)+"%";
                            break;
                        }
                        else if (chek[j]=='%'){
                            lab=pas(lab)+"%";
                            break;
                        }
                    }
                    label.setText(lab);
                    i = 1;

                }
            }
        });
        bpov.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lab.isEmpty()) {
                    label.setText(lab);
                } else {
                    int a = lab.length();
                    if (lab.substring(a - 1).equals("-")||lab.substring(a - 1).equals("+")||lab.substring(a - 1).equals("*")
                            ||lab.substring(a - 1).equals("/")  ||lab.substring(a - 1).equals("%")||lab.substring(a - 1).equals("=")){

                    } else {
                        i++;
                       lab+="=";

                    }

                }
                if (i == 2) {
                    char [] chek = lab.toCharArray();
                    for(int j =0; j<chek.length;j++) {
                        if (chek[j] == '+') {
                            lab = plus(lab);
                            break;
                        }
                        else if (chek[j]=='-'){
                            lab=minus(lab);
                            break;
                        }
                        else if (chek[j]=='/'){
                            lab=hard(lab);
                            break;
                        }
                        else if (chek[j]=='*'){
                            lab=multi(lab);
                            break;
                        }
                        else if (chek[j]=='%'){
                            lab=pas(lab);
                            break;
                        }
                    }
                    label.setText(lab);
                    i = 0;
                    bpov.setEnabled(false);
                }
            }
        });
    }

    public String plus(String a) {
        char[] b = a.toCharArray();
        String st1 = "";
        String st2 = "";
        for (int i = 0; i < b.length - 1; i++) {
            if (b[i] == '+') {
                st1 = st2;
                st2 = "";
            } else {
                st2 += b[i];

            }
        }
        if (mods == 2) {
            Double one = Double.parseDouble(st1);
            Double two = Double.parseDouble(st2);
            Double th = one + two;
            String pov1 = String.valueOf(th);
            return pov1;
        } else {
            int oneint = Integer.parseInt(st1);

            int twoint = Integer.parseInt(st2);
            int th1 = oneint + twoint;
            String pov1 = String.valueOf(th1);
            return pov1;
        }
    }
    public String minus(String b) {
        char[] c = b.toCharArray();
        String st1 = "";
        String st2 = "";
        for (int i = 0; i < c.length - 1; i++) {
            if (c[i] == '-') {
                st1 = st2;
                st2 = "";
            } else {
                st2 += c[i];

            }
        }if(mods==2) {
            Double one = Double.parseDouble(st1);
            Double two = Double.parseDouble(st2);
            Double th = one - two;
            String pov1 = String.valueOf(th);

            return pov1;
        }else {
            int oneint = Integer.parseInt(st1);
            int twoint = Integer.parseInt(st2);
            int th1 = oneint-twoint;
            String pov1 = String.valueOf(th1);
            return  pov1;
        }
    }
    public String multi(String b) {
        char[] c = b.toCharArray();
        String st1 = "";
        String st2 = "";
        for (int i = 0; i < c.length - 1; i++) {
            if (c[i] == '*') {
                st1 = st2;
                st2 = "";
            } else {
                st2 += c[i];

            }
        }
        if (mods == 2){
            Double one = Double.parseDouble(st1);
        Double two = Double.parseDouble(st2);
        Double th = one * two;
        String pov1 = String.valueOf(th);

        return pov1;
    }else{
        int oneint = Integer.parseInt(st1);
        int twoint = Integer.parseInt(st2);
        int th1 = oneint*twoint;
        String pov1 = String.valueOf(th1);
        return  pov1;
        }
    }
    public String hard(String b) {
        char[] c = b.toCharArray();
        String st1 = "";
        String st2 = "";
        for (int i = 0; i < c.length-1; i++) {

            if (c[i] == '/') {
                st1 = st2;
                st2 = "";
            } else {
                st2 += c[i];

            }
        }
        if(mods==2) {
            try {
                Double one = Double.parseDouble(st1);
                Double two = Double.parseDouble(st2);
                Double th = one / two;
                String pov1 = String.valueOf(th);
                return pov1;
            }catch (ArithmeticException e){
                return "0";
            }
        }else{
            try {
                int oneint = Integer.parseInt(st1);
                int twoint = Integer.parseInt(st2);
                int th1 = oneint / twoint;
                String pov1 = String.valueOf(th1);
                return pov1;
            }catch (ArithmeticException e){
                return "0";
            }
        }
    }
    public String pas(String b) {
        char[] c = b.toCharArray();
        String st1 = "";
        String st2 = "";
        for (int i = 0; i < c.length - 1; i++) {
            if (c[i] == '%') {
                st1 = st2;
                st2 = "";
            } else {
                st2 += c[i];

            }
        }

        if(mods==2) {
            Double one = Double.parseDouble(st1);
            Double two = Double.parseDouble(st2);
            Double th = one / 100 * two;
            String pov1 = String.valueOf(th);
            return  pov1;



        }
        return  "";
    }
}
