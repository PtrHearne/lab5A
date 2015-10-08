import java.awt.Color;

import edu.princeton.cs.introcs.Picture;

public class BoundingBox {

    public static void main(String[] args) {

        Picture pic = new Picture("images/white_box.bmp");

        int maxX = 0;
        int minX = pic.width();
        int maxY = 0;
        int minY = pic.height();

        for (int x = 0; x < pic.width(); x++) {
            for (int y = 0; y < pic.height(); y++) {
                if (!pic.get(x, y).equals(Color.WHITE) ) {

                    if (x < minX)
                        minX = x;
                    if (x > maxX)
                        maxX = x;
                    if (y < minY)
                        minY = y;
                    if (y > maxY)
                        maxY = y;

                }
            }

        }

        if (minX > maxX || minY > maxY) {
            System.out.println("It's All White Pixels!!!");
        } else {
            for (int x = minX; x <= maxX; x++) {
                pic.set(x, minY, Color.RED);
                pic.set(x, maxY, Color.RED);
            }

            for (int y = minY; y <= maxY; y++) {
                pic.set(minX, y, Color.RED);
                pic.set(maxX, y, Color.RED);
            }
        }

        pic.show();
    }

}
