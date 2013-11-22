import java.awt.Dimension;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Game implements Runnable {
	
	static Panel panel;
	
	public static void main(String [] args){
		
		JFrame frame = new JFrame ("Snake");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new Panel (1200, 800);
		frame.getContentPane().add(panel);
		panel.setFocusable(true);
		panel.setPreferredSize(new Dimension (1200,800));
		panel.requestFocus();
		
		frame.pack();
		frame.setVisible(true);
		
		(new Thread(new Game ())).start();
	}
	
	public void run() {
		while (!Thread.interrupted()){
			try {
       			Thread.sleep(10);
       		} catch (InterruptedException e) {
       		}
			if ((panel.collideWall() || panel.collideBody())==false)
				panel.moveSnake();
		}	
	}
}
