package se.su.dsv.inte.projektarbete.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagicianClassTest {

    @Test
    public void constructorSetsValuesCorrectly() {

        MagicianClass m = new MagicianClass();

        assertEquals(-5, m.getATTACK_MODIFIER());
        assertEquals(15, m.getMAGIC_ATTACK_MODIFIER());
        assertEquals(-5, m.getDEFENCE_MODIFIER());
        assertEquals(15, m.getMAGIC_DEFENCE_MODIFIER());
    }

}