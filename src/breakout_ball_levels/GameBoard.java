/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package breakout_ball_levels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author HP
 */
public class GameBoard extends JPanel{
    private int paddleXpos = 300;
    private int ballXpos = 250;
    private int ballYpos = 600;
//    private int ballMotionY = -5;
//    private int ballMotionX = 5;
    int score = 0;
    int life;
    GameLevel gameLevel;
   
    public GameBoard(){
        this.setBounds(0, 0, 900, 950);
        this.setFocusable(true);//to Listen to key Events
        this.setVisible(true);
        life = 3;
    }
    
    public void setLevel(GameLevel gameLevel){
        this.gameLevel = gameLevel;
       
    }
     public void paint(Graphics g){
        //painting background
        g.setColor(Color.decode("#333"));
        g.fillRect(0, 0, 900, 950);
        //DrawBall
        g.setColor(Color.red);
        g.fillOval(ballXpos, ballYpos, 20, 20);
        //DrawPaddle
        g.setColor(Color.red);
        g.fillRect(paddleXpos,700,200,10);
        //drawing setting score board
        drawScoreBoard(g);
        //Draw Bricks
        gameLevel.drawBricks(g);
    }
     public void checkAndMovePaddle(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_LEFT&&paddleXpos>=20){
            paddleXpos -=20;
        }
        else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&paddleXpos<=680){
        paddleXpos +=20;
    }
        repaint();
    }
    //ballfunction
    public void checkAndMoveBall(){
      int [] result = gameLevel.checkAndMoveBall(ballXpos, ballYpos,paddleXpos);
      ballXpos = result[0];
      ballYpos = result[1];
      //getting flag from checkAndMoveBall
      if(result[2]==1)
          score++;
  } 
    
    public void checkBrickDestroyed() {
      // gameLevel.checkBrickDestroyed(ballXpos,ballYpos);
       
    }  
    
   public boolean isGameOver(){
        if(ballYpos >=705 && ballYpos <706){
             life--; 
            gameLevel.setBallMotionY(-1);
             
        }
        if(life==-1){
            JOptionPane.showMessageDialog(null, "Game over!!! press OK to play again");
              return true;   
        }
        return false;
    }   

    private void drawScoreBoard(Graphics g) {
         g.setColor(Color.ORANGE);
        g.fillRect(0, 0, 900, 95);
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
        g.drawString("PlayerName :", 10, 25);
        g.drawString("Score", 10, 65);
         g.drawString(String.valueOf(score),100,65);    
        g.drawString("Time : ", 350, 50);
        g.drawString("Level : "+gameLevel.getLeve(), 750, 25);
        g.drawString("Life : "+life, 750, 65);
    }
}
