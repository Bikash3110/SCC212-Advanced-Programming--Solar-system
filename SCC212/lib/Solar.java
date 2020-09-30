import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;

public class Solar{
	
	private int totalAst = 400;
	private double[] vel = {0,0,0,0,0,0,0,0,0};                                         // initial placment value of planets
	private double[] mVel={0,45,90,45,75,150};                                          // initial placment of moons 
	private double[] dist={60,90,150,190,290,360,410,460,490};                          // distance of each planet from sun
	private double[] planetSize={10,20,30,26,50,45,40,35,9};
	private double[] moonSize={6,4,4,7,7,7};                                             // moon sizes 
	private String[] planetCol={"RED","ORANGE","BLUE","ORANGE","GREY","DARK GREY","WHITE","CYAN","PINK"};
	private String[] moonCol={"WHITE","PINK","WHITE","PINK","WHITE","CYAN"};
	private double[] planetSpeed= {5,4,3.5,2.7,2.3,2.5,1.8,2.1,1.5};                      // planets speed 
	
	private double[] ast = new double[totalAst];                                 // used to make astroids appear at random angle astroids belt
    private int[] n = new int[totalAst];                                         // and at random distance 
   
    private planet[] planets = new planet[9];                                   
	private moon[] moons = new moon[6];
	
	private PointInSpace[] p = new PointInSpace[9] ;                                        // instances of PointInSpace for planets
	private PointInSpace[] pAst = new PointInSpace[totalAst];                               // instances of PointInSpace for astroids

   // constructor	
	public Solar()
	{	
	  SolarSystem solar = new SolarSystem(1000,1000);
	                                              
      planet[] astroids = new planet[400];      //   generating arrays of astroids 
	  for(int i =0; i<totalAst; i++)              
	  { 
		  Random rand = new Random();                     
 		  ast[i] =(double)rand.nextInt(360);        // generate random astroids angle
		  n[i] = rand.nextInt(30) + 220;            // generate random astroids distance between 220 and 250 units
	  }	  

	  // loop starts 
	
	while(true){	
	  sun s = new sun(0,0,80,"YELLOW");              // sun is created
	  PointInSpace pSun = (PointInSpace) s;          //polymorphism used
	  pSun.planets(solar);                             
	  
	  // Planets created in the for loop
	  for(int i=0;i<9;i++)
	  {
		planets[i] = new planet(dist[i],vel[i],planetSize[i],planetCol[i]);
		p[i] = (PointInSpace)planets[i];		// Polymorphism
		p[i].planets(solar);
        	
			
			
	   //EARTH moon
		if(i==2)
		{
		 moons[0] = new moon(dist[i],vel[i],moonSize[0],moonCol[0],20,mVel[0]);
	     moons[0].drawmoon(solar,20,mVel[0]);
	     mVel[0]+= moons[0].move(5);                   //rotational movement of earth moon
		}
		
		// MARS MOONS
		if(i==3)
		{
		  moons[1] = new moon(dist[i],vel[i],moonSize[1],moonCol[1],20,mVel[1]);
	      moons[1].drawmoon(solar,20,mVel[1]);
	      moons[2] = new moon(dist[i],vel[i],moonSize[2],moonCol[2],20,mVel[2]);
	      moons[2].drawmoon(solar,20,mVel[2]);
	      mVel[1]+= moons[1].move(3.5);                                  // Movements of mars moons
	      mVel[2]+= moons[2].move(3.5);
		}
         // JUPITOR MOON 
        if(i==4)
		{
			moons[3] = new moon(dist[i],vel[i],moonSize[3],moonCol[3],35,mVel[3]);
	        moons[3].drawmoon(solar,35,mVel[3]);
	        moons[4] = new moon(dist[i],vel[i],moonSize[3],moonCol[4],35,mVel[4]);
	        moons[4].drawmoon(solar,35,mVel[4]);
	        moons[5] = new moon(dist[i],vel[i],moonSize[3],moonCol[5],35,mVel[5]);
	        moons[5].drawmoon(solar,35,mVel[5]);
	        mVel[3]+= moons[3].move(3.0);
	        mVel[4]+= moons[4].move(3.0);                     // Movements of jupitor moons
	        mVel[5]+= moons[5].move(3.0);
		}
		
		vel[i]+= planets[i].move(planetSpeed[i]);          // used for movement of planet 
	  }
	 
	  //astroids
	   
	  for(int i =0; i<totalAst; i++)
	  {
		  astroids[i] = new planet(n[i],ast[i],3,"WHITE");          //Astroids created 
		  pAst[i] = (planet) astroids[i];                           // polymorphism
		  pAst[i].planets(solar);
          ast[i]+= astroids[i].move(0.2);                            // movement of astroids
		  
	  }
	  
      solar.finishedDrawing();	                              // Draws the objects in space
	 }
	 // loop ends
	}
	
	public static void main(String []args)
	{
	  Solar s = new Solar();			
	}
}