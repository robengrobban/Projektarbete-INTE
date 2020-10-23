package se.su.dsv.inte.projektarbete.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaceModifierTest {

    @Test
    void constructorSetsCorrectValues() {
        RaceModifier modifier = new RaceModifier(4, -15, 10, 2);

        assertEquals(4, modifier.getAttackModifier());
        assertEquals(-15, modifier.getMagicAttackModifier());
        assertEquals(10, modifier.getDefenceModifier());
        assertEquals(2, modifier.getMagicDefenceModifier());
    }

    @Test
    void modifyAttackReturnsCorrectValue() {
        RaceModifier modifier = new RaceModifier(10, -15, 10, 12);
        int baseAttack = 60;
        assertEquals(66, modifier.modifyAttack(baseAttack));
    }

    @Test
    void modifyMagicAttackReturnsCorrectValue() {
        RaceModifier modifier = new RaceModifier(16, -10, 17, 18);
        int baseMagicAttack = 70;
        assertEquals(63, modifier.modifyMagicAttack(baseMagicAttack));
    }

    @Test
    void modifyDefenceReturnsCorrectValue() {
        RaceModifier modifier = new RaceModifier(15, 22, 12, 14);
        int baseDefence = 65;
        assertEquals(72, modifier.modifyDefence(baseDefence));
    }

    @Test
    void modifyMagicDefenceReturnsCorrectValue() {
        RaceModifier modifier = new RaceModifier(18, 19, 11, 23);
        int baseMagicAttack = 78;
        assertEquals(95, modifier.modifyMagicDefence(baseMagicAttack));
    }
}