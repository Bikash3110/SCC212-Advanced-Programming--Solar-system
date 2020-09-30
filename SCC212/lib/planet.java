import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;

// Inheriting Solar class to remove repeated variables  and codes in this class

public class planet extends PointInSpace {
	
	private double speed ;   // variable contains the speed of planet
	
	// calls the constructor of parent class 
	public planet(double dist, double angle, double dia, String col)
	{
		super(dist,angle,dia,col);                     
	}		
	public void drawplanet(SolarSystem s)
	{	
	     planets(s);                               // calls the drawObject method present in parent class for planets
	}

	//Meathod to manipulate the speed of planet
	public double move(double x)
	{
		speed = x; 
		return speed;
	}
}