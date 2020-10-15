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
        assertEquals(defenseModifier, sdm.getBaseDefenseModifier());
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


}