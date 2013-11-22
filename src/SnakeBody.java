import java.awt.Graphics;


public class SnakeBody {
	
	private int [][] positions;
	private int bodyParts;
	
	public SnakeBody(){
		bodyParts=0;
		positions = new int [2][5000];
	}
	
	public void addPart(int x, int y){
		if (bodyParts==0){
			positions[0][bodyParts] = x;
			positions[1][bodyParts] = y;
			positions[0][bodyParts+1] = x;
			positions[1][bodyParts+1] = y;
			bodyParts+=2;
		}
		else{
			positions[0][bodyParts] = positions[0][bodyParts-1];
			positions[1][bodyParts] = positions[1][bodyParts-1];
			positions[0][bodyParts+1] = positions[0][bodyParts-1];
			positions[1][bodyParts+1] = positions[1][bodyParts-1];
			positions[0][bodyParts+2] = positions[0][bodyParts-1];
			positions[1][bodyParts+2] = positions[1][bodyParts-1];
			positions[0][bodyParts+3] = positions[0][bodyParts-1];
			positions[1][bodyParts+3] = positions[1][bodyParts-1];
			positions[0][bodyParts+4] = positions[0][bodyParts-1];
			positions[1][bodyParts+4] = positions[1][bodyParts-1];
			bodyParts+=5;
		}
	}
	
	public void move(int x, int y){
			
		for (int i=bodyParts-1; i>0; i--){
			positions[0][i]=positions[0][i-1];
			positions[1][i]=positions[1][i-1];
		}
		positions[0][0]=x;
		positions[1][0]=y;
	}
	
	public void draw (Graphics g){
		for (int i=0;i<bodyParts;i++){
			g.fillRect(positions[0][i]*20, positions[1][i]*20, 20, 20);
		}
	}
	
	public boolean checkCollide(int x, int y){
		for (int i=2;i<bodyParts;i++){
			if (positions[0][i]==x && positions[1][i]==y)
				return true;
		}
		return false;
	}
	
	public int bodyPartX(int index){
		return positions[index][0];
	}
	public int bodyPartY(int index){
		return positions[index][1];
	}
}
