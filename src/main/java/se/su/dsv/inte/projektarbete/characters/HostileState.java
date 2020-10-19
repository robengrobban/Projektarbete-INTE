package se.su.dsv.inte.projektarbete.characters;

public class HostileState implements State {
    private CharacterStateController controller;

    public HostileState(CharacterStateController controller) {
        this.controller = controller;
    }

    @Override
    public void Attack() {
        //TO-DO: implement attack mechanic
    }

    @Override
    public String toString() {
        return "Hostile";
    }
}
