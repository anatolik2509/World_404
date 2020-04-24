package items;

import items.clothes.Clothes;
import items.food.Food;
import items.material.Material;
import items.weapon.Weapon;

import java.util.Objects;

public abstract class Item {
    private static double itemWeight;
    private Quality quality;

    public enum Quality {
        AWFUL(0),
        VERY_BAD(1),
        BAD(2),
        NORMAL(3),
        GOOD(4),
        VERY_GOOD(5),
        GREAT(6);

        private int points;
        Quality(int points){
            this.points = points;
        }

        public int getPoints() {
            return points;
        }
    }

    public enum Type{
        FOOD,
        WEAPON,
        CLOTHES,
        MATERIAL,
        TOOL;
    }

    private static Type type;

    public Item(Quality quality, double itemWeight, Type type){
        this.quality = quality;
        Item.itemWeight = itemWeight;
        Item.type = type;
    }

    public abstract String getName();

    public double getItemWeight() {
        return itemWeight;
    }

    public Quality getQuality() {
        return quality;
    }

    public Type getType() {
        return type;
    }

    public boolean isFood(){
        return this instanceof Food;
    }

    public boolean isMaterial(){
        return this instanceof Material;
    }

    public boolean isClothes(){
        return this instanceof Clothes;
    }

    public boolean isWeapon(){
        return this instanceof Weapon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return quality == item.quality;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int hashCode() {
        return Objects.hash(quality, getClass());
    }
}
