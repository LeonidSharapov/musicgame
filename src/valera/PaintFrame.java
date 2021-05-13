package valera;
import  java.awt.*;
import  java.awt.geom.*;
import  java.awt.event.*;
import  java.io.*;
import  javax.swing.*;
import  javax.swing.event.*;
import  java.awt.image.*;
import  javax.imageio.*;
import  javax.swing.filechooser.FileFilter;
class PaintFrame {
    // „Q„u„w„y„} „‚„y„ƒ„€„r„p„~„y„‘
    int rezhim = 0;
    int xPad;
    int xf;
    int yf;
    int yPad;
    int thickness;
    boolean pressed = false;
    // „„„u„{„…„‹„y„z „ˆ„r„u„„
    Color maincolor;
   PanelPaint japan;
    JButton colorbutton;
    JColorChooser tcc;
    // „„€„r„u„‚„‡„~„€„ƒ„„„ „‚„y„ƒ„€„r„p„~„y„‘
    BufferedImage imag;
    // „u„ƒ„|„y „}„ „x„p„s„‚„…„w„p„u„} „{„p„‚„„„y„~„{„…
    boolean loading = false;
    String fileName;

    public PaintFrame() {
        FramePaint mypaint= new FramePaint();
        mypaint.setSize(1280, 1024);

        maincolor = Color.black;

        JMenuBar menuBar = new JMenuBar();
        mypaint.setJMenuBar(menuBar);
        menuBar.setBounds(0, 0, 350, 30);
        JMenu fileMenu = new JMenu("„U„p„z„|");
        menuBar.add(fileMenu);

        Action loadAction = new AbstractAction("„H„p„s„‚„…„x„y„„„") {
            public void actionPerformed(ActionEvent event) {
                JFileChooser jf = new JFileChooser();
                int result = jf.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    try {
                        // „„‚„y „r„„q„€„‚„u „y„x„€„q„‚„p„w„u„~„y„‘ „„€„t„ƒ„„„‚„p„y„r„p„u„} „‚„p„x„}„u„‚„ „†„€„‚„}„
                        // „y „„p„~„u„|„y „„€„t „‚„p„x„}„u„‚„ „t„p„~„~„€„s„€ „y„x„€„q„‚„p„w„u„~„y„‘
                        fileName = jf.getSelectedFile().getAbsolutePath();
                        File iF = new File(fileName);
                        jf.addChoosableFileFilter(new TextFileFilter(".png"));
                        jf.addChoosableFileFilter(new TextFileFilter(".jpg"));
                        imag = ImageIO.read(iF);
                        loading = true;
                        mypaint.setSize(imag.getWidth() + 40, imag.getWidth() + 80);
                        japan.setSize(imag.getWidth(), imag.getWidth());
                        japan.repaint();
                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(mypaint, "„S„p„{„€„s„€ „†„p„z„|„p „~„u „ƒ„…„‹„u„ƒ„„„r„…„u„„");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(mypaint, "„I„ƒ„{„|„„‰„u„~„y„u „r„r„€„t„p-„r„„r„€„t„p");
                    } catch (Exception ex) {
                    }
                }
            }
        };
        JMenuItem loadMenu = new JMenuItem(loadAction);
        fileMenu.add(loadMenu);

        Action saveAction = new AbstractAction("„R„€„‡„‚„p„~„y„„„") {
            public void actionPerformed(ActionEvent event) {
                try {
                    JFileChooser jf = new JFileChooser();
                    // „R„€„x„t„p„u„} „†„y„|„„„„‚„  „†„p„z„|„€„r
                    TextFileFilter pngFilter = new TextFileFilter(".png");
                    TextFileFilter jpgFilter = new TextFileFilter(".jpg");
                    if (fileName == null) {
                        // „D„€„q„p„r„|„‘„u„} „†„y„|„„„„‚„
                        jf.addChoosableFileFilter(pngFilter);
                        jf.addChoosableFileFilter(jpgFilter);
                        int result = jf.showSaveDialog(null);
                        if (result == JFileChooser.APPROVE_OPTION) {
                            fileName = jf.getSelectedFile().getAbsolutePath();
                        }
                    }
                    // „R„}„€„„„‚„y„} „{„p„{„€„z „†„y„|„„„„‚ „r„„q„‚„p„~
                    if (jf.getFileFilter() == pngFilter) {
                        ImageIO.write(imag, "png", new File(fileName + ".png"));
                    } else {
                        ImageIO.write(imag, "jpeg", new File(fileName + ".jpg"));
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(mypaint, "„O„Š„y„q„{„p „r„r„€„t„p-„r„„r„€„t„p");
                }
            }
        };
        JMenuItem saveMenu = new JMenuItem(saveAction);
        fileMenu.add(saveMenu);

        Action saveasAction = new AbstractAction("„R„€„‡„‚„p„~„y„„„ „{„p„{...") {
            public void actionPerformed(ActionEvent event) {
                try {
                    JFileChooser jf = new JFileChooser();
                    // „R„€„x„t„p„u„} „†„y„|„„„„‚„ „t„|„‘ „†„p„z„|„€„r
                    TextFileFilter pngFilter = new TextFileFilter(".png");
                    TextFileFilter jpgFilter = new TextFileFilter(".jpg");
                    // „D„€„q„p„r„|„‘„u„} „†„y„|„„„„‚„
                    jf.addChoosableFileFilter(pngFilter);
                    jf.addChoosableFileFilter(jpgFilter);
                    int result = jf.showSaveDialog(null);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        fileName = jf.getSelectedFile().getAbsolutePath();
                    }
                    // „R„}„€„„„‚„y„} „{„p„{„€„z „†„y„|„„„„‚ „r„„q„‚„p„~
                    if (jf.getFileFilter() == pngFilter) {
                        ImageIO.write(imag, "png", new File(fileName + ".png"));
                    } else {
                        ImageIO.write(imag, "jpeg", new File(fileName + ".jpg"));
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(mypaint, "Error");
                }
            }
        };
        JMenuItem saveasMenu = new JMenuItem(saveasAction);
        fileMenu.add(saveasMenu);

        japan = new PanelPaint();
        japan.setBounds(30, 30, 3333, 2333);
        japan.setBackground(Color.white);
        japan.setOpaque(true);
        mypaint.add(japan);

        JToolBar toolbar = new JToolBar("Toolbar", JToolBar.VERTICAL);

        JButton penbutton = new JButton(new ImageIcon("pen.png"));
        penbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                rezhim = 0;
            }
        });
        toolbar.add(penbutton);
        JButton brushbutton = new JButton(new ImageIcon("brush.png"));
        brushbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                rezhim = 1;
            }
        });
        toolbar.add(brushbutton);

        JButton lasticbutton = new JButton(new ImageIcon("lastic.png"));
        lasticbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                rezhim = 2;
            }
        });
        toolbar.add(lasticbutton);

        JButton textbutton = new JButton(new ImageIcon("text.png"));
        textbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                rezhim = 3;
            }
        });
        toolbar.add(textbutton);

        JButton linebutton = new JButton(new ImageIcon("line.png"));
        linebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                rezhim = 4;
            }
        });
        toolbar.add(linebutton);

        JButton elipsbutton = new JButton(new ImageIcon("elips.png"));
        elipsbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                rezhim = 5;
            }
        });
        toolbar.add(elipsbutton);

        JButton rectbutton = new JButton(new ImageIcon("rect.png"));
        rectbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                rezhim = 6;
            }
        });
        toolbar.add(rectbutton);

        toolbar.setBounds(0, 0, 30, 300);
        mypaint.add(toolbar);

        // „S„…„|„q„p„‚ „t„|„‘ „{„~„€„„€„{
        JToolBar colorbar = new JToolBar("Colorbar", JToolBar.HORIZONTAL);
        colorbar.setBounds(30, 0, 260, 30);
        colorbutton = new JButton();
        colorbutton.setBackground(maincolor);
        colorbutton.setBounds(15, 5, 20, 20);
        colorbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ColorDialog coldi = new ColorDialog(mypaint, "„B„„q„€„‚ „ˆ„r„u„„„p");
                coldi.setVisible(true);
            }
        });
        colorbar.add(colorbutton);

        JButton redbutton = new JButton();
        redbutton.setBackground(Color.red);
        redbutton.setBounds(40, 5, 15, 15);
        redbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                maincolor = Color.red;
                colorbutton.setBackground(maincolor);
            }
        });
        colorbar.add(redbutton);

        JButton orangebutton = new JButton();
        orangebutton.setBackground(Color.orange);
        orangebutton.setBounds(60, 5, 15, 15);
        orangebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                maincolor = Color.orange;
                colorbutton.setBackground(maincolor);
            }
        });
        colorbar.add(orangebutton);

        JButton yellowbutton = new JButton();
        yellowbutton.setBackground(Color.yellow);
        yellowbutton.setBounds(80, 5, 15, 15);
        yellowbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                maincolor = Color.yellow;
                colorbutton.setBackground(maincolor);
            }
        });
        colorbar.add(yellowbutton);

        JButton greenbutton = new JButton();
        greenbutton.setBackground(Color.green);
        greenbutton.setBounds(100, 5, 15, 15);
        greenbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                maincolor = Color.green;
                colorbutton.setBackground(maincolor);
            }
        });
        colorbar.add(greenbutton);

        JButton bluebutton = new JButton();
        bluebutton.setBackground(Color.blue);
        bluebutton.setBounds(120, 5, 15, 15);
        bluebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                maincolor = Color.blue;
                colorbutton.setBackground(maincolor);
            }
        });
        colorbar.add(bluebutton);

        JButton cyanbutton = new JButton();
        cyanbutton.setBackground(Color.cyan);
        cyanbutton.setBounds(140, 5, 15, 15);
        cyanbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                maincolor = Color.cyan;
                colorbutton.setBackground(maincolor);
            }
        });
        colorbar.add(cyanbutton);

        JButton magentabutton = new JButton();
        magentabutton.setBackground(Color.magenta);
        magentabutton.setBounds(160, 5, 15, 15);
        magentabutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                maincolor = Color.magenta;
                colorbutton.setBackground(maincolor);
            }
        });
        colorbar.add(magentabutton);

        JButton whitebutton = new JButton();
        whitebutton.setBackground(Color.white);
        whitebutton.setBounds(180, 5, 15, 15);
        whitebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                maincolor = Color.white;
                colorbutton.setBackground(maincolor);
            }
        });
        colorbar.add(whitebutton);

        JButton blackbutton = new JButton();
        blackbutton.setBackground(Color.black);
        blackbutton.setBounds(200, 5, 15, 15);
        blackbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                maincolor = Color.black;
                colorbutton.setBackground(maincolor);
            }
        });
        colorbar.add(blackbutton);
        colorbar.setLayout(null);
        mypaint.add(colorbar);

        tcc = new JColorChooser(maincolor);
        tcc.getSelectionModel().addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                maincolor = tcc.getColor();
                colorbutton.setBackground(maincolor);
            }
        });
        japan.addMouseMotionListener(   new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (pressed == true) {
                    Graphics g = imag.getGraphics();
                    Graphics2D g2 = (Graphics2D) g;
                    // „…„ƒ„„„p„~„€„r„{„p „ˆ„r„u„„„p
                    g2.setColor(maincolor);
                    switch (rezhim) {
                        // „{„p„‚„p„~„t„p„Š
                        case 0:
                            g2.drawLine(xPad, yPad, e.getX(), e.getY());
                            break;
                        // „{„y„ƒ„„„
                        case 1:
                            g2.setStroke(new BasicStroke(3.0f));
                            g2.drawLine(xPad, yPad, e.getX(), e.getY());
                            break;
                        // „|„p„ƒ„„„y„{
                        case 2:
                            g2.setStroke(new BasicStroke(3.0f));
                            g2.setColor(Color.WHITE);
                            g2.drawLine(xPad, yPad, e.getX(), e.getY());
                            break;
                    }
                    xPad = e.getX();
                    yPad = e.getY();
                }
                japan.repaint();
            }
        });
        japan.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                Graphics g = imag.getGraphics();
                Graphics2D g2 = (Graphics2D) g;
                // „…„ƒ„„„p„~„€„r„{„p „ˆ„r„u„„„p
                g2.setColor(maincolor);
                switch (rezhim) {
                    // „{„p„‚„p„~„t„p„Š
                    case 0:
                        g2.drawLine(xPad, yPad, xPad + 1, yPad + 1);
                        break;
                    // „{„y„ƒ„„„
                    case 1:
                        g2.setStroke(new BasicStroke(3.0f));
                        g2.drawLine(xPad, yPad, xPad + 1, yPad + 1);
                        break;
                    // „|„p„ƒ„„„y„{
                    case 2:
                        g2.setStroke(new BasicStroke(3.0f));
                        g2.setColor(Color.WHITE);
                        g2.drawLine(xPad, yPad, xPad + 1, yPad + 1);
                        break;
                    // „„„u„{„ƒ„„
                    case 3:
                        // „…„ƒ„„„p„~„p„r„|„y„r„p„u„} „†„€„{„…„ƒ „t„|„‘ „„p„~„u„|„y,
                        // „‰„„„€„q„ „„u„‰„p„„„p„„„ „~„p „~„u„z „„„u„{„ƒ„„
                        japan.requestFocus();
                        break;
                }
                xPad = e.getX();
                yPad = e.getY();

                pressed = true;
                japan.repaint();
            }

            public void mousePressed(MouseEvent e) {
                xPad = e.getX();
                yPad = e.getY();
                xf = e.getX();
                yf = e.getY();
                pressed = true;
            }

            public void mouseReleased(MouseEvent e) {

                Graphics g = imag.getGraphics();
                Graphics2D g2 = (Graphics2D) g;
                // „…„ƒ„„„p„~„€„r„{„p „ˆ„r„u„„„p
                g2.setColor(maincolor);
                // „O„q„‹„y„u „‚„p„ƒ„ƒ„‰„u„„„ „t„|„‘ „€„r„p„|„p „y „„‚„‘„}„€„…„s„€„|„„~„y„{„p
                int x1 = xf, x2 = xPad, y1 = yf, y2 = yPad;
                if (xf > xPad) {
                    x2 = xf;
                    x1 = xPad;
                }
                if (yf > yPad) {
                    y2 = yf;
                    y1 = yPad;
                }
                switch (rezhim) {
                    // „|„y„~„y„‘
                    case 4:
                        g.drawLine(xf, yf, e.getX(), e.getY());
                        break;
                    // „{„‚„…„s
                    case 5:
                        g.drawOval(x1, y1, (x2 - x1), (y2 - y1));
                        break;
                    // „„‚„‘„}„€„…„s„€„|„„~„y„{
                    case 6:
                        g.drawRect(x1, y1, (x2 - x1), (y2 - y1));
                        break;
                }
                xf = 0;
                yf = 0;
                pressed = false;
                japan.repaint();
            }
        });
        japan.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                // „…„ƒ„„„p„~„p„r„|„y„r„p„u„} „†„€„{„…„ƒ „t„|„‘ „„p„~„u„|„y,
                // „‰„„„€„q„ „„u„‰„p„„„p„„„ „~„p „~„u„z „„„u„{„ƒ„„
                japan.requestFocus();
            }

            public void keyTyped(KeyEvent e) {
                if (rezhim == 3) {
                    Graphics g = imag.getGraphics();
                    Graphics2D g2 = (Graphics2D) g;
                    // „…„ƒ„„„p„~„€„r„{„p „ˆ„r„u„„„p
                    g2.setColor(maincolor);
                    g2.setStroke(new BasicStroke(2.0f));

                    String str = new String("");
                    str += e.getKeyChar();
                    g2.setFont(new Font("Arial", 0, 15));
                    g2.drawString(str, xPad, yPad);
                    xPad += 10;
                    // „…„ƒ„„„p„~„p„r„|„y„r„p„u„} „†„€„{„…„ƒ „t„|„‘ „„p„~„u„|„y,
                    // „‰„„„€„q„ „„u„‰„p„„„p„„„ „~„p „~„u„z „„„u„{„ƒ„„
                    japan.requestFocus();
                    japan.repaint();
                }
            }
        });
        mypaint.addComponentListener(new ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                // „u„ƒ„|„y „t„u„|„p„u„} „x„p„s„‚„…„x„{„…, „„„€ „y„x„}„u„~„u„~„y„u „‚„p„x„}„u„‚„€„r „†„€„‚„}„
                // „€„„„‚„p„q„p„„„„r„p„u„} „r „{„€„t„u „x„p„s„‚„…„x„{„y
                if (loading == false) {
                    japan.setSize(mypaint.getWidth() - 40, mypaint.getHeight() - 80);
                    BufferedImage tempImage = new BufferedImage(japan.getWidth(), japan.getHeight(), BufferedImage.TYPE_INT_RGB);
                    Graphics2D d2 = (Graphics2D) tempImage.createGraphics();
                    d2.setColor(Color.white);
                    d2.fillRect(0, 0, japan.getWidth(), japan.getHeight());
                    tempImage.setData(imag.getRaster());
                    imag = tempImage;
                    japan.repaint();
                }
                loading = false;
            }
        });
        mypaint.setLayout(null);

        mypaint.setVisible(true);

    }



    class ColorDialog extends JDialog {
        public ColorDialog(JFrame owner, String title) {
            super(owner, title, true);
            add(tcc);
            setSize(200, 200);
        }
    }

    static class FramePaint extends JFrame {
        public void paint(Graphics g) {
            super.paint(g);
            super.setDefaultCloseOperation(super.DISPOSE_ON_CLOSE);
        }

        public FramePaint() {
            super("paint");
        }
    }

    class PanelPaint extends JPanel {
        public PanelPaint() {
        }

        public void paintComponent(Graphics g) {
            if (imag == null) {
                imag = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D d2 = (Graphics2D) imag.createGraphics();
                d2.setColor(Color.white);
                d2.fillRect(0, 0, this.getWidth(), this.getHeight());
            }
            super.paintComponent(g);
            g.drawImage(imag, 0, 0, this);
        }

    }
    public class TextFileFilter extends FileFilter {
        private String down;
        public TextFileFilter(String down)
        {
            this.down=down;
        }
        public boolean accept(java.io.File file)
        {
            if (file.isDirectory()) return true;
            return (file.getName().endsWith(down));
        }
        public String getDescription()
        {
            return "*"+down;
        }
    }
}