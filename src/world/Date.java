package world;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date(){
        this.day = 1;
        this.month = 1;
        this.year = 0;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void newDay(){
        day++;
        if(day > 30){
            day = 1;
            month++;
        }
        if(month > 12){
            month = 1;
            year++;
        }
    }
}
