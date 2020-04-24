package items.material;

public class Fur extends Material {
    public static final double WEIGHT = 0.1;

    public Fur(){
        super(Quality.GOOD, WEIGHT);
    }

    @Override
    public String getName() {
        return "Fur";
    }
}
