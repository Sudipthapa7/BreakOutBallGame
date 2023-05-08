package breakout_ball_levels;

import breakoutball.BricksModel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Tream Greenary
 */
public class GameLevel_2 extends GameLevel {
    private int ballMotionY = 5;
    private int ballMotionX = 5;
    int BRICK_ROW = 8;
    int BRICK_COLUMN = 12;
    Scanner sc;
    File file;
    private int totalSpeed;
    private int speed;
    public GameLevel_2() {
        readSetting();
        gameScore = 84;
        BRICK_HEIGHT = 20;
        BRICK_WIDTH = 60;
        bricks = new ArrayList<>();
        bricks_2 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            List<BricksModel> brick = new ArrayList<>();
            List<BricksModel> brick2 = new ArrayList<>();
            for (int j = 0; j < 12 - (i * 2); j++) {
                brick.add(new BricksModel());
                brick2.add(new BricksModel());
            }
            bricks.add(brick);
            bricks_2.add(brick2);
        }
    }
    public void readSetting() {
        try {
            file = new File("setting.txt");
            sc = new Scanner(file);
            if (sc.hasNext()) {
                sc.nextLine();
            }
            if (sc.hasNext()) {
                sc.nextLine();
            }
            if (sc.hasNext()) {
                totalSpeed = Integer.parseInt(sc.nextLine());
            }
            speed = totalSpeed / 2;
            ballMotionY = speed;
            ballMotionX = speed;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }
    @Override
    public void drawBricks(Graphics g) {
        int col = 0;
        int row = 12;
        //drawing first loop
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < BRICK_COLUMN - (i * 2); j++) {
                if (!bricks.get(i).get(j).isDestroyed()) {
                    g.setColor(Color.blue);
                    g.fillRect(((60 + i * 65) + (j * 65)), (150 + (i * 25)), BRICK_WIDTH, BRICK_HEIGHT);
                }
            }
        }
        //drawing second loop
        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < BRICK_COLUMN - (i * 2); j++) {
                if (!bricks_2.get(i).get(j).isDestroyed()) {
                    g.setColor(Color.blue);
                    g.fillRect(((60 + i * 65) + (j * 65)), (300 + (col * 25)), BRICK_WIDTH, BRICK_HEIGHT);
                }
            }
            col++;
        }
    }

    public int checkBrickDestroyed(int ballXpos, int ballYpos) {
        int flag = 0;
        int col = 0;
        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < 12 - (i * 2); j++) {
                Rectangle brick = new Rectangle(((60 + i * 65) + (j * 65)), (300 + (col * 25)), BRICK_WIDTH, BRICK_HEIGHT);
                Rectangle ball = new Rectangle(ballXpos, ballYpos, 20, 20);
                if (!bricks_2.get(i).get(j).isDestroyed()) {
                    if (brick.intersects(ball)) {
                        flag = 1;
                        bricks_2.get(i).get(j).setDestroyed(true);
                        if ((ballXpos) < ((60 + i * 65) + (j * 65)) || (ballXpos) >= (60 + (j * 65) + BRICK_WIDTH)) {
                            ballMotionX = -ballMotionX;
                        } else {
                            ballMotionY = -ballMotionY;
                        }
                        return flag;
                    }
                }
            }
            col++;
        }

        //Lower Bricks   *******/////
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 12 - i * 2; j++) {
                Rectangle brick = new Rectangle(((60 + i * 65) + (j * 65)), (i * 25 + 150), BRICK_WIDTH, BRICK_HEIGHT);
                Rectangle ball = new Rectangle(ballXpos, ballYpos, 20, 20);
                if (!bricks.get(i).get(j).isDestroyed()) {
                    if (brick.intersects(ball)) {
                        flag = 1;
                        bricks.get(i).get(j).setDestroyed(true);
                        if ((ballXpos) < ((60 + i * 65) + (j * 65)) || (ballXpos) >= (60 + (j * 65) + BRICK_WIDTH)) {
                            ballMotionX = -ballMotionX;
                        } else {
                            ballMotionY = -ballMotionY;
                        }
                        return flag;
                    }
                }
            }
        }
        return flag;
    }

    @Override
    public int[] checkAndMoveBall(int ballXpos, int ballYpos, int paddleXpos) {
        ballXpos += ballMotionX;
        ballYpos += ballMotionY;
        if (ballXpos <= 0 || ballXpos > 860) {
            ballMotionX = -ballMotionX;
        }
        if (ballYpos <= 100) {
            ballMotionY = -ballMotionY;
        }
        Rectangle ball = new Rectangle(ballXpos, ballYpos, 20, 20);
        Rectangle paddle = new Rectangle(paddleXpos, 850, 200, 10);
        if (paddle.intersects(ball)) {
            if ((paddle.x + 120) < ball.x) {
                ballMotionX = speed;
            } else if ((paddle.x + 120) <= ball.x || (paddle.x + 70) <= ball.x) {
                ballMotionX = 0;
            } else {
                ballMotionX = -speed;
            }
            if (ballMotionY > 0) {
                ballMotionY = totalSpeed - Math.abs(ballMotionX);
            } else {
                ballMotionY = Math.abs(ballMotionX);
                // ballMotionY =-ballMotionY;
            }
            ballMotionY = -ballMotionY;
        }
        int flag = checkBrickDestroyed(ballXpos, ballYpos);
        int[] pos = {ballXpos, ballYpos, flag};
        return pos;
    }

    @Override
    public String getLeve() {
        return "2";
    }

    @Override
    public void setBallMotionY(int motion) {
        ballMotionY = -ballMotionY;
    }

    @Override
    public int getPassingScore() {
        return gameScore;
    }

}
