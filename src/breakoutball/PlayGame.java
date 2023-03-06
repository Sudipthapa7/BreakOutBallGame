/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package breakoutball;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author HP
 */
public final class PlayGame extends JFrame{
    int Score;
    ScoreBoard score;
    GameDraw draw;
    int PLAYING_WIDTH = 900;
    int PLAYING_HEIGHT = 950;
    PlayGame(){
       this.setSize(PLAYING_WIDTH,PLAYING_HEIGHT);
       this.setLayout(null);
       this.getContentPane().setBackground(Color.WHITE);
       this.setLocationRelativeTo(null);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setVisible(true);
      
    }
    void startGame(){
       //adding Score Board
       score = new ScoreBoard();
       this.add(score);
       this.setVisible(true);
       //adding game background
       draw = new GameDraw(score,this);
       this.add(draw);  
    }
   
    void scoreCount(){
        
    }
    
}
    
    
    
    

