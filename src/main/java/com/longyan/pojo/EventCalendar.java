package com.longyan.pojo;

import lombok.Data;

@Data
public class EventCalendar {
    private Integer event_id;
    private String month;
    private String duringDate;
    private String name;
    private String level;
    private String position;
    private String award;
    private Boolean isCancel;
}
