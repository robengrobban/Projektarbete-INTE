package se.su.dsv.inte.projektarbete.characters;

import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.ElementType;
import se.su.dsv.inte.projektarbete.weapon.Weapon;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class NonPlayerCharacterTest {
    @Test
    void hurtSwitchesState() {
        Weapon weapon = new Weapon("sword", "super shiny", 10, 2, new HashSet<>(Arrays.asList(ElementType.LAND)));
        NonPlayerCharacter c1 = new NonPlayerCharacter("Bobby", null, weapon, 2, 5, StateType.NEUTRAL);
        NonPlayerCharacter c2 = new NonPlayerCharacter("Bobby", null, weapon, 100, 5, StateType.NEUTRAL);
        CharacterStateController neutralController = new CharacterStateController(StateType.NEUTRAL);
        State deadState = new DeadState();
        State hostileState = new HostileState(neutralController);

        c1.hurt(5);
        System.out.println("HP: " + c1.getCurrentHealth());
        assertEquals(deadState.toString(), c1.getController().getCurrentState().toString());
        c2.hurt(5);
        System.out.println("HP: " + c2.getCurrentHealth());
        assertEquals(hostileState.toString(), c2.getController().getCurrentState().toString());
    }
}