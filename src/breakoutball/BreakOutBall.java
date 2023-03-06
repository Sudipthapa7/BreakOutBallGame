/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package breakoutball;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author HP
 */
public final class BreakOutBall extends JFrame implements ActionListener,MouseListener{

    /**
     * @param args the command line arguments
     */
    JPanel leftPanel;
    JPanel mainPanel;
    JLabel textLabel;
    JLabel settingLabel;
    JLabel howLabel;
    JLabel exitLabel;
    JButton playButton;
//  JButton playButton;
    JLabel ic_setting;
    JLabel ic_how; 
    JLabel ic_exit;
    static Clip clip;
    BreakOutBall(){
        
        this.setSize(900,950);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addLeftPanel();
        addMainPanel();
        addPlayButton();
        addLogo();
        //this.setBackground(Color.WHITE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        BreakOutBall b =  new BreakOutBall(); 
        Thread musicPlay = new Thread(new Runnable(){
            @Override
            public void run() {
                 playBackgroundMusic();
            }
            
        });
        musicPlay.start();
        
    }
    static void playBackgroundMusic(){
       File musicFile = new File("Res/audio_2.wav");
      try{
        if(musicFile.exists()){
            System.out.println("file exits");
            AudioInputStream ais = AudioSystem.getAudioInputStream(musicFile);
            clip  = AudioSystem.getClip();
            clip.open(ais);
            clip.start();  
        }  
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, "can't play music sorry!");
          
      }
        
    }
    void addLogo(){
        ImageIcon ic_logo = new ImageIcon(this.getClass().getResource("LOGO_1.png"));
        JLabel logo = new JLabel(ic_logo);
        logo.setBounds(2,5,64,68);
        this.add(logo);
    }
    void addLeftPanel(){
        ImageIcon ic_setting_icon = new ImageIcon(this.getClass().getResource("ic_setting.png"));
        ic_setting = new JLabel(ic_setting_icon);
        ImageIcon ic_how_icon = new ImageIcon(this.getClass().getResource("ic_how_2.png"));
         ic_how = new JLabel(ic_how_icon);
        ImageIcon ic_exit_icon = new ImageIcon(this.getClass().getResource("exit_2.png"));
         ic_exit = new JLabel(ic_exit_icon);
        
        settingLabel = new JLabel();
        howLabel = new JLabel();
        exitLabel  = new JLabel();
        leftPanel = new JPanel();
        
        settingLabel.setText("Setting");
        howLabel.setText("How to Play");
        exitLabel.setText("Exit");
        
        settingLabel.setBounds(100, 110, 130, 40);
       ic_setting.setBounds(105,90,90,30);
       settingLabel.setFont(new Font("Sans",Font.PLAIN,30));
       settingLabel.setForeground(Color.WHITE);
       ic_setting.addMouseListener(this);
       howLabel.setBounds(80, 250, 170, 40);
       ic_how.setBounds(105,220,90,30);
       howLabel.setFont(new Font("Sans",Font.PLAIN,30));
       howLabel.setForeground(Color.WHITE);
       ic_how.addMouseListener(this);
       exitLabel.setBounds(120, 400, 90, 30);
       ic_exit.setBounds(105,370,90,30);
       ic_exit.addMouseListener(this);//ALL LABELS MUST IMPLEMENT THIS .addMouseListener(this)
       exitLabel.setFont(new Font("Sans",Font.PLAIN,30));
       //exitLabel.setOpaque(true);
       exitLabel.setForeground(Color.WHITE);
       
        leftPanel.setLayout(null);
        //SETING COLOR TO LEFTPANEL
        leftPanel.setBackground(Color.decode("#9452FF"));
        leftPanel.setBounds(0, 100, 300, 840);
        leftPanel.add(ic_setting);
        leftPanel.add(ic_how);
        leftPanel.add(ic_exit);
        leftPanel.add(howLabel);
        leftPanel.add(exitLabel);
        leftPanel.add(settingLabel);
        //adding leftPanle to Parent JFrame;
        this.add(leftPanel);
    }
    void addMainPanel()
    {
       
        ImageIcon ic_gif = new ImageIcon(this.getClass().getResource("gif_play.gif"));
        JLabel animated_gif = new JLabel(ic_gif);
        textLabel  = new JLabel();
        mainPanel = new JPanel();
        
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBounds(320, 70, 600, 500);
        animated_gif.setBounds(20,180,500,300);
        textLabel.setBounds(20, 20, 580, 150);
        textLabel.setFont(new Font("Sans",Font.PLAIN,30));
        textLabel.setForeground(Color.BLUE);
        textLabel.setText("Welcome to most adventurous game!!!");
        mainPanel.add(textLabel);
        mainPanel.add(animated_gif);
        this.add(mainPanel);
    }
    
    void addPlayButton()
    {
        playButton = new JButton("Play");
//        Dimension size = playbutton.getPreferredSize();
        playButton.setLayout(null);
        playButton.setBorder(null);
        playButton.setBounds(450, 600,200, 60);
        playButton.setBackground(Color.decode("#C52FEA"));
        playButton.setFont(new Font("Sans",Font.PLAIN,40));
        playButton.setForeground(Color.WHITE);
       // playButton.setBorder(new RoundBorder(20));
       playButton.addActionListener(this);
        this.add(playButton);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==playButton){
           //JOptionPane.showMessageDialog(null,"Loading...");
           this.dispose();
           PlayGame playGame = new PlayGame();   
           playGame.startGame();
       }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==ic_exit){
            System.exit(0);
        }
       if(e.getSource()==ic_setting){
         this.dispose();
         GameSetting setting = new GameSetting();  
       }
       else if(e.getSource()==ic_how){
           this.dispose();
           GameHowToPlay howTo = new GameHowToPlay();
       }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }
}
