package Game;

import Entity.Balloon;
import Objects.*;

import java.util.Arrays;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        switch (gp.level) {
            case 1:
                gp.obj[0] = new Stair();
                gp.obj[0].x = 6 * gp.tileSize;
                gp.obj[0].y = gp.tileSize;

                gp.obj[1] = new Life();
                gp.obj[1].x = 12 * gp.tileSize;
                gp.obj[1].y = gp.tileSize;

                gp.obj[2] = new Portal();
                gp.obj[2].x = 6 * gp.tileSize;
                gp.obj[2].y = 2 * gp.tileSize;

                gp.obj[3] = new SpeedBoost();
                gp.obj[3].x = 2 * gp.tileSize;
                gp.obj[3].y = 10 * gp.tileSize;

                gp.obj[4] = new SpeedBoost();
                gp.obj[4].x = 14 * gp.tileSize;
                gp.obj[4].y = 11 * gp.tileSize;

                gp.obj[5] = new Key();
                gp.obj[5].x = 2 * gp.tileSize;
                gp.obj[5].y = 2 * gp.tileSize;
                break;
           case 2:
                gp.obj[0] = new Key();
                gp.obj[0].x = 5 * gp.tileSize;
                gp.obj[0].y = 2 * gp.tileSize;

                gp.obj[3] = new Portal();
                gp.obj[3].x = 9 * gp.tileSize;
                gp.obj[3].y = 7 * gp.tileSize;

                gp.obj[4] = new Stair();
                gp.obj[4].x = 7 * gp.tileSize;
                gp.obj[4].y = 7 * gp.tileSize;

                gp.obj[5] = new SpeedBoost();
                gp.obj[5].x = 1 * gp.tileSize;
                gp.obj[5].y = 14 * gp.tileSize;

                gp.obj[6] = new Life();
                gp.obj[6].x = 13 * gp.tileSize;
                gp.obj[6].y = 6 * gp.tileSize;

                gp.obj[7] = new Life();
                gp.obj[7].x = 6 * gp.tileSize;
                gp.obj[7].y = 11 * gp.tileSize;
                break;

            case 3:
                gp.obj[0] = new Key();
                gp.obj[0].x = 2 * gp.tileSize;
                gp.obj[0].y = 3 * gp.tileSize;

                gp.obj[1] = new SpeedBoost();
                gp.obj[1].x = 1 * gp.tileSize;
                gp.obj[1].y = 2 * gp.tileSize;

                gp.obj[2] = new Life();
                gp.obj[2].x = 6 * gp.tileSize;
                gp.obj[2].y = 14 * gp.tileSize;

                gp.obj[3] = new Portal();
                gp.obj[3].x = 14 * gp.tileSize;
                gp.obj[3].y = 3 * gp.tileSize;

                gp.obj[4] = new Stair();
                gp.obj[4].x = 14 * gp.tileSize;
                gp.obj[4].y = 1 * gp.tileSize;
                break;
    }

    public void clearObjectList() {
        Arrays.fill(gp.obj, null);
    }
}
