package tools;

import java.util.List;

public class ScheduleForView {
    String date;
    List<String> times;

    public ScheduleForView(String date, List<String> times) {
        this.date = date;
        this.times = times;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<String> getTimes() {
        return times;
    }

    public void setTimes(List<String> times) {
        this.times = times;
    }
}