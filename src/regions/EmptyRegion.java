package regions;

import world.Square;

public class EmptyRegion extends Region{
    public EmptyRegion(Square place){
        super(place, null);
    }

    @Override
    public boolean canThisBuilt(Square s) {
        return true;
    }
}
