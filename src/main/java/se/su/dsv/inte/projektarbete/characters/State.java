package se.su.dsv.inte.projektarbete.characters;

public interface State {
    public void attack(Character source, Character target);

    public void defend(Character defender, Character attacker);
}
