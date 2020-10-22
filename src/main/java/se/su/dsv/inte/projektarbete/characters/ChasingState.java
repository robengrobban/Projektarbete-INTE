package se.su.dsv.inte.projektarbete.characters;

public class ChasingState implements State {
    CharacterStateController controller;
    public ChasingState(CharacterStateController controller) {
        this.controller = controller;
    }

    @Override
    public void attack(Character source, Character target) {
        if(source.isWithinRange(target, source.getWeapon().getRange())) {
            controller.setCurrentState(StateType.HOSTILE);
            controller.attack(source, target);
        }
        else if(!source.isWithinRange(target, source.getWeapon().getRange() + Character.VISIBILITY_RANGE)) {
            controller.setCurrentState(StateType.NEUTRAL);
        }
        else {
            //move character
        }
    }

    @Override
    public String toString() {
        return "Chasing";
    }
}
