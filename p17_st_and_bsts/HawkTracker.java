/* *****************************************************************************
 * Name:
 * NetID:
 * Precept:
 *
 * Description: Reads the integer n from standard input, then reads a list of
 * n sharp-shinned hawk sighting entries, where each entry consists of four
 * fields, separated by whitespace:
 *     - state
 *     - year
 *     - time frame
 *     - count
 * Then, prints a list of states and the time frames in which hawk sightings
 * peaked per state.
 *
 * Compilation:  javac-introcs HawkTracker.java
 * Execution:    java-introcs HawkTracker < hawks_data.txt
 *
 * The data file, hawks_data.txt, looks like this:
 * 1223
 * CT	1970	7	7
 * CT	1971	3	1
 * CT	1971	4	11
 * CT	1971	5	4
 * ...
 *
 * In the first entry, "CT	1970	7	7" indicates that 7 sharp-shinned hawks
 * were sighted in Connecticut in 1970 during the 7th time frame (Oct 1 - 5).
 *
 * Your output should look like this:
 * CT 3
 * MA 3
 * MD 3
 * ME 2
 * NC 5
 * NH 2
 * NJ 3
 * NY 3
 * PA 3
 * SC 5
 * VA 5
 * VT 1
 * WV 4
 *
 **************************************************************************** */

public class HawkTracker {
    private static final int NUM_TIME_FRAMES = 8;

    // maintains sighting counts per time frame for each state
    // the key is the state, and
    // the value is an array of counts indexed by time frame
    private ST<String, int[]> st;

    public HawkTracker() {
        st = new ST<String, int[]>();
    }

    // add a sighting entry to the ST
    public void addEntry(String state, int timeframe, int count) {
        // if the state is not in the ST yet, create a new int array
        if (!st.contains(state)) {
            st.put(state, new int[NUM_TIME_FRAMES]);
        }

        // increment the current state and time frame's value by count
        st.get(state)[timeframe] += count;
    }

    // returns the index of the maximum value in the given int array
    private static int getMaxIndex(int[] values) {
        int maxValue = values[0];
        int maxIndex = 0;

        for (int i = 1; i < values.length; i++) {
            if (values[i] > maxValue) {
                maxValue = values[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    // returns the time frame in which the sightings peaked in the given state
    public int getMaxTimeFrame(String state) {
        int[] timeFrames = st.get(state);
        return getMaxIndex(timeFrames);
    }

    // return a string representation of the hawk tracker
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // for each loop goes through all keys in alphabetical order
        for (String state : st.keys()) {
            // print out the state and the time frame in which sightings peaked
            sb.append(state + " " + getMaxTimeFrame(state) + "\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        HawkTracker hawks = new HawkTracker();

        // read the number of hawk sighting entries from StdIn
        int n = StdIn.readInt();

        // read the data from standard input
        for (int i = 0; i < n; i++) {
            String state = StdIn.readString();
            StdIn.readString(); // skip year
            int timeframe = StdIn.readInt();
            int count = StdIn.readInt();
            hawks.addEntry(state, timeframe, count);
        }

        StdOut.println(hawks);
    }
}
