package com.longyan.controller;

import com.longyan.pojo.EventCalendar;
import com.longyan.pojo.Result;
import com.longyan.service.EventCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventCalendarController {

    @Autowired
    private EventCalendarService eventCalendarService;

    @GetMapping
    private Result<List<EventCalendar>> getEventCalendar() {
        List<EventCalendar> eventCalendar = eventCalendarService.getEventCalendar();
        return Result.success(eventCalendar);
    }
}
