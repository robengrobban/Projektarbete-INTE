package se.su.dsv.inte.projektarbete.player;

public class Elf extends Player{

    public Elf(String name) {
        super(name);
    }

    public Elf(String name, int health, int damage, int stamina, int staminaUsed, int defence, int attack, int experience, int level) {
        super(name, health, damage, stamina, staminaUsed, defence, attack, experience, level);
    }
}
