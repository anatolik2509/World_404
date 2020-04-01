package world;

public class World {
    private Map map;
    private Time worldTime;
    private Date date;

    public Map getMap() {
        return map;
    }

    public Time getWorldTime() {
        return worldTime;
    }

    public Date getDate() {
        return date;
    }

    public World(int seed){
        map = new Map(seed, this);
        worldTime = new Time();
        date = new Date();
    }
}
