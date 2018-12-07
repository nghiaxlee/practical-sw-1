package res;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class ResourceLoader {
    public static Image loadImage(String name) throws IOException
    {
        URL url = ResourceLoader.class.getClassLoader().getResource(name);
        return ImageIO.read(url);
    }
}
