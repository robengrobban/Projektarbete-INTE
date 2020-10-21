package se.su.dsv.inte.projektarbete.characters;

public class HostileState implements State {
    private CharacterStateController controller;

    public HostileState(CharacterStateController controller) {
        this.controller = controller;
    }

    @Override
    public void Attack(Character attacker, Character defender) {
        defender.hurt(attacker.CalculateDamage());
    }

    @Override
    public String toString() {
        return "Hostile";
    }
}
