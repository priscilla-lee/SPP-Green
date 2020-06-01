/* *****************************************************************************
 *
 *  Description:  Object-oriented model of a person, to be used in an
 *                infection simulation.
 *
 * Example:
 * > java-introcs PersonModel
 *
 **************************************************************************** */

import java.awt.Color;

public class PersonModel {
    // declare instance variables
    private double rx;            // position in x
    private double ry;            // postion in y
    private double vx;            // velocity in x
    private double vy;            // velocity in y
    private boolean infected;     // true if infected
    private double radius;        // radius
    private double infectionRate; // infection transmission rate

    // constructor
    public PersonModel(double r, double rate) {
        // initialize position and velocity randomly
        rx = 1.8 * Math.random() - 0.9;
        ry = 1.8 * Math.random() - 0.9;
        vx = 0.01 * Math.random() - 0.005;
        vy = 0.01 * Math.random() - 0.005;

        infected = false; // individuals are healthy by default
        radius = r;
        infectionRate = rate;
    }

    // draw a ball to represent a person (gray for healthy, red for infected)
    public void draw() {
        Color color = new Color(10, 10, 10, 100); // gray
        if (infected) {
            color = new Color(255, 0, 0, 100); // red
        }

        StdDraw.setPenColor(color);
        StdDraw.filledCircle(rx, ry, radius);
    }

    // bounce off vertical wall by reflecting x-velocity
    private void bounceOffVerticalWall() {
        if (Math.abs(rx + vx) > 1.0 - radius)
            vx = -vx;
    }

    // bounce off horizontal wall by reflecting y-velocity
    private void bounceOffHorizontalWall() {
        if (Math.abs(ry + vy) > 1.0 - radius)
            vy = -vy;
    }

    // move the person position one step, but don't draw it
    public void move() {
        // bounce off wall(s) if you are near the border
        bounceOffHorizontalWall();
        bounceOffVerticalWall();

        // update position using unit change in time
        rx = rx + vx;
        ry = ry + vy;
    }

    // infect this person based on proximity to another person
    public void potentiallyInfect(PersonModel other) {
        // this person is at risk if they are near the other person
        double dx = rx - other.rx;
        double dy = ry - other.ry;
        boolean close = (Math.sqrt(dx * dx + dy * dy) < 2 * radius);
        boolean atRisk = other.infected && close;

        // potentially infect this person if they are at risk
        if (atRisk && Math.random() < infectionRate) {
            infected = true;
        }
    }

    // set the infected status of this person to true
    public void infect() {
        infected = true;
    }

    // test client to create and animate just 2 person models
    // this part is already complete.
    public static void main(String[] args) {
        // create and initialize two person models
        PersonModel p1 = new PersonModel(0.1, 1);
        PersonModel p2 = new PersonModel(0.1, 1);
        p1.infect(); // infect the first person

        // initialize standard drawing
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.enableDoubleBuffering();

        // main animation loop
        while (true) {
            StdDraw.clear(StdDraw.LIGHT_GRAY);
            p1.move();
            p2.move();
            p1.potentiallyInfect(p2);
            p2.potentiallyInfect(p1);
            p1.draw();
            p2.draw();
            StdDraw.show();
            StdDraw.pause(1);
        }
    }
}
