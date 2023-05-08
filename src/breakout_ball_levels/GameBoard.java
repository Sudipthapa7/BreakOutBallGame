
package breakout_ball_levels;

import breakoutball.NewGame;
import breakoutball.ScoreBoard;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Team Greenary
 */
public class GameBoard extends JPanel{
    private int paddleXpos = 300;
    private int ballXpos = 250;
    private int ballYpos = 600;
    ScoreBoard scoreBoard;
    Rectangle paddle;
    public int score = 0;
    int life;
    GameLevel gameLevel;
    Scanner sc;
    File file;
    String pName ;
     int move=0;
     boolean press;
    public GameBoard(){
        readSetting();
        scoreBoard = new ScoreBoard();
        this.setBounds(0, 0, 900, 950);
        this.setFocusable(true);//to Listen to key Events
        this.setVisible(true);
        life = 3;
        scoreBoard.setLife(life);
        
    }
     public void readSetting(){
         try{
             file = new File("setting.txt");
             sc = new Scanner(file);
             if(sc.hasNext()) pName = sc.nextLine();    
             sc.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }
    public void setLevel(GameLevel gameLevel){
        this.gameLevel = gameLevel;
        scoreBoard.setLevel(gameLevel.getLeve());
        scoreBoard.setPlayerName(pName);
    }
    public int getLevel(){
        return Integer.parseInt(gameLevel.getLeve());
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
        g.fillRect(paddleXpos,850,200,10);
        //drawing setting score board
        drawScoreBoard(g);
        //Draw Bricks
        gameLevel.drawBricks(g);
    }
     public void checkAndMovePaddle(KeyEvent e, boolean pressed){
      press = pressed;
        if(e.getKeyCode()==KeyEvent.VK_LEFT&&paddleXpos>=20){
         move = -10;
        }
        else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&paddleXpos<=680){
       move = 10;
    }
        else if(e.getKeyCode()==KeyEvent.VK_RIGHT && e.getKeyCode()== KeyEvent.VK_SHIFT &&paddleXpos<=680){
        move = 50;
    }
        else if(e.getKeyCode()==KeyEvent.VK_LEFT && e.getKeyCode()== KeyEvent.VK_SHIFT &&paddleXpos>=20){
       move = -50;
    }
        Thread t = new Thread(new Runnable(){
             @Override
             public void run() {
                while(press){  
                 if(paddleXpos>=20&&move<0)
                  paddleXpos += move;  
                 else if(paddleXpos<=680&&move>0)
                  paddleXpos += move;  
                try{
                    Thread.sleep(10);
                }catch(Exception e){
                    e.printStackTrace();
                }
        }    
             }
         });
        t.start();
        repaint();
        
    }
    //ballfunction
    public void checkAndMoveBall(){
      int [] result = gameLevel.checkAndMoveBall(ballXpos, ballYpos,paddleXpos);
      ballXpos = result[0];
      ballYpos = result[1];
      //getting flag from checkAndMoveBall
      if(result[2]==1){
           score++;
           scoreBoard.setScore(score);
      }
         
  } 
    
   public int isGameOver(){
       Rectangle invisibleWall = new Rectangle(0,862,900,1);
       Rectangle ball = new Rectangle(ballXpos,ballYpos,20,20);
        if(invisibleWall.intersects(ball)){ 
            paddle = new Rectangle(paddleXpos,850,200,10);
            double paddleXcenter = paddle.getCenterX();
             ballXpos = (int)paddleXcenter;
             ballYpos = 830;
            gameLevel.setBallMotionY(-1); 
            life--;
            scoreBoard.setLife(life);
          }
         if(life<=0){
              return -1;   
        }
        if(score==gameLevel.getPassingScore()){
            return 1;
        }
        
        return 0;
    }   
    public void incTime(){
        scoreBoard.incTime();
    }
    private void drawScoreBoard(Graphics g) {
         scoreBoard.draw(g);

    }
}
