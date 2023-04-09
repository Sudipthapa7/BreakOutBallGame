  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package breakoutball;
import breakout_ball_levels.GameBoard;
import breakout_ball_levels.GameLevel_1;
import breakout_ball_levels.GameLevel_2;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author HP
 */
public class PlayGame extends JFrame implements KeyListener,ActionListener{
    Timer timer;
    ScoreBoard scoreBoard;
    GameBoard gameBoard;
    int PLAYING_WIDTH = 900;
    int PLAYING_HEIGHT = 950;
    boolean paused;
    
   public PlayGame(){
  
       this.setSize(PLAYING_WIDTH,PLAYING_HEIGHT);
       this.setLayout(null);
       this.getContentPane().setBackground(Color.WHITE);
       this.setLocationRelativeTo(null);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setVisible(true);    
    }
   
   public void startGame(int level){
       paused = false;
       //adding Score Board
       scoreBoard = new ScoreBoard();
       this.add(scoreBoard);
       this.setVisible(true);
       //adding game background
       gameBoard = new GameBoard();
       
       if(level==1)
            gameBoard.setLevel(new GameLevel_1());
       else if(level==2)
           gameBoard.setLevel(new GameLevel_2());
       
       gameBoard.addKeyListener(this);
       this.add(gameBoard);   
       timer = new Timer(6,this);
       timer.start();
    }
   

    @Override
    public void keyTyped(KeyEvent e) {
        gameBoard.checkAndMovePaddle(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
          if(e.getKeyCode()==KeyEvent.VK_SPACE){
              if(!paused){
                  timer.stop();
                  paused = true;
                   JOptionPane.showMessageDialog(null, "Game Paused, press Space to Restart ");
                    timer.start();
                    paused = false;
              } 

          }
        
          gameBoard.checkAndMovePaddle(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        gameBoard.checkAndMovePaddle(e);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameBoard.checkAndMoveBall();
       // gameBoard.checkBrickDestroyed();
        int check = gameBoard.isGameOver();
        if(check==-1){
            timer.stop();
            this.dispose();
            SwingUtilities.invokeLater(new Runnable(){
                   public void run(){    
                        NewGame ng = new NewGame(gameBoard.getLevel(),gameBoard.score);
                        
                   }
            });
            
            
        }
        else if(check==1){
            timer.stop();
            this.dispose();
            SwingUtilities.invokeLater(new Runnable(){
                   public void run(){    
                        LevelCompleted completed = new LevelCompleted(gameBoard.getLevel(),gameBoard.score);
                        
                   }
            });
        }
       else
            gameBoard.repaint();
    }
    //paddle function
    
    
}
    
    
    
    

