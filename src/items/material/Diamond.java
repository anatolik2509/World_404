package items.material;

public class Diamond extends Material {
    public static final double WEIGHT = 0.1;

    public Diamond(){
        super(Quality.GOOD, WEIGHT);
    }

    @Override
    public String getName() {
        return "Diamond";
    }
}
