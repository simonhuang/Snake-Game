import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;


public class Panel extends JPanel implements KeyListener{

	private int width, height;
	private int counter;
	
	private Food food;
	private Snake snake;
	private SnakeBody sbody;
	private Font font;
	private boolean turnSnake;
	private KeyEvent event;
	
	private Score score;
	
	public Panel(int w, int h){
		super();
		addKeyListener(this);
		
		width = w;
		height = h;
		counter = 0;
		
		turnSnake = false;
		
		snake = new Snake (30,20,1);
		sbody = new SnakeBody();
		food = new Food ();
		score = new Score();
		font = new Font ("Arial", Font.PLAIN, 36);
	}
	
	public void paintComponent (Graphics g){
		if (collideWall() || collideBody()){
			g.setColor(Color.RED);
			g.setFont(font);
			g.clearRect(470, 300, 280, 80);
			g.drawString("GAME OVER", 500, 350);
			g.setColor(Color.BLACK);
		}
		else{
			g.clearRect(0, 0, 1200, 800);
			
			for (int i=100; i< height;i+=20){
				g.drawLine(0, i, width, i);
			}
			for (int i=20; i< width;i+=20){
				g.drawLine(i, 100, i, height);
			};
			
			food.draw(g);
			
			snake.draw(g);
			sbody.draw(g);
			score.draw(g);
		}
	}

	
	public void checkEat(){
		if (snake.getX() == food.getX() && snake.getY() == food.getY()){

			sbody.addPart(snake.getX(), snake.getY());
			food = new Food();
			while (sbody.checkCollide (food.getX(), food.getY()))
				food = new Food();
			score.incrementScore();
		}
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		turnSnake = true;
		event = e;
		
		repaint();
	}
	
	public void moveSnake() {
		if (counter == 3) {
			if (turnSnake)
			{
				if (event.getKeyCode() == KeyEvent.VK_DOWN){
					snake.turn(2, sbody.bodyPartX(0), sbody.bodyPartY(0));
				}
				else if (event.getKeyCode() == KeyEvent.VK_UP){
					snake.turn(1, sbody.bodyPartX(0), sbody.bodyPartY(0));
				}
				else if (event.getKeyCode() == KeyEvent.VK_LEFT){
					snake.turn(3, sbody.bodyPartX(0), sbody.bodyPartY(0));
				}
				else if (event.getKeyCode() == KeyEvent.VK_RIGHT){
					snake.turn(4, sbody.bodyPartX(0), sbody.bodyPartY(0));
				}
				turnSnake = false;
			}
			sbody.move(snake.getX(), snake.getY());
			snake.move();
			checkEat();
			repaint();
			counter = 0;
		}
		else{
			counter++;
		}
	}
	
	public boolean collideWall(){
		if (snake.getX() > 60 || snake.getX() < 0 || snake.getY()>40 || snake.getY()<5 )
			return true;
		else 
			return false;
	}
	
	public boolean collideBody(){
		
		return sbody.checkCollide(snake.getX(), snake.getY());
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
