package model.schedule;

import java.util.List;

public interface ScheduleDAO {
    List getScheduleByMovieID(int id);
}
