package test;

import org.junit.Assert;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class ImageTest {

    @Test
    public void test() {
        try {
            BufferedImage image = ImageIO.read(Objects.requireNonNull(ImageTest.class.getClassLoader().getResourceAsStream("images/tankL.gif")));
            Assert.assertNotNull(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
