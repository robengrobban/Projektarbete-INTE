package se.su.dsv.inte.projektarbete.map;

/**
 * Representing an object that a Character may interact with on a point.
 */
public abstract class InteractableObject {

    /**
     * Description of object.
     */
    private final String description;

    /**
     * The point it is located on.
     */
    private final MapPoint mapPoint;

    /**
     * @param description description.
     * @param mapPoint the point on the map of the object.
     * @throws IllegalArgumentException, if description is either empty or null.
     * @throws NullPointerException, if mappoint is null.
     */
    public InteractableObject(String description, MapPoint mapPoint) {
        if (description == null || description.trim().isEmpty())
            throw new IllegalArgumentException("Object must have description");

        if (mapPoint == null)
            throw new NullPointerException("MapPoint may not be null");
        this.mapPoint = mapPoint;
        this.description = description;
    }

    /**
     * @return description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return point.
     */
    public MapPoint getPoint() {
        return mapPoint;
    }
}
