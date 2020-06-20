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
 * g1 = GAATGT
 * g2 = CATAGC
 * Are g1 and g2 identical = false
 *
 * g3 = GAATGTGAATGT <-- g1.getDuplicate()
 * Is g3[2, 8) a potential gene = true
 *
 * g4 = GAATGTCATAGC <-- g1.concat(g2)
 * Is g4[2, 8) a potential gene = false
 * Is g4[2, 11) a potential gene = true
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

    // create a genome from the given String
    public Genome(String sequence) {
        this.n = sequence.length();

        this.sequence = new char[n]; // sequence = new char[n] is equivalent
        for (int i = 0; i < this.n; i++) {
            this.sequence[i] = sequence.charAt(i);
        }
    }

    // return the length of the genome
    public int length() {
        return n;
    }

    // returns the nucleotide at the given position
    public char nucleotideAt(int i) {
        if (i < 0 || i >= n) {
            throw new RuntimeException("The requested nucleotide index " + i 
                  + " is out of bounds for a genome sequence of length " + n);
        }
        return sequence[i];
    }

    // returns true if the genome sequence in the given range starts with a
    // start codon (ATG) and ends with an end codon (TGA, TAA, or TAG)
    public boolean isPotentialGene(int start, int end) {
        // check that a start codon of length 3 is in range
        if (start < 0 || start > n - 3) {
            throw new RuntimeException("The requested start index is out of bounds");
        }

        // check that a end codon of length 3 is in range
        if (end < 3 || end > n) {
            throw new RuntimeException("The requested end index is out of bounds");
        }

        // check that the first 3 chars represent a start codon (ATG)
        String startCodon = "";
        for (int i = 0; i < 3; i++) {
            startCodon += sequence[start + i];
        }
        boolean isATG = startCodon.equals("ATG");

        // check that the last 3 chars represent an end codon (TGA, TAA, or TAG)
        String endCodon = "";
        for (int i = 3; i > 0; i--) {
            endCodon += sequence[end - i];
        }
        boolean isTGA = endCodon.equals("TGA");
        boolean isTAA = endCodon.equals("TAA");
        boolean isTAG = endCodon.equals("TAG");

        return isATG && (isTGA || isTAA || isTAG);
    }

    // returns true if this genome is identical to the given genome
    public boolean isIdentical(Genome that) {
        if (this.n != that.n) return false;

        for (int i = 0; i < n; i++) {
            if (this.sequence[i] != that.sequence[i]) {
                return false;
            }
        }

        return true;
    }

    // concats this genome with another genome and returns a new genome
    public Genome concat(Genome that) {
        // create a new array of the combined lengths
        char[] combined = new char[_____________________];

        // copy over all the nucleotide bases of ~this~ genome
        for (int i = 0; i < _______.n; i++) {
            combined[i] = _______.sequence[i];
        }

        // copy over all the nucleotide bases of ~that~ genome
        for (int i = 0; i < _______.n; i++) {
            combined[______.n + i] = _______.sequence[i];
        }

        // create a new genome with the concatenated sequence
        return new Genome(combined);
    }

    // return a new genome with two concatenated copies of this genome
    public Genome getDuplicate() {
        return this.concat(this);
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

        // testing the String constructor, isIdentical(), getDuplicate(), and concat()
        Genome g1 = new Genome("GAATGT");
        Genome g2 = new Genome("CATAGC");
        System.out.println("\ng1 = " + g1);
        System.out.println("g2 = " + g2);
        System.out.println("Are g1 and g2 identical = " + g1.isIdentical(g2));

        Genome g3 = g1.getDuplicate();
        System.out.println("\ng3 = " + g3 + " <-- g1.getDuplicate() ");
        System.out.println("Is g3[2, 8) a potential gene = " + g3.isPotentialGene(2, 8));

        Genome g4 = g1.concat(g2);
        System.out.println("\ng4 = " + g4 + " <-- g1.concat(g2) ");
        System.out.println("Is g4[2, 8) a potential gene = " + g4.isPotentialGene(2, 8));
        System.out.println("Is g4[2, 11) a potential gene = " + g4.isPotentialGene(2, 11));
    }
}
