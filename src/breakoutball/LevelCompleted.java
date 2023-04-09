/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package breakoutball;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import welcome.SecondPage;

/**
 *
 * @author HP
 */
public final class LevelCompleted extends JFrame implements ActionListener {
    
    JButton RetryButton;
    JButton BackButton;
    JButton NextLevelButton;
    int level;
    int score;
    public LevelCompleted(int level,int score){
        this.level = level;
        this.score = score;
        this.setSize(900,900);        
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(null);
         addScorePoint();
        addBackButton();
        addNextLevelButton();
        addLogo();
       addImage();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        LevelCompleted n = new LevelCompleted(1,30);
    }
       
     public void addBackButton()
    {
        BackButton = new JButton("Back to Home");
        BackButton.setLayout(null);
        BackButton.setBorder(null);
        BackButton.setBounds(250, 540, 160, 70);
        BackButton.setBackground(Color.decode("#3B4CEB"));
        BackButton.setFont(new Font("Sans",Font.PLAIN,20));
        BackButton.setForeground(Color.WHITE);
        BackButton.addActionListener(this);
        this.add(BackButton); 
    }
     public void addNextLevelButton()
    {
        NextLevelButton = new JButton("Next Level");
        NextLevelButton.setLayout(null);
        NextLevelButton.setBorder(null);
        NextLevelButton.setBounds(530, 540, 180, 70);
        NextLevelButton.setBackground(Color.decode("#3B4CEB"));
        NextLevelButton.setFont(new Font("Sans",Font.PLAIN,20));
        NextLevelButton.setForeground(Color.WHITE);
        NextLevelButton.addActionListener(this);
        this.add(NextLevelButton);   
    }
     
     void addImage(){
        ImageIcon ic_logo = new ImageIcon(this.getClass().getResource("LavelCompleted.png"));
        JLabel logo = new JLabel(ic_logo);
        logo.setBounds(0,0,910,900);
        this.add(logo);
    }
     
     void addLogo(){
        ImageIcon ic_logo = new ImageIcon(this.getClass().getResource("LOGO_1.png"));
        JLabel logo = new JLabel(ic_logo);
        logo.setBounds(0,10,64,68);
        this.add(logo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == NextLevelButton){
            this.dispose();
            PlayGame p = new PlayGame();
            if(level<=1)
            p.startGame(level+1);
            else
                p.startGame(level); 
        }
        if(e.getSource() == BackButton){
            this.dispose();
            SecondPage pf = new SecondPage();
        }
    }

    private void addScorePoint() {
        JLabel scorePoint = new JLabel("hello");
        scorePoint.setBounds(490, 345, 100, 50);
        scorePoint.setFont(new Font("Sans",Font.BOLD,45));
        scorePoint.setForeground(Color.WHITE);
        scorePoint.setText(String.valueOf(score));
        this.add(scorePoint);
    }
}
