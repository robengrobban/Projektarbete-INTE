package se.su.dsv.inte.projektarbete.characters;

import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.ElementType;
import se.su.dsv.inte.projektarbete.map.Map;
import se.su.dsv.inte.projektarbete.player.Elf;
import se.su.dsv.inte.projektarbete.player.Player;
import se.su.dsv.inte.projektarbete.weapon.Weapon;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class CharacterStateControllerTest {
    private static final CharacterStateController NEUTRAL_CONTROLLER = new CharacterStateController(StateType.NEUTRAL);
    private static final CharacterStateController HOSTILE_CONTROLLER = new CharacterStateController(StateType.HOSTILE);

    private static final State NEUTRAL_STATE = new NeutralState(NEUTRAL_CONTROLLER);
    private static final State HOSTILE_STATE = new HostileState(NEUTRAL_CONTROLLER);
    private static final State DEAD_STATE = new DeadState(NEUTRAL_CONTROLLER);
    private static final State CHASING_STATE = new ChasingState(NEUTRAL_CONTROLLER);

    private static final Map MAP = new Map(40, 40);
    private static final Weapon WEAPON = new Weapon("sword", "super shiny", 10, 2, new HashSet<>(Arrays.asList(ElementType.LAND)));
    private static final Player PLAYER = new Elf("Gob");

    @Test
    public void constructorSetsCorrectValues() {
        System.out.println("N: " + NEUTRAL_CONTROLLER.getCurrentState().toString());
        System.out.println("H: " + HOSTILE_CONTROLLER.getCurrentState().toString());
        assertEquals(NEUTRAL_STATE.toString(), NEUTRAL_CONTROLLER.getCurrentState().toString());
        assertEquals(HOSTILE_STATE.toString(), HOSTILE_CONTROLLER.getCurrentState().toString());
    }

    @Test
    public void constructorHandlesNullValues() {
        CharacterStateController nullController = new CharacterStateController(null);
        assertEquals(NEUTRAL_STATE.toString(), nullController.getCurrentState().toString());
    }

    @Test
    public void setsCorrectState() {
        NEUTRAL_CONTROLLER.setCurrentState(StateType.HOSTILE);
        assertEquals(HOSTILE_STATE.toString(), NEUTRAL_CONTROLLER.getCurrentState().toString());
        NEUTRAL_CONTROLLER.setCurrentState(StateType.NEUTRAL);
        assertEquals(NEUTRAL_STATE.toString(), NEUTRAL_CONTROLLER.getCurrentState().toString());
        NEUTRAL_CONTROLLER.setCurrentState(null);
        assertEquals(NEUTRAL_STATE.toString(), NEUTRAL_CONTROLLER.getCurrentState().toString());
        NEUTRAL_CONTROLLER.setCurrentState(StateType.DEAD);
        assertEquals(DEAD_STATE.toString(), NEUTRAL_CONTROLLER.getCurrentState().toString());
        NEUTRAL_CONTROLLER.setCurrentState(StateType.CHASING);
        assertEquals(CHASING_STATE.toString(), NEUTRAL_CONTROLLER.getCurrentState().toString());
    }

    //STATEMACHINE-tests
    //S1 - S2 - S4
    @Test
    void stateCase1() {
        NonPlayerCharacter enemy = new NonPlayerCharacter("Bob", null, WEAPON, StateType.NEUTRAL);
        PLAYER.setWeapon(WEAPON);
        MAP.placeCharacter(PLAYER, 1, 1);
        MAP.placeCharacter(enemy, 2, 2);
        assertEquals(NEUTRAL_STATE.toString(), enemy.getController().getCurrentState().toString());
        enemy.getController().defend(enemy, PLAYER);
        assertEquals(HOSTILE_STATE.toString(), enemy.getController().getCurrentState().toString());
        enemy.hurt(100);
        assertEquals(DEAD_STATE.toString(), enemy.getController().getCurrentState().toString());
    }

    //S1-S2-S3-S1-S2-S4
    @Test
    void stateCase2() {
        NonPlayerCharacter enemy = new NonPlayerCharacter("Bob", null, WEAPON, StateType.NEUTRAL);
        PLAYER.setWeapon(WEAPON);
        //Place 2 Characters, check if ENEMY spawns as Neutral
        MAP.placeCharacter(PLAYER, 1, 1);
        MAP.placeCharacter(enemy, 2, 2);
        assertEquals(NEUTRAL_STATE.toString(), enemy.getController().getCurrentState().toString());

        //PLAYER attacks ENEMY, check if ENEMY switches state to HOSTILE
        enemy.getController().defend(enemy, PLAYER);
        assertEquals(HOSTILE_STATE.toString(), enemy.getController().getCurrentState().toString());

        //PLAYER moves outside ENEMY Weapon.getRange(), but it stays within VISIBILITY_RANGE. Checks if ENEMY state switches to CHASING
        MAP.placeCharacter(PLAYER, 6, 2);
        enemy.getController().attack(enemy, PLAYER);
        assertEquals(CHASING_STATE.toString(), enemy.getController().getCurrentState().toString());

        //PLAYER moves outside ENEMY VISIBILITY_RANGE, checks if ENEMY changes state to NEUTRAL when trying to attack
        MAP.placeCharacter(PLAYER, 20, 1);
        enemy.getController().attack(enemy, PLAYER);
        assertEquals(NEUTRAL_STATE.toString(), enemy.getController().getCurrentState().toString());

        //PLAYER moves back to both ENEMY VISIBILITY_RANGE and Weapon.getRange(), then attacks ENEMY. Checks if ENEMY changes state to HOSTILE
        MAP.placeCharacter(PLAYER, 3, 2);
        enemy.getController().defend(enemy, PLAYER);
        assertEquals(HOSTILE_STATE.toString(), enemy.getController().getCurrentState().toString());

        //Kills ENEMY by lowering currentHealth to below 0, checks if ENEMY switches state to DEAD
        enemy.hurt(1000);
        assertEquals(DEAD_STATE.toString(), enemy.getController().getCurrentState().toString());
    }

    @Test
    void stateCase3() {
        NonPlayerCharacter enemy = new NonPlayerCharacter("Bob", null, WEAPON, StateType.NEUTRAL);
        PLAYER.setWeapon(WEAPON);

        //Place 2 Characters, check if ENEMY spawns as Neutral
        MAP.placeCharacter(PLAYER, 1, 1);
        MAP.placeCharacter(enemy, 2, 2);
        assertEquals(NEUTRAL_STATE.toString(), enemy.getController().getCurrentState().toString());

        //PLAYER attacks ENEMY, check if ENEMY switches state to HOSTILE
        enemy.getController().attack(PLAYER, enemy);
        assertEquals(HOSTILE_STATE.toString(), enemy.getController().getCurrentState().toString());

        //PLAYER moves outside ENEMY Weapon.getRange(), but it stays within VISIBILITY_RANGE. Checks if ENEMY state switches to CHASING
        MAP.placeCharacter(PLAYER, 6, 2);
        enemy.getController().attack(enemy, PLAYER);
        assertEquals(CHASING_STATE.toString(), enemy.getController().getCurrentState().toString());

        //Kills ENEMY by lowering currentHealth to below 0, checks if ENEMY switches state to DEAD
        enemy.hurt(1000);
        assertEquals(DEAD_STATE.toString(), enemy.getController().getCurrentState().toString());
    }

    @Test
    void stateCase4() {
        PLAYER.setWeapon(WEAPON);

        //Place 2 Characters, check if ENEMY spawns as Neutral
        MAP.placeCharacter(PLAYER, 1, 1);
        NonPlayerCharacter weakling = new NonPlayerCharacter("willy", null, null, 1, 100, StateType.NEUTRAL);
        MAP.placeCharacter(weakling, 1, 1);
        assertEquals(NEUTRAL_STATE.toString(), weakling.getController().getCurrentState().toString());

        weakling.getController().defend(weakling, PLAYER);

        assertEquals(DEAD_STATE.toString(), weakling.getController().getCurrentState().toString());
    }
}