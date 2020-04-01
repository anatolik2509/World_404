package items;

import items.util.Damageable;
import items.util.Usable;

public abstract class Weapon extends Item implements Usable, Damageable {
    private double strength;

    private static double maxStrength;

    public Weapon(Quality quality, double itemWeight, double maxStrength) {
        super(quality, itemWeight, Type.WEAPON);
        this.strength = maxStrength;
        this.maxStrength = maxStrength;
    }

    public double getStrength() {
        return strength;
    }

    public static double getMaxStrength() {
        return maxStrength;
    }

    @Override
    public void damage(double damage){
        this.strength-=damage;
        if(strength < 0) strength = 0;
    }
}
