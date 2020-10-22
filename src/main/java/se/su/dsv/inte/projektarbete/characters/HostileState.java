package se.su.dsv.inte.projektarbete.characters;

public class HostileState implements State {
    private CharacterStateController controller;

    public HostileState(CharacterStateController controller) {
        this.controller = controller;
    }

    @Override
    public void attack(Character source, Character target) {
        //TO-DO if within range attack, else switch to CHASING
        if(source.isWithinRange(target, source.getWeapon().getRange())) {
            target.hurt(source.CalculateDamage());
        }
        else if(!source.isWithinRange(target, source.getWeapon().getRange()) && source.isWithinRange(target, source.getWeapon().getRange() + Character.VISIBILITY_RANGE)) {
            controller.setCurrentState(StateType.CHASING);
        }
        else {
            controller.setCurrentState(StateType.NEUTRAL);
        }
    }

    @Override
    public String toString() {
        return "Hostile";
    }
}
