package lab5A;

import edu.princeton.cs.introcs.Picture;

import java.awt.*;
public class Threshold {

    public Threshold() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        Picture picture = new Picture("C:/dev/workspaceProg2/lab5A/images/stones.jpg");
        int width = picture.width();
        int height = picture.height();
        // convert to grayscale
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color color = picture.get(x, y);
                Color gray = Luminance.toGray(color);
                picture.set(x, y, gray);
            }
        }
        picture.show();
        // TODO Auto-generated method stub

    }

}
