/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dots;

import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author sheng
 */
public class Display implements Runnable {

    ListIterator iterLoc;
    int[] colLoc;
    BufferedImage picsLoc;
    
    public void run()
    {
        try{
            while(true)
            {
            for(int i=0;i<960000;i++)
            {
            colLoc[i] = 0;

           }
            AddDots(iterLoc,colLoc);

            picsLoc.setRGB(0, 0, 1200, 800, colLoc, 0, 1200);
            //leoLoc.PicIn = picsLoc;
            Thread.sleep(20);
            }
        }
        catch(Exception e){};
    }
    
    Display(ListIterator iter,LeoStuff leo1,int[] col,BufferedImage pics)
    {
        iterLoc=iter;
        colLoc=col;
        picsLoc= pics;
        leo1.PicIn=picsLoc;
        

    }
    
    private boolean full(int i, int j,LinkedList points)
    {
        Iterator iter = points.iterator();
        Point a;
        double xfloat,yfloat;
        while(iter.hasNext())
        {
            a = (Point) iter.next();
            xfloat=a.pos[0]-i;
            yfloat=a.pos[1]-j;
            if(xfloat<=0.5f&&xfloat>-0.5f &&yfloat<=0.5f&&yfloat>-0.5f ) {
                return true;
            }
        }
        return false;
    }
    
        private boolean AddDots(ListIterator iter, int[] col)
    {
        Point a;
        double xpos,ypos;

        if(iter.hasNext())
        {
            while(iter.hasNext())
            {
                a = (Point) iter.next();
                xpos=a.pos[0];
                ypos=a.pos[1];

                 if(ypos<800&&xpos<1200)
                {
                    if(ypos>0&&xpos>0)
                    {
                        int indexPos = 1200*(int)ypos+(int)xpos;
                        int Pixel = col[indexPos];

                        if (Pixel ==0)
                            col[indexPos] =  0b000000000101010100000000;  //start at 85G
                        else if( Pixel < 0b000000001111100000000000)
                            col[indexPos] += 0b000000000000111000000000;
                    }
                }
            }
        }
        else if(iter.hasPrevious())
        {
            while(iter.hasPrevious())
            {
                a = (Point) iter.previous();
                xpos=a.pos[0];
                ypos=a.pos[1];

                if(ypos<800&&xpos<1200)
                {
                    if(ypos>0&&xpos>0)
                    {
                        int indexPos = 1200*(int)ypos+(int)xpos;
                        int Pixel = col[indexPos];

                        if (Pixel ==0)
                            col[indexPos] =  0b000000000101010100000000;  //start at 85G
                        else if( Pixel < 0b000000001111100000000000)
                            col[indexPos] += 0b000000000000111000000000;
                    }
                }
            }
        }
            
        return false;
    }
    
}
