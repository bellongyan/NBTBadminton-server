package com.longyan.service.impl;

import com.longyan.mapper.EventCalendarMapper;
import com.longyan.pojo.EventCalendar;
import com.longyan.service.EventCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventCalendarServiceImpl implements EventCalendarService {

    @Autowired
    private EventCalendarMapper eventCalendarMapper;

    @Override
    public List<EventCalendar> getEventCalendar() {
        List<EventCalendar> eventCalendar = eventCalendarMapper.getEventCalendar();
        return eventCalendar;
    }
}
