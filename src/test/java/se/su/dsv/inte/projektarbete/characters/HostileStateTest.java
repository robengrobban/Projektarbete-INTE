package se.su.dsv.inte.projektarbete.characters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.ElementType;
import se.su.dsv.inte.projektarbete.map.Map;
import se.su.dsv.inte.projektarbete.weapon.Weapon;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class HostileStateTest {
    private CharacterStateController neutralController;
    private Map map;
    private Weapon weapon;
    private NonPlayerCharacter c1;
    private NonPlayerCharacter c2;

    @BeforeEach
    void testSetup() {
        neutralController = new CharacterStateController(StateType.NEUTRAL);
        map = new Map(30, 30);
        weapon = new Weapon("sword", "super shiny", 10, 2, new HashSet<>(Arrays.asList(ElementType.LAND)));
        c1 = new NonPlayerCharacter("Bob", null, weapon, StateType.NEUTRAL);
        c2 = new NonPlayerCharacter("Bobby", null, weapon, StateType.NEUTRAL);
    }

    @Test
    void attackWithinRange() {
        State hostileState = new HostileState(neutralController);
        map.placeCharacter(c1, 1, 1);
        map.placeCharacter(c2, 2, 2);
        c1.getController().attack(c1, c2);
        assertEquals(hostileState.toString(), c1.getController().getCurrentState().toString());
    }

    @Test
    void attackWithoutRangeTriggersChase() {
        State chasingState = new ChasingState(neutralController);
        map.placeCharacter(c1, 1, 1);
        map.placeCharacter(c2, 4, 4);
        c1.getController().attack(c1, c2);
        assertEquals(chasingState.toString(), c1.getController().getCurrentState().toString());
    }

    @Test
    void attackWithoutVisibilityTriggersNeutral() {
        State neutralState = new NeutralState(neutralController);
        map.placeCharacter(c1, 1, 1);
        map.placeCharacter(c2, 7, 7);
        c1.getController().attack(c1, c2);
        assertEquals(neutralState.toString(), c1.getController().getCurrentState().toString());
    }

    @Test
    void defendRemovesHealth() {

    }

    @Test
    void defendSwitchesToDead() {

    }
}