package welcome;
import breakoutball.PlayGame;
import breakoutball.GameSetting;
import breakoutball.Profile;
import breakoutball.Help;
import java.awt.Color;
import static java.awt.Color.WHITE;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *
 * @author Team Greenary
 */
public final class SecondPage extends JFrame implements ActionListener, MouseListener{
    JButton SettingButton;
    JButton HelpButton;
    JButton ExitButton;
    JLabel LevelOne;
    JLabel LevelTwo;
    JLabel LevelThree;
    JButton BackButton;
   public SecondPage()
    {
        this.setSize(900, 900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(WHITE);
        addLogo();
        addSettingButton();
        addHelpButton();
        addExitButton();
        addBackButton();
        addLabel_1();
        addLabel_2();
        addLabel_3();
        addImage();
        this.setVisible(true);
        
    }
    void addImage(){
        ImageIcon ic_logo = new ImageIcon(this.getClass().getResource("Second.png"));
        JLabel logo = new JLabel(ic_logo);
        logo.setBounds(0,0,920,900);
        this.add(logo);
    }
    void addLogo(){
        ImageIcon ic_logo = new ImageIcon(this.getClass().getResource("LOGO_1.png"));
        JLabel logo = new JLabel(ic_logo);
        logo.setBounds(20,20,64,68);
        this.add(logo);
    }
 
    public void addSettingButton()
    {
        SettingButton = new JButton("Setting");
        SettingButton.setLayout(null);
        SettingButton.setBorder(null);
        SettingButton.setBounds(360, 270, 170, 70);
        SettingButton.setFont(new Font("Sans",Font.PLAIN,40));
        SettingButton.setForeground(Color.BLUE);
        SettingButton.addActionListener(this);
        SettingButton.addMouseListener(this);

        this.add(SettingButton);
    }
    public void addHelpButton()
    {
        HelpButton = new JButton("Help");
        HelpButton.setLayout(null);
        HelpButton.setBorder(null);
        HelpButton.setBounds(360, 370, 170, 70);
        HelpButton.setFont(new Font("Sans",Font.PLAIN,40));
        HelpButton.setForeground(Color.BLUE);
        HelpButton.addActionListener(this);
        HelpButton.addMouseListener(this);

        this.add(HelpButton);
    }
    public void addExitButton()
    {
        ExitButton = new JButton("Exit");
        ExitButton.setLayout(null);
        ExitButton.setBorder(null);
        ExitButton.setBounds(360, 470, 170, 70);
        ExitButton.setFont(new Font("Sans",Font.PLAIN,40));
        ExitButton.setForeground(Color.BLUE);
        ExitButton.addActionListener(this);
        ExitButton.addMouseListener(this);

        this.add(ExitButton);
    }
    public void addLabel_1()
    {
        LevelOne =  new JLabel("  Level 1");
        LevelOne.setLayout(null);
        LevelOne.setBorder(null);
        LevelOne.setBounds(70, 630, 230, 180);
        LevelOne.setBackground(WHITE);
        LevelOne.setOpaque(true);
        LevelOne.setFont(new Font("Sans",Font.PLAIN,50));
        LevelOne.addMouseListener(this);
        this.add(LevelOne);
    }
    public void addLabel_2()
    {
        LevelTwo =  new JLabel("  Level 2");
        LevelTwo.setLayout(null);
        LevelTwo.setBorder(null);
        LevelTwo.setBounds(330, 630, 230, 180);
        LevelTwo.setBackground(WHITE);
        LevelTwo.setOpaque(true);
        LevelTwo.setFont(new Font("Sans",Font.PLAIN,50));
        LevelTwo.addMouseListener(this);
        this.add(LevelTwo);
    }
    public void addLabel_3()
    {
        LevelThree =  new JLabel("  Level 3");
        LevelThree.setLayout(null);
        LevelThree.setBorder(null);
        LevelThree.setBounds(590, 630, 230, 180);
        LevelThree.setBackground(WHITE);
        LevelThree.setOpaque(true);
        LevelThree.setFont(new Font("Sans",Font.PLAIN,50));
        LevelThree.addMouseListener(this);
        this.add(LevelThree);
    }
     public void addBackButton()
    {
        BackButton = new JButton("< Back");
        BackButton.setLayout(null);
        BackButton.setBorder(null);
        BackButton.setBounds(100, 30, 100, 60);
        BackButton.setBackground(Color.decode("#94B964"));
        BackButton.setFont(new Font("Sans",Font.PLAIN,18));
        BackButton.setForeground(Color.WHITE);
        BackButton.addActionListener(this);
        this.add(BackButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ExitButton)
        {
            System.exit(0);
        }
        else if(e.getSource()==BackButton)
                {
                    this.dispose();
                    FirstPage firstpage = new FirstPage();
                }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       
        if(e.getSource()== LevelOne)
        {  PlayGame playgame = new PlayGame();
            this.dispose();
            playgame.startGame(1);
        }
        else if(e.getSource()==LevelTwo){
             PlayGame playgame = new PlayGame();
            this.dispose();
            playgame.startGame(2);
        }
        else if(e.getSource()==LevelThree){
             PlayGame playgame = new PlayGame();
            this.dispose();
           playgame.startGame(3);
        }
        else if(e.getSource() == SettingButton){
            this.dispose();
            GameSetting g = new GameSetting();
        }
       else if(e.getSource() == HelpButton){
            this.dispose();
            Help f = new Help();
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
