package items.util;

import items.*;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;
    private int maxWeight;
    private double weight;

    public static final int DEFAULT_MAX_WEIGHT = 10000;

    public Inventory(int maxWeight){
        weight = 0;
        items = new ArrayList<>();
        this.maxWeight = maxWeight;
    }

    public Inventory(){
        this(DEFAULT_MAX_WEIGHT);
    }

    public void put(Item item){
        boolean flag = item.isStackable();
        if(!flag) {
            if (item.getItemWeight() + this.getWeight() > this.getMaxWeight()) {
                throw new InventoryOverweightException("Max weight is " +
                        this.getMaxWeight() +
                        ", putted " +
                        item.getItemWeight() +
                        this.getWeight());
            }
            weight += item.getItemWeight();
            items.add(item);
        }
        else {
            Stackable st = (Stackable) item;
            if (item.getItemWeight()*st.getAmount() + this.getWeight() > this.getMaxWeight()) {
                throw new InventoryOverweightException("Max weight is " +
                        this.getMaxWeight() +
                        ", putted " +
                        item.getItemWeight() +
                        this.getWeight());
            }
            weight += item.getItemWeight()*st.getAmount();
            for(int i = 0; i < items.size(); i++){
                if(items.get(i).equals(item)){
                    Stackable dest = (Stackable)items.get(i);
                    dest.add(st);
                    return;
                }
            }
            items.add(item);
        }
    }

    public Item get(Item item, int amount){
        boolean flag = item.isStackable();
        clear();
        if(flag) {
            for (Item i : items) {
                if (i.getClass() == item.getClass()) {
                    Stackable st = (Stackable)i;
                    return (Item)st.split(amount);
                }
            }
        }
        else{
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getClass() == item.getClass()) {
                   Item r = items.get(i);
                   items.remove(i);
                   return r;
                }
            }
        }
        throw new ItemDoesNotExistException("No " + item + " in this inventory");
    }

    public boolean hasItem(Item item){
        for(Item i : items){
            if(i.getClass() == item.getClass()){
                return true;
            }
        }
        return false;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public double getWeight() {
        return weight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    private void clear(){
        Item item;
        for (int j = 0; j < items.size(); j++) {
            item = items.get(j);
            boolean flag = item.isStackable();
            if(flag){
                Stackable st = (Stackable)item;
                if(st.getAmount() == 0){
                    items.remove(j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.put(new Sword(Item.Quality.NORMAL));
        inventory.put(new Stone(10));
        inventory.put(new Stone(20));
    }
}
