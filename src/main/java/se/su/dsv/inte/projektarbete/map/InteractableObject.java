package se.su.dsv.inte.projektarbete.map;

public abstract class InteractableObject {
    private final String description;

    public InteractableObject(String description) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Object must have description");
        }
        this.description = description;
    }

    public String inspect() {
        return description;
    }
}
