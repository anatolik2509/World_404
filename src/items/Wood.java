package items;


import items.util.NegativeAmountException;
import items.util.Stackable;

public class Wood extends Material{
    private static final int WEIGHT = 1;


    public Wood(int amount){
        super(Item.Quality.NORMAL, WEIGHT,amount);
    }

    @Override
    public Stackable split(int amount) {
        Stackable.verifySplitting(amount, this.getAmount());
        this.deleteItems(amount);
        return new Wood(amount);
    }

    @Override
    public String getName() {
        return "Wood";
    }


}
