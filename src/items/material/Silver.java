package items.material;

public class Silver extends Material {
    public static final double WEIGHT = 0.1;

    public Silver(){
        super(Quality.GOOD, WEIGHT);
    }

    @Override
    public String getName() {
        return "Silver";
    }
}
