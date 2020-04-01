package world;

public class Environment {
    private Square place;

    public Environment(Square place){
        this.place = place;
    }

    public int getLocalTimeHour(){
        int worldHour = place.getPlace().getWorldTime().getHour();
        int worldWidth = Map.WIDTH;
        return  worldHour + 24 * (place.getX() / worldWidth);
    }

    //TODO temperature


}
