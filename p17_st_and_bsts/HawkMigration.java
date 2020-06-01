/* *****************************************************************************
 * Name:
 * NetID:
 * Precept:
 *
 * Description:  Reads in pairs of states and peak time frames from StdIn,
 * and uses a symbol table to group states by peak time frames.
 *
 * Compilation:  javac-introcs HawkMigration.java
 * Execution:    java-introcs HawkTracker < hawks_data.txt | java-introcs HawkMigration
 *
 * The output should look like:
 * Sept 6 - 10: VT
 * Sept 11 - 15: ME NH
 * Sept 16 - 20: CT MA MD NJ NY PA
 * Sept 21 - 25: WV
 * Sept 26 - 30: NC SC VA
 *
 **************************************************************************** */

public class HawkMigration {
    private static final String[] DATE_RANGES = {
            "Sept 1 - 5",    // time frame 0
            "Sept 6 - 10",   // time frame 1
            "Sept 11 - 15",  // time frame 2
            "Sept 16 - 20",  // time frame 3
            "Sept 21 - 25",  // time frame 4
            "Sept 26 - 30",  // time frame 5
            "Oct 1 - 5",     // time frame 6
            "Oct 6 - 10"     // time frame 7
    };

    // groups states by peak sighting time frames
    // the key is the peak sighting time frame, and
    // the value is a queue of states
    private ST<Integer, Queue<String>> st;

    public HawkMigration() {
        st = new ST<Integer, Queue<String>>();
    }

    public void addEntry(int period, String state) {
        // if the period is not in the ST, add a new queue
        if (!st.contains(period)) {
            st.put(period, new Queue<String>());
        }
        st.get(period).enqueue(state);
    }

    // return a string represent of hawk migration
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // for each loop goes through all keys in numerical order
        for (int period : st) {
            sb.append(DATE_RANGES[period] + ": ");

            // append all the states
            for (String state : st.get(period)) {
                sb.append(state + " ");
            }
            sb.append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        HawkMigration migration = new HawkMigration();

        while (!StdIn.isEmpty()) {
            String state = StdIn.readString();
            int period = StdIn.readInt();
            migration.addEntry(period, state);
        }

        StdOut.println(migration);
    }
}
