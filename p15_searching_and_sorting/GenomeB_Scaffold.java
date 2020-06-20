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
 * Nucleotide of g at 1 = T
 * Is g[1, 4) a potential gene = false
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
        // char[] sequence = input;
        sequence = new char[n];  // create a new array same size as input
        for (int i = 0; i < n; i++) {
            // copy elements
            sequence[i] = input[i];
        }
    }

    // return the length of the genome
    public int length() {
        return n;
    }

    // returns the nucleotide at the given position
    public char nucleotideAt(int i) {
        if (i < 0 || i >= n) {
            throw new RuntimeException("The requested nucleotide index is out of bounds");
        }
        return sequence[i];
    }

    // returns true if the genome sequence in the given range starts with a
    // start codon (ATG) and ends with an end codon (TGA, TAA, or TAG)
    public boolean isPotentialGene(int start, int end) {
        // check that a start codon of length 3 is in range
        if (_________ < 0 || _________ > n - 3) {
            throw ___________________________________________________________
        }

        // check that a end codon of length 3 is in range
        if (________ < 3 || __________ > n) {
            throw new RuntimeException("The requested end index is out of bounds");
        }

        // check that the first 3 chars represent a start codon (ATG)
        String startCodon = "";
        for (int i = 0; i < 3; i++) {
            startCodon += __________[start + i];
        }
        boolean isATG = ________________.equals("ATG");

        // check that the last 3 chars represent an end codon (TGA, TAA, or TAG)
        String endCodon = "";
        for (int i = 3; i > 0; i--) {
            endCodon += sequence[end - i];
        }
        boolean isTGA = endCodon.equals(______);
        boolean isTAA = endCodon.______________;
        boolean isTAG = _______________________;

        return isATG && (isTGA || isTAA || isTAG);
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
        System.out.println("g = " + g); // should be "ATCG"
        values[0] = 'G';
        System.out.println("g = " + g); // should still be "ATCG"!!
        System.out.println("Length of g = " + g.length());

        // testing nucleotideAt() and isPotentialGene()
        System.out.println("Nucleotide of g at 1 = " + g.nucleotideAt(1));
        System.out.println("Is g[1, 4) a potential gene = " + g.isPotentialGene(1, 4));
    }
}
