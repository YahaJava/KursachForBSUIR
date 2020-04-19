package model.schedule;

import tools.DateService;
import tools.ScheduleForView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


public class ScheduleService {

    private DateService dateService = new DateService();

    public List<ScheduleForView> filter(List<Schedule> schedule) {
        long currentDate = dateService.getCurrentDate();
        schedule = schedule.stream().filter(schedule1 -> {
            long date = dateService.getIntDate(schedule1.getDay() + " " + schedule1.getTime());
            return date > currentDate;
        }).collect(Collectors.toList());
        return getScheduleForView(schedule);
    }

    private List<ScheduleForView> getScheduleForView(List<Schedule> schedule) {
        List<ScheduleForView> scheduleForView = new ArrayList<>();
        for (Schedule item1 : schedule) {
            boolean dublicate = false;
            for (ScheduleForView item2 : scheduleForView) {
                if (item1.getDay().equals(item2.getDate())) {
                    dublicate = true;
                    break;
                }
            }
            if (!dublicate) {
                List<String> times = new ArrayList<>();
                for (Schedule item : schedule) {
                    if(item.getDay().equals(item1.getDay())){
                        times.add(item.getTime());
                    }
                }
                scheduleForView.add(new ScheduleForView(item1.getDay(),times));
            }
        }
        Collections.sort(scheduleForView, Comparator.comparing(ScheduleForView::getDate));
        scheduleForView.forEach(item -> Collections.sort(item.getTimes()));
        return scheduleForView;
    }



}
