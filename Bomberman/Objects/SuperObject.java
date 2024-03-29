package Objects;

import Game.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int x, y;
    public Rectangle hitBox = new Rectangle(0, 0, 36, 36);
    public int hitBoxDefaultX = 0;
    public int hitBoxDefaultY = 0;

    public void draw(Graphics2D g2, GamePanel gp) {
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
