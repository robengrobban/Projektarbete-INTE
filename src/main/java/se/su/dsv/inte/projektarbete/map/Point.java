package se.su.dsv.inte.projektarbete.map;

import se.su.dsv.inte.projektarbete.map.Tiles.TileType;

public class Point {
    private final TileType type;
    private Character character;
    private InteractableObject interactableObject;
    private final int[] coordinates = new int[2];

    /**
     * @param type type value.
     */
    public Point(TileType type) {
        this.type = type;
    }

    /**
     * @param type type value.
     * @param interactableObject interactableObject value.
     */
    public Point(TileType type, InteractableObject interactableObject, int x, int y) {
        this.interactableObject = interactableObject;
        this.type = type;
        coordinates[0] = x;
        coordinates[1] = y;
    }

    /**
     * @return TileType, type
     */
    public TileType getType() {
        return type;
    }

    /**
     * @return interactableObject
     */
    public InteractableObject getInteractableObject() {
        if (interactableObject == null) {
            return null;
        }
        return interactableObject;
    }

    /**
     * Removes object be setting to null.
     */
    public void removeIntractableObject() {
        interactableObject = null;
    }

    /**
     * @return coordinates
     */
    public int[] getCoordinates() {
        return coordinates;
    }
}
