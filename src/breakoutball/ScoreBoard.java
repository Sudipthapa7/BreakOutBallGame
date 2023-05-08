package breakoutball;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Team
 */
public class ScoreBoard extends JPanel {

    int score;
    int sec;
    int min;
    String level;
    int life;
    String pName = "G";

    public ScoreBoard() {
        score = 0;
        min = 0;
        sec = 0;
        this.setBounds(0, 0, 900, 90);
        this.setVisible(true);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
        repaint();
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setPlayerName(String name) {
        this.pName = name;
    }

    public void incTime() {
        ++sec;
        if (sec >= 60) {
            ++min;
            sec = 0;
        }
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void draw(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(0, 0, 900, 95);
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        g.drawString("PlayerName :" + pName, 10, 25);
        g.drawString("Score", 10, 65);
        g.drawString(String.valueOf(score), 100, 65);
        g.drawString("Time :" + String.valueOf(min) + ":" + String.valueOf(sec), 350, 50);
        g.drawString("Level :" + level, 750, 25);
        g.drawString("Life :" + life, 750, 65);
    }

}
