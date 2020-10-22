package se.su.dsv.inte.projektarbete.characters;

public class NeutralState implements State {
    private CharacterStateController controller;

    public NeutralState(CharacterStateController controller) {
        this.controller = controller;
    }

    @Override
    public void Attack(Character source, Character target) {
        /*
        if(isWithinRange < 5) {
            controller.setCurrentState(StateType.HOSTILE);
            controller.Attack(source, target);
        }
        else if(isWithinRange > 5 && isWithinRange < 10) {
            controller.setCurrentState(StateType.CHASING);
        }
        else {
            System.out.println("Target is too far away. Source remains in neutral.");
        }
        */
    }

    @Override
    public String toString() {
        return "Neutral";
    }
}
