/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dots;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author sheng
 */
public class Point {
    //x,y,z
    public double[] pos={0,0,0};
    public double[] vel={0,0,0};
    public double[] acc={0,0,0};
    //+- 100 units
    
    Point()
    {
        Random rnd = new Random();

      pos[0] = rnd.nextFloat()*1200;
      
      pos[1] = rnd.nextFloat()*800;
      
      pos[2] = rnd.nextFloat()*800;

    }
    
    public void FindAcc(double[] CoG)
    {
        double difx = (CoG[0]-pos[0])*10;
        double dify = (CoG[1]-pos[1])*10;
        //double difz = (CoG[2]-pos[2])*10;    
        
        double distSq = difx*difx+dify*dify;
        double dist = Math.sqrt(distSq);
        
        //fake grav
        //acc[0] = 0.1*difx+800*1/(difx*Math.abs(difx)*difx*difx)+(RNG-0.5)*500;
        //acc[1] = 0.1*dify+1200*1/(dify*Math.abs(dify)*dify*dify)+(RNG-0.5)*750;
        //acc[2] = 0.5*difz+800*1/(difz*Math.abs(difz))+(RNG-0.5)*500;
        
        //acc[0] = Math.copySign(Math.exp(-difx*difx/1000000),difx);
        //acc[1] = Math.copySign(Math.exp(-dify*dify/1000000),dify);
        double acceleration = Math.exp(-distSq/5000000);
        acc[0] = difx*acceleration/dist;
        acc[1] = dify*acceleration/dist;
        
        //acc[2] = 0.5*difz+800*1/(difz*Math.abs(difz))
    }
    
    public void FindVel()
    {
       
        vel[0] += acc[0];//+(RNG-0.5)*10;
        vel[1] += acc[1];//+(RNG-0.5)*15;
        vel[2] += acc[2];//+(RNG-0.5)*10;
        
        vel[0]*= 0.97;
        vel[1]*= 0.97;
        vel[2]*= 0.97;
    }
    
    public void UpdatePos(double[] CoG)
    {
        FindAcc(CoG);
        FindVel();
        pos[0] +=vel[0]*0.7;//+ CoG.get(0)*0.01f;
        pos[1] +=vel[1]*0.7;//+ CoG.get(1)*0.01f;        
        pos[2] +=vel[2]*0.7;//+ CoG.get(2)*0.01f;
        
    }
    
}
