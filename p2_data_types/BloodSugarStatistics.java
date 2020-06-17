/* *****************************************************************************
 *  Description: Given three blood sugar level measurements, prints out the
 *               minimum, maximum, and average measurements, along with the
 *               standard deviation.
 *
 * Examples:
 * > java BloodSugarLevels 170 190 180
 * Min = 170
 * Max = 190
 * Average = 180.0
 * Standard deviation = 10.0
 * AIC = 7.898954703832753
 **************************************************************************** */

public class BloodSugarStatistics {
    public static void main(String[] args) {
        // read 3 command-line arguments
        int level1 = Integer.parseInt(args[0]);
        int level2 = Integer.parseInt(args[1]);
        int level3 = Integer.parseInt(args[2]);

        // compute and print out the min
        int min = Math.min(level1, Math.min(level2, level3));
        System.out.println("Min = " + min);

        // compute and print out the max
        int max = Math.max(level1, Math.max(level2, level3));
        System.out.println("Max = " + max);

        // compute and print out the average
        double mean = (level1 + level2 + level3) / 3.0;
        System.out.println("Average = " + mean);

        // compute and print out the standard deviation
        double sum = (level1 - mean) * (level1 - mean)
                + (level2 - mean) * (level2 - mean)
                + (level3 - mean) * (level3 - mean);
        double sd = Math.sqrt(sum / 2);
        System.out.println("Standard deviation = " + sd);
        
        // compute and print out the estimated A1C
        double a1c = (46.7 + mean) / 28.7;
        System.out.println("A1C = " + a1c);
    }
}
