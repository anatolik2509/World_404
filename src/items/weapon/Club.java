package items.weapon;

import items.Item;
import regions.Region;
import social.Human;

public class Club extends Weapon{
    public Club(Item.Quality quality) {
        super(quality, 5, 20);
    }

    @Override
    public String getName() {
        return "Club";
    }

    @Override
    public void useToHuman(Human target) {
        //TODO human damage
    }

    @Override
    public void useToRegion(Region target) {
        //TODO region damage
    }

    @Override
    public void useToBuilding(Region target) {
        //TODO building damage
    }


}
