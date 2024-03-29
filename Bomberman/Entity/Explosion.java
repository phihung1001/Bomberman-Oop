package Entity;

import Game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Explosion extends Entity {
    GamePanel gp;
    Bomb bomb;
    int col;
    int row;
    int tileNumU;
    int tileNumD;
    int tileNumL;
    int tileNumR;
    String[] explodeSide;

    BufferedImage flameX, flameY;
    BufferedImage full;
    BufferedImage up3, down3, left3, right3;
    BufferedImage up, down, left, right;
    BufferedImage upDown, downLeft, leftUp, upRight, rightDown, leftRight;

    public Explosion(GamePanel gp, Bomb bomb) {
        this.gp = gp;
        this.bomb = bomb;

        loadBombImage();
        setDefaultValues();
    }

    void setDefaultValues() {
        x = bomb.x;
        y = bomb.y;

        col = bomb.col;
        row = bomb.row;

        tileNumU = gp.tileM.mapTileNum[col][row - 1];
        tileNumD = gp.tileM.mapTileNum[col][row + 1];
        tileNumL = gp.tileM.mapTileNum[col - 1][row];
        tileNumR = gp.tileM.mapTileNum[col + 1][row];

        explodeSide = new String[4];
    }

    public void loadBombImage() {
        try {
            flameX = ImageIO.read(getClass().getResourceAsStream("/Res/explosions/flame_X.png"));
            flameY = ImageIO.read(getClass().getResourceAsStream("/Res/explosions/flame_Y.png"));

            full = ImageIO.read(getClass().getResourceAsStream("/Res/explosions/explosion_full.png"));

            up3 = ImageIO.read(getClass().getResourceAsStream("/Res/explosions/explosion_up_3.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/Res/explosions/explosion_down_3.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/Res/explosions/explosion_left_3.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/Res/explosions/explosion_right_3.png"));

            up = ImageIO.read(getClass().getResourceAsStream("/Res/explosions/explosion_up.png"));
            down = ImageIO.read(getClass().getResourceAsStream("/Res/explosions/explosion_down.png"));
            left = ImageIO.read(getClass().getResourceAsStream("/Res/explosions/explosion_left.png"));
            right = ImageIO.read(getClass().getResourceAsStream("/Res/explosions/explosion_right.png"));

            upDown = ImageIO.read(getClass().getResourceAsStream("/Res/explosions/explosion_up_down.png"));
            downLeft = ImageIO.read(getClass().getResourceAsStream("/Res/explosions/explosion_down_left.png"));
            leftUp = ImageIO.read(getClass().getResourceAsStream("/Res/explosions/explosion_left_up.png"));
            upRight = ImageIO.read(getClass().getResourceAsStream("/Res/explosions/explosion_up_right.png"));
            rightDown = ImageIO.read(getClass().getResourceAsStream("/Res/explosions/explosion_right_down.png"));
            leftRight = ImageIO.read(getClass().getResourceAsStream("/Res/explosions/explosion_left_right.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {}

    public void draw(Graphics2D g2) {
        int side = 0;

        if (tileNumU == 8) {
            explodeSide[side] = "up";
            side++;
        }
        if (tileNumD == 8) {
            explodeSide[side] = "down";
            side++;
        }
        if (tileNumL == 8) {
            explodeSide[side] = "left";
            side++;
        }
        if (tileNumR == 8) {
            explodeSide[side] = "right";
            side++;
        }

        switch (side) {
            case 1:
                switch (explodeSide[0]) {
                    case "up":
                        g2.drawImage(up, x, y, gp.tileSize, gp.tileSize, null);
                        g2.drawImage(flameY, x, y - 32, gp.tileSize, gp.tileSize, null);
                        break;
                    case "down":
                        g2.drawImage(down, x, y, gp.tileSize, gp.tileSize, null);
                        g2.drawImage(flameY, x, y + 32, gp.tileSize, gp.tileSize, null);
                        break;
                    case "left":
                        g2.drawImage(left, x, y, gp.tileSize, gp.tileSize, null);
                        g2.drawImage(flameY, x - 32, y, gp.tileSize, gp.tileSize, null);
                        break;
                    case "right":
                        g2.drawImage(right, x, y, gp.tileSize, gp.tileSize, null);
                        g2.drawImage(flameY, x + 32, y, gp.tileSize, gp.tileSize, null);
                        break;
                }
                break;
            case 2:
                if (explodeSide[0].equals("up") &&  explodeSide[1].equals("down")) {
                    g2.drawImage(upDown, x, y, gp.tileSize, gp.tileSize, null);
                    g2.drawImage(flameY, x, y - 32, gp.tileSize, gp.tileSize, null);
                    g2.drawImage(flameY, x, y + 32, gp.tileSize, gp.tileSize, null);
                }
                if (explodeSide[0].equals("up") &&  explodeSide[1].equals("left")) {
                    g2.drawImage(leftUp, x, y, gp.tileSize, gp.tileSize, null);
                    g2.drawImage(flameY, x, y - 32, gp.tileSize, gp.tileSize, null);
                    g2.drawImage(flameX, x - 32, y, gp.tileSize, gp.tileSize, null);
                }
                if (explodeSide[0].equals("up") &&  explodeSide[1].equals("right")) {
                    g2.drawImage(upRight, x, y, gp.tileSize, gp.tileSize, null);
                    g2.drawImage(flameY, x, y - 32, gp.tileSize, gp.tileSize, null);
                    g2.drawImage(flameX, x + 32, y, gp.tileSize, gp.tileSize, null);
                }
                if (explodeSide[0].equals("down") &&  explodeSide[1].equals("left")) {
                    g2.drawImage(downLeft, x, y, gp.tileSize, gp.tileSize, null);
                    g2.drawImage(flameY, x, y + 32, gp.tileSize, gp.tileSize, null);
                    g2.drawImage(flameX, x - 32, y, gp.tileSize, gp.tileSize, null);
                }
                if (explodeSide[0].equals("down") &&  explodeSide[1].equals("right")) {
                    g2.drawImage(rightDown, x, y, gp.tileSize, gp.tileSize, null);
                    g2.drawImage(flameY, x, y + 32, gp.tileSize, gp.tileSize, null);
                    g2.drawImage(flameX, x + 32, y, gp.tileSize, gp.tileSize, null);
                }
                if (explodeSide[0].equals("left") &&  explodeSide[1].equals("right")) {
                    g2.drawImage(leftRight, x, y, gp.tileSize, gp.tileSize, null);
                    g2.drawImage(flameX, x - 32, y, gp.tileSize, gp.tileSize, null);
                    g2.drawImage(flameX, x + 32, y, gp.tileSize, gp.tileSize, null);
                }
                break;
            case 3:
                if (explodeSide[0].equals("up") &&  explodeSide[1].equals("down") && explodeSide[2].equals("left")) {
                    g2.drawImage(left3, x, y, gp.tileSize, gp.tileSize, null);
                    g2.drawImage(flameY, x, y - 32, gp.tileSize, gp.tileSize, null);
                    g2.drawImage(flameY, x, y + 32, gp.tileSize, gp.tileSize, null);
                    g2.drawImage(flameX, x - 32, y, gp.tileSize, gp.tileSize, null);
                }
                if (explodeSide[0].equals("up") &&  explodeSide[1].equals("down") && explodeSide[2].equals("right")) {
                    g2.drawImage(right3, x, y, gp.tileSize, gp.tileSize, null);
                    g2.drawImage(flameY, x, y - 32, gp.tileSize, gp.tileSize, null);
                    g2.drawImage(flameY, x, y + 32, gp.tileSize, gp.tileSize, null);
                    g2.drawImage(flameX, x + 32, y, gp.tileSize, gp.tileSize, null);
                }
                if (explodeSide[0].equals("up") &&  explodeSide[1].equals("left") && explodeSide[2].equals("right")) {
                    g2.drawImage(up3, x, y, gp.tileSize, gp.tileSize, null);
                    g2.drawImage(flameY, x, y - 32, gp.tileSize, gp.tileSize, null);
                    g2.drawImage(flameX, x - 32, y, gp.tileSize, gp.tileSize, null);
                    g2.drawImage(flameX, x + 32, y, gp.tileSize, gp.tileSize, null);
                }
                if (explodeSide[0].equals("down") &&  explodeSide[1].equals("left") && explodeSide[2].equals("right")) {
                    g2.drawImage(down3, x, y, gp.tileSize, gp.tileSize, null);
                    g2.drawImage(flameY, x, y + 32, gp.tileSize, gp.tileSize, null);
                    g2.drawImage(flameX, x - 32, y, gp.tileSize, gp.tileSize, null);
                    g2.drawImage(flameX, x + 32, y, gp.tileSize, gp.tileSize, null);
                }
                break;
            case 4:
                g2.drawImage(full, x, y, gp.tileSize, gp.tileSize, null);

                g2.drawImage(flameY, x, y - 32, gp.tileSize, gp.tileSize, null);
                g2.drawImage(flameY, x, y + 32, gp.tileSize, gp.tileSize, null);

                g2.drawImage(flameX, x - 32, y, gp.tileSize, gp.tileSize, null);
                g2.drawImage(flameX, x + 32, y, gp.tileSize, gp.tileSize, null);
                break;
        }
    }
}
