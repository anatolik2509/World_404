package world;

public class Time {
    private int hour;

    public Time(){
        hour = 0;
    }

    public Time(int hour){
        this.hour = hour;
    }

    public void increaseHour(){
        hour++;
        if(hour >= 24) hour = 0;
    }

    public int getHour() {
        return hour;
    }
}
