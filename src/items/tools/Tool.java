package items.tools;

import items.Item;
import items.util.Damageable;
import items.util.Usable;

public abstract class Tool extends Item implements Usable, Damageable {
    private double strength;

    private static double maxStrength;

    public Tool(Quality quality, double itemWeight, double maxStrength) {
        super(quality, itemWeight, Type.TOOL);
        this.maxStrength = maxStrength;
        this.strength = maxStrength;
    }

    public static double getMaxStrength() {
        return maxStrength;
    }

    @Override
    public void damage(double damage) {
        this.strength-=damage;
    }
}
