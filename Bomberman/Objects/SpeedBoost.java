package Objects;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class SpeedBoost extends SuperObject {
    public SpeedBoost() {
        name = "Boot";

        hitBox = new Rectangle(6, 6, 24, 24);
        hitBoxDefaultX = hitBox.x;
        hitBoxDefaultY = hitBox.y;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Res/objects/boot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
