/* *****************************************************************************
 * Name:
 * NetID:
 * Precept:
 *
 * Description: Reads the integer n from standard input, then reads
 * a list of n monarch sighting entries, where each entry consists of five
 * fields, separated by whitespace:
 *     - location
 *     - year
 *     - month
 *     - date
 *     - number of sightings
 *
 * Then, prints all entries in the format
 *     (<month> <date>      <number of sightings>)
 * in the specified year and location.
 *
 * The data file, monarchs_data.txt, looks like this:
 * 4363
 * AltoonaIA	1994	Sept	15	6
 * AltoonaIA	1995	Sept	5	1
 * AltoonaIA	1995	Sept	8	1
 * AltoonaIA	1995	Sept	9	3
 * ...
 *
 * Compilation:  javac-introcs Monarchs.java
 * Execution:    java-introcs Monarchs WamegoKS 1996 < monarchs_data.txt
 *
 * Your output should look like this:
 * July 14         4
 * July 19         4
 * Sept 11         23
 * Sept 12         567
 * Sept 13         1037
 * Sept 14         412
 * Sept 15         56
 * Sept 16         1728
 * Sept 17         2359
 * Sept 18         1273
 * ...
 *
 * Note: The data file includes entries for the following 25 locations:
 * AltoonaIA,        AustinTX,        ColumbiaPA,      CouncilBluffsIA,  HoustonTX,
 * HowardPA,         IndependenceMO,  KansasCityMO,    LawrenceKS,       LeagueCityTX,
 * LewisburgWV,      ManhattanKS,     MifflinburgPA,   NeenahWI,         NormanOK,
 * OklahomaCityOK,   OlatheKS,        OrlandoFL,       OviedoFL,         TopekaKS,
 * TupperLakeNY,     WakeeneyKS,      WamegoKS,        WestHavenCT,      WichitaKS
 *
 **************************************************************************** */

public class Monarchs {
    public static void main(String[] args) {
        // parse the target location and year from the command line
        String targetLoc = args[0];
        int targetYear = Integer.parseInt(args[1]);

        // read the number of monarch sighting entries from StdIn
        int n = StdIn.readInt();

        // declare and initialize five parallel arrays
        String[] loc = new String[n];
        int[] year = new int[n];
        String[] month = new String[n];
        int[] date = new int[n];
        int[] count = new int[n];

        // read the data from standard input
        for (int i = 0; i < n; i++) {
            loc[i] = StdIn.readString();
            year[i] = StdIn.readInt();
            month[i] = StdIn.readString();
            date[i] = StdIn.readInt();
            count[i] = StdIn.readInt();
        }

        // print all monarch sighting entries in the given year and location
        for (int i = 0; i < n; i++) {
            if (loc[i].equals(targetLoc) && year[i] == targetYear) {
                StdOut.println(month[i] + " " + date[i] + "\t\t" + count[i]);
            }
        }
        StdOut.println();
    }
}
