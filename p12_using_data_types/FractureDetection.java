/* *****************************************************************************
 *  Name:    Alan Turing
 *  NetID:   aturing
 *  Precept: P00
 *
 *  Description: Reads an x-ray image from a file and detects whether it
 *               contains a fracture, by comparing it with a reference image.
 *
 **************************************************************************** */

import java.awt.Color;

public class FractureDetection {
    private static final double THRESHOLD = 2;

    // Returns the monochrome luminance of the given color using the
    // NTSC formula Y = 0.299*r + 0.587*g + 0.114*b.
    public static double luminance(Color color) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        return 0.299 * r + 0.587 * g + 0.114 * b;
    }

    public static void main(String[] args) {
        Picture inspect = new Picture(args[0]);
        Picture reference = new Picture(args[1]);

        int width = inspect.width();
        int height = inspect.height();

        // create an empty picture of the same dimension
        Picture detected = new Picture(width, height);

        // look at every pixel
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                // get the luminance of the pixel
                Color color = inspect.get(col, row);
                double lum = luminance(color);

                // get the luminance of the corresponding reference pixel
                Color refColor = reference.get(col, row);
                double refLum = luminance(refColor);

                // if the luminances differ significantly, highight the pixel
                if (Math.abs(lum - refLum) > THRESHOLD) {
                    detected.set(col, row, Color.YELLOW);
                }
                else {
                    detected.set(col, row, color);
                }
            }
        }

        detected.show();
    }
}
