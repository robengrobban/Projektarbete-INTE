package se.su.dsv.inte.projektarbete.map;

import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.map.Tiles.Ground;

import static org.junit.jupiter.api.Assertions.*;

public class InteractableObjectTest {
    private final static String VALID_DESCRIPTION = "desc";
    private final static String INVALID_EMPTY_DESCRIPTION = "";
    private final static String INVALID_NULL_DESCRIPTION = null;

    /**
     * ConcreteImplementation of InteractableObject testing it's specifics.
     */
    private static class ConcreteImplementation extends InteractableObject {
        public ConcreteImplementation(String description, MapPoint mapPoint) {
            super(description, mapPoint);
        }
    }

    private static class MockMapPoint extends MapPoint {
        public MockMapPoint() {
            super(new Ground(), 0,0);
        }
    }

    /**
     * Checks for correct return.
     */
    @Test
    void objectPlacedOnCorrectPoint() {
        MapPoint mapPoint = new MockMapPoint();
        ConcreteImplementation concreteImplementation = new ConcreteImplementation(VALID_DESCRIPTION, mapPoint);
        assertEquals(mapPoint, concreteImplementation.getPoint());
    }

    /**
     * Checks tht any attempt to set mapPoint to null throws exception.
     */
    @Test
    void nullMapPointThrowsException() {
        assertThrows(NullPointerException.class, () -> {
            ConcreteImplementation concreteImplementation = new ConcreteImplementation(VALID_DESCRIPTION, null);
        });
    }

    /**
     * Checks that correct description is returned.
     */
    @Test
    void descriptionReturned() {
        ConcreteImplementation concreteImplementation = new ConcreteImplementation(VALID_DESCRIPTION, new MockMapPoint());
        assertEquals(VALID_DESCRIPTION, concreteImplementation.getDescription());
    }

    /**
     * Checks that an empty description throws exception.
     */
    @Test
    void emptyDescriptionThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
           ConcreteImplementation concreteImplementation = new ConcreteImplementation(INVALID_EMPTY_DESCRIPTION, new MockMapPoint());
        });
    }

    /**
     * Checks that a null description throws exception.
     */
    @Test
    void nullDescriptionThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            ConcreteImplementation concreteImplementation = new ConcreteImplementation(INVALID_NULL_DESCRIPTION, new MockMapPoint());
        });
    }
}
