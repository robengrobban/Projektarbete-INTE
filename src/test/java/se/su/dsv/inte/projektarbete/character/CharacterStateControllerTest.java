package se.su.dsv.inte.projektarbete.character;

import org.junit.jupiter.api.Test;
import se.su.dsv.inte.projektarbete.characters.*;

import static org.junit.jupiter.api.Assertions.*;

class CharacterStateControllerTest {
    private static final State NEUTRAL_STATE = new NeutralState(new CharacterStateController(null));
    private static final State HOSTILE_STATE = new HostileState(new CharacterStateController(null));
    private static final CharacterStateController NEUTRAL_CONTROLLER = new CharacterStateController(StateType.NEUTRAL);
    private static final CharacterStateController HOSTILE_CONTROLLER = new CharacterStateController(StateType.HOSTILE);

    @Test
    public void constructorSetsCorrectValues() {
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
    }

}