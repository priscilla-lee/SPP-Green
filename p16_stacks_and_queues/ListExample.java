/* *****************************************************************************
 *
 *  Description:  Snippet of code to demonstrate linked nodes in Ed Lessons.
 *
 **************************************************************************** */

public class ListExample {
    private static class Node {
        String name; // name of Node
        Node next;   // link to the next Node

        private Node(String n) {
            name = n;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node first = new Node("A");
        first.next = new Node("B");
        first.next.next = new Node("C");
    }
}
