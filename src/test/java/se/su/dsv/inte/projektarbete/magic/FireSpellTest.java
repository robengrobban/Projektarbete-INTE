package se.su.dsv.inte.projektarbete.magic;

import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.ElementType;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class to test the FireSpell Class
 */
public class FireSpellTest {

    /**
     * Test constructor set with correct values
     */
    @Test
    public void testConstructorCorrectValues() {
        String name = "Fire damage";
        String description = "SO MUCH FIRE!";
        int range = 2;
        int manaCost = 10;
        int damage = 20;
        HashSet<ElementType> canAttack1 = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.AIR));
        HashSet<ElementType> canAttack2 = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.AIR));

        FireSpell f = new FireSpell(name, description, range, manaCost, damage, canAttack1);

        assertEquals(name, f.getName());
        assertEquals(description, f.getDescription());
        assertEquals(range, f.getRange());
        assertEquals(manaCost, f.getManaCost());
        assertEquals(damage, f.getDamage());
        assertEquals(canAttack2, f.getCanAttack());
    }

    /**
     * Test constructor set with null name
     */
    @Test
    public void testConstructorNullName() {
        String name = null;
        String description = "SO MUCH FIRE!";
        int range = 2;
        int manaCost = 10;
        int damage = 20;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.AIR));

        assertThrows( IllegalArgumentException.class, () -> {
            new FireSpell(name, description, range, manaCost, damage, canAttack);
        });
    }

    /**
     * Test constructor set with empty name
     */
    @Test
    public void testConstructorEmptyName() {
        String name = "";
        String description = "SO MUCH FIRE!";
        int range = 2;
        int manaCost = 10;
        int damage = 20;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.AIR));

        assertThrows( IllegalArgumentException.class, () -> {
            new FireSpell(name, description, range, manaCost, damage, canAttack);
        });
    }

    /**
     * Test constructor set with null description
     */
    @Test
    public void testConstructorNullDescription() {
        String name = "Fire damage";
        String description = null;
        int range = 2;
        int manaCost = 10;
        int damage = 20;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.AIR));

        assertThrows( IllegalArgumentException.class, () -> {
            new FireSpell(name, description, range, manaCost, damage, canAttack);
        });
    }

    /**
     * Test constructor set with empty description
     */
    @Test
    public void testConstructorEmptyDescription() {
        String name = "Fire damage";
        String description = "";
        int range = 2;
        int manaCost = 10;
        int damage = 20;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.AIR));

        assertThrows( IllegalArgumentException.class, () -> {
            new FireSpell(name, description, range, manaCost, damage, canAttack);
        });
    }

    /**
     * Test constructor set with zero range
     */
    @Test
    public void testConstructorZeroRange() {
        String name = "Fire damage";
        String description = "SO MUCH FIRE!";
        int range = 0;
        int manaCost = 10;
        int damage = 20;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.AIR));

        assertThrows( IllegalArgumentException.class, () -> {
            new FireSpell(name, description, range, manaCost, damage, canAttack);
        });
    }

    /**
     * Test constructor set with negative range
     */
    @Test
    public void testConstructorNegativeRange() {
        String name = "Fire damage";
        String description = "SO MUCH FIRE!";
        int range = -1;
        int manaCost = 10;
        int damage = 20;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.AIR));

        assertThrows( IllegalArgumentException.class, () -> {
            new FireSpell(name, description, range, manaCost, damage, canAttack);
        });
    }

    /**
     * Test constructor set with zero mana cost
     */
    @Test
    public void testConstructorZeroManaCost() {
        String name = "Fire damage";
        String description = "SO MUCH FIRE!";
        int range = 2;
        int manaCost = 0;
        int damage = 20;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.AIR));

        assertThrows( IllegalArgumentException.class, () -> {
            new FireSpell(name, description, range, manaCost, damage, canAttack);
        });
    }

    /**
     * Test constructor set with negative mana cost
     */
    @Test
    public void testConstructorNegativeManaCost() {
        String name = "Fire damage";
        String description = "SO MUCH FIRE!";
        int range = 2;
        int manaCost = -1;
        int damage = 20;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.AIR));

        assertThrows( IllegalArgumentException.class, () -> {
            new FireSpell(name, description, range, manaCost, damage, canAttack);
        });
    }

    /**
     * Test constructor set with zero damage
     */
    @Test
    public void testConstructorZeroDamage() {
        String name = "Fire damage";
        String description = "SO MUCH FIRE!";
        int range = 2;
        int manaCost = 10;
        int damage = 0;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.AIR));

        assertThrows( IllegalArgumentException.class, () -> {
            new FireSpell(name, description, range, manaCost, damage, canAttack);
        });
    }

    /**
     * Test constructor with negative damage
     */
    @Test
    public void testConstructorNegativeDamage() {
        String name = "Fire damage";
        String description = "SO MUCH FIRE!";
        int range = 2;
        int manaCost = 10;
        int damage = -1;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.AIR));

        assertThrows( IllegalArgumentException.class, () -> {
            new FireSpell(name, description, range, manaCost, damage, canAttack);
        });
    }

    /**
     * Test constructor with null can attack
     */
    @Test
    public void testConstructorNullCanAttack() {
        String name = "Fire damage";
        String description = "SO MUCH FIRE!";
        int range = 2;
        int manaCost = 10;
        int damage = 20;
        HashSet<ElementType> canAttack = null;

        assertThrows( IllegalArgumentException.class, () -> {
            new FireSpell(name, description, range, manaCost, damage, canAttack);
        });
    }

    /**
     * Test constructor with empty can attack
     */
    @Test
    public void testConstructorEmptyCanAttack() {
        String name = "Fire damage";
        String description = "SO MUCH FIRE!";
        int range = 2;
        int manaCost = 10;
        int damage = 20;
        HashSet<ElementType> canAttack = new HashSet<>();

        assertThrows( IllegalArgumentException.class, () -> {
            new FireSpell(name, description, range, manaCost, damage, canAttack);
        });
    }

}