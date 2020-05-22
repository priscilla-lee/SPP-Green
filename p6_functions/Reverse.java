/* *****************************************************************************
 * 
 * Description: The following two methods reverse the order of elements
 *              in an array of chars.
 *
 *              Example:
 *              >java Reverse
 *              original[] before reverse1() = A B C D
 *              original[] after  reverse1() = A B C D
 *              result[]   after  reverse1() = D C B A
 *              original[] before reverse2() = A B C D
 *              original[] after  reverse2() = D C B A
 *
 **************************************************************************** */

public class Reverse {
    // reverse1() takes an array of chars, and returns a new array of chars
    // which contains the same elements as the original, but in reverse order.
    // Note, it must not alter the original array.
    public static char[] reverse1(char[] original) {
        int n = original.length;

        // create a new array that is the same length as original
        char[] reversed = new char[n];

        // copy the contents of original in reversed order
        for (int i = 0; i < n; i++) {
            reversed[i] = original[n - i - 1];
        }

        // return the reverse of the original
        return reversed;
    }

    // reverse2() takes an array of chars and reverses the order of its elements
    // by modifying the original array. This method does not return anything.
    public static void reverse2(char[] original) {
        int n = original.length;
        for (int i = 0; i < n / 2; i++) {
            char temp = original[i];
            original[i] = original[n - 1 - i];
            original[n - 1 - i] = temp;
        }
    }

    // print all the chars in the input array
    public static void printAll(char[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        // print args
        char[] original = {'A', 'B', 'C', 'D'};
        StdOut.print("original[] before reverse1() = ");
        printAll(original);

        // reverse1() does not change original[]
        char[] result = reverse1(original);
        StdOut.print("original[] after  reverse1() = ");
        printAll(original);
        StdOut.print("result[]   after  reverse1() = ");
        printAll(result);

        // reverse2() modifies original[]!
        // print original
        StdOut.print("original[] before reverse2() = ");
        printAll(original);
        reverse2(original);
        StdOut.print("original[] after  reverse2() = ");
        printAll(original);
    }
}