package items.material;

import items.Item;

public abstract class Material extends Item{

    public Material(Quality quality, double itemWeight) {
        super(quality, itemWeight, Type.MATERIAL);
    }

}
