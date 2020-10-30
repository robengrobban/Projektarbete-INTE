package se.su.dsv.inte.projektarbete.characters;

public interface State {
    void attack(Character source, Character target);

    //void defend(Character defender, Character attacker);
}
