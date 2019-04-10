
import javax.swing.*;
import javax.swing.Timer;
import java.util.*;
import java.awt.*;

import java.awt.event.*;




public class DotField extends JPanel
{
   
  ArrayList<Dot> Dots = new ArrayList<Dot>();
    


    public DotField()
    {
        this.setPreferredSize(new Dimension(500, 500));
       for(int i=0; i < 100; i++){
            Dots.add(new Dot());   
        
    }
}
    
    public void paintComponent(Graphics g)
    {
        Random rng = new Random();
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color (rng.nextInt(256), rng.nextInt(256), rng.nextInt(256)));
       
       for (Dot d : Dots) {
        double temp1 = d.getX();
        double temp2 = d.getX();
        int tempX = (int) temp1;
        int tempY = (int) temp2;
        g2.fillRect(tempX, tempY, 3, 3);
        }           
       
      
         
    }
   
   
   
         public static void main(String[] args) {
       final JFrame f = new JFrame("Dot Field");
        final DotField df = new DotField();
        f.setLayout(new FlowLayout());
        f.add(df);
       f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                try {
                    df.finalize();
                } catch (Throwable e) {
                    
                    e.printStackTrace();
                }

                f.dispose();
            }
        });
        
        f.pack();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}