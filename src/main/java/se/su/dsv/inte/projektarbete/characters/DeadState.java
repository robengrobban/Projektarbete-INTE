package se.su.dsv.inte.projektarbete.characters;

public class DeadState implements State {
    @Override
    public void attack(Character source, Character target) {
        throw new IllegalArgumentException("Source is dead!");
    }

    /*@Override
    public void defend(Character defender, Character attacker) {
        throw new IllegalArgumentException("Source is dead!");
    }*/

    @Override
    public String toString() {
        return "Dead";
    }
}
