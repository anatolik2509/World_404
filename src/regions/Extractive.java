package regions;

import items.Item;
import items.util.Stackable;

public interface Extractive {
    public Stackable extract(int amount);

    public Stackable extractiveItems();
}
