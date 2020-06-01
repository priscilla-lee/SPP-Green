/* *****************************************************************************
 * Name:
 * NetID:
 * Precept:
 *
 * Description: Simulates and animates the spread of infection in a population
 *              of size n for a disease with a given infection rate. This client
 *              uses an array of PersonModels.
 *
 * Examples:
 * > java-introcs InfectionSimulationOOP 200 1
 *
 * > java-introcs InfectionSimulationOOP 400 0.15
 *
 **************************************************************************** */

public class InfectionSimulationOOP {
    public static void main(String[] args) {
        // get n and infectionRate from command-line
        int n = _____________________;
        double infectionRate = Double.parseDouble(args[1]);

        // initialize standard drawing
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.enableDoubleBuffering();

        // create an array of n PersonModels
        PersonModel[] people = ____________________;
        for (int i = 0; i < n; i++) {
            people[i] = __________________(0.02, ________________);
        }
        _____________.infect(); // infect patient zero

        // do the animation loop
        while (true) {
            StdDraw.clear(StdDraw.LIGHT_GRAY); // gray background

            // move all n people
            for (int i = 0; i < n; i++) {
                _______________________________
            }

            // potentially infect all n people based on proximity
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    people[i].potentiallyInfect(____________);
                }
            }

            // draw all n people
            for (int i = 0; i < n; i++) {
                _______________________________
            }

            StdDraw.show();
            StdDraw.pause(20);
        }
    }
}
