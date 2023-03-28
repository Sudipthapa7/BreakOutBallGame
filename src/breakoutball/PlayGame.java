/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package breakoutball;
import welcome.SecondPage;
import breakout_ball_levels.GameBoard;
import breakout_ball_levels.GameLevel_1;
import breakout_ball_levels.GameLevel_2;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author HP
 */
public class PlayGame extends JFrame implements KeyListener,ActionListener{
    Timer timer;
    int Score;
    ScoreBoard score;
    GameBoard gameBoard;
    int PLAYING_WIDTH = 900;
    int PLAYING_HEIGHT = 950;
    
   public PlayGame(){
       this.setSize(PLAYING_WIDTH,PLAYING_HEIGHT);
       this.setLayout(null);
       this.getContentPane().setBackground(Color.WHITE);
       this.setLocationRelativeTo(null);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setVisible(true);    
    }
   
   public void startGame(int level){
       //adding Score Board
       score = new ScoreBoard();
       this.add(score);
       this.setVisible(true);
       //adding game background
       gameBoard = new GameBoard();
       
       if(level==1)
            gameBoard.setLevel(new GameLevel_1());
       else if(level==2)
           gameBoard.setLevel(new GameLevel_2());
       
       gameBoard.addKeyListener(this);
       this.add(gameBoard);   
       timer = new Timer(5,this);
       timer.start();
    }
   
    void scoreCount(){
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        gameBoard.checkAndMovePaddle(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
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
        
        if(gameBoard.isGameOver()){
            timer.stop();
            this.dispose();
            
            SwingUtilities.invokeLater(new Runnable(){
                   public void run(){    
                        PlayGame playGame = new PlayGame();
                        playGame.startGame(1);
                   }
            });
            
            
        }
       else
            gameBoard.repaint();
    }
    //paddle function
    
    
}
    
    
    
    

