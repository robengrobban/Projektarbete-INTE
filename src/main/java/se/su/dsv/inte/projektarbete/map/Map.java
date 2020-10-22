package se.su.dsv.inte.projektarbete.map;

import se.su.dsv.inte.projektarbete.Item;
import se.su.dsv.inte.projektarbete.map.Tiles.Ground;
import se.su.dsv.inte.projektarbete.map.Tiles.Door;
import se.su.dsv.inte.projektarbete.map.Tiles.TileType;
import se.su.dsv.inte.projektarbete.characters.Character;

import java.util.ArrayList;
import java.util.Random;

public class Map {
    private static final int HIGHER_LIMIT = 10;
    private static final int LOWER_LIMIT = 4;

    //Public so they can be referred to in tests
    public static final int MIN_DOOR_AMOUNT = 1;
    public static final int MAX_DOOR_AMOUNT = 4;
    public static final int MIN_INTERACTABLEOBJECT_AMOUNT = 0;
    public static final int MAX_INTERACTABLEOBJECT_AMOUNT = 2;

    private int doorAmount = 0;
    private int objectAmount = 0;

    protected final ArrayList<ArrayList<Point>> map = new ArrayList<>(); //Protected for testing.

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
                list.add(new Point(generateTile(j, i, x, y), objectGen(j, i, x, y), j, i));
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
    private TileType generateTile(int currentX, int currentY, int maxX, int maxY) {
        boolean door = false;

        //20% chance of door
        if (randomInt(0, 5) == 4) {
            door = true;
        }

        if ( (isEdgeTile(currentX, currentY, maxX, maxY) && door) && doorAmount != MAX_DOOR_AMOUNT|| isLastEdgeTile(currentX, currentY, maxX, maxY) && doorAmount < MIN_DOOR_AMOUNT) {
            doorAmount++;
            return new Door();
        }

        else {
            return new Ground();
        }
    }

    /**
     * @param currentX int, of point.
     * @param currentY int, of point.
     * @param maxX int, max value.
     * @param maxY int, max value.
     * @return InteractableObject, the object to be placed if decided.
     */
    private InteractableObject objectGen(int currentX, int currentY, int maxX, int maxY) {
        boolean chest = false;
        if (randomInt(0, 10) == 9) {
            chest = true;
        }

        if ( (notEdgeTile(currentX, currentY, maxX, maxY) && chest) && objectAmount != MAX_INTERACTABLEOBJECT_AMOUNT) {
            objectAmount++;
            Item[] items = new Item[0];
            return new Chest(items, "desc");
        }
        return null;
    }

    private boolean isEdgeTile(int currentX, int currentY, int maxX, int maxY) {
        return currentX == 0 || currentY == 0 || currentX + 1 == maxX || currentY + 1 == maxY;
    }

    private boolean notEdgeTile(int currentX, int currentY, int maxX, int maxY) {
        return !isEdgeTile(currentX, currentY, maxX, maxY);
    }

    private boolean isLastEdgeTile(int currentX, int currentY, int maxX, int maxY) {
        return currentX == maxX - 1 && currentY == maxY - 1;
    }

    public int getYSize() {
        return map.size();
    }

    public int getXSize() {
        return map.get(1).size();
    }

    public int getDoorAmount() {
        return doorAmount;
    }

    public int getInteractableObjectAmount() {
        return objectAmount;
    }

    /**
     * @param character Character to place.
     * @param x coordinate
     * @param y coordinate
     */
    public void placeCharacter(Character character, int x, int y) {
        int[] coordinates = { x, y };
        character.setPoint(findPoint(coordinates));
    }

    /**
     * @param coordinates coordinates for desired point.
     * @return Point, the found point.
     * @throws IllegalStateException, if specified point does not exist.
     */
    private Point findPoint(int[] coordinates) {
        for (ArrayList<Point> list : map) {
            for (Point point : list) {
                if (point.getCoordinates()[0] == coordinates[0] && point.getCoordinates()[1] == coordinates[1]) {
                    return point;
                }
            }
        }
        throw new IllegalStateException("No point found");
    }
}
