/* *****************************************************************************
 *
 *  Description:  Object-oriented model of a person, to be used in an
 *                infection simulation.
 *
 * Example:
 * > java-introcs PersonModel
 *
 **************************************************************************** */

public class PersonModel {
    // declare instance variables
    ___________________________;  // position in x
    ___________________________;  // postion in y
    ___________________________;  // velocity in x
    ___________________________;  // velocity in y
    ___________________________;  // true if infected
    ___________________________;  // radius
    ___________________________;  // infection transmission rate

    // constructor
    public PersonModel(double r, double rate) {
        // initialize position and velocity randomly
        _________ = 1.8 * Math.random() - 0.9;
        _________ = 1.8 * Math.random() - 0.9;
        _________ = 0.01 * Math.random() - 0.005;
        _________ = 0.01 * Math.random() - 0.005;

        _________ = __________; // individuals are healthy by default
        radius = ________;
        infectionRate = ________;
    }

    // draw a ball to represent a person (gray for healthy, red for infected)
    public void draw() {


    }

    // bounce off vertical wall by reflecting x-velocity
    private void bounceOffVerticalWall() {


    }

    // bounce off horizontal wall by reflecting y-velocity
    private void bounceOffHorizontalWall() {


    }

    // move the person position one step, but don't draw it
    public void move() {
        // bounce off wall(s) if you are near the border


        // update position using unit change in time


    }

    // infect this person based on proximity to another person
    public void potentiallyInfect(PersonModel other) {
        // this person is at risk if they are near the other person
        double dx = rx - other.rx;
        double dy = ry - other.ry;
        boolean close = __________________________________;
        boolean atRisk = other.infected && close;

        // potentially infect this person if they are at risk
        if (________________________________________) {
            __________________________________;
        }
    }

    // set the infected status of this person to true
    public void infect() {

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
