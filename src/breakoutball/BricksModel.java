
package breakoutball;


public class BricksModel {
      private int BRICK_WIDTH = 60;
      private int BRICK_HEIGHT = 20;
      private boolean destroyed;
      
      
      public BricksModel(){
          destroyed = false;
      }
      
      public void setDestroyed(boolean d){
          destroyed = d;
      }
     public boolean isDestroyed(){
          return destroyed;
      }
     public int getBrickWidth(){
          return BRICK_WIDTH;
      }
     public  int getBrickHeight(){
          return BRICK_HEIGHT;
      }
}
