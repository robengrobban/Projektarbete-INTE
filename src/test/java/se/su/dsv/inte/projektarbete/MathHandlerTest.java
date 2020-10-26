package se.su.dsv.inte.projektarbete;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathHandlerTest {
    private static final int LOWER_VALUE= 3;
    private static final int HIGHER_VALUE = 5;
    private static final int NEGATIVE_VALUE = -1;

    private final MathHandler mathHandler = new MathHandler();

    @Test
    void randomIntLowerHavingHigherValueThanLowerThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> mathHandler.randomInt(HIGHER_VALUE, LOWER_VALUE));
    }

    @Test
    void randomIntLowerHavingTheSameValueAsHigherThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> mathHandler.randomInt(LOWER_VALUE, LOWER_VALUE));
    }

    @Test
    void negativeValueThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> mathHandler.randomInt(NEGATIVE_VALUE, LOWER_VALUE));
    }
}
