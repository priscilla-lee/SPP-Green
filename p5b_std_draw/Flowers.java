import java.awt.Color;

public class Flowers {

    //  Draws a filled equilateral triangle whose bottom vertex is (x, y)
    //  of the specified side length.
    public static void pentagon(double x, double y, double radius) {
        // compute the coordinates of the 4 tips of the H
        double height1 = radius * Math.sin((Math.toRadians(18)));
        double width1 = radius * Math.cos((Math.toRadians(18)));
        double height2 = radius * Math.cos((Math.toRadians(36)));
        double width2 = radius * Math.sin((Math.toRadians(36)));
        double[] xnew = { x, x + width1, x + width2, x - width2, x - width1 };
        double[] ynew = { y + radius, y + height1, y - height2, y - height2, y + height1 };
        StdDraw.setPenColor(Color.YELLOW);
        StdDraw.filledPolygon(xnew, ynew);
        StdDraw.setPenColor(Color.PINK);
        StdDraw.polygon(xnew, ynew);

    }

    //  Draws a Sierpinski triangle of order n, such that the largest filled
    //  triangle has bottom vertex (x, y) and sides of the specified length.
    public static void flower(int n, double x, double y, double radius) {
        if (n == 0) return;
        pentagon(x, y, radius);

        double height1 = radius * Math.sin((Math.toRadians(18)));
        double width1 = radius * Math.cos((Math.toRadians(18)));
        double height2 = radius * Math.cos((Math.toRadians(36)));
        double width2 = radius * Math.sin((Math.toRadians(36)));


        flower(n - 1, x, y + radius, radius / 2.5);
        flower(n - 1, x + width1, y + height1, radius / 2.5);
        flower(n - 1, x + width2, y - height2, radius / 2.5);
        flower(n - 1, x - width2, y - height2, radius / 2.5);
        flower(n - 1, x - width1, y + height1, radius / 2.5);
    }

    public static void main(String[] args) {
        flower(5, 0.5, 0.5, 0.05);

    }
}
