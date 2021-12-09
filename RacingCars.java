import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RacingCars extends JFrame {
    CarPanel car1;
    CarPanel car2;

    //Constructor
    public RacingCars(){
        setLayout(new GridLayout(2,1));
        car1 = new CarPanel('w',Color.RED);
        car2 = new CarPanel('k',Color.blue);

        car1.setBackground(Color.black);
        this.add(car1, BorderLayout.NORTH);
        this.add(car2, BorderLayout.SOUTH);

        this.addKeyListener(new MyKeyListener());
    }

    class MyKeyListener extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            if(e.getKeyChar()=='w'){
                car1.moveCar();
            }
            if(e.getKeyChar()=='k'){
                car2.moveCar();
            }
        }
    }

    public static void main(String[] args) {
        //Create the frame on the event dispatching thread
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                RacingCars rc = new RacingCars();
                rc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                rc.pack();
                rc.setVisible(true);
            }

        });
    }
}

class CarPanel extends JPanel {

    private char forwardKey = 'w';
    private boolean reachedTarget = false;
    private Color color = Color.blue;
    private int x= 10;
    private int y= 10;

    private int panelWidth;
    private int panelHeight;

    //default Constructor
    public CarPanel(){
    }

    //overloaded Constructor
    public CarPanel(char key, Color color){
        this.forwardKey=key;
        this.color = color;
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.GREEN);
        g.fillOval(0,0,25,25);

        panelWidth= getWidth();
        panelHeight= getHeight();

        //draw a Car
        g.setColor(color);

        //polygon points
        int t_x[]= {x+10,x+20,x+30,x+40};
        int t_y[]= {y+10,y,y,y+10};

        g.fillPolygon(t_x,t_y,t_x.length);
        g.fillRect(x, y+10, 50, 10);
        g.fillArc(x+10, y+20, 10, 10, 0, 360);
        g.fillArc(x+30, y+20, 10, 10, 0, 360);
    }

    @Override
    public Dimension getPreferredSize() {
       return new Dimension(750,100);
    }

    public void moveCar(){
        if(this.x < panelWidth){
            this.x+=10;
            repaint();
        }
    }
}