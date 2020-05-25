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
        Picture reference = _____________________

        int width = inspect.width();
        int height = inspect.height();

        // create an empty picture of the same dimension
        Picture detected = _____________________________

        // look at every pixel
        for (______________________________) {
            for (________________________________) {
                // get the luminance of the pixel
                Color color = inspect.get(________, _______);
                double lum = luminance(color);

                // get the luminance of the corresponding reference pixel
                ______________________________________
                        ______________________________________

                // if the luminances differ significantly, highight the pixel
                if (Math.abs(lum - _________) > THRESHOLD) {
                    detected._________(__________, _________, Color.YELLOW);
                }
                else {
                    __________________________________
                }
            }
        }

        detected.____________
    }
}
