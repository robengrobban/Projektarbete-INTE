package se.su.dsv.inte.projektarbete.armour;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing Simple Defense Modifier
 */
public class SimpleDefenceModifierTest {

    /**
     * Test the constructors sets correct values
     */
    @Test
    public void testConstructorSetCorrectValues() {
        String name = "More armour!";
        int cost = 10;
        int defenseModifier = 2;

        SimpleDefenceModifier sdm = new SimpleDefenceModifier(name, cost, defenseModifier);

        assertEquals(name, sdm.getName());
        assertEquals(cost, sdm.getCost());
        assertEquals(defenseModifier, sdm.getBaseDefenceModifier());
    }

    /**
     * Test constructor behavior if incorrect values are sent
     */
    @Test
    public void testConstructorSetIncorrectDefenseModifier() {
        String name = "No modifier here";
        int cost = 12;
        int defenseModifier = 0;

        assertThrows( IllegalArgumentException.class, () -> {
            SimpleDefenceModifier sdm = new SimpleDefenceModifier(name, cost, defenseModifier);
        });

    }

    /**
     * Test modifier for correct worth evaluation.
     */
    @Test
    public void testDefenseModifierWorth() {
        String name = "I have a value :)";
        int cost = 12;
        int defenseModifier = 2;

        SimpleDefenceModifier sdm = new SimpleDefenceModifier(name, cost, defenseModifier);

        assertEquals(14, sdm.getWorth());
    }

    /**
     * Test the equals method
     */
    @Test
    public void testEqualSimpleDamageModifier() {
        String name = "More defence...";
        int cost = 5;
        int defenceModifier = 2;

        SimpleDefenceModifier sdm1 = new SimpleDefenceModifier(name, cost, defenceModifier);
        SimpleDefenceModifier sdm2 = new SimpleDefenceModifier(name, cost, defenceModifier);

        assertTrue(sdm1.equals(sdm2));
    }

    /**
     * Test the equals method different ArmourModifier
     */
    @Test
    public void testEqualDifferentName() {
        String name1 = "More defence?";
        String name2 = "I do not know...";
        int cost = 5;
        int defenceModifier = 2;

        SimpleDefenceModifier sdm1 = new SimpleDefenceModifier(name1, cost, defenceModifier);
        SimpleDefenceModifier sdm2 = new SimpleDefenceModifier(name2, cost, defenceModifier);

        assertFalse(sdm1.equals(sdm2));
    }

    /**
     * Test the equals method different ArmourModifier
     */
    @Test
    public void testEqualDifferentCost() {
        String name = "More defence!";
        int cost1 = 5;
        int cost2 = 10;
        int defenceModifier = 2;

        SimpleDefenceModifier sdm1 = new SimpleDefenceModifier(name, cost1, defenceModifier);
        SimpleDefenceModifier sdm2 = new SimpleDefenceModifier(name, cost2, defenceModifier);

        assertFalse(sdm1.equals(sdm2));
    }

    /**
     * Test the equals method different DefenceModifier
     */
    @Test
    public void testEqualDifferentDefenceModifier() {
        String name = "More defence?!?!?!";
        int cost = 5;
        int defenceModifier1 = 2;
        int defenceModifier2 = 3;

        SimpleDefenceModifier sdm1 = new SimpleDefenceModifier(name, cost, defenceModifier1);
        SimpleDefenceModifier sdm2 = new SimpleDefenceModifier(name, cost, defenceModifier2);

        assertFalse(sdm1.equals(sdm2));
    }

    /**
     * Test the equals method with wrong class
     */
    @Test
    public void testEqualWrongClass() {
        String name = "More defence?!?!?!";
        int cost = 5;
        int defenceModifier = 2;

        SimpleDefenceModifier sdm = new SimpleDefenceModifier(name, cost, defenceModifier);

        assertFalse(sdm.equals(new Object()));
    }


}