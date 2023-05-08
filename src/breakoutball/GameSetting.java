
package breakoutball;

import java.awt.Color;
import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import welcome.FirstPage;
import welcome.SecondPage;

/*

 */
public final class GameSetting extends JFrame implements ActionListener {

    JButton BackButton;
    JButton ExitButton;
    PrintWriter pw;
    Map<String, String> setting;
    JButton savebutton;
    File file;
    JTextField playerField;
    JRadioButton r1, r2;
    ButtonGroup bg;
    JSlider slider;

    public GameSetting() {
        setting = new HashMap();
        readSettingFile();
        this.setSize(900, 950);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addLogo();
        addBackButton();
        addTitle();
        SetPlayerName();
        gameSound();
        ballSpeed();
        addImage();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    void readSettingFile() {
        file = new File("setting.txt");
        try {
            if (file.createNewFile()) {
            }
            Scanner sr = new Scanner(file);
            if (sr.hasNext()) {
                setting.put("name", sr.nextLine());
            }
            if (sr.hasNext()) {
                setting.put("sound", sr.nextLine());
            }
            if (sr.hasNext()) {
                setting.put("ballspeed", sr.nextLine());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }

    void addImage() {
        ImageIcon ic_logo = new ImageIcon(this.getClass().getResource("Second.png"));
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

    private void addTitle() {
        JLabel title = new JLabel();
        title.setBounds(400, 80, 500, 80);
        title.setLayout(null);
        title.setBorder(null);
        title.setForeground(BLUE);
        title.setText("User Setting");
        title.setFont(new Font("Sans", Font.BOLD, 36));
        title.setBackground(Color.decode("#94B964"));
        this.add(title);
    }

    private void SetPlayerName() {
        JLabel playerNameLabel = new JLabel();
        playerNameLabel.setBounds(200, 200, 200, 50);
        playerNameLabel.setText("Player Name : ");
        playerNameLabel.setFont(new Font("Sans", Font.BOLD, 28));
        this.add(playerNameLabel);
        playerField = new JTextField();
        playerField.setBounds(420, 200, 200, 50);
        playerField.setFont(new Font("sans", Font.BOLD, 28));
        this.add(playerField);
        playerField.setText(setting.get("name"));
        savebutton = new JButton();
        savebutton.setBounds(640, 200, 100, 50);
        savebutton.setText("Save");
        savebutton.setFont(new Font("sans", Font.BOLD, 28));
        savebutton.setForeground(BLACK);
        savebutton.addActionListener(this);
        this.add(savebutton);
    }

    private void gameSound() {
        JLabel gameSoundLabel = new JLabel();
        gameSoundLabel.setBounds(200, 300, 200, 50);
        gameSoundLabel.setText("Game Sound :");
        gameSoundLabel.setFont(new Font("Sans", Font.BOLD, 28));
        this.add(gameSoundLabel);

        r1 = new JRadioButton("ON");
        r2 = new JRadioButton("OFF");
        r1.setBounds(420, 300, 100, 50);
        r1.setFont(new Font("Sans", Font.PLAIN, 20));
        r2.setBounds(520, 300, 100, 50);
        r2.setFont(new Font("Sans", Font.PLAIN, 20));
        bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        if (setting.get("sound").equals("1")) {
            bg.setSelected(r1.getModel(), true);
        } else {
            bg.setSelected(r2.getModel(), true);
        }
        this.add(r1);
        this.add(r2);
    }

    private void ballSpeed() {
        JLabel ballspeedLabel = new JLabel();
        ballspeedLabel.setBounds(200, 400, 200, 50);
        ballspeedLabel.setText("Ball Speed : ");
        ballspeedLabel.setFont(new Font("Sans", Font.BOLD, 28));
        this.add(ballspeedLabel);

        slider = new JSlider(JSlider.HORIZONTAL, 5, 15, 10);
        slider.setMinorTickSpacing(5);
        slider.setMajorTickSpacing(5);
        slider.setFont(new Font("Sans", Font.PLAIN, 20));
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ballspeedLabel.setText("Ball Speed :" + ((JSlider) e.getSource()).getValue());
            }
        });
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        slider.setBounds(420, 400, 200, 50);
        slider.setValue(Integer.parseInt(setting.get("ballspeed")));
        this.add(slider);

    }

    public void addBackButton() {
        BackButton = new JButton("< Back");
        BackButton.setLayout(null);
        BackButton.setBorder(null);
        BackButton.setBounds(100, 30, 100, 60);
        BackButton.setBackground(Color.decode("#94B964"));
        BackButton.setFont(new Font("Sans", Font.PLAIN, 18));
        BackButton.setForeground(Color.WHITE);
        BackButton.addActionListener(this);
        this.add(BackButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ExitButton) {
            System.exit(0);
        } else if (e.getSource() == savebutton) {
            saveFile();
        } else if (e.getSource() == BackButton) {
            this.dispose();
            SecondPage secondpage = new SecondPage();
        }
    }

    private void saveFile() {
        String name = playerField.getText();
        String sound;
        if (bg.isSelected(r1.getModel())) {
            sound = "1";
        } else {
            sound = "0";
        }
        String ballspeed = String.valueOf(slider.getValue());
        try {
            pw = new PrintWriter(file);
            pw.println(name);
            pw.println(sound);
            pw.println(ballspeed);
            pw.close();
            JOptionPane.showMessageDialog(null, "setting saved!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }

}
