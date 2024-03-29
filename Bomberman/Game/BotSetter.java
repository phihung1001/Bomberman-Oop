package Game;

import Entity.*;

import java.util.Arrays;

public class BotSetter {
    GamePanel gp;

    public BotSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setBot() {
        switch (gp.level) {
            case 1:
                gp.bot[0] = new Balloon(gp, gp.tileSize, 14 * gp.tileSize, "up");
                gp.bot[1] = new Balloon(gp, 6 * gp.tileSize, 12 * gp.tileSize, "left");
                gp.bot[2] = new Balloon(gp, gp.tileSize, 13 * gp.tileSize, "right");
                gp.bot[3] = new Balloon(gp, 9 * gp.tileSize, 12 * gp.tileSize, "down");
                gp.bot[4] = new Balloon(gp, 14 * gp.tileSize, 12 * gp.tileSize, "left");
                gp.bot[5] = new Balloon(gp, 14 * gp.tileSize, 13 * gp.tileSize, "left");
                gp.bot[6] = new Slime(gp, 14 * gp.tileSize, gp.tileSize);
                gp.bot[7] = new Slime(gp, 13 * gp.tileSize, gp.tileSize);
                gp.bot[8] = new Balloon(gp, 9 * gp.tileSize, gp.tileSize, "down");
                gp.bot[9] = new Balloon(gp, 5 * gp.tileSize, 9 * gp.tileSize, "right");
                gp.bot[10] = new Slime(gp, 6 * gp.tileSize, 5 * gp.tileSize);
                break;
            case 2:
                gp.bot[0] = new Slime(gp, 5 * gp.tileSize, 1 * gp.tileSize);
                gp.bot[1] = new Slime(gp, 10 * gp.tileSize, 10 * gp.tileSize);
                gp.bot[2] = new Balloon(gp, 1 * gp.tileSize, 4 * gp.tileSize, "down");
                gp.bot[3] = new Balloon(gp, 2 * gp.tileSize, 12 * gp.tileSize,"up");
                gp.bot[4] = new Balloon(gp, 3 * gp.tileSize, 13 * gp.tileSize, "right");
                gp.bot[5] = new Balloon(gp, 12 * gp.tileSize, 13 * gp.tileSize, "left");
                gp.bot[6] = new Balloon(gp, 12 * gp.tileSize, 14 * gp.tileSize, "left");
                gp.bot[7] = new Balloon(gp, 3 * gp.tileSize, 14 * gp.tileSize, "right");
                gp.bot[8] = new Balloon(gp, 13 * gp.tileSize, 10 * gp.tileSize, "up");
                gp.bot[9] = new Balloon(gp, 14 * gp.tileSize, 6 * gp.tileSize, "down");
                gp.bot[10] = new Balloon(gp, 13 * gp.tileSize, 4 * gp.tileSize, "down");
                gp.bot[11] = new Slime(gp, 4 * gp.tileSize, 11 * gp.tileSize);
                break;
            case 3:
                gp.bot[0] = new Slime(gp, 1 * gp.tileSize, 14 * gp.tileSize);
                gp.bot[1] = new Slime(gp, 2 * gp.tileSize, 14 * gp.tileSize);
                gp.bot[2] = new Slime(gp, 1 * gp.tileSize, 13 * gp.tileSize);
                gp.bot[3] = new Slime(gp, 2 * gp.tileSize, 13 * gp.tileSize);
                gp.bot[4] = new Slime(gp, 1 * gp.tileSize, 12 * gp.tileSize);
                gp.bot[5] = new Slime(gp, 2 * gp.tileSize, 12 * gp.tileSize);
                gp.bot[6] = new Slime(gp, 1 * gp.tileSize, 11 * gp.tileSize);
                gp.bot[7] = new Slime(gp, 2 * gp.tileSize, 11 * gp.tileSize);
                gp.bot[8] = new Balloon(gp, 10 * gp.tileSize, 1 * gp.tileSize, "down");
                gp.bot[9] = new Balloon(gp, 11 * gp.tileSize, 1 * gp.tileSize, "down");
                gp.bot[10] = new Balloon(gp, 10 * gp.tileSize, 14 * gp.tileSize, "up");
                gp.bot[11] = new Balloon(gp, 11 * gp.tileSize, 14 * gp.tileSize, "up");
                gp.bot[12] = new Slime(gp, 13 * gp.tileSize, 1 * gp.tileSize);
                gp.bot[13] = new Slime(gp, 14 * gp.tileSize, 14 * gp.tileSize);
                gp.bot[14] = new Slime(gp, 13 * gp.tileSize, 2 * gp.tileSize);
                break;

        }
    }

    public void clearBotList() {
        Arrays.fill(gp.bot, null);
    }
}
