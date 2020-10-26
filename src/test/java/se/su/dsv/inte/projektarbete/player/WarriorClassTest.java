package se.su.dsv.inte.projektarbete.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorClassTest {

    @Test
    public void constructorSetsValuesCorrectly() {

        WarriorClass w = new WarriorClass();

        assertEquals(10, w.getAttackModifier());
        assertEquals(0, w.getMagicAttackModifier());
        assertEquals(10, w.getDefenceModifier());
        assertEquals(0, w.getMAGIC_DEFENCE_MODIFIER());
    }
}