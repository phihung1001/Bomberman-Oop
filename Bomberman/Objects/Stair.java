package Objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Stair extends SuperObject {
    public Stair() {
        name = "Stair";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Res/objects/stair.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
