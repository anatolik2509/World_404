package buildings;

import items.Item;
import items.util.Damageable;
import regions.City;
import social.Human;

import java.util.ArrayList;

public abstract class Building implements Damageable {

    private double hp;
    private static ProjectBuilding project;

    private City place;
    private ArrayList<Item> items;
    private ArrayList<Human> humans;

    public Building(City region, ProjectBuilding projectBuilding){
        place = region;
        items = new ArrayList<>();
        humans = new ArrayList<>();
        this.project = projectBuilding;
    }

    @Override
    public void damage(double damage) {
        hp -= damage;
        if(hp < 0) hp = 0;
    }

    public City getPlace() {
        return place;
    }

    public double getHp() {
        return hp;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Human> getHumans() {
        return humans;
    }

    public static ProjectBuilding getProject() {
        return project;
    }
}
