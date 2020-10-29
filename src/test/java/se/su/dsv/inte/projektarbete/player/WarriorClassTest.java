package se.su.dsv.inte.projektarbete.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorClassTest {

    @Test
    public void constructorSetsValuesCorrectly() {

        WarriorClass w = new WarriorClass();

        assertEquals(10, w.getATTACK_MODIFIER());
        assertEquals(0, w.getMAGIC_ATTACK_MODIFIER());
        assertEquals(10, w.getDEFENCE_MODIFIER());
        assertEquals(0, w.getMAGIC_DEFENCE_MODIFIER());
    }
}