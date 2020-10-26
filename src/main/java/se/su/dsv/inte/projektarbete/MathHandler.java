package se.su.dsv.inte.projektarbete;

import java.util.Random;

/**
 * Handles math calculations.
 */
public class MathHandler {
    /**
     * @param lower lowest allowed number.
     * @param higher highest allowed number.
     * @return int, random number between lower and higher.
     * @throws IllegalArgumentException either if lower is higher than higher or if lower is lower than 0.
     */
    public int randomInt(int lower, int higher) {
        if (lower >= higher)
            throw new IllegalArgumentException("Lower must be lower than higher and not of same value");
        if (lower < 0)
            throw new IllegalArgumentException("Must be positive integers");

        return new Random().nextInt(higher - lower) + lower;
    }

    /**
     * @param x1 x value of point of first point.
     * @param y1 y value of point of first point.
     * @param x2 x value of point of second point.
     * @param y2 y value of point of second point.
     * @return int, the length of the hypotenuse between the points.
     */
    public int pythagoras(int x1, int y1, int x2, int y2) {
        double a = Math.pow(Math.abs(y1 - y2), 2.0);
        double b = Math.pow(Math.abs(x1 - x2), 2.0);
        return (int) Math.sqrt(a + b);
    }
}
