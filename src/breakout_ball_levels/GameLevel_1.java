
package breakout_ball_levels;

import breakoutball.BricksModel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class GameLevel_1 extends GameLevel {
    int BRICK_ROW = 8;
    int BRICK_COLUMN = 12;
    private int ballMotionY = 5;
    private int ballMotionX = 5;
//    int Score = 0;
    
    
   public GameLevel_1(){
        BRICK_HEIGHT = 20;
        BRICK_WIDTH = 60;
        bricks = new ArrayList<>();
        for(int i=0;i<8;i++){
            List<BricksModel> brick = new ArrayList<>();
            for(int j=0;j<12;j++)
                brick.add(new BricksModel());
          bricks.add(brick);
        }
    }
    
    void startDrawing(){
        
    }
    @Override
    public void drawBricks(Graphics g) {
        for(int i=0;i<BRICK_ROW;i++){
            for(int j=0;j<BRICK_COLUMN;j++){
                if(!bricks.get(i).get(j).isDestroyed()){
                       g.setColor(Color.blue);
                       g.fillRect((60+(j*65)), (150+(i*25)), BRICK_WIDTH, BRICK_HEIGHT);   
                  } 
            }
        }
    }
     public int checkBrickDestroyed(int ballXpos,int ballYpos) {
         int flag = 0;
        for(int i=0;i<8;i++){
            for(int j=0;j<12;j++){
                if(!bricks.get(i).get(j).isDestroyed()){
                 Rectangle brick = new Rectangle((60+(j*65)), (i*25+150), BRICK_WIDTH, BRICK_HEIGHT);
                 Rectangle ball = new Rectangle(ballXpos,ballYpos,20,20);
                 if(brick.intersects(ball)){
                     flag = 1;
                     bricks.get(i).get(j).setDestroyed(true);
                     if((ballXpos) < (60+(j*65)) || (ballXpos) >= (60+(j*65)+BRICK_WIDTH)){
                          ballMotionX =-ballMotionX;
                     }
                     else{
                        ballMotionY =-ballMotionY;
                     }
                }
                     
                }
            }   
        }
        return flag;
    } 
    public int[] checkAndMoveBall(int ballXpos,int ballYpos,int paddleXpos){
        ballXpos +=ballMotionX;
        ballYpos +=ballMotionY;
        if(ballXpos<=0||ballXpos>860){
            ballMotionX =-ballMotionX;
        }
        if(ballYpos<=100)
            ballMotionY =-ballMotionY;
        Rectangle ball = new Rectangle(ballXpos,ballYpos,20,20);
        Rectangle paddle = new Rectangle(paddleXpos,700,200,10);
        if(paddle.intersects(ball)){
//              if((paddle.x+160)<ball.x)
//              ballMotionX = 5;
//              else if((paddle.x+130)<ball.x)
//                  ballMotionX = 4;
//              else if((paddle.x+110)<ball.x)
//                  ballMotionX = 2;
//              else if((paddle.x+100)<=ball.x||(paddle.x+90)<=ball.x)
//                  ballMotionX = 0;
//              else if((paddle.x+80)<ball.x) 
//                  ballMotionX = -2;
//              else if((paddle.x+60)<ball.x)
//                  ballMotionX = -4;
//              else 
//                  ballMotionX = -5;
              ballMotionY =-ballMotionY;
              System.out.println("paddle cordinate "+paddle.getBounds());
              System.out.println("Ball cordinate "+ball.getBounds());
              System.out.println("-----------------------------------------------------");
        } 
         int flag = checkBrickDestroyed(ballXpos,ballYpos);
            int [] pos = {ballXpos,ballYpos,flag};
            return pos;
      
  } 

    @Override
    public String getLeve() {
        return "1";
    }

    @Override
    public void setBallMotionY(int motion) {
           ballMotionY = -ballMotionY;
    }
      
}  
    





