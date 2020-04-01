package items;

import social.Human;

public class SimpleShirt extends Clothes{
    public SimpleShirt(Quality quality) {
        super(quality, 0.25, 20);
    }

    @Override
    public String getName() {
        return "Simple shirt";
    }

    @Override
    public void wear(Human target) {
        //TODO wearing
    }



}
