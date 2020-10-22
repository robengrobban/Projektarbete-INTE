package se.su.dsv.inte.projektarbete.characters;

public class ChasingState implements State {
    CharacterStateController controller;
    public ChasingState(CharacterStateController controller) {
        this.controller = controller;
    }

    @Override
    public void Attack(Character source, Character target) {
        //TO-DO
        /*
        if(isWithinRange < 5) {
            controller.setCurrentState(StateType.HOSTILE);
            controller.Attack(source, target);
        }
        else if(isWithinRange > 10) {
            controller.setCurrentState(StateType.NEUTRAL);
        }
        else {
            //move character
        }
        */
    }

    @Override
    public String toString() {
        return "Chasing";
    }
}
