package se.su.dsv.inte.projektarbete.characters;

import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.ElementType;
import se.su.dsv.inte.projektarbete.map.Map;
import se.su.dsv.inte.projektarbete.weapon.Weapon;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class NeutralStateTest {

    @Test
    void neutralTransitionsToChasing() {
        CharacterStateController controller = new CharacterStateController(null);
        Map map = new Map(20, 20);
        Weapon weapon = new Weapon("sword", "super shiny", 10, 2, new HashSet<>(Arrays.asList(ElementType.LAND)));
        NonPlayerCharacter c1 = new NonPlayerCharacter("Bob", null, weapon, StateType.NEUTRAL);
        NonPlayerCharacter c2 = new NonPlayerCharacter("Bobby", null, weapon, StateType.HOSTILE);
        State chasingState = new ChasingState(controller);

        map.placeCharacter(c1, 1, 1);
        map.placeCharacter(c2, 5, 1);
        c1.getController().attack(c1, c2);

        assertEquals(chasingState.toString(), c1.getController().getCurrentState().toString());
    }

}