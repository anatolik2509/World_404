package regions;

import items.Item;
import items.food.ExoticFruits;
import items.food.Food;
import items.food.Grape;
import items.food.Wheat;
import items.material.Tea;
import items.util.ItemStack;
import world.Square;

public class Farm extends Region implements Extractive {

    public enum AVAILABLE_PLANTS{
        //TODO new plants;
        WHEAT(new Wheat()),
        DEFAULT(null);

        private Item plant;

        AVAILABLE_PLANTS(Item plant){
            this.plant = plant;
        }

        public Item getPlant() {
            return plant;
        }
    }

    public Farm(Square place){
        this(place, new Wheat());
        if(getSquarePlant() != null){
            setPlant(AVAILABLE_PLANTS.DEFAULT);
        }
    }

    public Farm(Square place, Item plant){
        super(place, RegionProject.FARM);
        this.plant = plant;
    }

    private Item plant;

    @Override
    public ItemStack extract(int amount) {
        if(plant != null) {
            ItemStack s = new ItemStack(plant, amount);
            return s;
        }
        return null;
    }

    @Override
    public Item extractiveItems() {
        return getPlant();
    }

    public Item getSquarePlant(){
        Square s = this.getPlace();
        switch (s.getResource()){
            case TEA:
                return new Tea();
            case GRAPE:
                return new Grape();
            case EXOTIC_FRUITS:
                return new ExoticFruits();
            default:
                return null;
        }
    }

    public Item getPlant() {
        return plant;
    }

    public void setPlant(AVAILABLE_PLANTS plant) {
        if(plant == AVAILABLE_PLANTS.DEFAULT){
            this.plant = getSquarePlant();
        }
        else {
            this.plant = plant.getPlant();
        }
    }

    public static boolean canBuilt(Square s){
        if(s.getType() == Square.WATER) return false;
        if(s.getType() == Square.HILL) return false;
        return true;
    }

    @Override
    public boolean canThisBuilt(Square s) {
        return canBuilt(s);
    }
}
