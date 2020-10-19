package se.su.dsv.inte.projektarbete.characters;

public class CharacterStateController {
    private State currentState;
    private State neturalState;
    private State hostileState;

    public CharacterStateController(State currentState) {
        this.currentState = currentState;
        neturalState = new NeutralState(this);
        hostileState = new HostileState(this);

        //if input state was null, set currentState to default Neutral
        if(currentState == null) {
            this.currentState = new NeutralState(this);
        }
    }

    /**
     * Runs the Attack-method of the state stored in currentState
     */
    public void Attack() {
        currentState.Attack();
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
     * @param currentState State, the state to be set
     */
    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    /**
     * Returns a HostileState in the form of State
     * @return State, instance of HostileState
     */
    public State getHostileState() {
        return hostileState;
    }

    /**
     * Returns a NeutralState in the form of State
     * @return State, instance of HostileState
     */
    public State getNeturalState() {
        return neturalState;
    }
}
