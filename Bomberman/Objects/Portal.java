package Objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Portal extends SuperObject {
    public Portal() {
        name = "Door";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Res/objects/door.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        collision = true;
    }
}
