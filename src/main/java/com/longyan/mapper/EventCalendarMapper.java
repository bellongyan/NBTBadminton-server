package com.longyan.mapper;

import com.longyan.pojo.EventCalendar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EventCalendarMapper {
    @Select("select * from event_calendar;")
    List<EventCalendar> getEventCalendar();
}
