/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package breakout_ball_levels;

import breakoutball.BricksModel;
import java.awt.Graphics;
import java.util.List;

/**
 *
 * @author HP
 */
public abstract class GameLevel {
    int BRICK_HEIGHT;
    int BRICK_WIDTH;
    int BRICK_COLOUMN;
    int BRICK_ROW;
    
   public List <List<BricksModel>> bricks;
   
   abstract public  void drawBricks(Graphics g);
   // abstract public void checkBrickDestroyed(int ballXpos,int ballYpos);
    abstract public int[] checkAndMoveBall(int ballXpos,int ballYpos,int paddleXpos);
    abstract public String getLeve();  
    abstract public void setBallMotionY(int motion);
    
}
