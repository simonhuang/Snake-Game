import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Food{
	
	private int x,y;
	
	public Food(){
		x=(int)(Math.random()*60);
		y=(int)(Math.random()*35)+5;
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void draw (Graphics g){
		g.setColor(Color.RED);
		g.fillRect(x*20, y*20, 20, 20);
		g.setColor(Color.BLACK);
	}
}
