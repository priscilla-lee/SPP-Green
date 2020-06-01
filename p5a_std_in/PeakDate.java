/* *****************************************************************************
 * Name:
 * NetID:
 * Precept:
 *
 * Description: Reads in pairs of dates and monarch sighting counts from StdIn
 * and prints the date of maxmimum monarch sightings. Tie break in favor of
 * the first date that appears in the input.
 *
 * Examples:
 *
 * > java-introcs Monarchs OklahomaCityOK 1998 < monarchs_data.txt | java-introcs PeakDate
 * Monarch sightings (count: 616) peaked on Oct 7.
 *
 * > java-introcs Monarchs WamegoKS 1996 < monarchs_data.txt | java-introcs PeakDate
 * Monarch sightings (count: 2359) peaked on Sept 17.
 *
 * > java-introcs Monarchs WamegoKS 1997 < monarchs_data.txt | java-introcs PeakDate
 * Monarch sightings (count: 2721) peaked on Sept 18.
 *
 **************************************************************************** */

public class PeakDate {
    public static void main(String[] args) {
        // first values initialize peak date and max count
        String peakDate = StdIn.readString() + " " + StdIn.readInt();
        int maxCount = StdIn.readInt();

        // read in the data, keep track of max count and peak date
        while (!StdIn.isEmpty()) {
            String date = StdIn.readString() + " " + StdIn.readInt();
            int count = StdIn.readInt();

            if (count > maxCount) {
                maxCount = count;
                peakDate = date;
            }
        }

        // output
        StdOut.println("Monarch sightings (count: " + maxCount
                               + ") peaked on " + peakDate + ".");
    }
}
