/* *****************************************************************************
 * Name:
 * NetID:
 * Precept:
 *
 * Description: Randomly sample quadrat positions from a grid.
 *
 * Examples:
 * > java-introcs QuadratSampling 5 5
 * 3, 0, 1, 4, 2,
 *
 * > java-introcs QuadratSampling 100 10
 * 54, 60, 52, 71, 77, 79, 68, 25, 78, 7,
 *
 * > java-introcs QuadratSampling 100 20
 * 1, 39, 43, 41, 54, 77, 74, 7, 68, 4, 99, 66, 34, 0, 67, 80, 95, 53, 86, 69,
 **************************************************************************** */

public class QuadratSampling {
    public static void main(String[] args) {
        // the total number of available quadrat positions in the area
        int available = Integer.parseInt(args[0]);

        // the number of quadrats we need to sample
        int needed = Integer.parseInt(args[1]);

        // the number of quadrats that we've sampled so far
        int sampled = 0;

        // this array will associate true or false with each possible quadrat
        // (true if the quadrat has already been sampled)
        boolean[] seenBefore = new ______________________;

        // keep sampling until we reach the desired number of quadrats
        while (____________ < ____________) {
            // pick a random quadrat number
            int quadratNum = ___________________________________;

            // if we've seen this quadratNum before, skip this iteration
            if (_____________________) continue;

            // update seenBefore[], for future iterations of this loop
            seenBefore[____________] = ____________;

            // print out the sampled quadrat number
            StdOut.print(quadratNum + ", ");
            sampled++;
        }

        StdOut.println();
    }
}
