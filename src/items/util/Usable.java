package items.util;

import regions.Region;
import social.Human;

public interface Usable {
    default void useToHuman(Human target){}

    default void useToRegion(Region target){}

    default void useToBuilding(Region target){}
}
