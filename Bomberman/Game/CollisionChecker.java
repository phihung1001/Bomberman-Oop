package Game;

import Entity.Entity;

public class CollisionChecker {
    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public boolean checkExplosion(Entity entity) {
        int entityLeftX = entity.x + entity.hitBox.x;
        int entityRightX = entityLeftX + entity.hitBox.width;
        int entityTopY = entity.y + entity.hitBox.y;
        int entityBottomY = entityTopY + entity.hitBox.height;

        int entityLeftCol = entityLeftX / gp.tileSize;
        int entityRightCol = entityRightX / gp.tileSize;
        int entityTopRow = entityTopY / gp.tileSize;
        int entityBottomRow = entityBottomY / gp.tileSize;

        int tileNum1, tileNum2, tileNum3, tileNum4;

        tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
        tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
        tileNum3 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
        tileNum4 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];

        return gp.tileM.tile[tileNum1].damage || gp.tileM.tile[tileNum2].damage ||
                gp.tileM.tile[tileNum3].damage || gp.tileM.tile[tileNum4].damage;
    }

    public void checkTile(Entity entity) {
        int entityLeftX = entity.x + entity.hitBox.x;
        int entityRightX = entityLeftX + entity.hitBox.width;
        int entityTopY = entity.y + entity.hitBox.y;
        int entityBottomY = entityTopY + entity.hitBox.height;

        int entityLeftCol = entityLeftX / gp.tileSize;
        int entityRightCol = entityRightX / gp.tileSize;
        int entityTopRow = entityTopY / gp.tileSize;
        int entityBottomRow = entityBottomY / gp.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];

                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomY + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];

                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];

                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];

                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
        }
    }

    public boolean checkBot(Entity entity) {
        for (int i = 0; i < gp.bot.length; i++) {
            if (gp.bot[i] != null) {
                entity.hitBox.x = entity.hitBoxDefaultX + entity.x;
                entity.hitBox.y = entity.hitBoxDefaultY + entity.y;

                gp.bot[i].hitBox.x = gp.bot[i].hitBoxDefaultX + gp.bot[i].x;
                gp.bot[i].hitBox.y = gp.bot[i].hitBoxDefaultY + gp.bot[i].y;

                switch (entity.direction) {
                    case "up":
                        entity.hitBox.y -= entity.speed;
                        if (entity.hitBox.intersects(gp.bot[i].hitBox)) {
                            return true;
                        }
                        break;
                    case "down":
                        entity.hitBox.y += entity.speed;
                        if (entity.hitBox.intersects(gp.bot[i].hitBox)) {
                            return true;
                        }
                        break;
                    case "left":
                        entity.hitBox.x -= entity.speed;
                        if (entity.hitBox.intersects(gp.bot[i].hitBox)) {
                            return true;
                        }
                        break;
                    case "right":
                        entity.hitBox.x += entity.speed;
                        if (entity.hitBox.intersects(gp.bot[i].hitBox)) {
                           return true;
                        }
                        break;
                }

                entity.hitBox.x = entity.hitBoxDefaultX;
                entity.hitBox.y = entity.hitBoxDefaultY;

                gp.bot[i].hitBox.x = gp.bot[i].hitBoxDefaultX;
                gp.bot[i].hitBox.y = gp.bot[i].hitBoxDefaultY;
            }
        }
        return false;
    }

    public int checkObject(Entity entity, boolean player) {
        int index = 999;

        for (int i = 0; i < gp.obj.length; i++) {
            if (gp.obj[i] != null) {
                entity.hitBox.x = entity.hitBoxDefaultX + entity.x;
                entity.hitBox.y = entity.hitBoxDefaultY + entity.y;

                gp.obj[i].hitBox.x = gp.obj[i].hitBoxDefaultX + gp.obj[i].x;
                gp.obj[i].hitBox.y = gp.obj[i].hitBoxDefaultY + gp.obj[i].y;

                switch (entity.direction) {
                    case "up":
                        entity.hitBox.y -= entity.speed;
                        if (entity.hitBox.intersects(gp.obj[i].hitBox)) {
                            if (gp.obj[i].collision) {
                                entity.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.hitBox.y += entity.speed;
                        if (entity.hitBox.intersects(gp.obj[i].hitBox)) {
                            if (gp.obj[i].collision) {
                                entity.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.hitBox.x -= entity.speed;
                        if (entity.hitBox.intersects(gp.obj[i].hitBox)) {
                            if (gp.obj[i].collision) {
                                entity.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.hitBox.x += entity.speed;
                        if (entity.hitBox.intersects(gp.obj[i].hitBox)) {
                            if (gp.obj[i].collision) {
                                entity.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;
                }

                entity.hitBox.x = entity.hitBoxDefaultX;
                entity.hitBox.y = entity.hitBoxDefaultY;

                gp.obj[i].hitBox.x = gp.obj[i].hitBoxDefaultX;
                gp.obj[i].hitBox.y = gp.obj[i].hitBoxDefaultY;
            }
        }

        return index;
    }
}
