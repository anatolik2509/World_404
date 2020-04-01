package world;

public enum Resource {
    WOOD(0, 0, 1000),
    STONE(0, 0, 1000),
    IRON(0, 0, 1000),
    DIAMOND(1, 0, 1000),
    TEA(1, 30,10),
    GOLD(1, 0, 1000),
    SILVER(1, 0, 1000),
    EXOTIC_FRUITS(1, 40, 10),
    PORCELAIN(1, 0, 1000),
    GRAPE(1, 30, 10),
    FUR(1, -30, 20),
    ELEPHANTS(1, 30,10);

    private int type;
    private int temperature;
    private int temperatureBorders;
    public static final int BASIC=0;
    public static final int RARE=1;
    Resource(int type, int temperature, int temperatureBorders){
        this.type=type;
        this.temperature = temperature;
        this.temperatureBorders = temperatureBorders;
    }

    public int getType() {
        return type;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getTemperatureBorders() {
        return temperatureBorders;
    }
}
