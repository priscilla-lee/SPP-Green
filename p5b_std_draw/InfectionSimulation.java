/* *****************************************************************************
 * Name:
 * NetID:
 * Precept:
 *
 * Description: Simulates and animates the spread of infection in a population
 *              of size n for a disease with a given infection rate.
 *
 * Examples:
 * > java-introcs InfectionSimulation 200 1
 * 
 * > java-introcs InfectionSimulation 400 0.15 
 * 
 **************************************************************************** */

import java.awt.Color;

public class InfectionSimulation {
    public static void main(String[] args) {
        // get n and infectionRate from command-line
        int n = Integer.parseInt(args[0]);
        double infectionRate = Double.parseDouble(args[1]);

        // initial values for n people
        double[] rx = new double[n];
        double[] ry = new double[n];
        double[] vx = new double[n];
        double[] vy = new double[n];
        boolean[] infected = new boolean[n];
        double radius = 0.02;

        for (int i = 0; i < n; i++) {
            rx[i] = 1.8 * Math.random() - 0.9; // random values in [-0.9, 0.9)
            ry[i] = 1.8 * Math.random() - 0.9;
            vx[i] = 0.01 * Math.random() - 0.005;  // random values in [-0.005, 0.005)
            vy[i] = 0.01 * Math.random() - 0.005;
        }
        
        // infect patient zero
        infected[0] = true;

        // initialize standard drawing
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.enableDoubleBuffering();

        // keep track of the number of animation iterations so far
        int iteration = 1;

        // main animation loop
        while (true) {
            // 1. bounce all balls off wall according to law of elastic collision
            for (int i = 0; i < n; i++) {
                if (Math.abs(rx[i] + vx[i]) + radius > 1.0) {
                    vx[i] = -vx[i];
                }
                if (Math.abs(ry[i] + vy[i]) + radius > 1.0) {
                    vy[i] = -vy[i];
                }
            }

            // 2. update positions of all balls - velocity is constant
            for (int i = 0; i < n; i++) {
                rx[i] = rx[i] + vx[i];
                ry[i] = ry[i] + vy[i];
            }

            // 2b. infect people based on proximity and infection rate
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // person i is at risk if they are near a person j who is infected
                    double dx = rx[i] - rx[j];
                    double dy = ry[i] - ry[j];
                    boolean close = (Math.sqrt(dx * dx + dy * dy) < 2 * radius);
                    boolean atRisk = infected[j] && close;

                    // potentially infect person i if they are at risk
                    if (atRisk && Math.random() < infectionRate) {
                        infected[i] = true;
                    }
                }
            }

            // 3a. set the background to light gray
            StdDraw.clear(StdDraw.LIGHT_GRAY);

            // 3b. draw all people on the screen
            for (int i = 0; i < n; i++) {
                // color healthy people gray and infected people red
                Color color = new Color (10, 10, 10, 100); // gray
                if (infected[i]) {
                    color = new Color(255, 0, 0, 100); // red
                }

                StdDraw.setPenColor(color);
                StdDraw.filledCircle(rx[i], ry[i], radius);
            }

            // display and pause for 20 ms
            StdDraw.show();  // double buffer is enabled
            StdDraw.pause(20);

            // report the proportion of infected people every 20 iterations
            iteration++;
            if (iteration % 10 == 0) {
                int numInfected = 0;
                for (int i = 0; i < n; i++) {
                    if (infected[i]) numInfected++;
                }
                StdOut.println(1.0 * numInfected / n);
            }
        }
    }
}
