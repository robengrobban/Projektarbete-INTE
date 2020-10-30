package se.su.dsv.inte.projektarbete.characters;

import org.junit.jupiter.api.BeforeEach;
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
    private CharacterStateController neutralController;

    @BeforeEach
    public void testSetup() {
        neutralController = new CharacterStateController(StateType.NEUTRAL);
    }

    @Test
    public void constructorSetsCorrectValues() {
        CharacterStateController hostileController = new CharacterStateController(StateType.HOSTILE);
        State neutralState = new NeutralState(neutralController);
        State hostileState = new HostileState(neutralController);

        assertEquals(neutralState.toString(), neutralController.getCurrentState().toString());
        assertEquals(hostileState.toString(), hostileController.getCurrentState().toString());
    }

    @Test
    public void constructorHandlesNullValues() {
        State neutralState = new NeutralState(neutralController);
        CharacterStateController nullController = new CharacterStateController(null);

        assertEquals(neutralState.toString(), nullController.getCurrentState().toString());
    }

    @Test
    public void setsCorrectState() {
        State neutralState = new NeutralState(neutralController);
        State hostileState = new HostileState(neutralController);
        State deadState = new DeadState();
        State chasingState = new ChasingState(neutralController);

        neutralController.setCurrentState(StateType.HOSTILE);
        assertEquals(hostileState.toString(), neutralController.getCurrentState().toString());
        neutralController.setCurrentState(StateType.NEUTRAL);
        assertEquals(neutralState.toString(), neutralController.getCurrentState().toString());
        neutralController.setCurrentState(null);
        assertEquals(neutralState.toString(), neutralController.getCurrentState().toString());
        neutralController.setCurrentState(StateType.DEAD);
        assertEquals(deadState.toString(), neutralController.getCurrentState().toString());
        neutralController.setCurrentState(StateType.CHASING);
        assertEquals(chasingState.toString(), neutralController.getCurrentState().toString());
    }

    //STATEMACHINE-tests
    //S1 - S2 - S4
    @Test
    void stateCase1() {
        State neutralState = new NeutralState(neutralController);
        State hostileState = new HostileState(neutralController);
        State deadState = new DeadState();
        Weapon weapon = new Weapon("sword", "super shiny", 10, 2, new HashSet<>(Arrays.asList(ElementType.LAND)));
        NonPlayerCharacter enemy = new NonPlayerCharacter("Bob", null, weapon, StateType.NEUTRAL);
        Player player = new Elf("Gob");
        player.setWeapon(weapon);
        Map map = new Map(40, 40);

        map.placeCharacter(player, 1, 1);
        map.placeCharacter(enemy, 2, 2);

        assertEquals(neutralState.toString(), enemy.getController().getCurrentState().toString());

        enemy.hurt(player.calculateDamage());

        assertEquals(hostileState.toString(), enemy.getController().getCurrentState().toString());

        while(enemy.getCurrentHealth() > 0) {
            enemy.hurt(player.calculateDamage());
        }

        assertEquals(deadState.toString(), enemy.getController().getCurrentState().toString());
    }

    //S1-S2-S3-S1-S2-S4
    @Test
    void stateCase2() {
        State neutralState = new NeutralState(neutralController);
        State hostileState = new HostileState(neutralController);
        State deadState = new DeadState();
        State chasingState = new ChasingState(neutralController);
        Weapon weapon = new Weapon("sword", "super shiny", 10, 2, new HashSet<>(Arrays.asList(ElementType.LAND)));
        NonPlayerCharacter enemy = new NonPlayerCharacter("Bob", null, weapon, StateType.NEUTRAL);
        Player player = new Elf("Gob");
        player.setWeapon(weapon);
        Map map = new Map(40, 40);

        //Place 2 Characters, check if ENEMY spawns as Neutral
        map.placeCharacter(player, 1, 1);
        map.placeCharacter(enemy, 2, 2);
        assertEquals(neutralState.toString(), enemy.getController().getCurrentState().toString());

        //PLAYER attacks ENEMY, check if ENEMY switches state to HOSTILE
        enemy.hurt(player.calculateDamage());
        assertEquals(hostileState.toString(), enemy.getController().getCurrentState().toString());

        //PLAYER moves outside ENEMY Weapon.getRange(), but it stays within VISIBILITY_RANGE. Checks if ENEMY state switches to CHASING
        map.placeCharacter(player, 6, 2);
        enemy.getController().attack(enemy, player);
        assertEquals(chasingState.toString(), enemy.getController().getCurrentState().toString());

        //PLAYER moves outside ENEMY VISIBILITY_RANGE, checks if ENEMY changes state to NEUTRAL when trying to attack
        map.placeCharacter(player, 20, 1);
        enemy.getController().attack(enemy, player);
        assertEquals(neutralState.toString(), enemy.getController().getCurrentState().toString());

        //PLAYER moves back to both ENEMY VISIBILITY_RANGE and Weapon.getRange(), then attacks ENEMY. Checks if ENEMY changes state to HOSTILE
        map.placeCharacter(player, 3, 2);
        enemy.hurt(player.calculateDamage());
        assertEquals(hostileState.toString(), enemy.getController().getCurrentState().toString());

        //Kills ENEMY by lowering currentHealth to below 0, checks if ENEMY switches state to DEAD
        enemy.hurt(1000);
        assertEquals(deadState.toString(), enemy.getController().getCurrentState().toString());
    }

    @Test
    void stateCase3() {
        State neutralState = new NeutralState(neutralController);
        State hostileState = new HostileState(neutralController);
        State deadState = new DeadState();
        State chasingState = new ChasingState(neutralController);
        Weapon weapon = new Weapon("sword", "super shiny", 10, 2, new HashSet<>(Arrays.asList(ElementType.LAND)));
        NonPlayerCharacter enemy = new NonPlayerCharacter("Bob", null, weapon, StateType.NEUTRAL);
        Player player = new Elf("Gob");
        player.setWeapon(weapon);
        Map map = new Map(40, 40);

        //Place 2 Characters, check if ENEMY spawns as Neutral
        map.placeCharacter(player, 1, 1);
        map.placeCharacter(enemy, 2, 2);
        assertEquals(neutralState.toString(), enemy.getController().getCurrentState().toString());

        //PLAYER attacks ENEMY, check if ENEMY switches state to HOSTILE
        enemy.getController().attack(player, enemy);
        assertEquals(hostileState.toString(), enemy.getController().getCurrentState().toString());

        //PLAYER moves outside ENEMY Weapon.getRange(), but it stays within VISIBILITY_RANGE. Checks if ENEMY state switches to CHASING
        map.placeCharacter(player, 6, 2);
        enemy.getController().attack(enemy, player);
        assertEquals(chasingState.toString(), enemy.getController().getCurrentState().toString());

        //Kills ENEMY by lowering currentHealth to below 0, checks if ENEMY switches state to DEAD
        enemy.hurt(1000);
        assertEquals(deadState.toString(), enemy.getController().getCurrentState().toString());
    }

    @Test
    void stateCase4() {
        State neutralState = new NeutralState(neutralController);
        State deadState = new DeadState();
        Weapon weapon = new Weapon("sword", "super shiny", 10, 2, new HashSet<>(Arrays.asList(ElementType.LAND)));
        Player player = new Elf("Gob");
        player.setWeapon(weapon);
        Map map = new Map(40, 40);

        //Place 2 Characters, check if ENEMY spawns as Neutral
        map.placeCharacter(player, 1, 1);
        NonPlayerCharacter weakling = new NonPlayerCharacter("willy", null, null, 1, 100, StateType.NEUTRAL);
        map.placeCharacter(weakling, 1, 1);
        assertEquals(neutralState.toString(), weakling.getController().getCurrentState().toString());

        weakling.hurt(player.calculateDamage());

        assertEquals(deadState.toString(), weakling.getController().getCurrentState().toString());
    }
}