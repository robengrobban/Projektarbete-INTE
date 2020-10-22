package se.su.dsv.inte.projektarbete.characters;

public class NeutralState implements State {
    private CharacterStateController controller;

    public NeutralState(CharacterStateController controller) {
        this.controller = controller;
    }

    @Override
    public void defend(Character defender, Character attacker) {
        defender.hurt(attacker.CalculateDamage());
        if(defender.isAlive()) {
            controller.setCurrentState(StateType.HOSTILE);
        }
        else {
            controller.setCurrentState(StateType.DEAD);
        }
    }


    @Override
    public void attack(Character source, Character target) {
        if(source.isWithinRange(target, source.getWeapon().getRange())) {
            System.out.println("Switching to HOSTILE");
            controller.setCurrentState(StateType.HOSTILE);
            controller.attack(source, target);
        }
        else if(!source.isWithinRange(target, source.getWeapon().getRange()) && source.isWithinRange(target, source.getWeapon().getRange() + Character.VISIBILITY_RANGE)) {
            System.out.println("Switching to CHASING");
            controller.setCurrentState(StateType.CHASING);
        }
    }

    @Override
    public String toString() {
        return "Neutral";
    }
}
