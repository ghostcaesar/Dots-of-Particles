package dots;

import java.awt.Color;
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


    }
}