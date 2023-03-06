/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package breakoutball;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author HP
 */
public final class GameDraw extends JPanel implements KeyListener,ActionListener {
    private final int BRICK_WIDTH = 60;
    private final int BRICK_HEIGHT = 20;
    private int paddleXpos = 300;
    private int ballXpos = 200;
    private int ballYpos = 400;
    private int ballMotionY = 5;
    private int ballMotionX = 5;
    int Score = 0;
    Timer timer;
    List <List<BricksModel>> bricks;
    ScoreBoard scoreBoard;
    PlayGame play;
    boolean isGameOver = false;
    GameDraw(ScoreBoard score,PlayGame play){
        this.play = play;
        this.scoreBoard = score;
        bricks = new ArrayList<>();
        for(int i=0;i<8;i++){
            List<BricksModel> brick = new ArrayList<>();
            for(int j=0;j<12;j++)
                brick.add(new BricksModel());
          bricks.add(brick);
        }
        this.setBounds(0, 100, 900, 950);
        this.addKeyListener(this);
        this.setFocusable(true);//to Listen to key Events
        timer = new Timer(8,this);
        timer.start();
        this.setVisible(true);
    }
    
    void startDrawing(){
        
    }
    @Override
    public void paint(Graphics g){
        //painting background
        g.setColor(Color.decode("#333"));
        g.fillRect(0, 0, 900, 850);
        //DrawBall
        g.setColor(Color.red);
        g.fillOval(ballXpos, ballYpos, 20, 20);
        //DrawPaddle
        g.setColor(Color.red);
        g.fillRect(paddleXpos,600,200,10);
        //scoreboard

        //Draw Bricks
        for(int i=0;i<8;i++){  
            for(int j=0;j<12;j++){ 
                  if(!bricks.get(i).get(j).isDestroyed()){
                       g.setColor(Color.blue);
                       g.fillRect((60+(j*65)), (60+(i*25)), BRICK_WIDTH, BRICK_HEIGHT);   

                  }
            }  
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        checkAndMovePaddle(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        checkAndMoveBall();
        checkBrickDestroyed();
        checkGameOver();
        repaint();   
    }
    //paddle function
    void checkAndMovePaddle(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_LEFT&&paddleXpos>=20){
            paddleXpos -=20;
        }
        else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&paddleXpos<=680){
        paddleXpos +=20;
    }
        repaint();
    }
    //ballfunction
    void checkAndMoveBall(){
        ballXpos +=ballMotionX;
        ballYpos +=ballMotionY;
        if(ballXpos<=0||ballXpos>860){
            ballMotionX =-ballMotionX;
        }
        if(ballYpos<=0)
            ballMotionY =-ballMotionY;
        Rectangle ball = new Rectangle(ballXpos,ballYpos,20,20);
        Rectangle paddle = new Rectangle(paddleXpos,600,200,10);
        for(int i=0;i<8;i++){
            for(int j=0;j<12;j++){
                if(!bricks.get(i).get(j).isDestroyed()){
                Rectangle brick = new Rectangle((60+(j*65)), (i*25+60), BRICK_WIDTH, BRICK_HEIGHT);
                 if(brick.intersects(ball)){
//                   System.out.println("Intersection point : is ->"+brick.intersection(ball)); 
//                   System.out.println("Ball Bounds is : -> "+ball.getBounds());
//                   System.out.println("brick bound is  is" + brick.getBounds());
//                   System.out.println("----------------------------------------------------------------\n");
                     if((ballXpos) < (60+(j*65)) || (ballXpos) >= (60+(j*65)+BRICK_WIDTH)){
                          ballMotionX =-ballMotionX;
                     }
                     else{
                   ballMotionY =-ballMotionY;
                     }
                     //Increase the score on every collision
                      scoreBoard.setScore(++Score);
                   
                }
               }
             }
          }

        if(paddle.intersects(ball))
            ballMotionY =-ballMotionY;
//        if else(paddle.intersects(brick))
//                ballMotionY =-ballMotionY;
      
  } 
    
     

    private void checkBrickDestroyed() {
        for(int i=0;i<8;i++){
            for(int j=0;j<12;j++){
                if(!bricks.get(i).get(j).isDestroyed()){
                Rectangle brick = new Rectangle((60+(j*65)), (i*25+60), BRICK_WIDTH, BRICK_HEIGHT);
                 Rectangle ball = new Rectangle(ballXpos,ballYpos,20,20);
                 if(brick.intersects(ball))
                     bricks.get(i).get(j).setDestroyed(true);
                }
            }   
        }
    }  
    
   void checkGameOver(){
        if(ballYpos >=605 && ballYpos <606){
//            System.out.println("Game Over!!!");
             JOptionPane.showMessageDialog(null, "Game over!!! press OK to play again");
              isGameOver = true;
              timer.stop();
              play.dispose();
            BreakOutBall b =  new BreakOutBall(); 
              //restartGame();    
        }
    } 
   void restartGame(){
       PlayGame p = new PlayGame();
       p.startGame();
   }
}  
    

   

