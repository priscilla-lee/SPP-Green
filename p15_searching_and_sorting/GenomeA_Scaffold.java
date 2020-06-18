/* *****************************************************************************
 * Name:
 * NetID:
 * Precept:
 *
 * Description: This class is implemented to be immutable: once the
 * client program initializes a Genome, it cannot change any of its
 * fields (n or sequence[i]) either directly or indirectly. Immutability
 * is a very desirable feature of a data type.
 *
 * Output:
 * > java-introcs Genome
 * g = ATCG
 * g = ATCG
 * Length of g = 4
 *
 **************************************************************************** */

public class Genome {
    private int n;           // length of the genome
    private char[] sequence; // array containing genome sequence

    // create a genome from the given char array
    public Genome(char[] input) {
        n = input.length;

        // We need a defensive copy so client can't alter our copy of sequence[]
        // This isn't it!
        char[] sequence = input;
    }

    // return the length of the genome
    public int length() {
        return n;
    }

    // returns a string representation of this genome
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(sequence[i]);
        }
        return sb.toString();
    }

    // sample client for testing
    public static void main(String[] args) {
        // is it really immutable?
        char[] values = { 'A', 'T', 'C', 'G' };
        Genome g = new Genome(values);
        StdOut.println("g = " + g); // should be "ATCG"
        values[0] = 'G';
        StdOut.println("g = " + g); // should still be "ATCG"!!
        StdOut.println("Length of g = " + g.length());
    }
}
