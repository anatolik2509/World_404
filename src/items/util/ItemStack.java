package items.util;

import items.Item;

import java.util.Objects;

public class ItemStack {
    private Item item;
    private int size;
    private double stackWeight;

    public ItemStack(Item item, int size) {
        this.item = item;
        this.size = size;
        stackWeight = item.getItemWeight() * size;
    }

    public ItemStack(Item item){
        this(item, 0);
    }

    public boolean add(Item another, int amount){
        if(another.equals(item)){
            size += amount;
            stackWeight += item.getItemWeight() * amount;
            return true;
        }
        return false;
    }

    public ItemStack get(int amount){
        if(size < amount){
            size = 0;
            stackWeight = 0;
            return new ItemStack(item, size);
        }
        else {
            size -= amount;
            stackWeight -= item.getItemWeight() * amount;
            return new ItemStack(item, amount);
        }
    }

    public ItemStack get(){
        return get(size);
    }

    public boolean merge(ItemStack another){
        if(another.item.equals(item)){
            add(another.item, another.size);
            another.get(another.size);
            return true;
        }
        return false;
    }

    public Item getItem() {
        return item;
    }

    public int getSize() {
        return size;
    }

    public double getStackWeight() {
        return stackWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemStack itemStack = (ItemStack) o;
        return item.equals(itemStack.item);
    }

    public static ItemStack[] itemStacksByItems(Item ... items){
        ItemStack[] r = new ItemStack[items.length];
        for(int i = 0; i < r.length; i++){
            r[i] = new ItemStack(items[i]);
        }
        return r;
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }
}
