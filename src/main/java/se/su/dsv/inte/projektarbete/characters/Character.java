package se.su.dsv.inte.projektarbete.characters;

public abstract class Character {
    private String name;
    private int health;
    private ThreatLevel threatLevel;

    public Character(String name, ThreatLevel threatLevel) {
        health = 100;
        this.name = name;
        this.threatLevel = threatLevel;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public ThreatLevel getThreatLevel() {
        return threatLevel;
    }

    public void setThreatLevel(ThreatLevel threatLevel) {
        this.threatLevel = threatLevel;
    }

    public void Attack() {

    }

    private int CalculateDamage() {
        int damage = 0;
        return damage;
    }

    /*public Item loot() {
        return Item;
    }*/
}
