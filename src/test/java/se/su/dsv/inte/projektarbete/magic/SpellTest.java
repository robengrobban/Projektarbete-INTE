package se.su.dsv.inte.projektarbete.magic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class to test the Spell class
 */
public class SpellTest {

    /**
     * Test the constructor to set the correct values
     */
    @Test
    public void testConstructorSetCorrectValues() {
        String name = "A fantastic spell";
        String description = "This ia a fantastic spell";

        int range = 10;
        int manaCost = 120;

        Spell spell = new Spell(name, description, range, manaCost) {};

        assertEquals(name, spell.getName());
        assertEquals(description, spell.getDescription());
        assertEquals(range, spell.getRange());
        assertEquals(manaCost, spell.getManaCost());
    }

    /**
     * Test the constructor with null names
     */
    @Test
    public void testConstructorNullName() {
        String name = null;
        String description = "The description for that spell";
        int range = 2;
        int manaCost = 100;

        assertThrows( IllegalArgumentException.class, () -> {
            new Spell(name, description, range, manaCost) {};
        } );
    }

    /**
     * Test the constructor with empty name
     */
    @Test
    public void testConstructorEmptyName() {
        String name = "";
        String description = "The description for that spell";
        int range = 2;
        int manaCost = 100;

        assertThrows( IllegalArgumentException.class, () -> {
            new Spell(name, description, range, manaCost) {};
        } );
    }

    /**
     * Test the constructor with null description
     */
    @Test
    public void testConstructorNullDescription() {
        String name = "A spell";
        String description = null;
        int range = 2;
        int manaCost = 100;

        assertThrows( IllegalArgumentException.class, () -> {
            new Spell(name, description, range, manaCost) {};
        } );
    }

    /**
     * Test the constructor with empty description
     */
    @Test
    public void testConstructorEmptyDescription() {
        String name = "A spell";
        String description = "";
        int range = 2;
        int manaCost = 100;

        assertThrows( IllegalArgumentException.class, () -> {
            new Spell(name, description, range, manaCost) {};
        } );
    }

    /**
     * Test the constructor with zero range
     */
    @Test
    public void testConstructorZeroRange() {
        String name = "A spell";
        String description = "The description for that spell";
        int range = 0;
        int manaCost = 100;

        assertThrows( IllegalArgumentException.class, () -> {
            new Spell(name, description, range, manaCost) {};
        } );
    }

    /**
     * Test the constructor with negative range
     */
    @Test
    public void testConstructorNegativeRange() {
        String name = "A spell";
        String description = "The description for that spell";
        int range = -1;
        int manaCost = 100;

        assertThrows( IllegalArgumentException.class, () -> {
            new Spell(name, description, range, manaCost) {};
        } );
    }

    /**
     * Test the constructor with zero mana cost
     */
    @Test
    public void testConstructorZeroManaCost() {
        String name = "A spell";
        String description = "The description for that spell";
        int range = 2;
        int manaCost = 0;

        assertThrows( IllegalArgumentException.class, () -> {
            new Spell(name, description, range, manaCost) {};
        } );
    }

    /**
     * Test the constructor with negative mana cost
     */
    @Test
    public void testConstructorNegativeManaCost() {
        String name = "A spell";
        String description = "The description for that spell";
        int range = 2;
        int manaCost = -1;

        assertThrows( IllegalArgumentException.class, () -> {
            new Spell(name, description, range, manaCost) {};
        } );
    }

}