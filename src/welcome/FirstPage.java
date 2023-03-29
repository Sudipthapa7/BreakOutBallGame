
package welcome;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;


public final class FirstPage extends JFrame implements ActionListener{
    JButton NextButton;
    JButton BackButton;
    
    public FirstPage(){
        this.setSize(900,900);        
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(null);
//         addVideoGif();
         addBackButton();
         addNextButton();
           addLogo();
         addImage();
        this.setVisible(true);
       
    }
//    public static void main(String arg[]){
//        FirstPage firstPage = new FirstPage();
//    }
//    public void addVideoGif(){
//     JPanel welcomeGifPanel = new JPanel();
//     welcomeGifPanel.setLayout(null);
//      ImageIcon welcomegif = new ImageIcon(this.getClass().getResource("gif_play.gif"));
//     JLabel gifLabel = new JLabel(welcomegif);
//     //gifLabel.setBackground(Color.red);
//     //gifLabel.setIcon(welcomegif);
//     welcomeGifPanel.setBounds(250,100,500,600);
//     gifLabel.setBounds(0,0,welcomeGifPanel.getWidth(),welcomeGifPanel.getHeight());
//     welcomeGifPanel.add(gifLabel);
//     this.add(welcomeGifPanel);
//    }
    public void addNextButton(){
//        JPanel nextPanel = new JPanel();
//        JLabel nextLabel = new JLabel();
//        nextLabel.setText(">Next >");
//        nextLabel.setBackground(Color.decode("#94B964"));
//        nextLabel.setFont(new Font("Serif",Font.PLAIN,30));
//        nextLabel.setBounds(0,0,100,60);
//        nextLabel.setOpaque(true);
//        nextPanel.add(nextLabel);
//        nextPanel.setBounds(750,750,100,60);
//        nextPanel.setBackground(Color.decode("#94B964"));
//        this.add(nextPanel);
        NextButton = new JButton("Next >");
        NextButton.setLayout(null);
        NextButton.setBorder(null);
        NextButton.setBounds(760, 760, 100, 60);
        NextButton.setBackground(Color.decode("#94B964"));
        NextButton.setFont(new Font("Sans",Font.PLAIN,18));
        NextButton.setForeground(Color.WHITE);
        NextButton.addActionListener(this);
        this.add(NextButton);
    }
    void addImage(){
        ImageIcon ic_logo = new ImageIcon(this.getClass().getResource("Welcome.png"));
        JLabel logo = new JLabel(ic_logo);
        logo.setBounds(0,0,910,900);
        this.add(logo);
    }
    void addLogo(){
        ImageIcon ic_logo = new ImageIcon(this.getClass().getResource("LOGO_1.png"));
        JLabel logo = new JLabel(ic_logo);
        logo.setBounds(0,20,64,68);
        this.add(logo);
    }
    public void addBackButton()
    {
        BackButton = new JButton("< Back");
        BackButton.setLayout(null);
        BackButton.setBorder(null);
        BackButton.setBounds(20, 760, 100, 60);
        BackButton.setBackground(Color.decode("#94B964"));
        BackButton.setFont(new Font("Sans",Font.PLAIN,18));
        BackButton.setForeground(Color.WHITE);
        BackButton.addActionListener(this);
        this.add(BackButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== BackButton)
        {
            System.exit(0);
        }
        else if(e.getSource() == NextButton)
        {
            this.dispose();
            SecondPage secondPage = new SecondPage();
        }
        
    }

}