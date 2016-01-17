package dots;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 * Created by sheng on 15/01/16.
 */
public class Window extends JFrame {
    
    public LeoStuff panel;
    
    public Window() {
        panel = new LeoStuff();
        add(panel);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setVisible(true);
        this.setBackground(Color.black);
        
                    addWindowListener(new WindowAdapter() 
            {
                @Override
                public void windowClosing(WindowEvent e) {
                 System.exit(0);
                     }
            });


    }
}