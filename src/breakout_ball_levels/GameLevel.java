
package breakout_ball_levels;

import breakoutball.BricksModel;
import java.awt.Graphics;
import java.util.List;

/**
 *
 * @author Team Greenary
 */
public abstract class GameLevel {
    int BRICK_HEIGHT;
    int BRICK_WIDTH;
    int BRICK_COLOUMN;
    int BRICK_ROW;
    int gameScore;
    
   public List <List<BricksModel>> bricks;
   public List <List<BricksModel>> bricks_2;
   public List <List<BricksModel>> bricks_3;
   
   abstract public  void drawBricks(Graphics g);
   // abstract public void checkBrickDestroyed(int ballXpos,int ballYpos);
    abstract public int[] checkAndMoveBall(int ballXpos,int ballYpos,int paddleXpos);
    abstract public String getLeve();  
    abstract public void setBallMotionY(int motion);
    abstract public int getPassingScore();  
}
