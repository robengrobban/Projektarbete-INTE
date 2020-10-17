package se.su.dsv.inte.projektarbete.map;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InteractableObjectTest {
    private final static String VALID_DESCRIPTION = "desc";
    private final static String INVALID_EMPTY_DESCRIPTION = "";
    private final static String INVALID_NULL_DESCRIPTION = null;

    private static class ConcreteImplementation extends InteractableObject {
        public ConcreteImplementation(String description) {
            super(description);
        }
    }

    @Test
    void descriptionReturned() {
        ConcreteImplementation concreteImplementation = new ConcreteImplementation(VALID_DESCRIPTION);
        assertEquals(VALID_DESCRIPTION, concreteImplementation.inspect());
    }

    @Test
    void emptyDescriptionThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
           ConcreteImplementation concreteImplementation = new ConcreteImplementation(INVALID_EMPTY_DESCRIPTION);
        });
    }

    @Test
    void nullDescriptionThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            ConcreteImplementation concreteImplementation = new ConcreteImplementation(INVALID_NULL_DESCRIPTION);
        });
    }
}
