import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;

//Solar class Inherited to the sun class  

public class sun extends PointInSpace{
	
	public sun(double dist,double angle,double dia,String col)
	{
		super(dist, angle, dia, col);      // parent class constructor called
	  
	}		
	public void drawsun(SolarSystem s)
	{	
	    planets(s);                        // parent class method called to make sun
	}
}