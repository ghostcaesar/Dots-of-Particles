/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dots;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

/**
 *
 * @author sheng
 */
public class Dots{

    static int[] col = new int[960000];
                
    static LinkedList universe;
    
    Thread T;
    
    //center of Gravity
    static double[] CoG = {600f,400f,400f};
            
    Dots()
    {
        
        universe = new LinkedList();
        
        //100points
        for(int i =0;i<100000;i++)
        {
            universe.add(new Point());
        }
    }

    
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Window tempWin = new Window();
        
                //moved from 
        tempWin.panel.setDoubleBuffered(true);
        
        Dots dots1 = new Dots();
        
        MousePointer thd = new MousePointer(CoG,tempWin);    
        new Thread(thd).start();
        
        BufferedImage pics = new BufferedImage(1200, 800,BufferedImage.TYPE_INT_RGB);;
        
        Point p;
        
        ListIterator iter = universe.listIterator(0);
        
        Display dispThread =new Display(iter,tempWin.panel,col,pics);
        new Thread(dispThread).start();
        
        while(true)
        {
                //p.FindAccel(dots1.CoG);
            iter = universe.listIterator(0);
            while(iter.hasNext())
            {
            p=(Point) iter.next();
            p.UpdatePos(dots1.CoG);
            }
            Thread.sleep(30);
           
        }
        
    }
}
   
    

