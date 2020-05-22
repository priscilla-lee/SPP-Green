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
    public static _________ reverse1(_________________) {






    }

    // reverse2() takes an array of chars and reverses the order of its elements
    // by modifying the original array. This method does not return anything.
    public static _________ reverse2(_________________) {






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