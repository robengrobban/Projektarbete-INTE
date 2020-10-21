package se.su.dsv.inte.projektarbete.characters;

public class CharacterStateController {
    private State currentState;
    private State neutralState;
    private State hostileState;
    private State deadState;
    private State chasingState;

    public CharacterStateController(StateType stateType) {
        neutralState = new NeutralState(this);
        hostileState = new HostileState(this);
        deadState = new DeadState(this);
        chasingState = new ChasingState(this);
        setCurrentState(stateType);
    }

    /**
     * Runs the Attack-method of the state stored in currentState
     */
    public void Attack(Character attacker, Character defender) {
        currentState.Attack(attacker, defender);
    }

    /**
     * Returns the current state of CharacterStateController
     * @return State, the current value of currentState
     */
    public State getCurrentState() {
        return currentState;
    }

    /**
     * Sets the value of currentState
     * @param stateType StateType, the state to be set
     */
    public void setCurrentState(StateType stateType) {
        if(stateType == null) {
            currentState = neutralState;
        }
        else {
            switch(stateType) {
                case HOSTILE: currentState = hostileState;
                break;
                case NEUTRAL: currentState = neutralState;
                break;
                case DEAD: currentState = deadState;
                break;
                case CHASING: currentState = chasingState;
            }
        }

    }
}
