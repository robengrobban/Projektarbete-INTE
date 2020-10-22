package se.su.dsv.inte.projektarbete.characters;

import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.ElementType;
import se.su.dsv.inte.projektarbete.weapon.Weapon;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class NonPlayerCharacterTest {
    private static final Weapon WEAPON = new Weapon("sword", "super shiny", 10, 2, new HashSet<>(Arrays.asList(ElementType.LAND)));
    private static final NonPlayerCharacter c1 = new NonPlayerCharacter("Bobby", null, WEAPON, 2, 5, StateType.NEUTRAL);
    private static final CharacterStateController NEUTRAL_CONTROLLER = new CharacterStateController(StateType.NEUTRAL);
    private static final State DEAD_STATE = new DeadState(NEUTRAL_CONTROLLER);

    @Test
    void hurtSwitchesState() {
        c1.hurt(5);
        System.out.println("HP: " + c1.getCurrentHealth());
        assertEquals(DEAD_STATE.toString(), c1.getController().getCurrentState().toString());
    }
}