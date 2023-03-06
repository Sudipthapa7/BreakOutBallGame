/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package breakoutball;
import java.awt.Color;
import javax.swing.JFrame;
/*
/**
 *
 * @author HP
 */
public class GameSetting extends JFrame{
    GameSetting(){
        this.setSize(900,950);
       this.setLayout(null);
       this.getContentPane().setBackground(Color.WHITE);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setLocationRelativeTo(null);
       this.setVisible(true);
    }
}
