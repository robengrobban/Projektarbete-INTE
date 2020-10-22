package se.su.dsv.inte.projektarbete.characters;

public class NeutralState implements State {
    private CharacterStateController controller;

    public NeutralState(CharacterStateController controller) {
        this.controller = controller;
    }

    @Override
    public void attack(Character source, Character target) {
        if(source.isWithinRange(target, source.getWeapon().getRange())) {
            controller.setCurrentState(StateType.HOSTILE);
            controller.attack(source, target);
        }
        else if(!source.isWithinRange(target, source.getWeapon().getRange()) && source.isWithinRange(target, source.getWeapon().getRange() + Character.VISIBILITY_RANGE)) {
            controller.setCurrentState(StateType.CHASING);
        }
    }
    @Override
    public String toString() {
        return "Neutral";
    }
}
