/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class GameLevel_2 extends GameLevel{
    private int ballMotionY = 5;
    private int ballMotionX = 5;
     int BRICK_ROW = 8;
    int BRICK_COLUMN = 12;
   public GameLevel_2(){
        BRICK_HEIGHT = 20;
        BRICK_WIDTH = 60;
          bricks = new ArrayList<>();
           for(int i=0;i<6;i++){
            List<BricksModel> brick = new ArrayList<>();
            for(int j=0;j<12-(i*2);j++)
                brick.add(new BricksModel());
          bricks.add(brick);
        }
    }
    @Override
    public void drawBricks(Graphics g) {
        //drawing first loop
        for(int i=0;i<6;i++){
            for(int j=0;j<BRICK_COLUMN-(i*2);j++){
                if(!bricks.get(i).get(j).isDestroyed()){
                       g.setColor(Color.blue);
                       g.fillRect(((60+i*65)+(j*65)), (150+(i*25)), BRICK_WIDTH, BRICK_HEIGHT);   
                  } 
            }
        }   
    }

    
    public int checkBrickDestroyed(int ballXpos, int ballYpos) {
        int flag = 0;
         for(int i=0;i<6;i++){
            for(int j=0;j<12-i*2;j++){
                 Rectangle brick = new Rectangle(((60+i*65)+(j*65)), (i*25+150), BRICK_WIDTH, BRICK_HEIGHT);
                 Rectangle ball = new Rectangle(ballXpos,ballYpos,20,20);
                 if(!bricks.get(i).get(j).isDestroyed()){
                  if(brick.intersects(ball)){
                      flag = 1;
                       bricks.get(i).get( j).setDestroyed(true);
//                     System.out.println("cordinate of intersection is "+brick.intersection(ball));
//                     System.out.println("X point of brick -> "+brick.x+" Y point of brick -> "+brick.y);
//                     System.out.println("X point of ball -> "+ball.x+" Y point of ball is -> "+ball.y);
                     if((ballXpos) < ((60+i*65)+(j*65)) || (ballXpos) >= (60+(j*65)+BRICK_WIDTH)){
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

    @Override
    public int[] checkAndMoveBall(int ballXpos, int ballYpos, int paddleXpos) {
        ballXpos +=ballMotionX;
        ballYpos +=ballMotionY;
        if(ballXpos<=0||ballXpos>860){
            ballMotionX =-ballMotionX;
        }
        if(ballYpos<=100)
            ballMotionY =-ballMotionY;
        Rectangle ball = new Rectangle(ballXpos,ballYpos,20,20);
        Rectangle paddle = new Rectangle(paddleXpos,700,200,10);
         if(paddle.intersects(ball))
              ballMotionY =-ballMotionY;
        int flag = checkBrickDestroyed(ballXpos,ballYpos);
            int [] pos = {ballXpos,ballYpos,flag};
            return pos;
    }

    @Override
    public String getLeve() {
        return "2";
    }

    @Override
    public void setBallMotionY(int motion) {
         ballMotionY = -ballMotionY;
    }
    
}
