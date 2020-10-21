package se.su.dsv.inte.projektarbete.characters;

public class HostileState implements State {
    private CharacterStateController controller;

    public HostileState(CharacterStateController controller) {
        this.controller = controller;
    }

    @Override
    public void Attack(Character source, Character target) {
        //TO-DO if within range attack, else switch to CHASING
        target.damaged(source.CalculateDamage());
    }

    @Override
    public String toString() {
        return "Hostile";
    }
}
