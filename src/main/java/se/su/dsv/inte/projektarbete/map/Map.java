package se.su.dsv.inte.projektarbete.map;

import se.su.dsv.inte.projektarbete.Item;
import se.su.dsv.inte.projektarbete.MathHandler;
import se.su.dsv.inte.projektarbete.map.Tiles.Ground;
import se.su.dsv.inte.projektarbete.map.Tiles.TileType;
import se.su.dsv.inte.projektarbete.characters.Character;
import se.su.dsv.inte.projektarbete.map.Tiles.Toxic;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a map which is a 2D list of points and handles generation and interaction.
 */
public class Map {

    /**
     * Used for random numbers.
     */
    private static final MathHandler MATH_HANDLER = new MathHandler();
    /**
     * Min amount of doors a map may generate.
     */
    private static final int MIN_DOOR_AMOUNT = 1;

    /**
     * Max amount of doors a map may generate.
     */
    private static final int MAX_DOOR_AMOUNT = 4;

    /**
     * Min amount of interactable objects a map may generate.
     */
    private static final int MIN_CHEST_AMOUNT = 0;

    /**
     * Max amount of interactable objects a map may generate.
     */
    private static final int MAX_CHEST_AMOUNT = 2;

    /**
     * The default max size of a map (both x and y values).
     */
    private static final int HIGHER_MAP_SIZE_LIMIT = 10;
    /**
     * The default lower size of a map (both x and y values).
     */
    private static final int LOWER_MAP_SIZE_LIMIT = 4;

    //Generation odds:

    /**
     * Possible numbers.
     */
    private static final int DOOR_GENERATION_ODDS = 5;

    /**
     * Possible numbers.
     */
    private static final int CHEST_GENERATION_ODDS = 10;

    /**
     * Possible numbers.
     */
    private static final int TOXIC_GENERATION_ODDS = 20;

    /**
     * Amount of doors.
     */
    protected int doorAmount = 0;

    /**
     * Amount of chests.
     */
    private int chestAmount = 0;

    /**
     * 2D list of points.
     */
    protected final List<List<MapPoint>> map = new ArrayList<>(); //Protected for testing.

    /**
     * List of all object in map.
     */
    protected final List<InteractableObject> interactableObjects = new ArrayList<>(); //protected for testing.

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
     * @throws IllegalArgumentException if either xSize or ySize are <= 0.
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
     * @throws IllegalArgumentException if either xMin or yMin are <= 0, larger or equal to the max values.
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
     * @return min amount of doors.
     */
    public static int getMinDoorAmount() {
        return MIN_DOOR_AMOUNT;
    }

    /**
     * @return max amount of doors.
     */
    public static int getMaxDoorAmount() {
        return MAX_DOOR_AMOUNT;
    }

    /**
     * @return min amount of interactable objects.
     */
    public static int getMinChestAmount() {
        return MIN_CHEST_AMOUNT;
    }

    /**
     * @return max amount of interactable objects.
     */
    public static int getMaxChestAmount() {
        return MAX_CHEST_AMOUNT;
    }

    /**
     * @return the default higher limit of map size.
     */
    public static int getHigherMapSizeLimit() {
        return HIGHER_MAP_SIZE_LIMIT;
    }

    /**
     * @return the default lower limit of map size.
     */
    public static int getLowerMapSizeLimit() {
        return LOWER_MAP_SIZE_LIMIT;
    }

    /**
     * @return y size of map.
     */
    public int getYSize() {
        return map.size();
    }

    /**
     * @return x size of map.
     */
    public int getXSize() {
        return map.get(1).size();
    }

    /**
     * @return amount of doors.
     */
    public int getDoorAmount() {
        return doorAmount;
    }

    /**
     * @return amount of interactable objects.
     */
    public int getChestAmount() {
        return chestAmount;
    }

    /**
     * @param character Character to place.
     * @param x coordinate.
     * @param y coordinate.
     * @throws NullPointerException if specified Character is null.
     */
    public void placeCharacter(Character character, int x, int y) {
        if (character == null)
            throw new NullPointerException("Character may not be null");

        int[] coordinates = { x, y };
        character.setPoint(findPoint(coordinates));
    }

    /**
     * Populates map randomly according to the lower and higher limits.
     */
    private void populateMap() {
        int x = MATH_HANDLER.randomInt(LOWER_MAP_SIZE_LIMIT, HIGHER_MAP_SIZE_LIMIT);
        int y = MATH_HANDLER.randomInt(LOWER_MAP_SIZE_LIMIT, HIGHER_MAP_SIZE_LIMIT);

        addRandomTile(x, y);
    }

    /**
     * @param x size of map.
     * @param y size of map.
     */
    private void populateMap(int x, int y) {
        addRandomTile(x, y);
    }

    /**
     * @param xMin min size of x.
     * @param xMax max size of x.
     * @param yMin min size of y.
     * @param yMax max size of y.
     */
    private void populateMap(int xMin, int xMax, int yMin, int yMax) {
        int x = MATH_HANDLER.randomInt(xMin, xMax + 1);
        int y = MATH_HANDLER.randomInt(yMin, yMax + 1);

        addRandomTile(x, y);
    }

    /**
     * Fills every point in map with a TileType.
     * @param maxX size of maxX axis in list.
     * @param maxY size of maxY axis in list.
     */
    private void addRandomTile(int maxX, int maxY) {
        for (int currentY = 0; currentY < maxY; currentY++) {
            List<MapPoint> yRow = new ArrayList<>();
            for (int currentX = 0; currentX < maxX; currentX++) {
                MapPoint mapPoint = new MapPoint(generateTile(), currentX, currentY);

                InteractableObject interactableObject = generateObject(currentX, currentY, maxX, maxY, mapPoint);

                if (interactableObject != null) {
                    interactableObjects.add(interactableObject);
                }

                yRow.add(mapPoint);

            }
            map.add(currentY, yRow);
        }
    }

    /**
     * @return type of tile.
     */
    private TileType generateTile() {
        if (objectShouldSpawn(TOXIC_GENERATION_ODDS)) {
            return new Toxic();
        }
        return new Ground();
    }

    /**
     * @param currentX value of current x in creation loop.
     * @param currentY value of current y in creation loop.
     * @param maxX max x value of created map.
     * @param maxY max y value of created map.
     * @param mapPoint the current point.
     * @return the InteractableObject generated.
     */
    protected InteractableObject generateObject(int currentX, int currentY, int maxX, int maxY, MapPoint mapPoint) {
        if (isLastEdgeTile(currentX, currentY, maxX, maxY) && doorAmount < MIN_DOOR_AMOUNT) {
            doorAmount++;
            return new Door("a door", mapPoint);
        }

        else if (doorAllowed(currentX, currentY, maxX, maxY) && objectShouldSpawn(DOOR_GENERATION_ODDS)) {
            doorAmount++;
            return new Door("a door", mapPoint);
        }
        else if (chestAllowed() && objectShouldSpawn(CHEST_GENERATION_ODDS)) {
            chestAmount++;
            return new Chest(new Item[0], "desc", mapPoint);
        }

        return null;
    }

    /**
     * @param currentX value of current x in creation loop.
     * @param currentY value of current y in creation loop.
     * @param maxX max x value of created map.
     * @param maxY max y value of created map.
     * @return whether a door is allowed to spawn.
     */
    private boolean doorAllowed(int currentX, int currentY, int maxX, int maxY) {
        return isEdgeTile(currentX, currentY, maxX, maxY) && doorAmount != MAX_DOOR_AMOUNT;
    }

    /**
     * @return whether a chest i allowed to spawn.
     */
    private boolean chestAllowed() {
        return chestAmount != MAX_CHEST_AMOUNT;
    }

    /**
     * @param maxNumber max number generates, determines the odds.
     * @return whether or not an object (or tile) should spawn.
     */
    private boolean objectShouldSpawn(int maxNumber) {
        int x = MATH_HANDLER.randomInt(0, maxNumber);
        return x == maxNumber - 1;
    }

    /**
     * @param currentX the x value being checked.
     * @param currentY the y value being checked.
     * @param maxX the max value of x.
     * @param maxY the max value of y.
     * @return whether or not current point is edge tile or not.
     */
    private boolean isEdgeTile(int currentX, int currentY, int maxX, int maxY) {
        return currentX == 0 || currentY == 0 || currentX + 1 == maxX || currentY + 1 == maxY;
    }

    /**
     * @param currentX the x value being checked.
     * @param currentY the y value being checked.
     * @param maxX the max value of x.
     * @param maxY the max value of y.
     * @return whether or not current point is edge tile or not.
     */
    private boolean isLastEdgeTile(int currentX, int currentY, int maxX, int maxY) {
        return (currentX == maxX - 1 && currentY == maxY - 1) || (currentX == maxX - 1 && maxY == 0);
    }

    /**
     * @param coordinates coordinates for desired point.
     * @return Point, the found point.
     * @throws IllegalStateException, if specified point does not exist.
     */
    private MapPoint findPoint(int[] coordinates) {
        MapPoint mapPoint;

        try {
            mapPoint = map.get(coordinates[1]).get(coordinates[0]);
        }
        catch (IndexOutOfBoundsException e) {
            throw new IllegalStateException("No point found");
        }
        return mapPoint;
    }
}
