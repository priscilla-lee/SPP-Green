/* *****************************************************************************
 * Name:    
 * NetID:   
 * Precept: 
 *
 * Description: Given a DNA sequence, generate its reverse complement.
 *
 * Examples:
 * > java-introcs ReverseComplement TTGAC
 * GTCAA
 * 
 * > java-introcs ReverseComplement AACCGGTT
 * AACCGGTT
 *
 **************************************************************************** */
public class ReverseComplement {
    public static void main(String[] args) {
        // read in the DNA sequence from the command line
        char[] original = args[0].toCharArray();

        // generate the reverse complement of the given sequence
        char[] complemented = Complement.complement(original);
        char[] reverseComplemented = Reverse.reverse1(complemented);
        StdOut.println(new String(reverseComplemented));
    }
}
