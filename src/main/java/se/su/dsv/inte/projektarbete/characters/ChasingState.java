package se.su.dsv.inte.projektarbete.characters;

public class ChasingState implements State {
    CharacterStateController controller;
    public ChasingState(CharacterStateController controller) {
        this.controller = controller;
    }

    @Override
    public void attack(Character source, Character target) {
        if(source.isWithinRange(target, source.getWeapon().getRange())) {
            System.out.println("Switching to HOSTILE");
            controller.setCurrentState(StateType.HOSTILE);
            controller.attack(source, target);
        }
        else if(!source.isWithinRange(target, source.getWeapon().getRange() + Character.VISIBILITY_RANGE)) {
            System.out.println("Switching to NEUTRAL");
            controller.setCurrentState(StateType.NEUTRAL);
        }
    }

    @Override
    public void defend(Character defender, Character attacker) {
        defender.hurt(attacker.CalculateDamage());

        if (!defender.isAlive()){
            controller.setCurrentState(StateType.DEAD);
        }
    }

    @Override
    public String toString() {
        return "Chasing";
    }
}
