
package breakoutball;

import static java.awt.Color.WHITE;
import javax.swing.JFrame;

public class Profile extends JFrame{
    
    public Profile(){
        this.setSize(900,900);
        this.setLayout(null);
        this.getContentPane().setBackground(WHITE);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
}
