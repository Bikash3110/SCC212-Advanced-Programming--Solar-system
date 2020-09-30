import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;

// point in space class which describes the space and its objects
public class PointInSpace{
	
	 double Dist,Angle,Dia,rotDist,rotAngle;
	 String Col;
	
	//counstructor which consist of variables that is common for the objects in space
	 public PointInSpace(double dist, double angle, double dia, String col)
	{
		this.Dist = dist;
		this.Angle = angle;
		this.Dia = dia;
		this.Col = col;
	}		
	
   // meathod to draw solar objects	
	public void planets(SolarSystem s)
	{
		s.drawSolarObject(Dist,Angle,Dia,Col);
	}
	
	// meathods to draw solar object about
	public void moons(SolarSystem s,double rotDist,double rotAngle)
	{    	
		s.drawSolarObjectAbout(Dist,Angle,Dia,Col,rotDist,rotAngle);
	}
	
}