package se.su.dsv.inte.projektarbete.map;

public abstract class InteractableObject {
    private final String description;
    private Point point;
    /**
     * @param description description.
     * @throws IllegalArgumentException, if description either empty or null.
     */
    public InteractableObject(String description) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Object must have description");
        }
        this.description = description;
    }

    /**
     * @return description.
     */
    public String inspect() {
        return description;
    }

    /**
     * @return point.
     */
    public Point getPoint() {
        return point;
    }

    /**
     * @param point point value.
     */
    public void setPoint(Point point) {
        this.point = point;
    }
}
