/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package breakoutball;

/**
 *
 * @author HP
 */
public class BricksModel {
      private final int BRICK_WIDTH = 60;
      private final int BRICK_HEIGHT = 20;
      private boolean destroyed;
      BricksModel(){
          destroyed = false;
      }
      
      void setDestroyed(boolean d){
          destroyed = d;
      }
      boolean isDestroyed(){
          return destroyed;
      }
      int getBrickWidth(){
          return BRICK_WIDTH;
      }
      int getBrickHeight(){
          return BRICK_HEIGHT;
      }
}
