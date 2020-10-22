package se.su.dsv.inte.projektarbete.magic;

import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.ElementType;
import se.su.dsv.inte.projektarbete.armour.Armour;
import se.su.dsv.inte.projektarbete.armour.ArmourType;
import se.su.dsv.inte.projektarbete.characters.Character;
import se.su.dsv.inte.projektarbete.map.Map;

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

    /**
     * Test use correctly
     */
    @Test
    public void testUseCorrectly() {
        String name = "Fire damage";
        String description = "SO MUCK FIRE!";
        int range = 2;
        int manaCost = 10;
        int damage = 20;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND));

        FireSpell fireSpell = new FireSpell( name, description, range, manaCost, damage, canAttack );

        Character source = new Character("Bob", ElementType.LAND, new Armour("ARMOUR", "Yea", ArmourType.LIGHT, 10, 100, null), null, 100, 100){};
        Character target = new Character("Bob", ElementType.LAND, new Armour("ARMOUR", "Yea", ArmourType.LIGHT, 10, 100, null), null, 100, 100){};

        Map map = new Map(10,10);
        map.placeCharacter(source, 0, 0);
        map.placeCharacter(target, 1, 1);

        assertTrue(fireSpell.use(source, target));

        assertEquals(90, source.getCurrentMana());
        assertEquals(90, target.getCurrentHealth());
    }

    /**
     * Test use target too much armour half damage
     */
    @Test
    public void testUseTooMuchArmourHalfDamage() {
        String name = "Fire damage";
        String description = "SO MUCK FIRE!";
        int range = 2;
        int manaCost = 10;
        int damage = 10;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND));

        FireSpell fireSpell = new FireSpell( name, description, range, manaCost, damage, canAttack );

        Character source = new Character("Bob", ElementType.LAND, new Armour("ARMOUR", "Yea", ArmourType.LIGHT, 10, 100, null), null, 100, 100){};
        Character target = new Character("Bob", ElementType.LAND, new Armour("ARMOUR", "Yea", ArmourType.LIGHT, 10, 100, null), null, 100, 100){};

        Map map = new Map(10,10);
        map.placeCharacter(source, 0, 0);
        map.placeCharacter(target, 1, 1);

        assertTrue(fireSpell.use(source, target));

        assertEquals(90, source.getCurrentMana());
        assertEquals(95, target.getCurrentHealth());
    }

    /**
     * Test use target different element type
     */
    @Test
    public void testUseTargetDifferentElementType() {
        String name = "Fire damage";
        String description = "SO MUCK FIRE!";
        int range = 2;
        int manaCost = 10;
        int damage = 20;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND));

        FireSpell fireSpell = new FireSpell( name, description, range, manaCost, damage, canAttack );

        Character source = new Character("Bob", ElementType.LAND, null, null, 100, 100){};
        Character target = new Character("Bob", ElementType.AIR, new Armour("ARMOUR", "Yea", ArmourType.LIGHT, 10, 100, null), null, 100, 100){};

        Map map = new Map(10,10);
        map.placeCharacter(source, 0, 0);
        map.placeCharacter(target, 1, 1);

        assertFalse(fireSpell.use(source, target));

        assertEquals(100, source.getCurrentMana());
        assertEquals(100, target.getCurrentHealth());
    }

    /**
     * Test use source not enough mana
     */
    @Test
    public void testUseTargetNotEnoughMana() {
        String name = "Fire damage";
        String description = "SO MUCK FIRE!";
        int range = 2;
        int manaCost = 10;
        int damage = 20;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND));

        FireSpell fireSpell = new FireSpell( name, description, range, manaCost, damage, canAttack );

        Character source = new Character("Bob", ElementType.LAND, null, null, 100, 9){};
        Character target = new Character("Bob", ElementType.LAND, new Armour("ARMOUR", "Yea", ArmourType.LIGHT, 10, 100, null), null, 100, 100){};

        Map map = new Map(10,10);
        map.placeCharacter(source, 0, 0);
        map.placeCharacter(target, 1, 1);

        assertFalse(fireSpell.use(source, target));

        assertEquals(9, source.getCurrentMana());
        assertEquals(100, target.getCurrentHealth());
    }

    /**
     * Test use target not within range
     */
    @Test
    public void testUseTargetNotWithinRange() {
        String name = "Fire damage";
        String description = "SO MUCK FIRE!";
        int range = 2;
        int manaCost = 10;
        int damage = 100;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND));

        FireSpell fireSpell = new FireSpell( name, description, range, manaCost, damage, canAttack );

        Character source = new Character("Bob", ElementType.LAND, null, null, 100, 120){};
        Character target = new Character("Bob", ElementType.LAND, new Armour("ARMOUR", "Yea", ArmourType.LIGHT, 10, 100, null), null, 100, 100){};

        Map map = new Map(10,10);
        map.placeCharacter(source, 0, 0);
        map.placeCharacter(target, 5, 5);

        assertFalse(fireSpell.use(source, target));

        assertEquals(120, source.getCurrentMana());
        assertEquals(100, target.getCurrentHealth());
    }

}