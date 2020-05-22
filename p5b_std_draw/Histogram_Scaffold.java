/* *****************************************************************************
 * Name:    
 * NetID:   
 * Precept: 
 *
 * Description: Plot a histogram of data points read in from StdIn using
 *              bars of a specified width. Each of the data points represent
 *              bar heights and must be less than or equal to 1.
 *
 * Execution: 
 *   -- input required from standard input
 *   -- use Ctrl-d (Mac) or Ctrl-z <enter> (Windows) for EOF
 * 
 * Examples:
 * > java-introcs Histogram 0.2
 * 0.5 0.7 0.3 0.1 0.8
 * Ctrl-d / Ctrl-z <enter>
 *
 * > java-introcs Histogram 0.1 < data.txt
 *
 **************************************************************************** */

public class Histogram {
    public static void main(String[] args) {
    	// parse the bar width from the command line
        double barWidth = Double.parseDouble(args[0]);
        double x = barWidth / 2;

        while (!StdIn.isEmpty()) {
        	// read in each data point (representing bar heights)
            double barHeight = __________________;

            // draw a rectangle of the specified height
            StdDraw.filledRectangle(_______, _______, _______, _______);

            // update the x coordinate
            x += barWidth;
        }
    }
}
