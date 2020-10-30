package se.su.dsv.inte.projektarbete.characters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.ElementType;
import se.su.dsv.inte.projektarbete.map.Map;
import se.su.dsv.inte.projektarbete.weapon.Weapon;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class ChasingStateTest {
    CharacterStateController controller;
    Map map;
    Weapon weapon;
    NonPlayerCharacter c1;
    NonPlayerCharacter c2;
    @BeforeEach
    void testSetup() {
        controller = new CharacterStateController(null);
        map = new Map(20, 20);
        weapon = new Weapon("sword", "super shiny", 10, 2, new HashSet<>(Arrays.asList(ElementType.LAND)));
    }

    @Test
    void chasingTransitionsToHostile() {
        NonPlayerCharacter c1 = new NonPlayerCharacter("Bob", null, weapon, StateType.CHASING);
        NonPlayerCharacter c2 = new NonPlayerCharacter("Bobby", null, weapon, StateType.HOSTILE);
        State hostileState = new HostileState(controller);

        map.placeCharacter(c1, 1, 1);
        map.placeCharacter(c2, 1, 1);
        c1.getController().attack(c1, c2);

        assertEquals(hostileState.toString(), c1.getController().getCurrentState().toString());
    }

    @Test
    void chasingTransitionsToNeutral() {
        NonPlayerCharacter c1 = new NonPlayerCharacter("Bob", null, weapon, StateType.CHASING);
        NonPlayerCharacter c2 = new NonPlayerCharacter("Bobby", null, weapon, StateType.HOSTILE);
        State neutralState = new NeutralState(controller);

        map.placeCharacter(c1, 1, 1);
        map.placeCharacter(c2, 15, 15);
        c1.getController().attack(c1, c2);

        assertEquals(neutralState.toString(), c1.getController().getCurrentState().toString());
    }

    @Test
    void chasingKeepsChasing() {
        NonPlayerCharacter c1 = new NonPlayerCharacter("Bob", null, weapon, StateType.CHASING);
        NonPlayerCharacter c2 = new NonPlayerCharacter("Bobby", null, weapon, StateType.HOSTILE);
        State chasingState = new ChasingState(controller);

        map.placeCharacter(c1, 1, 1);
        map.placeCharacter(c2, 4, 1);
        c1.getController().attack(c1, c2);

        assertEquals(chasingState.toString(), c1.getController().getCurrentState().toString());
    }

    @Test
    void defendRemovesHealth() {
        NonPlayerCharacter c1 = new NonPlayerCharacter("bob", null, weapon, 100, 100, StateType.CHASING);
        NonPlayerCharacter c2 = new NonPlayerCharacter("Bobby", null, weapon, StateType.HOSTILE);
        int startingHealth = c1.getCurrentHealth();
        c1.hurt(c2.calculateDamage());
        int currentHealth = c1.getCurrentHealth();
        assertTrue(currentHealth < startingHealth);
    }

    @Test
    void defendSwitchesToDead() {
        NonPlayerCharacter weakling = new NonPlayerCharacter("bob", null, weapon, 1, 100, StateType.CHASING);
        NonPlayerCharacter c2 = new NonPlayerCharacter("Bobby", null, weapon, StateType.HOSTILE);
        State deadState = new DeadState();

        weakling.hurt(c2.calculateDamage());
        assertEquals(deadState.toString(), weakling.getController().getCurrentState().toString());
    }
}