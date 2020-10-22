package se.su.dsv.inte.projektarbete.characters;

public class HostileState implements State {
    private CharacterStateController controller;

    public HostileState(CharacterStateController controller) {
        this.controller = controller;
    }

    @Override
    public void Attack(Character source, Character target) {
        //TO-DO if within range attack, else switch to CHASING
        /*
        if(isWithinRange < 5) {
            target.damaged(source.CalculateDamage());
        }
        else if(isWithinRange > 5 && isWithinRange < 10) {
            controller.setCurrentState(StateType.CHASING);
        }
        else {
            controller.setCurrentState(StateType.NEUTRAL);
        }
         */

    }

    @Override
    public String toString() {
        return "Hostile";
    }
}
