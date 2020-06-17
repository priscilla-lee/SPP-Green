/****************************************************************************
 * Description: Simulate the assignment of multiple experiment
 *              participants into one of three weighted experimental
 *              groups (in which each participant is assigned to groups 1
 *              and 2 with 20% probability each, and group 3 with 60% probability).
 *
 * Example:
 * > java WeightedRandomGroups 10
 * Participant 0 to Group 3
 * Participant 1 to Group 3
 * Participant 2 to Group 3
 * Participant 3 to Group 3
 * Participant 4 to Group 3
 * Participant 5 to Group 3
 * Participant 6 to Group 2
 * Participant 7 to Group 3
 * Participant 8 to Group 1
 * Participant 9 to Group 3
 **************************************************************************** */
public class WeightedRandomGroups {
    public static void main(String[] args) {
        int numParticipants = Integer.parseInt(args[0]);

        for (int i = 0; i < numParticipants; i++) {
            // assign a random group with desired probabilities
            double r = Math.random();
            int group;
            if (r < 0.2) group = 1;
            else if (r < 0.4) group = 2;
            else group = 3;

            // print the group assignment
            System.out.println("Participant " + i + " to Group " + group);
        }
    }
}
