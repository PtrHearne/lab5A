package lab5A;

import edu.princeton.cs.introcs.Picture;

/**
 * @author Owner
 *
 */
public class Dimension {

    /**
     *
     */
    public Dimension() {


    }
    public static void main(String[] args) {
        Picture picture = new Picture("C:/dev/workspaceProg2/lab5A/images/stones.jpg");
        System.out.printf("%d-by-%d\n", picture.width(), picture.height());
        picture.show();
    }
}
