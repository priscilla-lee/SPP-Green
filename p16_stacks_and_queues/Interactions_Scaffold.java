/* *****************************************************************************
 * Name:
 * NetID:
 * Precept:
 *
 * Description: Keeps track of a person's history of interactions. It uses a
 * Stack to store multiple days' worth of interactions, and it uses a Queue per
 * day to store names. It retrieves a list of names of people a person contacted
 * in the last few days to facilitate contract tracing.
 *
 * Examples:
 * > java-introcs Interactions
 * Day 7: Gertrude Gary
 * Day 6: Frank Fred Fernanda
 * Day 5: Eve Edison Eric Evelyn
 * Day 4: Dave Doug
 * Day 3: Carol Cathy Crystal
 * Day 2: Bob Billy Barbara
 * Day 1: Alice Alex
 *
 * Past 2 days: Gertrude Gary Frank Fred Fernanda
 *
 **************************************************************************** */

public class Interactions {
    // use a Stack to store multiple days' worth of interactions
    // use a Queue per day to store names of interactions for that day
    private Stack<Queue<String>> history;

    public Interactions() {
        // create a new Stack to store multiple days
        history = ___________________________________;

        // add a first day of interactions (initially empty)
        Queue<String> firstDay = new Queue<String>();
        history.________(firstDay);
    }

    // add the given name to the current day's collection of names
    public void contact(String name) {
        ______________ today = history.peek();
        today.___________(name);
    }

    // add a new day to the Stack
    public void newDay() {
        history.push(________________);
    }

    // retrieve a list of all interactions in the past numDays days.
    // (you can assume that numDays < history.size())
    public Queue<String> contactTrace(int numDays) {
        // ALL people seen in the most recent numDays days
        Queue<String> all = new Queue<String>();

        // pop off the most recent numDays Queues from the Stack
        for (int i = 0; i < numDays; i++) {
            Queue<String> day = _________________;

            // add all of the names in this day to the full list of names
            for (String name : day) {
                all.enqueue(name);
            }
        }

        return all;
    }

    // returns a string representation of the entire history of interactions
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int i = history.size(); // to keep track of the day #

        // iterate across all the days
        for (Queue<String> day : history) {
            sb.append("Day " + i + ": ");

            // iterate across all the names per day
            for (String person : day)
                sb.append(person + " ");

            sb.append("\n");
            i--;
        }

        return sb.toString();
    }

    // test client
    public static void main(String[] args) {
        Interactions person = new Interactions();

        // a week's worth of human interactions
        person.contact("Alice");
        person.contact("Alex");
        person.newDay();
        person.contact("Bob");
        person.contact("Billy");
        person.contact("Barbara");
        person.newDay();
        person.contact("Carol");
        person.contact("Cathy");
        person.contact("Crystal");
        person.newDay();
        person.contact("Dave");
        person.contact("Doug");
        person.newDay();
        person.contact("Eve");
        person.contact("Edison");
        person.contact("Eric");
        person.contact("Evelyn");
        person.newDay();
        person.contact("Frank");
        person.contact("Fred");
        person.contact("Fernanda");
        person.newDay();
        person.contact("Gertrude");
        person.contact("Gary");

        // print out the person's full history of interactions
        StdOut.println(person);

        // print out a Queue of people this person contacted in the past 2 days
        StdOut.print("Past 2 days: ");
        StdOut.println(person.contactTrace(2));
    }
}
