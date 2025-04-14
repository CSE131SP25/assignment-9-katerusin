package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Mouse extends Food {

	private double yVelocity;
	private Color mouseColor;
	
	public Mouse() {
		super(true);
		yVelocity = Math.random()*.006-.003;
		mouseColor = Color.GRAY;
	}
	
	public void draw() {
		StdDraw.setPenColor(mouseColor);
		StdDraw.setPenRadius();
		StdDraw.filledEllipse(getX(), getY(), .035, .02); //body
		StdDraw.filledEllipse(getX()-.03, getY()+.015, .02, .016); //head
		StdDraw.filledEllipse(getX()-.043, getY()+.012, .012, .01); //nose
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.filledEllipse(getX()-.055, getY()+.0135, .0035, .0035); //nose
		StdDraw.setPenColor(170,170,170);
		StdDraw.filledEllipse(getX()+.013, getY()-.0059, .015, .012); //haunches
		StdDraw.setPenColor(250,200,200);
		StdDraw.filledEllipse(getX()+.0019, getY()-.019, .01, .0047); //back foot
		StdDraw.filledEllipse(getX()-.028, getY()-.013, .005, .008); //front foot
		StdDraw.setPenColor(250,250,250);
		StdDraw.line(getX()-.045, getY()+.013, getX()-.03, getY()+.018 ); //whiskers
		StdDraw.line(getX()-.048, getY()+.008, getX()-.03, getY()+.008 );
		StdDraw.setPenColor(160,160,160);
		StdDraw.filledEllipse(getX()-.023, getY()+.028, .016, .012); //ear
		StdDraw.setPenColor(135,135,135);
		StdDraw.filledEllipse(getX()-.026, getY()+.024, .01, .007);
		StdDraw.setPenColor();
		StdDraw.setPenRadius(.005);
		StdDraw.point(getX()-.042, getY()+.02); //eye

	}
	
	public void updateFood(){
		setX(getX()-.004);
		setY(getY()+yVelocity);
	}
	
}
