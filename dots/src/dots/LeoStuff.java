package dots;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 * Created by leoxiong on 15/01/16.
 */
public class LeoStuff extends JPanel{

    
    public BufferedImage PicIn;



    public LeoStuff() {
        
        Timer timer = new Timer(51, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    repaint();
                }
            });
            timer.start();
            
            


    }


    @Override
    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(PicIn, 000,000, this);
        
    }
    
    /*
    @Override
    public void run() {
        while (true) {
            try {
                repaint();
                Thread.sleep(30);
            } catch (Exception e) {
            }
        }
    }
*/
}

