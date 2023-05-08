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

public class Help extends JFrame implements ActionListener {

    private JButton BackButton;

    public Help() {
        this.setSize(900, 950);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocationRelativeTo(null);
        addLogo();
        addBackButton();
        addImage();
        this.setVisible(true);
    }
    void addImage() {
        ImageIcon ic_logo = new ImageIcon(this.getClass().getResource("Help.png"));
        JLabel logo = new JLabel(ic_logo);
        logo.setBounds(0, 0, 920, 900);
        this.add(logo);
    }

    void addLogo() {
        ImageIcon ic_logo = new ImageIcon(this.getClass().getResource("LOGO_1.png"));
        JLabel logo = new JLabel(ic_logo);
        logo.setBounds(20, 20, 64, 68);
        this.add(logo);
    }

    public void addBackButton() {
        BackButton = new JButton("< Back");
        BackButton.setLayout(null);
        BackButton.setBorder(null);
        BackButton.setBounds(100, 800, 100, 60);
        BackButton.setBackground(Color.decode("#94B964"));
        BackButton.setFont(new Font("Sans", Font.PLAIN, 18));
        BackButton.setForeground(Color.WHITE);
        BackButton.addActionListener(this);
        this.add(BackButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BackButton) {
            this.dispose();
            SecondPage secondpage = new SecondPage();
        }
    }
}
