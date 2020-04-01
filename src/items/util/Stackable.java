package items.util;

import items.Item;

public interface Stackable {

    public void add(Stackable another, int amount);

    public void add(Stackable another);

    public Stackable split(int amount);

    public void createItems(int amount);

    public void deleteItems(int amount);

    public int getAmount();

    public static void verifySplitting(int amount, int stackAmount){
        if(amount < 0) throw new NegativeAmountException("Amount cant be " + amount);
        if(stackAmount < amount) throw new NegativeAmountException("Amount cant be " + (stackAmount - amount));
    }
}
