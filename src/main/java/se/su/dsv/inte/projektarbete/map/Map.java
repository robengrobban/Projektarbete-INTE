package se.su.dsv.inte.projektarbete.map;

import se.su.dsv.inte.projektarbete.map.Tiles.Ground;
import se.su.dsv.inte.projektarbete.map.Tiles.TileType;

import java.util.ArrayList;
import java.util.Random;

public class Map {
    private static final int HIGHER_LIMIT = 10;
    private static final int LOWER_LIMIT = 4;

    private final ArrayList<ArrayList<Point>> map = new ArrayList<>();

    /**
     * Creates a map with random x and y value by calling populateMap()
     */
    public Map() {
        populateMap();
    }

    /**
     * Creates a map with specified x and y values.
     * @param xSize Desired x size of map.
     * @param ySize Desired y size of map.
     * @throws IllegalArgumentException if either xSize or ySize are < 0.
     */
    public Map(int xSize, int ySize) {
        if (xSize <= 0 || ySize <= 0) {
            throw new IllegalArgumentException("Specified x or y must have a value of at least 1");
        }
        else {
            populateMap(xSize, ySize);
        }
    }

    /**
     * Creates a map of random size with the specified limits in regard.
     * @param xMin Minimum size of x.
     * @param xMax Maximum size of x.
     * @param yMin Minimum size of y.
     * @param yMax Maximum size of y.
     * @throws IllegalArgumentException if either xMin or yMin are < 0, larger or equal to the max values.
     */
    public Map(int xMin, int xMax, int yMin, int yMax) {
        if (xMin <= 0 || yMin <= 0) {
            throw new IllegalArgumentException("Specified xMin or yMin must have a value of at least 1");
        }
        else if (xMin >= xMax || yMin >= yMax) {
            throw new IllegalArgumentException("Min may not be larger than Max or the same value");
        }
        else {
            populateMap(xMin, xMax, yMin, yMax);
        }
    }

    /**
     * Populates map randomly according to the lower and higher limits.
     */
    private void populateMap() {
        int x = randomInt(LOWER_LIMIT, HIGHER_LIMIT);
        int y = randomInt(LOWER_LIMIT, HIGHER_LIMIT);

        addRandomTile(x, y);
    }

    /**
     * Populates map according to specified x and y values.
     */
    private void populateMap(int x, int y) {
        addRandomTile(x, y);
    }

    /**
     * Populates map randomly according to the lower and higher limits.
     */
    private void populateMap(int xMin, int xMax, int yMin, int yMax) {
        int x = randomInt(xMin, xMax + 1);
        int y = randomInt(yMin, yMax);

        addRandomTile(x, y);
    }

    /**
     * Fills every point in map with a TileType.
     * @param x x size of list.
     * @param y y size of list.
     */
    private void addRandomTile(int x, int y) {
        for (int i = 0; i < y; i++) {
            ArrayList<Point> list = new ArrayList<>();
            for (int j = 0; j < x; j++) {
                list.add(new Point(generateTile()));
            }
            map.add(i, list);
        }
    }

    /**
     * @param lower lowest allowed number.
     * @param higher highest allowed number.
     * @return int, random number between lower and higher.
     */
    private int randomInt(int lower, int higher) {
        Random r = new Random();
        return r.nextInt(higher - lower) + lower;
    }

    /**
     * Generates a tile type to be placed on a point.
     * @return TileType, the type of tile that gets selected.
     */
    //TODO
    private TileType generateTile() {
        return new Ground();
    }

    public int getYSize() {
        return map.size();
    }

    public int getXSize() {
        return map.get(1).size();
    }
}
