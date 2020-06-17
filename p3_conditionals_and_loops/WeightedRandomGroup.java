/****************************************************************************
 * Description: Simulate the assignment of an experiment participant
 *              into one of three weighted experimental groups (in which 
 *              the participant is assigned to groups 1 and 2 with 20%
 *              probability each, and group 3 with 60% probability).
 *
 * Examples:
 * > java WeightedRandomGroup
 * 3
 * > java WeightedRandomGroup
 * 1
 **************************************************************************** */
public class WeightedRandomGroup {
    public static void main(String[] args) {
        // generate random double in the range [0.0, 1.0)
        double r = Math.random();

        // assign a random group with desired probabilities
        int group;
        if (r < 0.2)
            group = 1;
        else if (r < 0.4)
            group = 2;
        else
            group = 3;

        // print the group assignment
        System.out.println(group);
    }
}