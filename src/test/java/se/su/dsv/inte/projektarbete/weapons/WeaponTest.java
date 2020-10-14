package se.su.dsv.inte.projektarbete.weapons;

import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.ElementType;
import se.su.dsv.inte.projektarbete.weapons.modifiers.WeaponModifier;

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
        String name = "Svärd 1";
        String desc = "Det första svärdet som skapades.";
        int baseDamage = 10;
        int range = 1;
        ElementType[] canAttack = {ElementType.LAND, ElementType.WATER};
        int durability = 100;
        WeaponModifier modifer = null;

        Weapon w = new Weapon(name, desc, baseDamage, range, canAttack, durability, modifer);

        assertEquals(name, w.getName());
        assertEquals(desc, w.getDescription());
        assertEquals(baseDamage, w.getBaseDamage());
        assertEquals(range, w.getRange());
        assertEquals(canAttack, w.getCanAttackElementTypes());
        assertEquals(durability, w.getDurability());
        assertEquals(modifer, w.getModifier());

    }

    /**
     * Test the constructor with minimal correct values sent.
     */
    @Test
    public void testConstructorSetMinimalValues() {
        String name = "Svärd 2";
        String desc = "Det andra svärdet som skapades.";
        int baseDamage = 12;
        int range = 2;
        ElementType[] canAttack = {ElementType.LAND, ElementType.WATER};

        Weapon w = new Weapon(name, desc, baseDamage, range, canAttack);

        assertEquals(name, w.getName());
        assertEquals(desc, w.getDescription());
        assertEquals(baseDamage, w.getBaseDamage());
        assertEquals(range, w.getRange());
        assertEquals(canAttack, w.getCanAttackElementTypes());
        assertEquals(100, w.getDurability());
        assertEquals(null, w.getModifier());
    }

    /**
     * Test the constructor with minimal correct values plus durability.
     */
    @Test
    public void testConstructorSetMinimalValuesPlusDurability() {
        String name = "Svärd 3";
        String desc = "Det tredje svärdet som skapades.";
        int baseDamage = 12;
        int range = 2;
        ElementType[] canAttack = {ElementType.LAND, ElementType.WATER};
        int durability = 100;

        Weapon w = new Weapon(name, desc, baseDamage, range, canAttack, durability);

        assertEquals(name, w.getName());
        assertEquals(desc, w.getDescription());
        assertEquals(baseDamage, w.getBaseDamage());
        assertEquals(range, w.getRange());
        assertEquals(canAttack, w.getCanAttackElementTypes());
        assertEquals(durability, w.getDurability());
        assertEquals(null, w.getModifier());
    }

    /**
     * Test the constructor with minimal correct values plus weapon modifier.
     */
    @Test
    public void testConstructorSetMinimalValuesPlusWeaponModifier() {
        String name = "Svärd 4";
        String desc = "Det fjärde svärdet som skapades.";
        int baseDamage = 12;
        int range = 2;
        ElementType[] canAttack = {ElementType.LAND, ElementType.WATER};
        WeaponModifier modifier = null;

        Weapon w = new Weapon(name, desc, baseDamage, range, canAttack, modifier);

        assertEquals(name, w.getName());
        assertEquals(desc, w.getDescription());
        assertEquals(baseDamage, w.getBaseDamage());
        assertEquals(range, w.getRange());
        assertEquals(canAttack, w.getCanAttackElementTypes());
        assertEquals(100, w.getDurability());
        assertEquals(modifier, w.getModifier());
    }

    /**
     * Test the constructor with a base damage of 0.
     */
    @Test
    public void testConstructorBaseDamageEqualToZero() {
        String name = "Svärd 5";
        String desc = "Det femte svärdet som skapades.";
        int baseDamage = 0;
        int range = 3;
        ElementType[] canAttack = {ElementType.LAND, ElementType.WATER};

        assertThrows( IllegalArgumentException.class, () -> {
            new Weapon(name, desc, baseDamage, range, canAttack);
        });
    }

    /**
     * Test the constructor with a base damage of -1.
     */
    @Test
    public void testConstructorBaseDamageLessThanZero() {
        String name = "Svärd 6";
        String desc = "Det sjätte svärdet som skapades.";
        int baseDamage = -1;
        int range = 4;
        ElementType[] canAttack = {ElementType.LAND, ElementType.WATER};

        assertThrows(IllegalArgumentException.class, () -> {
            new Weapon(name, desc, baseDamage, range, canAttack);
        });
    }

    /**
     * Test the constructor with a range of 0.
     */
    @Test
    public void testConstructorRangeEqualToZero() {
        String name = "Svärd 7";
        String desc = "Det sjunde svärdet som skapades.";
        int baseDamage = 2;
        int range = 0;
        ElementType[] canAttack = {ElementType.LAND, ElementType.WATER};

        assertThrows( IllegalArgumentException.class, () -> {
            new Weapon(name, desc, baseDamage, range, canAttack);
        } );
    }

    /**
     * Test the constructor with a range of -1.
     */
    @Test
    public void testConstructorRangeLessThanZero() {
        String name = "Svärd 8";
        String desc = "Det åttonde svärdet som skapades.";
        int baseDamage = 3;
        int range = -1;
        ElementType[] canAttack = {ElementType.LAND, ElementType.WATER};

        assertThrows( IllegalArgumentException.class, () ->{
            new Weapon(name, desc, baseDamage, range, canAttack);
        } );
    }

    /**
     * Test the constructor with a durability of -1.
     */
    @Test
    public void testConstructorDurabilityLessThanZero() {
        String name = "Svärd 9";
        String desc = "Det nionde svärdet som skapades.";
        int baseDamage = 4;
        int range = 1;
        ElementType[] canAttack = {ElementType.LAND, ElementType.WATER};
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
        String name = "Svärd 10";
        String desc = "Det tionde svärdet som skapades.";
        int baseDamage = 10;
        int range = 4;
        ElementType[] canAttack = {ElementType.LAND, ElementType.WATER};
        int durability = 101;

        assertThrows( IllegalArgumentException.class, () -> {
            new Weapon(name, desc, baseDamage, range, canAttack, durability);
        } );
    }

    /**
     * Test the constrcutor with a can attack value of null.
     */
    @Test
    public void testConstructorCanAttackElementTypesNull() {
        String name = "Svärd 11";
        String desc = "Det elfte svärdet som skapades.";
        int baseDamage = 10;
        int range = 2;
        ElementType[] canAttack = null;

        assertThrows( IllegalArgumentException.class, () -> {
            new Weapon(name, desc, baseDamage, range, canAttack);
        });
    }


    @Test
    public void testConstructorCanAttackElementTypesEmpty() {
        String name = "Svärd 12";
        String desc = "Det tolfte svärdet som skapades";
        int baseDamage = 10;
        int range = 1;
        ElementType[] canAttack = {};

        assertThrows( IllegalArgumentException.class, () -> {
            new Weapon(name, desc, baseDamage, range, canAttack);
        } );
    }



}