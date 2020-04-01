package items;
import items.util.NegativeAmountException;
import items.util.Stackable;
import items.util.Usable;
import social.Human;

public class Meat extends Food {

    private static final int WEIGHT = 1;



    public Meat(int amount){
        super(Quality.VERY_BAD, WEIGHT, amount);
    }

    @Override
    public Stackable split(int amount) {
        Stackable.verifySplitting(amount, this.getAmount());
        this.deleteItems(amount);
        return new Meat(amount);
    }

    @Override
    public void useToHuman(Human target) {
        //TODO human feeding
    }

    @Override
    public String getName() {
        return "Meat";
    }


}
