package com.longyan.service;

import com.longyan.pojo.EventCalendar;
import com.longyan.pojo.Rank;

import java.util.List;

public interface EventCalendarService {

    /**
     * @return 赛事日历
     */
    List<EventCalendar> getEventCalendar();
}
