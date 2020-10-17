package se.su.dsv.inte.projektarbete;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class that test the item abstract class
 */
public class ItemTest {

    /**
     * Test if the constructor sets the correct values
     */
    @Test
    public void testConstructorSetValuesCorrect() {
        String name = "An item";
        String desc = "This is an amazing item";

        Item item = new Item(name, desc) {
            @Override
            public int getValue() {
                return 0;
            }
        };

        assertEquals(name, item.getName());
        assertEquals(desc, item.getDescription());
    }

    /**
     * Test the constructors handling of a null name
     */
    @Test
    public void testConstructorNameNull() {
        String name = null;
        String desc = "This is an amazing item";

        assertThrows( IllegalArgumentException.class, () -> {
            Item item = new Item(name, desc) {
                @Override
                public int getValue() {
                    return 0;
                }
            };
        });
    }

    /**
     * Test the constructors handling of a empty name
     */
    @Test
    public void testConstructorNameEmpty() {
        String name = "";
        String desc = "This is an amazing item";

        assertThrows( IllegalArgumentException.class, () -> {
            Item item = new Item(name, desc) {
                @Override
                public int getValue() {
                    return 0;
                }
            };
        });
    }

    /**
     * Test the constructors handling of a null description
     */
    @Test
    public void testConstructorDescriptionNull() {
        String name = "An item";
        String desc = null;

        assertThrows( IllegalArgumentException.class, () -> {
            Item item = new Item(name, desc) {
                @Override
                public int getValue() {
                    return 0;
                }
            };
        });
    }

    /**
     * Test the constructors handling of a empty description
     */
    @Test
    public void testConstructorDescriptionEmpty() {
        String name = "An item";
        String desc = "";

        assertThrows( IllegalArgumentException.class, () -> {
            Item item = new Item(name, desc) {
                @Override
                public int getValue() {
                    return 0;
                }
            };
        });
    }

    /**
     * Test if the equals methods works
     */
    @Test
    public void testEqualsMethod() {
        String name = "An item";
        String desc = "This is an amazing item";

        Item item1 = new Item(name, desc) {
            @Override
            public int getValue() {
                return 0;
            }
        };

        Item item2 = new Item(name, desc) {
            @Override
            public int getValue() {
                return 0;
            }
        };

        assertTrue(item1.equals(item2));
    }

    /**
     * Test if the equals methods works different names
     */
    @Test
    public void testEqualsMethodDifferentName() {
        String name1 = "An item";
        String name2 = "Another item";
        String desc = "This is an amazing item";

        Item item1 = new Item(name1, desc) {
            @Override
            public int getValue() {
                return 0;
            }
        };

        Item item2 = new Item(name2, desc) {
            @Override
            public int getValue() {
                return 0;
            }
        };

        assertFalse(item1.equals(item2));
    }

    /**
     * Test if the equals methods works different description
     */
    @Test
    public void testEqualsMethodDifferentDescription() {
        String name = "An item";
        String desc1 = "This is an amazing item";
        String desc2 = "This is not an amazing item";

        Item item1 = new Item(name, desc1) {
            @Override
            public int getValue() {
                return 0;
            }
        };

        Item item2 = new Item(name, desc2) {
            @Override
            public int getValue() {
                return 0;
            }
        };

        assertFalse(item1.equals(item2));
    }

    /**
     * Test if the equals methods works with two different objects
     */
    @Test
    public void testEqualsMethodDifferentObjects() {
        String name = "An item";
        String desc = "This is an amazing item";

        Item item = new Item(name, desc) {
            @Override
            public int getValue() {
                return 0;
            }
        };

        assertFalse(item.equals(new Object()));
    }

}