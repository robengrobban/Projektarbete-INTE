package se.su.dsv.inte.projektarbete.characters;

import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.ElementType;
import se.su.dsv.inte.projektarbete.map.Map;
import se.su.dsv.inte.projektarbete.weapon.Weapon;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class HostileStateTest {
    private static final CharacterStateController NEUTRAL_CONTROLLER = new CharacterStateController(StateType.NEUTRAL);
    private static final State NEUTRAL_STATE = new NeutralState(NEUTRAL_CONTROLLER);
    private static final State HOSTILE_STATE = new HostileState(NEUTRAL_CONTROLLER);
    private static final State DEAD_STATE = new DeadState(NEUTRAL_CONTROLLER);
    private static final State CHASING_STATE = new ChasingState(NEUTRAL_CONTROLLER);
    private static final Map MAP = new Map(20, 20);
    private static final Weapon WEAPON = new Weapon("sword", "super shiny", 10, 2, new HashSet<>(Arrays.asList(ElementType.LAND)));
    private static final NonPlayerCharacter c1 = new NonPlayerCharacter("Bob", null, WEAPON, StateType.NEUTRAL);
    private static final NonPlayerCharacter c2 = new NonPlayerCharacter("Bobby", null, WEAPON, StateType.NEUTRAL);

    @Test
    void attackWithinRange() {
        MAP.placeCharacter(c1, 1, 1);
        MAP.placeCharacter(c2, 2, 2);
        c1.getController().attack(c1, c2);
        assertEquals(HOSTILE_STATE.toString(), c1.getController().getCurrentState().toString());
    }

    @Test
    void attackWithoutRangeTriggersChase() {
        MAP.placeCharacter(c1, 1, 1);
        MAP.placeCharacter(c2, 4, 4);
        c1.getController().attack(c1, c2);
        assertEquals(CHASING_STATE.toString(), c1.getController().getCurrentState().toString());
    }

    @Test
    void attackWithoutVisibilityTriggersNeutral() {
        MAP.placeCharacter(c1, 1, 1);
        MAP.placeCharacter(c2, 7, 7);
        c1.getController().attack(c1, c2);
        assertEquals(NEUTRAL_STATE.toString(), c1.getController().getCurrentState().toString());
    }
}