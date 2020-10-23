package se.su.dsv.inte.projektarbete.map;

import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.map.Tiles.Ground;
import se.su.dsv.inte.projektarbete.map.Tiles.TileType;

import static org.junit.jupiter.api.Assertions.*;

public class InteractableObjectTest {
    private final static String VALID_DESCRIPTION = "desc";
    private final static String INVALID_EMPTY_DESCRIPTION = "";
    private final static String INVALID_NULL_DESCRIPTION = null;

    /**
     * ConcreteImplementation of InteractableObject testing it's specifics.
     */
    private static class ConcreteImplementation extends InteractableObject {
        public ConcreteImplementation(String description) {
            super(description);
        }
    }

    private static class MockPoint extends Point {
        public MockPoint() {
            super(new Ground(), 0,0);
        }
    }

    /**
     * Checks for correct return.
     */
    @Test
    void objectPlacedOnCorrectPoint() {
        ConcreteImplementation concreteImplementation = new ConcreteImplementation(VALID_DESCRIPTION);
        Point point = new MockPoint();
        concreteImplementation.setPoint(point);
        assertEquals(point, concreteImplementation.getPoint());
    }

    /**
     * Checks that correct description is returned.
     */
    @Test
    void descriptionReturned() {
        ConcreteImplementation concreteImplementation = new ConcreteImplementation(VALID_DESCRIPTION);
        assertEquals(VALID_DESCRIPTION, concreteImplementation.inspect());
    }

    /**
     * Checks that an empty description throws exception.
     */
    @Test
    void emptyDescriptionThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
           ConcreteImplementation concreteImplementation = new ConcreteImplementation(INVALID_EMPTY_DESCRIPTION);
        });
    }

    /**
     * Checks that a null description throws exception.
     */
    @Test
    void nullDescriptionThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            ConcreteImplementation concreteImplementation = new ConcreteImplementation(INVALID_NULL_DESCRIPTION);
        });
    }
}
