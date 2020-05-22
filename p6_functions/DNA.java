/* *****************************************************************************
 * Name:
 * NetID:
 * Precept:
 *
 * Description: Draws a given DNA sequence and its complement.
 *
 * Examples:
 * > java-introcs DNA TTGAC
 * > java-introcs DNA ATGCAACAGCTC
 *
 **************************************************************************** */

import java.awt.Color;

public class DNA {
    // draw a shape representing a single base of a template sequence
    public static void templateShape(double x, double y, double size) {
        double[] px = { x - size, x + size, x + size, x, x - size };
        double[] py = { y + size, y + size, y - size, y - 2 * size, y - size };
        StdDraw.filledPolygon(px, py);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.polygon(px, py);
    }

    // draw a shape representing a single base of a complement sequence
    public static void complementShape(double x, double y, double size) {
        double[] px = { x - size, x, x + size, x + size, x - size };
        double[] py = { y + size, y, y + size, y - 2 * size, y - 2 * size };
        StdDraw.filledPolygon(px, py);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.polygon(px, py);
    }

    // returns the complement of a single DNA base
    public static char complementaryBase(char base) {
        if (base == 'A')
            return 'T';
        else if (base == 'T')
            return 'A';
        else if (base == 'C')
            return 'G';
        else
            return 'C';
    }

    // returns a Color associated with a single DNA base
    public static Color getColor(char base) {
        if (base == 'A')
            return new Color(255, 100, 100); // coral
        else if (base == 'T')
            return Color.YELLOW;
        else if (base == 'C')
            return Color.GREEN;
        else
            return Color.CYAN;
    }

    public static void main(String[] args) {
        String sequence = args[0];
        int n = sequence.length();

        // set the scale according to the length of the given DNA sequence
        StdDraw.setXscale(0, n);
        StdDraw.setYscale(-n / 2.0, n / 2.0);

        for (int i = 0; i < n; i++) {
            // draw the template 
            char base = sequence.charAt(i);
            StdDraw.setPenColor(getColor(base));
            templateShape(i + 0.5, 0.5, 0.5);

            // draw the complement
            char complement = complementaryBase(base);
            StdDraw.setPenColor(getColor(complement));
            complementShape(i + 0.5, -0.5, 0.5);

            // label the base pairs
            StdDraw.text(i + 0.5, 0.5, "" + base);
            StdDraw.text(i + 0.5, -1, "" + complement);
        }
    }
}
