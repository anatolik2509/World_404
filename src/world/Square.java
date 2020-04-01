package world;

import regions.Region;

public class Square {
    //координаты клетки
    private int x=0;
    private int y=0;

    private World place;

    public static final int WATER=0;
    public static final int GROUND=1;
    public static final int HILL=2;
    public static final int RIVER=3;

    private int type;
    private double height;

    private Resource resource;
    public Resource getResource() {
        return resource;
    }

    private Region region;
    private Environment environment;

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    //взаимодействия с клеткой

    public Square(int type, int height, World place){
        this.type=type;
        this.height = height;
        this.place = place;
        this.environment = new Environment(this);
    }

    public Square(int type, int x, int y, World place){
        this.type=type;
        this.height = 0;
        this.x = x;
        this.y = y;
        this.place = place;
    }

    public int getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public World getPlace() {
        return place;
    }

    @Override
    protected Square clone() throws CloneNotSupportedException {
        return (Square)super.clone();
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Environment getEnvironment() {
        return environment;
    }
}
