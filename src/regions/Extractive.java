package regions;

import items.Item;
import items.util.ItemStack;

public interface Extractive {
    public ItemStack extract(int amount);

    public Item extractiveItems();
}
