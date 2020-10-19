package se.su.dsv.inte.projektarbete.characters;

public class NeutralState implements State {
    private CharacterStateController controller;

    public NeutralState(CharacterStateController controller) {
        this.controller = controller;
    }

    /**
     * Switches state to Hostile and attacks 1 time
     */
    @Override
    public void Attack() {
        System.out.println("Switching state from Neutral to Hostile");
        controller.setCurrentState(controller.getHostileState());
        controller.Attack();
    }

    @Override
    public String toString() {
        return "Neutral";
    }
}
