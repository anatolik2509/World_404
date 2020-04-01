package items;

import social.Human;

public class SimplePants extends Clothes{
    public SimplePants(Quality quality) {
        super(quality, 1, 20);
    }

    @Override
    public String getName() {
        return "Simple pants";
    }

    @Override
    public void wear(Human target) {
        //TODO wearing
    }



}
