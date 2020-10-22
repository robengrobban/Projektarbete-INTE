package se.su.dsv.inte.projektarbete.characters;

public class HostileState implements State {
    private CharacterStateController controller;

    public HostileState(CharacterStateController controller) {
        this.controller = controller;
    }

    @Override
    public void attack(Character source, Character target) {
        if(source.isWithinRange(target, source.getWeapon().getRange())) {
            System.out.println("Still on HOSTILE");
            target.hurt(source.CalculateDamage());
        }
        else if(!source.isWithinRange(target, source.getWeapon().getRange()) && source.isWithinRange(target, source.getWeapon().getRange() + Character.VISIBILITY_RANGE)) {
            System.out.println("Switching to CHASING");
            controller.setCurrentState(StateType.CHASING);
        }
        else {
            System.out.println("Switching to NEUTRAL");
            controller.setCurrentState(StateType.NEUTRAL);
        }
    }

    @Override
    public void defend(Character defender, Character attacker) {
        defender.hurt(attacker.CalculateDamage());
        if(!defender.isAlive()) {
            controller.setCurrentState(StateType.DEAD);
        }
    }

    @Override
    public String toString() {
        return "Hostile";
    }
}
