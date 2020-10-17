package se.su.dsv.inte.projektarbete;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class that tests the Modifier class
 */
public class ModifierTest {

    /**
     * Test that the constructor sets the correct values
     */
    @Test
    public void testConstructorSetCorrect() {
        String name = "A modifier";
        int cost = 10;

        Modifier m = new Modifier(name, cost) {
            @Override
            public int getValue() {
                return 0;
            }
        };

        assertEquals(name, m.getName());
        assertEquals(cost, m.getCost());
    }

    /**
     * Test constructor with null name
     */
    @Test
    public void testConstructorNullName() {
        String name = null;
        int cost = 10;

        assertThrows( IllegalArgumentException.class, () -> {
            Modifier m = new Modifier(name, cost) {
                @Override
                public int getValue() {
                    return 0;
                }
            };
        });
    }

    /**
     * Test constructor with empty name
     */
    @Test
    public void testConstructorEmptyName() {
        String name = "";
        int cost = 10;

        assertThrows( IllegalArgumentException.class, () -> {
            Modifier m = new Modifier(name, cost) {
                @Override
                public int getValue() {
                    return 0;
                }
            };
        });
    }

    /**
     * Test constructor with zero cost
     */
    @Test
    public void testConstructorZeroCost() {
        String name = "A modifier";
        int cost = 0;

        assertThrows( IllegalArgumentException.class, () -> {
            Modifier m = new Modifier(name, cost) {
                @Override
                public int getValue() {
                    return 0;
                }
            };
        });
    }

    /**
     * Test constructor with negative cost
     */
    @Test
    public void testConstructorNegativeCost() {
        String name = "A modifier";
        int cost = -1;

        assertThrows( IllegalArgumentException.class, () -> {
            Modifier m = new Modifier(name, cost) {
                @Override
                public int getValue() {
                    return 0;
                }
            };
        });
    }

    /**
     * Test equals method equal objects
     */
    @Test
    public void testEqualsMethodEqualObjects() {
        String name = "A modifier";
        int cost = 12;

        Modifier m1 = new Modifier(name, cost) {
            @Override
            public int getValue() {
                return 0;
            }
        };
        Modifier m2 = new Modifier(name, cost) {
            @Override
            public int getValue() {
                return 0;
            }
        };

        assertTrue(m1.equals(m2));
    }

    /**
     * Test equals method different name
     */
    @Test
    public void testEqualsMethodDifferentName() {
        String name1 = "A modifier";
        String name2 = "Another modifier";
        int cost = 12;

        Modifier m1 = new Modifier(name1, cost) {
            @Override
            public int getValue() {
                return 0;
            }
        };
        Modifier m2 = new Modifier(name2, cost) {
            @Override
            public int getValue() {
                return 0;
            }
        };

        assertFalse(m1.equals(m2));
    }

    /**
     * Test equals method different cost
     */
    @Test
    public void testEqualsMethodDifferentCost() {
        String name = "A modifier";
        int cost1 = 12;
        int cost2 = 14;

        Modifier m1 = new Modifier(name, cost1) {
            @Override
            public int getValue() {
                return 0;
            }
        };
        Modifier m2 = new Modifier(name, cost2) {
            @Override
            public int getValue() {
                return 0;
            }
        };

        assertFalse(m1.equals(m2));
    }

    /**
     * Test equals method different objects
     */
    @Test
    public void testEqualsMethodDifferentObjects() {
        String name = "A modifier";
        int cost = 12;

        Modifier m1 = new Modifier(name, cost) {
            @Override
            public int getValue() {
                return 0;
            }
        };

        assertFalse(m1.equals(new Object()));
    }

}