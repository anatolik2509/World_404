package items.util;

import items.*;
import items.material.Stone;
import items.weapon.Sword;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class Inventory {
    private HashSet<ItemStack> items;
    private int maxWeight;
    private double weight;

    public static final int DEFAULT_MAX_WEIGHT = 10000;

    public Inventory(int maxWeight){
        weight = 0;
        items = new HashSet<>();
        this.maxWeight = maxWeight;
    }

    public Inventory(){
        this(DEFAULT_MAX_WEIGHT);
    }

    public boolean put(ItemStack item){
        return put(item, item.getSize());
    }

    public boolean put(ItemStack item, int amount){
        if(items.contains(item)){
            for(ItemStack i : items){
                if(i.hashCode() == item.hashCode()){
                    if(i.equals(item)){
                        if(weight + item.getItem().getItemWeight() * amount > maxWeight){
                            return false;
                        }

                        boolean flag = i.merge(item.get(amount));
                        if(flag){
                            weight += item.getItem().getItemWeight() * amount;
                        }
                        return flag;
                    }
                }
            }
        }
        boolean flag = items.add(item.get(amount));
        if(flag){
            weight += item.getItem().getItemWeight() * amount;
        }
        return flag;
    }

    public ItemStack get(Item item, int amount){
        ItemStack s = new ItemStack(item);
        if(items.contains(s)){
            for(ItemStack i : items){
                if(i.hashCode() == s.hashCode()){
                    if(i.equals(s)){
                        s.merge(i.get(amount));
                        weight -= s.getStackWeight();
                        return s;
                    }
                }
            }
        }
        return null;
    }

    public boolean hasItem(Item item){
        return items.contains(new ItemStack(item));
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
        items.clear();
        weight = 0;
    }
}
