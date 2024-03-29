package Game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class UI {
    GamePanel gp;
    Font arial_36;
    BufferedImage keyImage, heartImage, bootImage, bottomPanel;

    public UI(GamePanel gp) {
        this.gp = gp;

        arial_36 = new Font("Arial", Font.PLAIN, 36);

        try {
            keyImage = ImageIO.read(getClass().getResourceAsStream("/Res/objects/key.png"));
            heartImage = ImageIO.read(getClass().getResourceAsStream("/Res/objects/heart.png"));
            bootImage = ImageIO.read(getClass().getResourceAsStream("/Res/objects/boot.png"));
            bottomPanel = ImageIO.read(getClass().getResourceAsStream("/Res/objects/bottom_panel.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(bottomPanel, 0, 16 * gp.tileSize, 512, 64, null);

        for (int i = 1; i <= gp.player.life; i++) {
            graphics2D.drawImage(heartImage, i * gp.tileSize + 8, 16 * gp.tileSize + 14, gp.tileSize, gp.tileSize, null);
        }

        if (gp.player.haveBoot) {
            graphics2D.drawImage(bootImage, 7 * gp.tileSize + 20, 16 * gp.tileSize + 14, gp.tileSize, gp.tileSize, null);
        }

        graphics2D.setFont(arial_36);
        graphics2D.setColor(Color.white);
        graphics2D.drawImage(keyImage, 12 * gp.tileSize + 8, 16 * gp.tileSize + 14, gp.tileSize, gp.tileSize, null);
        graphics2D.drawString(" x " + gp.player.hasKey, 13 * gp.tileSize + 3, 17 * gp.tileSize + 14);
    }
}
