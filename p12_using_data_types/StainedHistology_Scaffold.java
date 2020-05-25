/* *****************************************************************************
 * Name:
 * NetID:
 * Precept:
 *
 * Description: Reads a histological image from a file, and detects and displays
 *              the blue-stained cells in a new window.
 *
 **************************************************************************** */

import java.awt.Color;

public class StainedHistology {
    private static final int THRESHOLD = 80;

    public static Picture detectStained(Picture input) {
        // get the dimensions of the input picture
        int width = input.width();
        int height = input.height();

        // create an empty picture of the same dimension
        Picture output = new Picture(______________________);

        // look at every pixel
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                // color value of current pixel
                Color color = input.____________________;

                // cell is stained if red intensity value is below threshold
                if (color.____________________ < THRESHOLD) {
                    output.set(________, ____________, Color.YELLOW);
                }
                else {
                    output.set(col, row, ________________);
                }
            }
        }

        return output;
    }

    public static void main(String[] args) {
        // read the picture specified by command-line argument
        Picture original = new Picture(args[0]);

        // display the original image and the detected image
        Picture detected = detectStained(_____________);
        original.show();
        ___________.show();
    }
}
