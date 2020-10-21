package se.su.dsv.inte.projektarbete.characters;

public class ChasingState implements State {
    CharacterStateController controller;
    public ChasingState(CharacterStateController controller) {
        this.controller = controller;
    }

    @Override
    public void Attack(Character source, Character target) {
        //TO-DO
    }

    @Override
    public String toString() {
        return "Chasing";
    }
}
