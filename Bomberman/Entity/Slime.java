package Entity;

import Game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Slime extends Entity {

    GamePanel gamePanel;
    int hitBoxWidth = 26;
    int hitBoxHeight = 16;

    /**
     * Method khoi tao
     */
    public Slime(GamePanel GP, int x, int y) {
        this.gamePanel = GP;
        hitBox = new Rectangle(3, 13, hitBoxWidth, hitBoxHeight);
        hitBoxDefaultX = hitBox.x;
        hitBoxDefaultY = hitBox.y;
        this.x = x;
        this.y = y;
        this.speed = 3;
        direction = "Start";
        getSlimeImage();
    }

    /**
     * Nap hinh anh cua quai Slime.
     */
    public void getSlimeImage() {
        try {
            start = ImageIO.read(getClass().getResourceAsStream("/Res/slime/slime_1.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/Res/slime/slime_2.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/Res/slime/slime_3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Su dung phuong thuc tim duong di ngan nhat huong toi nguoi choi, neu duong di co vat can hoac bi chan dung lai
     */
    public void searchPath(int goalC, int goalR) {
        int startC = (x + hitBox.x) / gamePanel.tileSize;
        int startR = (y + hitBox.y) / gamePanel.tileSize;

        gamePanel.pFinder.setNodes(startC, startR, goalC, goalR);

        if (gamePanel.pFinder.search()) {
            int nextX = gamePanel.pFinder.pathList.get(0).c * gamePanel.tileSize;
            int nextY = gamePanel.pFinder.pathList.get(0).r * gamePanel.tileSize;

            int botTopY = y + hitBox.y;
            int botBottomY = y + hitBox.y + hitBoxHeight;
            int botLeftX = x + hitBox.x;
            int botRightX = x + hitBox.x + hitBoxWidth;


            if (botTopY > nextY && botLeftX >= nextX && botRightX < nextX + gamePanel.tileSize) {
                direction = "up";
            } else if (botTopY < nextY && botLeftX >= nextX && botRightX < nextX + gamePanel.tileSize) {
                direction = "down";
            } else if (botTopY >= nextY && botBottomY < nextY + gamePanel.tileSize) {
                if (botLeftX > nextX) {
                    direction = "left";
                }
                if (botLeftX < nextX) {
                    direction = "right";
                }
            } else if (botTopY > nextY && botLeftX > nextX) {
                direction = "up";
                collisionOn = false;
                gamePanel.cChecker.checkTile(this);
                if (collisionOn) {
                    direction = "left";
                }
            } else if (botTopY > nextY && botLeftX < nextX) {
                direction = "up";
                collisionOn = false;
                gamePanel.cChecker.checkTile(this);
                if (collisionOn) {
                    direction = "right";
                }
            } else if (botTopY < nextY && botLeftX > nextX) {
                direction = "down";
                collisionOn = false;
                gamePanel.cChecker.checkTile(this);
                if (collisionOn) {
                    direction = "left";
                }
            } else if (botTopY < nextY && botLeftX < nextX) {
                direction = "down";
                collisionOn = false;
                gamePanel.cChecker.checkTile(this);
                if (collisionOn) {
                    direction = "right";
                }
            }
        }
    }

    public void update() {
        int xDistance = Math.abs(x - gamePanel.player.x);
        int yDistance = Math.abs(y - gamePanel.player.y);
        int tileDistance = (xDistance + yDistance) / gamePanel.tileSize;

        if (!onPath && tileDistance < 4) {
            onPath = true;
        }

        if (onPath) {
            int goalCol = (gamePanel.player.x + gamePanel.player.hitBoxWidth) / gamePanel.tileSize;
            int goalRow = (gamePanel.player.y + gamePanel.player.hitBoxHeight) / gamePanel.tileSize;

            searchPath(goalCol, goalRow);
        }

        collisionOn = false;
        gamePanel.cChecker.checkTile(this);

        int objIndex = gamePanel.cChecker.checkObject(this, true);
        if (objIndex != 999) {
            String objectName = gamePanel.obj[objIndex].name;
            if (objectName.equals("Door")) {
                collisionOn = true;
            }
        }

        if (!collisionOn) {
            switch (direction) {
                case "up": y -= speed; break;
                case "down": y += speed; break;
                case "left": x -= speed; break;
                case "right": x += speed; break;
            }
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
