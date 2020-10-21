package se.su.dsv.inte.projektarbete.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagicianClassTest {

    @Test
    public void constructorSetsValuesCorrectly() {

        MagicianClass m = new MagicianClass();

        assertEquals(-5, m.getAttackModifier());
        assertEquals(15, m.getMagicAttackModifier());
        assertEquals(-5, m.getDefenceModifier());
        assertEquals(15, m.getMagicDefenceModifier());
    }

}