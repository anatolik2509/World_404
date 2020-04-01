package items;

import items.util.DifferentItemsException;
import items.util.NegativeAmountException;
import items.util.Stackable;
import items.util.Usable;

public abstract class Material extends Item implements Stackable {

    private int amount;

    public Material(Quality quality, double itemWeight, int amount) {
        super(quality, itemWeight, Type.MATERIAL);
        this.amount = amount;
    }

    @Override
    public void add(Stackable another, int amount) {
        if(this.getClass() != another.getClass()){
            throw new DifferentItemsException("Can't add " + another.getClass() + " to " + this.getClass());
        }
        this.createItems(amount);
        another.deleteItems(amount);
    }

    @Override
    public void add(Stackable another) {
        add(another,another.getAmount());
    }

    @Override
    public void createItems(int amount) {
        if(amount < 0){
            throw new NegativeAmountException("Amount cant be " + amount);
        }
        this.amount += amount;
    }

    @Override
    public void deleteItems(int amount) {
        if(amount < 0){
            throw new NegativeAmountException("Amount cant be " + amount);
        }
        if(amount > this.getAmount()){
            throw new NegativeAmountException("Amount cant be " + (this.getAmount() - amount));
        }
        this.amount -= amount;
    }

    @Override
    public int getAmount() {
        return amount;
    }
}
