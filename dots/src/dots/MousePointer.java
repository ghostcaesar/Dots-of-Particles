/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dots;

import static dots.Dots.CoG;

/**
 *
 * @author sheng
 */
public class MousePointer implements Runnable{
    
    double[] CoGTemp = {0,0,0};
    Window winTemp;
    
    Thread T;
    
    public MousePointer(double[] CoG, Window winIn)
    {
        CoGTemp = CoG;
        winTemp = winIn;
        
    }
    
    @Override
    public void run()
    {
                while (true) {
            try {
            CoGTemp[0]=winTemp.getMousePosition().x;
            CoGTemp[1]=winTemp.getMousePosition().y;
            Thread.sleep(30);
            }
            catch(Exception e)
            {}
        }
    
    }
    
}
