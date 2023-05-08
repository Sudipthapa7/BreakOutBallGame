
package breakoutball;

import java.io.File;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import welcome.FirstPage;

public final class BreakOutBall  {

    static Clip clip;
    BreakOutBall(){
      
        FirstPage fp = new FirstPage();

    }
    public static void main(String[] args) {
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
       File file = new File("setting.txt");
       
      try{
           String sound="1";
       Scanner sc = new Scanner(file);
       if(sc.hasNext()){
           sc.nextLine();
       }
       if(sc.hasNext()){
         sound =  sc.nextLine();
       }
          //Music
        if(musicFile.exists()&&sound.equals("1")){
            System.out.println("file exits");
            AudioInputStream ais = AudioSystem.getAudioInputStream(musicFile);
            clip  = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
        }
       
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, e.getLocalizedMessage());  
      }   
    }

}
