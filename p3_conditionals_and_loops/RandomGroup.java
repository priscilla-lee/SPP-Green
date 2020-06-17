/****************************************************************************
 * Description: Simulate the assignment of an experiment participant
 *              into one of three experimental groups.
 *
 * Examples:
 * > java RandomGroup
 * 3
 * > java RandomGroup
 * 1
 **************************************************************************** */

public class RandomGroup {
   public static void main(String[] args) {
       // how many experimental groups are in this study?
      int NUM_GROUPS = 3;

      // group should be 1 through NUM_GROUPS
      int group = (int)(Math.random() * NUM_GROUPS) + 1

      // print group assignment
      System.out.println(group);
   }
}