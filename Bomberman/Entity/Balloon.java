package Entity;

import Game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Balloon extends Entity {

    GamePanel gp;
    int hitBoxWidth = 22;
    int hitBoxHeight = 22;

    public Balloon(GamePanel gp, int x, int y, String direction) {
        this.gp = gp;
        hitBox = new Rectangle(5, 3, hitBoxWidth, hitBoxHeight);
        hitBoxDefaultX = hitBox.x;
        hitBoxDefaultY = hitBox.y;

        this.x = x;
        this.y = y;
        this.speed = 2;
        this.direction = direction;

        getBalloonImage();
    }

    public void getBalloonImage() {
        try {
            start = ImageIO.read(getClass().getResourceAsStream("/Res/balloon/balloon_1.png"));
            upx = ImageIO.read(getClass().getResourceAsStream("/Res/balloon/balloon_2.png"));
            upy = ImageIO.read(getClass().getResourceAsStream("/Res/balloon/balloon_3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (direction.equals("left") || direction.equals("right")) {
            collisionOn = false;
            gp.cChecker.checkTile(this);

            if (collisionOn) {
                if (direction.equals("left")) {
                    direction = "right";
                } else {
                    direction = "left";
                }
            }
        } else {
            collisionOn = false;
            gp.cChecker.checkTile(this);

            if (collisionOn) {
                if (direction.equals("up")) {
                    direction = "down";
                } else {
                    direction = "up";
                }
            }
        }

        switch (direction) {
            case "up": y -= speed; break;
            case "down": y += speed; break;
            case "left": x -= speed; break;
            case "right": x += speed; break;
        }

        spriteCounter++;
        if (spriteCounter > 12) {
            switch (spriteNum) {
                case 1:
                    spriteNum = 2;
                    break;
                case 2:
                    spriteNum = 3;
                    break;
                case 3:
                    spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }
}
