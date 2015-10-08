package lab5A;

/**
 * Created by Owner on 06-Oct-15.
 */

import edu.princeton.cs.introcs.StdOut;

import java.awt.*;

/**public class BoundingBox {

    public static void main(String[] args) {
        Picture pic = new Picture("C:/dev/workspaceProg2/lab5A/images/square.bmp");

        int width = pic.width();
        int height = pic.height();
        double thresholdPixelValue = 128.0;
        // convert to grayscale
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = pic.get(x, y);
                if (Luminance.lum(c) < thresholdPixelValue) {
                    pic.set(x, y, Color.BLACK);
                } else {
                    pic.set(x, y, Color.WHITE);
                }
            }
        }
        pic.show();
        System.out.printf("%d-by-%d\n", pic.width(), pic.height());
        //picture.show();
    }
}
*/
public class BoundingBox {
    private double x1, y1;   // lower left
    private double x2, y2;   // upper right

    public BoundingBox(double x1, double y1, double x2, double y2) {
        this.x1 = Math.min(x1, x2);
        this.x2 = Math.max(x1, x2);
        this.y1 = Math.min(y1, y2);
        this.y2 = Math.max(y1, y2);
    }

    public BoundingBox(Point p, Point q) {
        this(p.x, p.y, q.x, q.y);
    }

    // is Point p inside this BoundingBox?
    public boolean contains(Point p) {
        return (p.x >= x1 && p.x <= x2 && p.y >= y1 && p.y <= y2);
    }

    // does this BoundingBox r intersect s?
    public boolean intersects(BoundingBox s) {
        BoundingBox r = this;
        return (r.x2 >= s.x1 && r.y2 >= s.y1 && s.x2 >= r.x1 && s.y2 >= r.y1);
    }


    // return the area
    public double area() {
        return (x2 - x1) * (y2 - y1);
    }

    // return the area
    public String toString() {
        return "[(" + x1 + ", " + y1 + ") (" + x2 + ", " + y2 + ")]";
    }



  /** // test client
    public static void main(String[] args) {

        // check rectangle intersection
        BoundingBox r0 = new BoundingBox(0.25, 0.25, 0.75, 0.75);

        BoundingBox r1 = new BoundingBox(0.4, 0.4, 0.6, 0.6);    // r0 completely contains r1
        BoundingBox r2 = new BoundingBox(0.1, 0.1, 0.9, 0.9);    // r2 completely contains r0
        BoundingBox r3 = new BoundingBox(0.2, 0.2, 0.6, 0.6);    // intersection
        BoundingBox r4 = new BoundingBox(0.2, 0.2, 0.6, 0.6);    // intersection
        BoundingBox r5 = new BoundingBox(0.3, 0.3, 0.8, 0.5);    // intersection
        BoundingBox r6 = new BoundingBox(0.3, 0.3, 0.5, 0.8);    // intersection
        BoundingBox r7 = new BoundingBox(0.3, 0.3, 0.5, 0.8);    // intersection
        StdOut.println(r0.intersects(r1));
        StdOut.println(r0.intersects(r2));
        StdOut.println(r0.intersects(r3));
        StdOut.println(r0.intersects(r4));
        StdOut.println(r0.intersects(r5));
        StdOut.println(r0.intersects(r6));
        StdOut.println(r0.intersects(r7));

        BoundingBox r8  = new BoundingBox(0.1, 0.1, 0.2, 0.2);    // no intersection
        BoundingBox r9  = new BoundingBox(0.1, 0.1, 0.2, 0.8);    // no intersection
        BoundingBox r10 = new BoundingBox(0.1, 0.1, 0.8, 0.2);    // no intersection
        StdOut.println(r0.intersects(r8));
        StdOut.println(r0.intersects(r9));
        StdOut.println(r0.intersects(r10));
    }/*
