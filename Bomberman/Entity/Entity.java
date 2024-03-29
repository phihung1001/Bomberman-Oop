package Entity;

import Game.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    GamePanel gameP;
    public int x, y, speed;
    public BufferedImage start, upx, upy, downx, downy, leftx, lefty, rightx, righty;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Rectangle hitBox;
    public int hitBoxDefaultX, hitBoxDefaultY;
    public boolean collisionOn = false;

    public boolean onPath = false;

    public void update() {}

    public void draw(Graphics2D g2, GamePanel gameP) {
        BufferedImage image = null;

        switch (spriteNum) {
            case 1:
                image = start;
                break;
            case 2:
                image = upx;
                break;
            case 3:
                image = upy;
                break;
        }

        g2.drawImage(image, x, y, gameP.tileSize, gameP.tileSize, null);
    }
}
