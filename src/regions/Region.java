package regions;

import items.Item;
import items.util.Damageable;
import social.Faction;
import world.Square;

import java.util.ArrayList;

public abstract class Region implements Damageable {

    private int hp;
    private Faction owner;
    private Square place;
    private ArrayList<Item> items;
    private RegionProject regionProject;

    public Region(Square place, RegionProject regionProject) {
        this.place = place;
        items = new ArrayList<>();
        this.regionProject = regionProject;
    }

    @Override
    public void damage(double damage) {
        this.hp -= damage;
        if(hp < 0) hp = 0;
    }

    public Square getPlace() {
        return place;
    }

    public Faction getOwner() {
        return owner;
    }

    public void setOwner(Faction owner) {
        this.owner = owner;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public RegionProject getProject() {
        return regionProject;
    }

    public int getHp() {
        return hp;
    }

    public static boolean canBuilt(Square s){
        return true;
    }

    public abstract boolean canThisBuilt(Square s);
}
