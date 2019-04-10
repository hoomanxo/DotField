
import javax.swing.*;
import javax.swing.Timer;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.*;

public class DotFieldWithTimer extends DotField{
  
    Timer timer; 
   
   
      public DotFieldWithTimer (){
       this.setPreferredSize(new Dimension(500,500));


 
    timer = new Timer(40, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent ae) {
        for (Dot d : dots) {
            d.move();
        }
        repaint();
    }
});
    timer.start();  

}
   public void paintComponent(Graphics g) {
      
        Random rng = new Random();
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color (rng.nextInt(256), rng.nextInt(256), rng.nextInt(256)));
  for (Dot d : dots) {
      double temp1 = d.getX();
        double temp2 = d.getX();
        int tempX = (int) temp1;
        int tempY = (int) temp2;  
        g2.fillRect(tempX, tempY, 3, 3);
        }           

    }
   public static void main(String[] args) {
        final JFrame f = new JFrame("Particle Field With Timer");
        final DotFieldWithTimer dft = new DotFieldWithTimer();
        f.setLayout(new FlowLayout());
        f.add(dft);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                try {
                    dft.finalize();
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