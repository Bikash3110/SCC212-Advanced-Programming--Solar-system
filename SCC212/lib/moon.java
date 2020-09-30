import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;

public class moon extends PointInSpace{
	
	private double speed ;      // contains the rotation speed for moon

// 	calling parent class constructor and also including extra required variables in the constructor
	public moon(double dist, double angle, double dia, String col, double Rotd,double RotA)
	{
		super(dist,angle,dia,col);
		this.rotDist = Rotd;                    
		this.rotAngle = RotA;
	}
	public void drawmoon(SolarSystem s, double rotDist, double rotAngle)
	{	
	    moons(s,rotDist,rotAngle);               //calls a meathod from parents class
	}
//meathod used to determine the speed of moon	
	public double move(double x)
	{
		speed = x;
		return speed;
	}
}