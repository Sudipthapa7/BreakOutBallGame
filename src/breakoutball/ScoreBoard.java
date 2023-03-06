/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package breakoutball;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author HP
 */
public class ScoreBoard extends JPanel implements ActionListener {
    Timer timer;
    int score;
  ScoreBoard()
  {
      score = 0;
      this.setBounds(0, 0, 900, 90);
      timer = new Timer(8,this);
      timer.start();
      this.setVisible(true);
  }
  int getScore(){
      return score;
  }
  void setScore(int score){
      this.score = score;
      repaint();
  }
  @Override
  public void paint(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillRect(0, 0, 900, 95);
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
        g.drawString("PlayerName :", 10, 25);
        g.drawString("Score", 10, 65);
         g.drawString(String.valueOf(score),100,65);    
        g.drawString("Time : ", 350, 50);
        g.drawString("Level : 1", 750, 25);
        g.drawString("Life : ", 750, 65);
       
  }

    @Override
    public void actionPerformed(ActionEvent e) {
        ShowScore();
    }

    private void ShowScore() {
         
    }
}
