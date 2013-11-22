import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;

public class Snake {
	
	private int x, y;
	private int dir;
	
	public Snake (int x, int y, int dir){
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	public void draw (Graphics g){

		g.fillRect(x*20, y*20, 20, 20);
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	//1 is up, 2 is down, 3 is left, 4 is right
	public void move (){
		if (dir == 1)
			y--;
		else if (dir == 2)
			y++;
		else if (dir == 3) 
			x--;
		else
			x++;
	}
	
	//true is right, false is left
	public void turn (int direction, int snakeBodyX, int snakeBodyY){
		if (dir==1 || dir==2){
			if (direction == 3 && y!=snakeBodyY)
				dir=direction;
			else if (direction == 4 && y!=snakeBodyY)
				dir=direction;
		}
		else if (dir==3 || dir==4){
			if (direction == 1 && x!=snakeBodyX)
				dir=direction;
			else if (direction == 2 && x!=snakeBodyX)
				dir=direction;
		}
	}
}
