package Objects;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Life extends SuperObject {
    public Life() {
        name = "Heart";

        hitBox = new Rectangle(6, 6, 20, 20);
        hitBoxDefaultX = hitBox.x;
        hitBoxDefaultY = hitBox.y;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Res/objects/heart.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
