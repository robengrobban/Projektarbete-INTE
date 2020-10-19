package se.su.dsv.inte.projektarbete.armour;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class to test the Armour class
 */
public class ArmourTest {

    /**
     * Test if the constructor sets the maximum constructor correctly
     */
    @Test
    public void testConstructorSetValuesCorrectlyMax() {
        String name = "Chest plate of something";
        String desc = "This will not help you...";

        ArmourType type = ArmourType.HEAVY;
        int baseDefence = 10;
        int durability = 100;

        ArmourModifier modifier = new SimpleDefenceModifier("asd", 12,14);

        Armour a = new Armour(name, desc, type, baseDefence, durability, modifier);

        assertEquals(name, a.getName());
        assertEquals(desc, a.getDescription());
        assertEquals(ArmourType.valueOf(type.name()), a.getType());
        assertEquals(baseDefence, a.getBaseDefence());
        assertEquals(durability, a.getDurability());
        assertEquals(new SimpleDefenceModifier("asd", 12, 14), a.getModifier());
    }

    /**
     * Test if the constructor sets the minimal constructor correctly
     */
    @Test
    public void testConstructorSetValuesCorrectlyMin() {
        String name = "Chest plate of something";
        String desc = "This will not help you...";

        ArmourType type = ArmourType.HEAVY;
        int baseDefence = 10;

        Armour a = new Armour(name, desc, type, baseDefence);

        assertEquals(name, a.getName());
        assertEquals(desc, a.getDescription());
        assertEquals(ArmourType.valueOf(type.name()), a.getType());
        assertEquals(baseDefence, a.getBaseDefence());
        assertEquals(100, a.getDurability());
        assertEquals(null, a.getModifier());
    }

    /**
     * Test if the constructor sets the minimal constructor correctly with durability
     */
    @Test
    public void testConstructorSetValuesCorrectlyMinWithDurability() {
        String name = "Chest plate of something";
        String desc = "This will not help you...";

        ArmourType type = ArmourType.HEAVY;
        int baseDefence = 10;
        int durability = 100;


        Armour a = new Armour(name, desc, type, baseDefence, durability);

        assertEquals(name, a.getName());
        assertEquals(desc, a.getDescription());
        assertEquals(ArmourType.valueOf(type.name()), a.getType());
        assertEquals(baseDefence, a.getBaseDefence());
        assertEquals(durability, a.getDurability());
        assertEquals(null, a.getModifier());
    }

    /**
     * Test if the constructor sets the minimal constructor correctly with a modifier
     */
    @Test
    public void testConstructorSetValuesCorrectlyMinWithModifier() {
        String name = "Chest plate of something";
        String desc = "This will not help you...";

        ArmourType type = ArmourType.HEAVY;
        int baseDefence = 10;

        ArmourModifier modifier = new SimpleDefenceModifier("asd", 12,14);

        Armour a = new Armour(name, desc, type, baseDefence, modifier);

        assertEquals(name, a.getName());
        assertEquals(desc, a.getDescription());
        assertEquals(ArmourType.valueOf(type.name()), a.getType());
        assertEquals(baseDefence, a.getBaseDefence());
        assertEquals(100, a.getDurability());
        assertEquals(new SimpleDefenceModifier("asd", 12, 14), a.getModifier());
    }

    /**
     * Test constructor null name
     */
    @Test
    public void testConstructorNullName() {
        String name = null;
        String desc = "This helmet will cover your ears...";

        ArmourType type = ArmourType.LIGHT;
        int baseDefence = 10;

        assertThrows( IllegalArgumentException.class, () -> {
            new Armour(name, desc, type, baseDefence);
        });
    }

    /**
     * Test constructor empty name
     */
    @Test
    public void testConstructorEmptyName() {
        String name = "";
        String desc = "This helmet will cover your ears...";

        ArmourType type = ArmourType.LIGHT;
        int baseDefence = 10;

        assertThrows( IllegalArgumentException.class, () -> {
            new Armour(name, desc, type, baseDefence);
        });
    }

    /**
     * Test constructor null description
     */
    @Test
    public void testConstructorNullDescription() {
        String name = "Helmet";
        String desc = null;

        ArmourType type = ArmourType.LIGHT;
        int baseDefence = 10;

        assertThrows( IllegalArgumentException.class, () -> {
            new Armour(name, desc, type, baseDefence);
        });
    }

    /**
     * Test constructor empty name
     */
    @Test
    public void testConstructorEmptyDescription() {
        String name = "Helmet";
        String desc = "";

        ArmourType type = ArmourType.LIGHT;
        int baseDefence = 10;

        assertThrows( IllegalArgumentException.class, () -> {
            new Armour(name, desc, type, baseDefence);
        });
    }

    /**
     * Test constructor zero base defence
     */
    @Test
    public void testConstructorZeroBaseDefence() {
        String name = "Helmet";
        String desc = "This helmet will cover your ears...";

        ArmourType type = ArmourType.LIGHT;
        int baseDefence = 0;

        assertThrows( IllegalArgumentException.class, () -> {
            new Armour(name, desc, type, baseDefence);
        });
    }

    /**
     * Test constructor negative base defence
     */
    @Test
    public void testConstructorNegativeBaseDefence() {
        String name = "Helmet";
        String desc = "This helmet will cover your ears...";

        ArmourType type = ArmourType.LIGHT;
        int baseDefence = -1;

        assertThrows( IllegalArgumentException.class, () -> {
            new Armour(name, desc, type, baseDefence);
        });
    }

    /**
     * Test constructor negative durability
     */
    @Test
    public void testConstructorNegativeDurability() {
        String name = "Helmet";
        String desc = "This helmet will cover your ears...";

        ArmourType type = ArmourType.LIGHT;
        int baseDefence = 10;

        int durability = -1;

        assertThrows( IllegalArgumentException.class, () -> {
            new Armour(name, desc, type, baseDefence, durability);
        });
    }

    /**
     * Test constructor over one hundred durability
     */
    @Test
    public void testConstructorOverOneHundredDurability() {
        String name = "Helmet";
        String desc = "This helmet will cover your ears...";

        ArmourType type = ArmourType.LIGHT;
        int baseDefence = 10;

        int durability = 101;

        assertThrows( IllegalArgumentException.class, () -> {
            new Armour(name, desc, type, baseDefence, durability);
        });
    }

    /**
     * Test the equals method with all correct values
     */
    @Test
    public void testEqualsMethodAllValuesCorrect() {
        String name = "We are equals";
        String desc = "Yes we are";

        ArmourType type = ArmourType.LIGHT;
        int baseDefence = 12;
        int durability = 40;

        ArmourModifier modifier1 = new SimpleDefenceModifier("MOD", 14,15);
        ArmourModifier modifier2 = new SimpleDefenceModifier("MOD", 14, 15);

        Armour a1 = new Armour(name, desc, type, baseDefence, durability, modifier1);
        Armour a2 = new Armour(name, desc, type, baseDefence, durability, modifier2);

        assertTrue(a1.equals(a2));
    }

    /**
     * Test the equals method with different name
     */
    @Test
    public void testEqualsMethodDifferentName() {
        String name1 = "We are not equals";
        String name2 = "No we are not!";
        String desc = "Yes we are";

        ArmourType type = ArmourType.LIGHT;
        int baseDefence = 12;
        int durability = 40;

        ArmourModifier modifier1 = new SimpleDefenceModifier("MOD", 14,15);
        ArmourModifier modifier2 = new SimpleDefenceModifier("MOD", 14, 15);

        Armour a1 = new Armour(name1, desc, type, baseDefence, durability, modifier1);
        Armour a2 = new Armour(name2, desc, type, baseDefence, durability, modifier2);

        assertFalse(a1.equals(a2));
    }

    /**
     * Test the equals method with different descriptions
     */
    @Test
    public void testEqualsMethodDifferentDescription() {
        String name = "We are equals";
        String desc1 = "No we are NOT!";
        String desc2 = "Absolutely not!";

        ArmourType type = ArmourType.LIGHT;
        int baseDefence = 12;
        int durability = 40;

        ArmourModifier modifier1 = new SimpleDefenceModifier("MOD", 14,15);
        ArmourModifier modifier2 = new SimpleDefenceModifier("MOD", 14, 15);

        Armour a1 = new Armour(name, desc1, type, baseDefence, durability, modifier1);
        Armour a2 = new Armour(name, desc2, type, baseDefence, durability, modifier2);

        assertFalse(a1.equals(a2));
    }

    /**
     * Test the equals method with different armour types
     */
    @Test
    public void testEqualsMethodDifferentArmourType() {
        String name = "We are equals";
        String desc = "Yes we are";

        ArmourType type1 = ArmourType.LIGHT;
        ArmourType type2 = ArmourType.MEDIUM;
        int baseDefence = 12;
        int durability = 40;

        ArmourModifier modifier1 = new SimpleDefenceModifier("MOD", 14,15);
        ArmourModifier modifier2 = new SimpleDefenceModifier("MOD", 14, 15);

        Armour a1 = new Armour(name, desc, type1, baseDefence, durability, modifier1);
        Armour a2 = new Armour(name, desc, type2, baseDefence, durability, modifier2);

        assertFalse(a1.equals(a2));
    }

    /**
     * Test the equals method with different base defence
     */
    @Test
    public void testEqualsMethodDifferentBaseDefence() {
        String name = "We are equals";
        String desc = "Yes we are";

        ArmourType type = ArmourType.LIGHT;
        int baseDefence1 = 12;
        int baseDefence2 = 13;
        int durability = 40;

        ArmourModifier modifier1 = new SimpleDefenceModifier("MOD", 14,15);
        ArmourModifier modifier2 = new SimpleDefenceModifier("MOD", 14, 15);

        Armour a1 = new Armour(name, desc, type, baseDefence1, durability, modifier1);
        Armour a2 = new Armour(name, desc, type, baseDefence2, durability, modifier2);

        assertFalse(a1.equals(a2));
    }

    /**
     * Test the equals method with different durability
     */
    @Test
    public void testEqualsMethodDifferentDurability() {
        String name = "We are equals";
        String desc = "Yes we are";

        ArmourType type = ArmourType.LIGHT;
        int baseDefence = 12;
        int durability1 = 40;
        int durability2 = 50;

        ArmourModifier modifier1 = new SimpleDefenceModifier("MOD", 14,15);
        ArmourModifier modifier2 = new SimpleDefenceModifier("MOD", 14, 15);

        Armour a1 = new Armour(name, desc, type, baseDefence, durability1, modifier1);
        Armour a2 = new Armour(name, desc, type, baseDefence, durability2, modifier2);

        assertFalse(a1.equals(a2));
    }

    /**
     * Test the equals method with different modifier name
     */
    @Test
    public void testEqualsMethodDifferentModifierName() {
        String name = "We are equals";
        String desc = "Yes we are";

        ArmourType type = ArmourType.LIGHT;
        int baseDefence = 12;
        int durability = 40;

        ArmourModifier modifier1 = new SimpleDefenceModifier("MOD1", 14,15);
        ArmourModifier modifier2 = new SimpleDefenceModifier("MOD2", 14, 15);

        Armour a1 = new Armour(name, desc, type, baseDefence, durability, modifier1);
        Armour a2 = new Armour(name, desc, type, baseDefence, durability, modifier2);

        assertFalse(a1.equals(a2));
    }

    /**
     * Test the equals method with different modifier cost
     */
    @Test
    public void testEqualsMethodDifferentModifierCost() {
        String name = "We are equals";
        String desc = "Yes we are";

        ArmourType type = ArmourType.LIGHT;
        int baseDefence = 12;
        int durability = 40;

        ArmourModifier modifier1 = new SimpleDefenceModifier("MOD", 14,15);
        ArmourModifier modifier2 = new SimpleDefenceModifier("MOD", 13, 15);

        Armour a1 = new Armour(name, desc, type, baseDefence, durability, modifier1);
        Armour a2 = new Armour(name, desc, type, baseDefence, durability, modifier2);

        assertFalse(a1.equals(a2));
    }

    /**
     * Test the equals method with different modifier defence modifier
     */
    @Test
    public void testEqualsMethodDifferentModifierDefence() {
        String name = "We are equals";
        String desc = "Yes we are";

        ArmourType type = ArmourType.LIGHT;
        int baseDefence = 12;
        int durability = 40;

        ArmourModifier modifier1 = new SimpleDefenceModifier("MOD", 14,15);
        ArmourModifier modifier2 = new SimpleDefenceModifier("MOD", 14, 16);

        Armour a1 = new Armour(name, desc, type, baseDefence, durability, modifier1);
        Armour a2 = new Armour(name, desc, type, baseDefence, durability, modifier2);

        assertFalse(a1.equals(a2));
    }

    /**
     * Test the equals method with no modifier
     */
    @Test
    public void testEqualsMethodNoModifier() {
        String name = "We are equals";
        String desc = "Yes we are";

        ArmourType type = ArmourType.LIGHT;
        int baseDefence = 12;
        int durability = 40;


        Armour a1 = new Armour(name, desc, type, baseDefence, durability);
        Armour a2 = new Armour(name, desc, type, baseDefence, durability);

        assertTrue(a1.equals(a2));
    }

    /**
     * Test the equals method with one modifier and no modifier
     */
    @Test
    public void testEqualsMethodOneModifier() {
        String name = "We are equals";
        String desc = "Yes we are";

        ArmourType type = ArmourType.LIGHT;
        int baseDefence = 12;
        int durability = 40;

        ArmourModifier modifier1 = new SimpleDefenceModifier("MOD", 14,15);

        Armour a1 = new Armour(name, desc, type, baseDefence, durability, modifier1);
        Armour a2 = new Armour(name, desc, type, baseDefence, durability);

        assertFalse(a1.equals(a2));
    }

    /**
     * Test the equals method with a different object
     */
    @Test
    public void testEqualsMethodDifferentObject() {
        String name = "We are equals";
        String desc = "Yes we are";

        ArmourType type = ArmourType.LIGHT;
        int baseDefence = 12;
        int durability = 40;

        ArmourModifier modifier = new SimpleDefenceModifier("MOD", 14,15);

        Armour a = new Armour(name, desc, type, baseDefence, durability, modifier);

        assertFalse(a.equals(new Object()));
    }

    /**
     * Test the calculation total armour with no modifier and full durability
     */
    @Test
    public void testCalculateTotalArmourNoModifierAndFullDurability() {
        String name = "So much armour!";
        String desc = "Yes, yes there is!";

        ArmourType type = ArmourType.LIGHT;
        int baseDefence = 12;
        int durability = 100;

        Armour a = new Armour(name, desc, type, baseDefence, durability);

        assertEquals(12, a.getTotalArmour());
    }

    /**
     * Test the calculation of total armour with no modifier and half durability
     */
    @Test
    public void testCalculateTotalArmourNoModifierAndHalfDurability() {
        String name = "So much armour!";
        String desc = "Yes, yes there is!";

        ArmourType type = ArmourType.LIGHT;
        int baseDefence = 12;
        int durability = 50;

        Armour a = new Armour(name, desc, type, baseDefence, durability);

        assertEquals(6, a.getTotalArmour());
    }

    /**
     * Test the calculation of total armour with modifier and full durability
     */
    @Test
    public void testCalculateTotalArmourWithModifierFullDurability() {
        String name = "So much armour!";
        String desc = "Yes, yes there is!";

        ArmourType type = ArmourType.LIGHT;
        int baseDefence = 12;
        int durability = 100;

        SimpleDefenceModifier sdm = new SimpleDefenceModifier("MORE", 10, 8);

        Armour a = new Armour(name, desc, type, baseDefence, durability, sdm);

        assertEquals(20, a.getTotalArmour());
    }

    /**
     * Test the calculation of total armour with modifier and half durability
     */
    @Test
    public void testCalculateTotalArmourWithModifierHalfDurability() {
        String name = "So much armour!";
        String desc = "Yes, yes there is!";

        ArmourType type = ArmourType.MEDIUM;
        int baseDefence = 12;
        int durability = 50;

        SimpleDefenceModifier sdm = new SimpleDefenceModifier("MORE", 10, 8);

        Armour a = new Armour(name, desc, type, baseDefence, durability, sdm);

        assertEquals(16, a.getTotalArmour());
    }

    /**
     * Test the calculate of total armour with no modifier and zero durability
     */
    @Test
    public void testCalculateTotalArmourNoModifierZeroDurability() {
        String name = "So much armour!";
        String desc = "Yes, yes there is!";

        ArmourType type = ArmourType.LIGHT;
        int baseDefence = 12;
        int durability = 0;

        Armour a = new Armour(name, desc, type, baseDefence, durability);

        assertEquals(0, a.getTotalArmour());
    }

    /**
     * Test the calculate of total armour with modifier and zero durability
     */
    @Test
    public void testCalculateTotalArmourWithModifierZeroDurability() {
        String name = "So much armour!";
        String desc = "Yes, yes there is!";

        ArmourType type = ArmourType.LIGHT;
        int baseDefence = 12;
        int durability = 0;

        SimpleDefenceModifier sdm = new SimpleDefenceModifier("MORE", 10, 8);

        Armour a = new Armour(name, desc, type, baseDefence, durability, sdm);

        assertEquals(0, a.getTotalArmour());
    }

    /**
     * Test the deteriorate
     */
    @Test
    public void testDeteriorateArmour() {
        String name = "So much armour!";
        String desc = "Yes, yes there is!";

        ArmourType type = ArmourType.LIGHT;
        int baseDefence = 12;
        int durability = 2;

        Armour a = new Armour(name, desc, type, baseDefence, durability);

        // Deteriorate once
        a.deteriorate();
        assertEquals(1, a.getDurability());

        // Deteriorate twice
        a.deteriorate();
        assertEquals(0, a.getDurability());

        // Deteriorate again, not under 0
        a.deteriorate();
        assertEquals(0, a.getDurability());

    }

    /**
     * Test the worth with modifier and full durability
     */
    @Test
    public void testWorthWithModifierFullDurability() {
        String name = "So much armour!";
        String desc = "Yes, yes there is!";

        ArmourType type = ArmourType.HEAVY;
        int baseDefence = 12;
        int durability = 100;

        SimpleDefenceModifier sdm = new SimpleDefenceModifier("MORE", 10, 8);

        Armour a = new Armour(name, desc, type, baseDefence, durability, sdm);

        assertEquals(54, a.getValue());
    }

    /**
     * Test the worth with no modifier and full durability
     */
    @Test
    public void testWorthNoModifierFullDurability() {
        String name = "So much armour!";
        String desc = "Yes, yes there is!";

        ArmourType type = ArmourType.MEDIUM;
        int baseDefence = 10;
        int durability = 100;

        Armour a = new Armour(name, desc, type, baseDefence, durability);

        assertEquals(20, a.getValue());
    }

    /**
     * Test the worth with modifier and half durability
     */
    @Test
    public void testWorthWithModifierHalfDurability() {
        String name = "So much armour!";
        String desc = "Yes, yes there is!";

        ArmourType type = ArmourType.LIGHT;
        int baseDefence = 8;
        int durability = 50;

        SimpleDefenceModifier sdm = new SimpleDefenceModifier("MORE", 12, 8);

        Armour a = new Armour(name, desc, type, baseDefence, durability, sdm);

        assertEquals(14, a.getValue());
    }

    /**
     * Test the worth with no modifier and half durability
     */
    @Test
    public void testWorthNoModiferHalfDurability() {
        String name = "So much armour!";
        String desc = "Yes, yes there is!";

        ArmourType type = ArmourType.LIGHT;
        int baseDefence = 16;
        int durability = 50;

        Armour a = new Armour(name, desc, type, baseDefence, durability);

        assertEquals(8, a.getValue());
    }

    /**
     * Test the worth with modifier and zero durability
     */
    @Test
    public void testWorthWithModifierZeroDurability() {
        String name = "So much armour!";
        String desc = "Yes, yes there is!";

        ArmourType type = ArmourType.HEAVY;
        int baseDefence = 12;
        int durability = 0;

        SimpleDefenceModifier sdm = new SimpleDefenceModifier("MORE", 10, 8);

        Armour a = new Armour(name, desc, type, baseDefence, durability, sdm);

        assertEquals(0, a.getValue());
    }

    /**
     * Test the worth with no modifier and zero durability
     */
    @Test
    public void testWorthNoModifierZeroDurability() {
        String name = "So much armour!";
        String desc = "Yes, yes there is!";

        ArmourType type = ArmourType.MEDIUM;
        int baseDefence = 165;
        int durability = 0;

        Armour a = new Armour(name, desc, type, baseDefence, durability);

        assertEquals(0, a.getValue());
    }

    /**
     * Test the worth modifier with a uneven base damage no modifier half durability
     */
    @Test
    public void testWorthNoModifierHalfDurabilityUnevenBaseDamage() {
        String name = "So much armour!";
        String desc = "Yes, yes there is!";

        ArmourType type = ArmourType.LIGHT;
        int baseDefence = 11;
        int durability = 50;

        Armour a = new Armour(name, desc, type, baseDefence, durability);

        assertEquals(5, a.getValue());
    }

    /**
     * Test set modifier if no modifier previous exists
     */
    @Test
    public void setModifierNoPreviousModifierExists() {
        String name = "So much armour!";
        String desc = "No.... no there are not";

        ArmourType type = ArmourType.HEAVY;
        int baseDefence = 12;

        SimpleDefenceModifier sdm1 = new SimpleDefenceModifier("ASD", 20, 10);
        SimpleDefenceModifier sdm2 = new SimpleDefenceModifier("ASD", 20, 10);

        Armour a = new Armour(name, desc, type, baseDefence);

        a.setModifier(sdm1);

        assertEquals(sdm2, a.getModifier());
    }

    /**
     * Test set modifier if modifier previous exists
     */
    @Test
    public void setModifierPreviousModifierExists() {
        String name = "So much armour!";
        String desc = "No.... no there are not";

        ArmourType type = ArmourType.HEAVY;
        int baseDefence = 12;

        SimpleDefenceModifier sdm1 = new SimpleDefenceModifier("ASD", 20, 10);
        SimpleDefenceModifier sdm2 = new SimpleDefenceModifier("ASD", 20, 10);

        Armour a = new Armour(name, desc, type, baseDefence, new SimpleDefenceModifier("asddkkl",32,2));

        a.setModifier(sdm1);

        assertEquals(sdm2, a.getModifier());
    }

}