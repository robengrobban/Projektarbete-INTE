package se.su.dsv.inte.projektarbete.characters;

import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.ElementType;
import se.su.dsv.inte.projektarbete.map.Map;
import se.su.dsv.inte.projektarbete.weapon.Weapon;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class DeadStateTest {
    @Test
    void attackThrowsException() {
        Map MAP = new Map(20, 20);
        Weapon WEAPON = new Weapon("sword", "super shiny", 10, 2, new HashSet<>(Arrays.asList(ElementType.LAND)));
        NonPlayerCharacter deadCharacter = new NonPlayerCharacter("Bob", null, WEAPON, StateType.DEAD);
        NonPlayerCharacter livingCharacter = new NonPlayerCharacter("Bobby", null, WEAPON, StateType.NEUTRAL);

        assertThrows(IllegalArgumentException.class, () -> {deadCharacter.getController().attack(deadCharacter, livingCharacter);});
    }
}