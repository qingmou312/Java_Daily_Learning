package test2;

/**
 * Author:lidan
 * Created:2019/6/21
 */
public class Date {
    public int Year;
    public int  Month;
    public int Day;
    public int Hour;
    public int Minute;
    public int Second;

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public int getMonth() {
        return Month;
    }

    public void setMonth(int month) {
        Month = month;
    }

    public int getDay() {
        return Day;
    }

    public void setDay(int day) {
        Day = day;
    }

    public int getHour() {
        return Hour;
    }

    public void setHour(int hour) {
        Hour = hour;
    }

    public int getMinute() {
        return Minute;
    }

    public void setMinute(int minute) {
        Minute = minute;
    }

    public int getSecond() {
        return Second;
    }

    public void setSecond(int second) {
        Second = second;
    }

    @Override
    public String toString() {
        return "Date{" +
                "Year=" + Year +
                ", Month=" + Month +
                ", Day=" + Day +
                ", Hour=" + Hour +
                ", Minute=" + Minute +
                ", Second=" + Second +
                '}';
    }
}
