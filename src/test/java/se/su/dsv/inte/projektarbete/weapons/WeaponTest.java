package se.su.dsv.inte.projektarbete.weapons;

import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.ElementType;

import javax.swing.text.Element;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class to test the Weapons Class
 */
public class WeaponTest {

    /**
     * Test the constructor with correct values sent.
     */
    @Test
    public void testConstructorSetValues() {
        String name = "Sword 1";
        String desc = "The 1 sword ever created.";
        int baseDamage = 10;
        int range = 1;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));
        int durability = 100;
        WeaponModifier modifer = null;

        Weapon w = new Weapon(name, desc, baseDamage, range, canAttack, durability, modifer);

        assertEquals(name, w.getName());
        assertEquals(desc, w.getDescription());
        assertEquals(baseDamage, w.getBaseDamage());
        assertEquals(range, w.getRange());
        assertEquals(canAttack, w.getCanAttack());
        assertEquals(durability, w.getDurability());
        assertEquals(modifer, w.getModifier());

    }

    /**
     * Test the constructor with minimal correct values sent.
     */
    @Test
    public void testConstructorSetMinimalValues() {
        String name = "Sword 2";
        String desc = "The 2 sword ever created.";
        int baseDamage = 12;
        int range = 2;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));

        Weapon w = new Weapon(name, desc, baseDamage, range, canAttack);

        assertEquals(name, w.getName());
        assertEquals(desc, w.getDescription());
        assertEquals(baseDamage, w.getBaseDamage());
        assertEquals(range, w.getRange());
        assertEquals(canAttack, w.getCanAttack());
        assertEquals(100, w.getDurability());
        assertEquals(null, w.getModifier());
    }

    /**
     * Test the constructor with minimal correct values plus durability.
     */
    @Test
    public void testConstructorSetMinimalValuesPlusDurability() {
        String name = "Sword 3";
        String desc = "The 3 sword ever created.";
        int baseDamage = 12;
        int range = 2;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));
        int durability = 100;

        Weapon w = new Weapon(name, desc, baseDamage, range, canAttack, durability);

        assertEquals(name, w.getName());
        assertEquals(desc, w.getDescription());
        assertEquals(baseDamage, w.getBaseDamage());
        assertEquals(range, w.getRange());
        assertEquals(canAttack, w.getCanAttack());
        assertEquals(durability, w.getDurability());
        assertEquals(null, w.getModifier());
    }

    /**
     * Test the constructor with minimal correct values plus weapon modifier.
     */
    @Test
    public void testConstructorSetMinimalValuesPlusWeaponModifier() {
        String name = "Sword 4";
        String desc = "The 4 sword ever created.";
        int baseDamage = 12;
        int range = 2;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));
        WeaponModifier modifier = null;

        Weapon w = new Weapon(name, desc, baseDamage, range, canAttack, modifier);

        assertEquals(name, w.getName());
        assertEquals(desc, w.getDescription());
        assertEquals(baseDamage, w.getBaseDamage());
        assertEquals(range, w.getRange());
        assertEquals(canAttack, w.getCanAttack());
        assertEquals(100, w.getDurability());
        assertEquals(modifier, w.getModifier());
    }

    /**
     * Test the constructor with a base damage of 0.
     */
    @Test
    public void testConstructorBaseDamageEqualToZero() {
        String name = "Sword 5";
        String desc = "The 5 sword ever created.";
        int baseDamage = 0;
        int range = 3;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));

        assertThrows( IllegalArgumentException.class, () -> {
            new Weapon(name, desc, baseDamage, range, canAttack);
        });
    }

    /**
     * Test the constructor with a base damage of -1.
     */
    @Test
    public void testConstructorBaseDamageLessThanZero() {
        String name = "Sword 6";
        String desc = "The 6 sword ever created.";
        int baseDamage = -1;
        int range = 4;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));

        assertThrows(IllegalArgumentException.class, () -> {
            new Weapon(name, desc, baseDamage, range, canAttack);
        });
    }

    /**
     * Test the constructor with a range of 0.
     */
    @Test
    public void testConstructorRangeEqualToZero() {
        String name = "Sword 7";
        String desc = "The 7 sword ever created.";
        int baseDamage = 2;
        int range = 0;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));

        assertThrows( IllegalArgumentException.class, () -> {
            new Weapon(name, desc, baseDamage, range, canAttack);
        } );
    }

    /**
     * Test the constructor with a range of -1.
     */
    @Test
    public void testConstructorRangeLessThanZero() {
        String name = "Sword 8";
        String desc = "The 8 sword ever created.";
        int baseDamage = 3;
        int range = -1;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));

        assertThrows( IllegalArgumentException.class, () ->{
            new Weapon(name, desc, baseDamage, range, canAttack);
        } );
    }

    /**
     * Test the constructor with a durability of -1.
     */
    @Test
    public void testConstructorDurabilityLessThanZero() {
        String name = "Sword 9";
        String desc = "The 9 sword ever created.";
        int baseDamage = 4;
        int range = 1;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));
        int durability = -1;

        assertThrows( IllegalArgumentException.class, () -> {
            new Weapon(name, desc, baseDamage, range, canAttack, durability);
        } );
    }

    /**
     * Test the constructor with a durability of 101.
     */
    @Test
    public void testConstructorDurabilityGreaterThanOneHundred() {
        String name = "Sword 10";
        String desc = "The 10 sword ever created.";
        int baseDamage = 10;
        int range = 4;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));
        int durability = 101;

        assertThrows( IllegalArgumentException.class, () -> {
            new Weapon(name, desc, baseDamage, range, canAttack, durability);
        } );
    }

    /**
     * Test the constructor with a can attack value of null.
     */
    @Test
    public void testConstructorCanAttackNull() {
        String name = "Sword 11";
        String desc = "The 11 sword ever created.";
        int baseDamage = 10;
        int range = 2;
        HashSet<ElementType> canAttack = null;

        assertThrows( IllegalArgumentException.class, () -> {
            new Weapon(name, desc, baseDamage, range, canAttack);
        });
    }

    /**
     * Test the constructor with an empty element attack types.
     */
    @Test
    public void testConstructorCanAttackEmpty() {
        String name = "Sword 12";
        String desc = "The 12 sword ever created";
        int baseDamage = 10;
        int range = 1;
        HashSet<ElementType> canAttack = new HashSet<>();;

        assertThrows( IllegalArgumentException.class, () -> {
            new Weapon(name, desc, baseDamage, range, canAttack);
        } );
    }

    /**
     * Test the constructor with a null name.
     */
    @Test
    public void testConstructorNameNull() {
        String name = null;
        String desc = "The 13 sword ever created";
        int baseDamage = 3;
        int range = 2;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));

        assertThrows( IllegalArgumentException.class, () -> {
            new Weapon(name, desc, baseDamage, range, canAttack);
        } );
    }

    /**
     * Test the constructor with a empty name.
     */
    @Test
    public void testConstructorNameEmpty() {
        String name = "";
        String desc = "The 14 sword ever created";
        int baseDamage = 4;
        int range = 3;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));

        assertThrows( IllegalArgumentException.class, () -> {
            new Weapon(name, desc, baseDamage, range, canAttack);
        } );
    }

    /**
     * Test the constructor with a null description.
     */
    @Test
    public void testConstructorDescriptionNull() {
        String name = "Sword 15";
        String desc = null;
        int baseDamage = 13;
        int range = 4;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));

        assertThrows( IllegalArgumentException.class, () -> {
            new Weapon(name, desc, baseDamage, range, canAttack);
        } );
    }

    /**
     * Test the constructor with a empty description.
     */
    @Test
    public void testConstructorDescriptionEmpty() {
        String name = "Sword 16";
        String desc = "";
        int baseDamage = 15;
        int range = 2;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));

        assertThrows( IllegalArgumentException.class, () -> {
            new Weapon(name, desc, baseDamage, range, canAttack);
        } );
    }

    /**
     * Test the equals method to determine if two swords are alike with minimal constructor
     */
    @Test
    public void testWeaponEqualsMethodMinimal() {
        String name = "Sword 17";
        String desc = "The 17 sword ever created.";
        int baseDamage = 13;
        int range = 1;
        HashSet<ElementType> canAttack1 = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));
        HashSet<ElementType> canAttack2 = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));

        Weapon w1 = new Weapon(name, desc, baseDamage, range, canAttack1);
        Weapon w2 = new Weapon(name, desc, baseDamage, range, canAttack2);

        assertTrue(w1.equals(w2));

    }

    /**
     * Test the equals method to determine if two swords are alike with maximal constructor
     */
    @Test
    public void testWeaponEqualsMethodMaximal() {
        String name = "Sword 18";
        String desc = "The 18 sword ever created.";
        int baseDamage = 13;
        int range = 1;
        int durability = 100;
        HashSet<ElementType> canAttack1 = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));
        HashSet<ElementType> canAttack2 = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));

        SimpleDamageModifier sdm1 = new SimpleDamageModifier("More...", 10, 2);
        SimpleDamageModifier sdm2 = new SimpleDamageModifier("More...", 10, 2);

        Weapon w1 = new Weapon(name, desc, baseDamage, range, canAttack1, durability, sdm1);
        Weapon w2 = new Weapon(name, desc, baseDamage, range, canAttack2, durability, sdm2);

        assertTrue(w1.equals(w2));

    }

    /**
     * Test the equals method to determine if two swords are alike with maximal constructor
     */
    @Test
    public void testWeaponEqualsMethodMaximalDifferentName() {
        String name1 = "Sword 19";
        String name2 = "Sword 20";
        String desc = "The 19 sword ever created.";
        int baseDamage = 13;
        int range = 1;
        int durability = 100;
        HashSet<ElementType> canAttack1 = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));
        HashSet<ElementType> canAttack2 = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));

        SimpleDamageModifier sdm1 = new SimpleDamageModifier("More...", 10, 2);
        SimpleDamageModifier sdm2 = new SimpleDamageModifier("More...", 10, 2);

        Weapon w1 = new Weapon(name1, desc, baseDamage, range, canAttack1, durability, sdm1);
        Weapon w2 = new Weapon(name2, desc, baseDamage, range, canAttack2, durability, sdm2);

        assertFalse(w1.equals(w2));
    }

    /**
     * Test the equals method to determine if two swords are alike with maximal constructor
     */
    @Test
    public void testWeaponEqualsMethodMaximalDifferentDescription() {
        String name = "Sword #";
        String desc1 = "The 123890123 sword ever created.";
        String desc2 = "The 348902348 sword ever created.";
        int baseDamage = 13;
        int range = 1;
        int durability = 100;
        HashSet<ElementType> canAttack1 = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));
        HashSet<ElementType> canAttack2 = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));

        SimpleDamageModifier sdm1 = new SimpleDamageModifier("More...", 10, 2);
        SimpleDamageModifier sdm2 = new SimpleDamageModifier("More...", 10, 2);

        Weapon w1 = new Weapon(name, desc1, baseDamage, range, canAttack1, durability, sdm1);
        Weapon w2 = new Weapon(name, desc2, baseDamage, range, canAttack2, durability, sdm2);

        assertFalse(w1.equals(w2));
    }

    /**
     * Test the equals method to determine if two swords are alike with maximal constructor
     */
    @Test
    public void testWeaponEqualsMethodMaximalDifferentBaseDamage() {
        String name = "Sword #";
        String desc = "The 123890123 sword ever created.";
        int baseDamage1 = 13;
        int baseDamage2 = 12;
        int range = 1;
        int durability = 100;
        HashSet<ElementType> canAttack1 = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));
        HashSet<ElementType> canAttack2 = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));

        SimpleDamageModifier sdm1 = new SimpleDamageModifier("More...", 10, 2);
        SimpleDamageModifier sdm2 = new SimpleDamageModifier("More...", 10, 2);

        Weapon w1 = new Weapon(name, desc, baseDamage1, range, canAttack1, durability, sdm1);
        Weapon w2 = new Weapon(name, desc, baseDamage2, range, canAttack2, durability, sdm2);

        assertFalse(w1.equals(w2));
    }

    /**
     * Test the equals method to determine if two swords are alike with maximal constructor
     */
    @Test
    public void testWeaponEqualsMethodMaximalDifferentRange() {
        String name = "Sword #";
        String desc = "The 123890123 sword ever created.";
        int baseDamage = 13;
        int range1 = 1;
        int range2 = 2;
        int durability = 100;
        HashSet<ElementType> canAttack1 = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));
        HashSet<ElementType> canAttack2 = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));

        SimpleDamageModifier sdm1 = new SimpleDamageModifier("More...", 10, 2);
        SimpleDamageModifier sdm2 = new SimpleDamageModifier("More...", 10, 2);

        Weapon w1 = new Weapon(name, desc, baseDamage, range1, canAttack1, durability, sdm1);
        Weapon w2 = new Weapon(name, desc, baseDamage, range2, canAttack2, durability, sdm2);

        assertFalse(w1.equals(w2));
    }

    /**
     * Test the equals method to determine if two swords are alike with maximal constructor
     */
    @Test
    public void testWeaponEqualsMethodMaximalDifferentDurability() {
        String name = "Sword #";
        String desc = "The 123890123 sword ever created.";
        int baseDamage = 13;
        int range = 1;
        int durability1 = 100;
        int durability2 = 0;
        HashSet<ElementType> canAttack1 = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));
        HashSet<ElementType> canAttack2 = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));

        SimpleDamageModifier sdm1 = new SimpleDamageModifier("More...", 10, 2);
        SimpleDamageModifier sdm2 = new SimpleDamageModifier("More...", 10, 2);

        Weapon w1 = new Weapon(name, desc, baseDamage, range, canAttack1, durability1, sdm1);
        Weapon w2 = new Weapon(name, desc, baseDamage, range, canAttack2, durability2, sdm2);

        assertFalse(w1.equals(w2));
    }

    /**
     * Test the equals method to determine if two swords are alike with maximal constructor
     */
    @Test
    public void testWeaponEqualsMethodMaximalDifferentCanAttack() {
        String name = "Sword #";
        String desc = "The 123890123 sword ever created.";
        int baseDamage = 13;
        int range = 1;
        int durability = 100;
        HashSet<ElementType> canAttack1 = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));
        HashSet<ElementType> canAttack2 = new HashSet<>(Arrays.asList(ElementType.AIR, ElementType.WATER));

        SimpleDamageModifier sdm1 = new SimpleDamageModifier("More...", 10, 2);
        SimpleDamageModifier sdm2 = new SimpleDamageModifier("More...", 10, 2);

        Weapon w1 = new Weapon(name, desc, baseDamage, range, canAttack1, durability, sdm1);
        Weapon w2 = new Weapon(name, desc, baseDamage, range, canAttack2, durability, sdm2);

        assertFalse(w1.equals(w2));
    }

    /**
     * Test the equals method to determine if two swords are alike with maximal constructor
     */
    @Test
    public void testWeaponEqualsMethodMaximalDifferentCanAttackOrder() {
        String name = "Sword #";
        String desc = "The 123890123 sword ever created.";
        int baseDamage = 13;
        int range = 1;
        int durability = 100;
        HashSet<ElementType> canAttack1 = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));
        HashSet<ElementType> canAttack2 = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));

        SimpleDamageModifier sdm1 = new SimpleDamageModifier("More...", 10, 2);
        SimpleDamageModifier sdm2 = new SimpleDamageModifier("More...", 10, 2);

        Weapon w1 = new Weapon(name, desc, baseDamage, range, canAttack1, durability, sdm1);
        Weapon w2 = new Weapon(name, desc, baseDamage, range, canAttack2, durability, sdm2);

        assertTrue(w1.equals(w2));
    }

    /**
     * Test the equals method to determine if two swords are alike with maximal constructor
     */
    @Test
    public void testWeaponEqualsMethodMaximalDifferentModifiersName() {
        String name = "Sword #";
        String desc = "The 123890123 sword ever created.";
        int baseDamage = 13;
        int range = 1;
        int durability = 100;
        HashSet<ElementType> canAttack1 = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));
        HashSet<ElementType> canAttack2 = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));

        SimpleDamageModifier sdm1 = new SimpleDamageModifier("More...", 10, 2);
        SimpleDamageModifier sdm2 = new SimpleDamageModifier("Less...", 10, 2);

        Weapon w1 = new Weapon(name, desc, baseDamage, range, canAttack1, durability, sdm1);
        Weapon w2 = new Weapon(name, desc, baseDamage, range, canAttack2, durability, sdm2);

        assertFalse(w1.equals(w2));
    }

    /**
     * Test the equals method to determine if two swords are alike with maximal constructor
     */
    @Test
    public void testWeaponEqualsMethodMaximalDifferentModifiersCost() {
        String name = "Sword #";
        String desc = "The 123890123 sword ever created.";
        int baseDamage = 13;
        int range = 1;
        int durability = 100;
        HashSet<ElementType> canAttack1 = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));
        HashSet<ElementType> canAttack2 = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));

        SimpleDamageModifier sdm1 = new SimpleDamageModifier("More...", 10, 2);
        SimpleDamageModifier sdm2 = new SimpleDamageModifier("More...", 20, 2);

        Weapon w1 = new Weapon(name, desc, baseDamage, range, canAttack1, durability, sdm1);
        Weapon w2 = new Weapon(name, desc, baseDamage, range, canAttack2, durability, sdm2);

        assertFalse(w1.equals(w2));
    }

    /**
     * Test the equals method to determine if two swords are alike with maximal constructor
     */
    @Test
    public void testWeaponEqualsMethodMaximalDifferentModifiersDamage() {
        String name = "Sword #";
        String desc = "The 123890123 sword ever created.";
        int baseDamage = 13;
        int range = 1;
        int durability = 100;
        HashSet<ElementType> canAttack1 = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));
        HashSet<ElementType> canAttack2 = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));

        SimpleDamageModifier sdm1 = new SimpleDamageModifier("More...", 10, 1);
        SimpleDamageModifier sdm2 = new SimpleDamageModifier("More...", 10, 2);

        Weapon w1 = new Weapon(name, desc, baseDamage, range, canAttack1, durability, sdm1);
        Weapon w2 = new Weapon(name, desc, baseDamage, range, canAttack2, durability, sdm2);

        assertFalse(w1.equals(w2));
    }

    /**
     * Test if the weapon can correctly determine if a target is attackable or not.
     */
    @Test
    public void testWeaponCanAttackTargetInList() {
        String name = "A Spear";
        String desc = "A long spear!";
        int baseDamage = 12;
        int range = 2;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));

        Weapon w = new Weapon(name, desc, baseDamage, range, canAttack);

        assertTrue(w.canAttack( ElementType.LAND ));

    }

    /**
     * Test if the weapon can correctly determine if a target is attackable or not.
     */
    @Test
    public void testWeaponCannotAttackTargetThatIsNotInList() {
        String name = "A Spear";
        String desc = "A long spear!";
        int baseDamage = 12;
        int range = 2;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND, ElementType.WATER));

        Weapon w = new Weapon(name, desc, baseDamage, range, canAttack);

        assertFalse(w.canAttack( ElementType.AIR ));

    }

    /**
     * Test if the weapon returns the correct total damage.
     */
    @Test
    public void testWeaponCorrectTotalDamageNoModifier() {
        String name = "A rusty Sword";
        String desc = "The sword is so rusty that you shuold really consider switching it...";
        int baseDamage = 2;
        int range = 1;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND));

        Weapon w = new Weapon(name, desc, baseDamage, range, canAttack);

        assertEquals(2, w.getTotalDamage());
    }

    /**
     * Test if the weapon returns the correct total damage with a modifier.
     */
    @Test
    public void testWeaponCorrectTotalDamageWithSimpleDamageModifier() {
        String name = "A rusty Sword";
        String desc = "The sword is rusty, but it has as magic coting that gives it SO MYCH MORE DAMAGE...";
        int baseDamage = 2;
        int range = 1;
        HashSet<ElementType> canAttack = new HashSet<>(Arrays.asList(ElementType.LAND));

        SimpleDamageModifier sdm = new SimpleDamageModifier("Magic Coting...", 2, 4);

        Weapon w = new Weapon(name, desc, baseDamage, range, canAttack, sdm);

        assertEquals(6, w.getTotalDamage());
    }


}