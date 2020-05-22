/* *****************************************************************************
 * Name:    
 * NetID:   
 * Precept: 
 *
 * Description: Given a DNA sequence, generate its complement.
 *
 * Example:
 * > java-introcs Complement
 * debugging: running the first method
 * AAGTC
 * debugging: running the second method
 * AAGTC
 *
 **************************************************************************** */
public class Complement {
    // returns the complement of a single DNA base
    public static char complementaryBase(char base) {
        if (base == 'A')
            return 'T';
        else if (base == 'T')
            return 'A';
        else if (base == 'C')
            return 'G';
        else
            return 'C';
    }

    // returns the complement of a DNA sequence represented as a String
    public static ________ complement(__________________) {
        StdOut.println("debugging: running the first method");




    }

    // returns the complement of a DNA sequence represented as a char[]
    public static ________ complement(__________________) {
        StdOut.println("debugging: running the second method");




    }

    public static void main(String[] args) {
        StdOut.println(complement("TTCAG"));

        char[] original = {'T', 'T', 'C', 'A', 'G'};
        char[] complement = complement(original);
        for (int i = 0; i < complement.length; i++) {
            StdOut.print(complement[i]);
        }
        StdOut.println();

    }
}
