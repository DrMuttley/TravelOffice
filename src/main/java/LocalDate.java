package main.java;

public class LocalDate {

    private int year = 2001;
    private int mounth = 1;
    private int day = 1;

    public LocalDate(int year, int mounth, int day){

        this.year = year;
        this.mounth = mounth;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMounth() {
        return mounth;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMounth(int mounth) {
        this.mounth = mounth;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString(){

        String returnDate = this.year + ", " + this.mounth + ", " + this.day + " ";

        return returnDate;
    }

    public static LocalDate of(String stringDate){

        if(stringDate.length() == 10) {

            int year = Integer.parseInt(stringDate.substring(0, 4));
            int month = Integer.parseInt(stringDate.substring(5, 7));
            int day = Integer.parseInt(stringDate.substring(8, 10));

            return new LocalDate(year, month, day);
        }else{
            return null;
        }
    }
}
