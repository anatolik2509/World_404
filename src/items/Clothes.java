package items;

import items.util.Damageable;
import items.util.Wearable;

public abstract class Clothes extends Item implements Wearable, Damageable {
    private double strength;

    private static double maxStrength;

    public Clothes(Quality quality, double itemWeight, double maxStrength) {
        super(quality, itemWeight, Type.CLOTHES);
        this.maxStrength = maxStrength;
        this.strength = maxStrength;
    }

    @Override
    public void damage(double damage) {
        this.strength-=damage;
    }
}
